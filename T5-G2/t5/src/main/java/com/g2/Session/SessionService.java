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
import com.g2.Session.Exceptions.GameModeAlreadyExist;
import com.g2.Session.Exceptions.GameModeDontExist;
import com.g2.Session.Exceptions.SessionAlredyExist;
import com.g2.Session.Exceptions.SessionDontExist;

import redis.clients.jedis.exceptions.JedisConnectionException;

@Service
public class SessionService {

    // TTL di default per tutte le operazioni relative alla sessione (in secondi)
    public static final long DEFAULT_SESSION_TTL = 10800L; // 3 ore
    private final RedisTemplate<String, Sessione> redisTemplate;
    /*
     * Prefisso key della sessione 
     */
    private static final String KEY_PREFIX = "User_session";
    /*
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SessionService.class);

    @Autowired
    public SessionService(RedisTemplate<String, Sessione> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * Crea la chiave della sessione usando playerId e un timestamp. Il formato
     * della chiave sarà: "prefix:playerId:".
     */
    private String buildCompositeKey(String userId) {
        return KEY_PREFIX + ":" + userId + ":";
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

    public String createSession(String playerId) throws SessionAlredyExist {
        return createSession(playerId, Optional.empty());
    }

    public String createSession(String playerId, Optional<Long> ttlSeconds) throws SessionAlredyExist {
        Long ttl = ttlSeconds.filter(ttlSec -> ttlSec > 0).orElse(DEFAULT_SESSION_TTL);
        logger.info("createSession - Creazione sessione per il giocatore {} con TTL: {}", playerId, ttl);

        String sessionKey = buildCompositeKey(playerId);
        Sessione session = new Sessione(playerId, sessionKey);

        boolean success = executeSessionCall("createSession", () -> {
            redisTemplate.opsForValue().setIfAbsent(sessionKey, session, ttl, TimeUnit.SECONDS);
        });

        if (!success) {
            logger.error("createSession - Creazione della sessione fallita per il giocatore {}", playerId);
            throw new SessionAlredyExist("Errore nella creazione della sessione.");
        }

        logger.info("createSession - Sessione creata con successo per il giocatore {} con sessionKey: {}", playerId, sessionKey);
        return sessionKey;
    }

    public Sessione getSession(String playerId) {
        boolean SessionExist = doesSessionExistForPlayer(playerId);
        if(!SessionExist){
            throw new SessionDontExist("Sessione non esiste per il playerId: " + playerId);
        }

        String sessionKey = buildCompositeKey(playerId);
        logger.info("getSession - Recupero della sessione per sessionKey: {}", sessionKey);
        Sessione sessione = redisTemplate.opsForValue().get(sessionKey);

        if (sessione == null) {
            logger.error("getSession - Sessione non trovata per sessionKey: {}", sessionKey);
            throw new SessionDontExist("Sessione non trovata per la sessionKey: " + sessionKey);
        }

        logger.info("getSession - Sessione recuperata con successo per sessionKey: {}", sessionKey);
        return sessione;
    }

    /**
     * Cerca una sessione esistente per il player.
     */
    public boolean doesSessionExistForPlayer(String playerId) {
        String key = KEY_PREFIX + ":" + playerId + ":";
        return executeSessionCall("doesSessionExistForPlayer", 
            () -> Boolean.TRUE.equals(redisTemplate.hasKey(key))
        );
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

    public boolean deleteSession(String playerId) {
        boolean SessionExist = doesSessionExistForPlayer(playerId);
        if(!SessionExist){
            throw new SessionDontExist("Sessione non esiste per il playerId: " + playerId);
        }

        String sessionKey = buildCompositeKey(playerId);

        logger.info("deleteSession - Eliminazione della sessione per sessionKey: {}", sessionKey);
        return executeSessionCall("deleteSession", () -> {
            redisTemplate.delete(sessionKey);
        });
    }

    public boolean updateSession(String playerId, Sessione updatedSession) {
        return updateSession(playerId, updatedSession, Optional.empty());
    }

    public boolean updateSession(String playerId, Sessione updatedSession, Optional<Long> ttlSeconds) {
        boolean SessionExist = doesSessionExistForPlayer(playerId);
        if(!SessionExist){
            throw new SessionDontExist("Sessione non esiste per il playerId: " + playerId);
        }

        long ttl = ttlSeconds.filter(ttlSec -> ttlSec > 0).orElse(DEFAULT_SESSION_TTL);
        logger.info("updateSession - Aggiornamento della sessione per playerId: {} con TTL: {}", playerId, ttl);

        if (updatedSession == null) {
            logger.error("updateSession - La sessione aggiornata non può essere null");
            throw new IllegalArgumentException("La sessione aggiornata non può essere null");
        }

        return executeSessionCall("updateSession", () -> {
            String sessionKey = buildCompositeKey(playerId);
            redisTemplate.opsForValue().set(sessionKey, updatedSession, ttl, TimeUnit.SECONDS);
        });
    }

    public List<Sessione> getAllSessions() {
        logger.info("getAllSessions - Recupero di tutte le sessioni da Redis");
        Set<String> keys = redisTemplate.keys("*");
        return (keys == null || keys.isEmpty()) ? Collections.emptyList() : redisTemplate.opsForValue().multiGet(keys);
    }

    public GameLogic getGameMode(String playerId, String mode){
        Sessione sessione = getSession(playerId);
        if(sessione.hasModalita(mode)){
            return sessione.getGame(mode);
        }else{
            throw new GameModeDontExist("Non esiste modalità " + mode);   
        }
    }

    public boolean SetGameMode(String playerId, GameLogic game) {
        return SetGameMode(playerId, game, Optional.empty());
    }

    public boolean SetGameMode(String playerId, GameLogic game, Optional<Long> ttlSeconds) {
        logger.info("GetGameMode - Aggiunta del game mode: {} per il player: {}", game.getMode(), playerId);
        Sessione session = getSession(playerId);
        if(session.hasModalita(game.getMode())){
            //Già esiste 
            throw new GameModeAlreadyExist("Esiste modalità " + game.getMode());
        }else{
            session.addModalita(game.getMode(), game);
            return updateSession(playerId, session, ttlSeconds);
        }
    }

    public boolean removeGameMode(String playerId, String mode){
        return removeGameMode(playerId, mode, Optional.empty());
    }

    public boolean removeGameMode(String playerId, String mode, Optional<Long> ttlSeconds) {
        logger.info("removeGameMode - Rimozione del game mode: {} per il player: {}", mode, playerId);
        Sessione session = getSession(playerId);
        session.removeModalita(mode);
        return updateSession(playerId, session, ttlSeconds);
    }

    public boolean updateGameMode(String playerId, GameLogic game) {
        return updateGameMode(playerId, game, Optional.empty());
    }

    public boolean updateGameMode(String playerId, GameLogic game, Optional<Long> ttlSeconds) {
        logger.info("updateGameMode - Aggiornamento del game mode: {} per il player: {}", game.getMode(), playerId);
        Sessione session = getSession(playerId);
        if(session.hasModalita(game.getMode())){
            session.addModalita(game.getMode(), game);
            return updateSession(playerId, session, ttlSeconds);
        }else{
            throw new GameModeDontExist("Non esiste modalità" + game.getMode());
        }
    }
}
