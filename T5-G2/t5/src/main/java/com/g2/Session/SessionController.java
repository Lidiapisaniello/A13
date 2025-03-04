package com.g2.Session;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/session")
public class SessionController {

    private final SessionService sessionService;
    private final ObjectMapper mapper;

    @Autowired
    public SessionController(SessionService sessionService, ObjectMapper mapper) {
        this.sessionService = sessionService;
        this.mapper = mapper;
    }

    // ==========================
    // Endpoint per ottenere TUTTE le sessioni
    // ==========================
    /**
     * GET /session
     * Ottiene tutte le sessioni presenti.
     */
    @GetMapping("/all")
    public ResponseEntity<List<Sessione>> getAllSessions() {
        List<Sessione> sessions = sessionService.getAllSessions();
        return ResponseEntity.ok(sessions);
    }

    // ==========================
    // Endpoints per la SESSIONE (basati su playerId)
    // ==========================
    /**
     * GET /session/{playerId}
     * Ottiene la sessione associata al playerId.
     */
    @GetMapping("/{playerId}")
    public ResponseEntity<Sessione> getSession(@PathVariable String playerId) {
        String sessionKey = sessionService.getExistingSessionKeyForPlayer(playerId);
        if (sessionKey == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Sessione sessione = sessionService.getSession(sessionKey);
        if (sessione == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(sessione);
    }

    /**
     * POST /session/{playerId}
     * Crea una nuova sessione per il player specificato.
     * Il corpo della richiesta contiene un JSON che rappresenta la sessione.
     */
    @PostMapping("/{playerId}")
    public ResponseEntity<Sessione> createSession(@PathVariable String playerId, @RequestBody Sessione sessione) {
        if (sessione == null) {
            return ResponseEntity.badRequest().build();
        }
        // Imposta l'id della sessione e il timestamp corrente
        sessione.setIdSessione(playerId);
        sessione.setTimestamp(Instant.now());
        // Se esiste già una sessione per il player, restituisce un conflitto
        String existingSessionKey = sessionService.getExistingSessionKeyForPlayer(playerId);
        if (existingSessionKey != null) {
            Sessione existing = sessionService.getSession(existingSessionKey);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(existing);
        }
        // Crea la nuova sessione usando il playerId come chiave
        boolean created = sessionService.updateSession(playerId, sessione, SessionService.DEFAULT_SESSION_TTL);
        if (!created) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(sessione);
    }

    /**
     * PUT /session/{playerId}
     * Aggiorna la sessione esistente per il player specificato.
     */
    @PutMapping("/{playerId}")
    public ResponseEntity<Sessione> updateSession(@PathVariable String playerId, @RequestBody Sessione updatedSession) {
        String sessionKey = sessionService.getExistingSessionKeyForPlayer(playerId);
        if (sessionKey == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        updatedSession.setIdSessione(playerId);
        boolean updated = sessionService.updateSession(sessionKey, updatedSession, SessionService.DEFAULT_SESSION_TTL);
        if (updated) {
            return ResponseEntity.ok(updatedSession);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * DELETE /session/{playerId}
     * Elimina la sessione associata al player specificato.
     */
    @DeleteMapping("/{playerId}")
    public ResponseEntity<String> deleteSession(@PathVariable String playerId) {
        String sessionKey = sessionService.getExistingSessionKeyForPlayer(playerId);
        if (sessionKey == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sessione non trovata");
        }
        sessionService.deleteSession(sessionKey);
        return ResponseEntity.ok("Sessione eliminata con successo");
    }

    // ============================
    // Endpoints per la GAMEMODE (basati su playerId)
    // ============================
    /**
     * GET /session/gamemode/{playerId}?mode={mode}
     * Ottiene la modalità (gamemode) associata alla sessione del player.
     */
    @GetMapping("/gamemode/{playerId}")
    public ResponseEntity<Sessione.ModalitaWrapper> getGameMode(@PathVariable String playerId, @RequestParam String mode) {
        String sessionKey = sessionService.getExistingSessionKeyForPlayer(playerId);
        if (sessionKey == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Sessione sessione = sessionService.getSession(sessionKey);
        if (sessione == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Sessione.ModalitaWrapper modalita = sessione.getModalita().get(mode);
        if (modalita == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(modalita);
    }

    /**
     * POST /session/gamemode/{playerId}?mode={mode}
     * Crea una nuova entry per la modalità nella sessione del player.
     * Il corpo della richiesta contiene il gameObject (in formato JSON) da associare.
     */
    @PostMapping("/gamemode/{playerId}")
    public ResponseEntity<String> createGameMode(@PathVariable String playerId,
                                                 @RequestParam String mode,
                                                 @RequestBody Object gameObject) {
        String sessionKey = sessionService.getExistingSessionKeyForPlayer(playerId);
        if (sessionKey == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sessione non trovata");
        }
        Sessione sessione = sessionService.getSession(sessionKey);
        if (sessione == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sessione non trovata");
        }
        String timestamp = Instant.now().toString();
        try {
            GameLogic gameLogic = mapper.convertValue(gameObject, GameLogic.class);
            Sessione.ModalitaWrapper wrapper = new Sessione.ModalitaWrapper(gameLogic, timestamp);
            sessione.getModalita().put(mode, wrapper);
            boolean updated = sessionService.updateSession(sessionKey, sessione, SessionService.DEFAULT_SESSION_TTL);
            if (updated) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Gamemode creata con successo");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore nella creazione della gamemode");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Errore nella conversione del gameObject: " + e.getMessage());
        }
    }

    /**
     * PUT /session/gamemode/{playerId}?mode={mode}
     * Aggiorna la modalità esistente nella sessione del player.
     */
    @PutMapping("/gamemode/{playerId}")
    public ResponseEntity<String> updateGameMode(@PathVariable String playerId,
                                                 @RequestParam String mode,
                                                 @RequestBody Object gameObject) {
        String sessionKey = sessionService.getExistingSessionKeyForPlayer(playerId);
        if (sessionKey == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sessione non trovata");
        }
        Sessione sessione = sessionService.getSession(sessionKey);
        if (sessione == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sessione non trovata");
        }
        if (!sessione.getModalita().containsKey(mode)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Gamemode non trovata per il mode: " + mode);
        }
        try {
            GameLogic gameLogic = mapper.convertValue(gameObject, GameLogic.class);
            Sessione.ModalitaWrapper wrapper = new Sessione.ModalitaWrapper(gameLogic, Instant.now().toString());
            sessione.getModalita().put(mode, wrapper);
            boolean updated = sessionService.updateSession(sessionKey, sessione, SessionService.DEFAULT_SESSION_TTL);
            if (updated) {
                return ResponseEntity.ok("Gamemode aggiornata con successo");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore nell'aggiornamento della gamemode");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Errore nella conversione del gameObject: " + e.getMessage());
        }
    }

    /**
     * DELETE /session/gamemode/{playerId}?mode={mode}
     * Elimina la modalità specificata dalla sessione del player.
     */
    @DeleteMapping("/gamemode/{playerId}")
    public ResponseEntity<String> deleteGameMode(@PathVariable String playerId, @RequestParam String mode) {
        String sessionKey = sessionService.getExistingSessionKeyForPlayer(playerId);
        if (sessionKey == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sessione non trovata");
        }
        Sessione sessione = sessionService.getSession(sessionKey);
        if (sessione == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sessione non trovata");
        }
        if (!sessione.getModalita().containsKey(mode)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Gamemode non trovata per il mode: " + mode);
        }
        sessione.getModalita().remove(mode);
        boolean updated = sessionService.updateSession(sessionKey, sessione, SessionService.DEFAULT_SESSION_TTL);
        if (updated) {
            return ResponseEntity.ok("Gamemode eliminata con successo");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore nell'eliminazione della gamemode");
        }
    }
}
