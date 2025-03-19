/*
 *   Copyright (c) 2025 Stefano Marano https://github.com/StefanoMarano80017
 *   All rights reserved.

 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at

 *   http://www.apache.org/licenses/LICENSE-2.0

 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.g2.Session;

import java.util.List;
import java.util.Map;

import com.g2.Game.GameFactory.params.GameParams;
import com.g2.Game.GameFactory.params.GameParamsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.g2.Game.GameDTO.GameLogicDTO.GameLogicDTO;
import com.g2.Game.GameFactory.GameRegistry;
import com.g2.Game.GameModes.GameLogic;
import com.g2.Session.Exceptions.GameModeAlreadyExist;
import com.g2.Session.Exceptions.GameModeDontExist;
import com.g2.Session.Exceptions.SessionAlredyExist;
import com.g2.Session.Exceptions.SessionDontExist;

@CrossOrigin
@RestController
@RequestMapping("/session")
public class SessionController {

    private final SessionService sessionService;
    private final GameRegistry gameRegistry;

    @Autowired
    public SessionController(SessionService sessionService,GameRegistry gameRegistry ) {
        this.gameRegistry = gameRegistry;
        this.sessionService = sessionService;
    }

    // ==========================
    // Endpoint per ottenere TUTTE le sessioni
    // ==========================
    /**
     * GET /session Ottiene tutte le sessioni presenti.
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
     * GET /session/{playerId} Ottiene la sessione associata al playerId.
     */
    @GetMapping("/{playerId}")
    public ResponseEntity<?> getSession(@PathVariable String playerId) {
        try {
            Sessione sessione = sessionService.getSession(playerId);
            return ResponseEntity.ok(sessione);
        } catch (SessionDontExist e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error", "Sessione non trovata")
            );
        }
    }

    /**
     * POST /session/{playerId} Crea una nuova sessione per il player
     * specificato. Il corpo della richiesta contiene un JSON che rappresenta la
     * sessione.
     */
    @PostMapping("/{playerId}")
    public ResponseEntity<?> createSession(@PathVariable String playerId, @RequestBody Sessione sessione) {
        if (sessione == null) {
            return ResponseEntity.badRequest().body(
                Map.of("error", "Request is null")
            );
        }

        try {
            String key = sessionService.createSession(playerId);
            return ResponseEntity.status(HttpStatus.CREATED).body(key);
        } catch (SessionAlredyExist e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                Map.of("error", "Session Alredy Exist")
            );
        }
    }

    /**
     * PUT /session/{playerId} Aggiorna la sessione esistente per il player
     * specificato.
     */
    @PutMapping("/{playerId}")
    public ResponseEntity<?> updateSession(@PathVariable String playerId, @RequestBody Sessione updatedSession) {
        if (updatedSession == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of("error", "Request is null")
            );
        }

        try {
            sessionService.updateSession(playerId, updatedSession);
            Sessione sessione = sessionService.getSession(playerId);
            return ResponseEntity.ok(sessione);
        } catch (SessionDontExist e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error","Session Dont Exist")
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                Map.of("error", e.getMessage())
            );
        }
    }

    /**
     * DELETE /session/{playerId} Elimina la sessione associata al player
     * specificato.
     */
    @DeleteMapping("/{playerId}")
    public ResponseEntity<?> deleteSession(@PathVariable String playerId) {
        try {
            sessionService.deleteSession(playerId);
            return ResponseEntity.ok("Eliminazione avvenuta");
        } catch (SessionDontExist e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error","Session Dont Exist")
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                Map.of("error", e.getMessage())
            );
        }
    }

    // ============================
    // Endpoints per la GAMEMODE (basati su playerId)
    // ============================
    /**
     * GET /session/gamemode/{playerId}?mode={mode} Ottiene la modalità
     * (gamemode) associata alla sessione del player.
     */
    @GetMapping("/gamemode/{playerId}")
    public ResponseEntity<?> getGameMode(@PathVariable String playerId, @RequestParam String mode) {
        try {
            GameLogic game = sessionService.getGameMode(playerId, mode);
            return ResponseEntity.ok(game);
        } catch (SessionDontExist e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error","Session Dont Exist")
            );
        } catch (GameModeDontExist e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error","Game Dont Exist")
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                Map.of("error", e.getMessage())
            );
        }
    }

    /**
     * POST /session/gamemode/{playerId} Crea una nuova entry per la
     * modalità nella sessione del player. Il corpo della richiesta contiene il
     * gameObject (in formato JSON) da associare.
     */
    @PostMapping("/gamemode/{playerId}")    
    public ResponseEntity<?> createGameMode(@RequestBody GameLogicDTO gameLogicDTO) {
        try {
            /*
            GameLogic gameObject = gameRegistry.createGame(gameLogicDTO.getMode(), 
                                                           null, 
                                                           gameLogicDTO.getPlayerId(), 
                                                           gameLogicDTO.getUnderTestClassName(), 
                                                           gameLogicDTO.getTypeRobot(), 
                                                           gameLogicDTO.getDifficulty());

             */
            GameParams gameParams = GameParamsFactory.createGameParams(gameLogicDTO);
            GameLogic gameObject = gameRegistry.createGame(null, gameParams);
            sessionService.SetGameMode(gameLogicDTO.getPlayerId(), gameObject);
            return ResponseEntity.ok("Modalità Creata");
        } catch (SessionDontExist e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error","Session Dont Exist")
            );
        } catch (GameModeAlreadyExist e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error","Game Alredy Exist")
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                Map.of("error", e.getMessage())
            );
        }
    }

    /**
     * PUT /session/gamemode/{playerId}?mode={mode} Aggiorna la modalità
     * esistente nella sessione del player.
     */
    @PutMapping("/gamemode/{playerId}")
    public ResponseEntity<?> updateGameMode(@RequestBody GameLogicDTO gameLogicDTO) {
        try {
            /*
            GameLogic gameObject = gameRegistry.createGame(gameLogicDTO.getMode(), 
                                                           null, 
                                                           gameLogicDTO.getPlayerId(), 
                                                           gameLogicDTO.getUnderTestClassName(), 
                                                           gameLogicDTO.getTypeRobot(), 
                                                           gameLogicDTO.getDifficulty());

            */
            GameParams gameParams = GameParamsFactory.createGameParams(gameLogicDTO);
            GameLogic gameObject = gameRegistry.createGame(null, gameParams);
            sessionService.updateGameMode(gameLogicDTO.getPlayerId(), gameObject);
            return ResponseEntity.ok("Modalità Creata");
        } catch (SessionDontExist e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error","Session Dont Exist")
            );
        } catch (GameModeDontExist e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error","Game Dont Exist")
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                Map.of("error", e.getMessage())
            );
        }
    }

    /**
     * DELETE /session/gamemode/{playerId}?mode={mode} Elimina la modalità
     * specificata dalla sessione del player.
     */
    @DeleteMapping("/gamemode/{playerId}")
    public ResponseEntity<?> deleteGameMode(@PathVariable String playerId, @RequestParam String mode) {
        try {
            sessionService.removeGameMode(playerId, mode);
            return ResponseEntity.ok("Modalità Eliminata");
        } catch (SessionDontExist e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error","Session Dont Exist")
            );
        } catch (GameModeDontExist e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error","Game Dont Exist")
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                Map.of("error", e.getMessage())
            );
        }
    }
}
