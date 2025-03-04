package com.g2.Session;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.g2.Game.GameModes.GameLogic;
import com.g2.Session.Exceptions.SessionDontExist;

import redis.clients.jedis.exceptions.JedisConnectionException;

@Service
public class SessionService {

    // TTL di default per tutte le operazioni relative alla sessione (in secondi)
    public static final long DEFAULT_SESSION_TTL = 10800L; // 3 ore
    private final RedisTemplate<String, Sessione> redisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(SessionService.class);

    @Autowired
    public SessionService(RedisTemplate<String, Sessione> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public interface SessionCall {
        void execute() throws Exception;
    }

    private boolean executeSessionCall(String caller, SessionCall call) {
        try {
            call.execute(); 
            logger.info("{} - Operazione completata con successo", caller);
            return true;
        } catch (JedisConnectionException e) {
            logger.error("{} - Errore di connessione a Redis: {}", caller, e.getMessage(), e);
        } catch (RedisConnectionFailureException e) {
            logger.error("{} - Connessione fallita a Redis: {}", caller, e.getMessage(), e);
        } catch (DataAccessException e) {
            logger.error("{} - Errore generico di accesso a RedisTemplate: {}", caller, e.getMessage(), e);
        } catch (TimeoutException e) {
            logger.error("{} - Timeout durante l'operazione su Redis: {}", caller, e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            logger.error("{} - Argomento non valido passato al metodo: {}", caller, e.getMessage(), e);
        } catch (Exception e) {
            logger.error("{} - Errore sconosciuto: {}", caller, e.getMessage(), e);
        }
        return false; 
    }

    public String createSession(String playerId, Optional<Long> ttlSeconds) throws Exception {
        long ttl = ttlSeconds.filter(ttlSec -> ttlSec > 0).orElse(DEFAULT_SESSION_TTL);
        logger.info("createSession - Creazione sessione per il giocatore {} con TTL: {}", playerId, ttl);

        Sessione session = new Sessione(playerId);
        String sessionKey = session.getIdSessione();

        boolean success = executeSessionCall("createSession", () -> {
            redisTemplate.opsForValue().setIfAbsent(sessionKey, session, ttl, TimeUnit.SECONDS);
        });

        if (!success) {
            logger.error("createSession - Creazione della sessione fallita per il giocatore {}", playerId);
            throw new Exception("Errore nella creazione della sessione.");
        }

        logger.info("createSession - Sessione creata con successo per il giocatore {} con sessionKey: {}", playerId, sessionKey);
        return sessionKey;
    }

    public Sessione getSession(String sessionKey) {
        logger.info("getSession - Recupero della sessione per sessionKey: {}", sessionKey);
        Sessione sessione = redisTemplate.opsForValue().get(sessionKey);

        if (sessione == null) {
            logger.error("getSession - Sessione non trovata per sessionKey: {}", sessionKey);
            throw new SessionDontExist("Sessione non trovata per la sessionKey: " + sessionKey);
        }

        logger.info("getSession - Sessione recuperata con successo per sessionKey: {}", sessionKey);
        return sessione;
    }

    public boolean renewSessionTTL(String sessionKey, long ttlSeconds) {
        logger.info("renewSessionTTL - Rinnovo del TTL per sessionKey: {} con ttlSeconds: {}", sessionKey, ttlSeconds);
        boolean success = redisTemplate.expire(sessionKey, ttlSeconds, TimeUnit.SECONDS);

        if (!success) {
            logger.warn("renewSessionTTL - Rinnovo del TTL fallito per sessionKey: {}", sessionKey);
        } else {
            logger.info("renewSessionTTL - TTL rinnovato con successo per sessionKey: {}", sessionKey);
        }

        return success;
    }

    public boolean deleteSession(String sessionKey) {
        logger.info("deleteSession - Eliminazione della sessione per sessionKey: {}", sessionKey);
        return executeSessionCall("deleteSession", () -> {
            redisTemplate.delete(sessionKey);
        });
    }

    public boolean updateSession(String sessionKey, Sessione updatedSession, Optional<Long> ttlSeconds) {
        long ttl = ttlSeconds.filter(ttlSec -> ttlSec > 0).orElse(DEFAULT_SESSION_TTL);
        logger.info("updateSession - Aggiornamento della sessione per sessionKey: {} con TTL: {}", sessionKey, ttl);

        if (updatedSession == null) {
            logger.error("updateSession - La sessione aggiornata non può essere null");
            throw new IllegalArgumentException("La sessione aggiornata non può essere null");
        }

        return executeSessionCall("updateSession", () -> {
            redisTemplate.opsForValue().set(sessionKey, updatedSession, ttl, TimeUnit.SECONDS);
        });
    }

    public List<Sessione> getAllSessions() {
        logger.info("getAllSessions - Recupero di tutte le sessioni da Redis");
        Set<String> keys = redisTemplate.keys("*");
        return (keys == null || keys.isEmpty()) ? Collections.emptyList() : redisTemplate.opsForValue().multiGet(keys);
    }

    public boolean removeGameMode(String sessionKey, String mode, Optional<Long> ttlSeconds) {
        logger.info("removeGameMode - Rimozione del game mode: {} dalla sessione: {}", mode, sessionKey);
        Sessione session = getSession(sessionKey);
        session.removeModalita(mode);
        return updateSession(sessionKey, session, ttlSeconds);
    }

    public boolean updateGameMode(String sessionKey, GameLogic game, Optional<Long> ttlSeconds) {
        logger.info("updateGameMode - Aggiornamento del game mode: {} per la sessione: {}", game.getMode(), sessionKey);
        Sessione session = getSession(sessionKey);
        session.addModalita(game.getMode(), game);
        return updateSession(sessionKey, session, ttlSeconds);
    }
}
