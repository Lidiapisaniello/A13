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

package com.g2.Game.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.g2.Game.GameDTO.EndGameDTO.EndGameResponseDTO;
import com.g2.Game.GameFactory.params.GameParams;
import com.g2.Model.*;
import com.g2.Service.UnlockAchievementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g2.Game.GameFactory.GameRegistry;
import com.g2.Game.GameModes.Compile.CompileResult;
import com.g2.Game.GameModes.GameLogic;
import com.g2.Interfaces.ServiceManager;
import com.g2.Service.AchievementService;
import com.g2.Session.Exceptions.GameModeAlreadyExist;
import com.g2.Session.Exceptions.GameModeDontExist;
import com.g2.Session.Exceptions.SessionDontExist;
import com.g2.Session.SessionService;

@Service
public class GameService {

    private final ServiceManager serviceManager;
    private final GameRegistry gameRegistry;
    private final AchievementService achievementService;
    private final SessionService sessionService;
    private final UnlockAchievementService unlockAchievementService;
    private static final Logger logger = LoggerFactory.getLogger(GameService.class);

    @Autowired
    public GameService(ServiceManager serviceManager,
                        GameRegistry gameRegistry,
                        AchievementService achievementService,
                        SessionService sessionService,
                        UnlockAchievementService unlockAchievementService) {
        this.serviceManager = serviceManager;
        this.gameRegistry = gameRegistry;
        this.achievementService = achievementService;
        this.sessionService = sessionService;
        this.unlockAchievementService = unlockAchievementService;
    }

    public GameLogic CreateGame(GameParams gameParams) throws GameModeAlreadyExist {
        String playerId = gameParams.getPlayerId();
        String mode = gameParams.getMode();
        try {
            /*
             * gameRegistry istanzia dinamicamente uno degli oggetti gameLogic (sfida, allenamento, scalata e ecc)
             * basta passargli il campo mode e dinamicamente se ne occupa lui
             */
            GameLogic gameLogic = gameRegistry.createGame(serviceManager, gameParams);
            logger.info("createGame: oggetto game creato con successo per playerId={}, mode={}.", playerId, mode);
            /*
             * Salvo il game in T4
             */
            gameLogic.CreateGame();
            logger.info("createGame: Inizio creazione partita per playerId={}, mode={}.", playerId, mode);
            /*
             * Creo nella sessione i dati di gioco
             */
            sessionService.SetGameMode(playerId, gameLogic);
            logger.info("createGame: sessione aggiornata con successo per playerId={}, mode={}.", playerId, mode);
            return gameLogic;
        } catch (SessionDontExist e) {
            logger.info("createGame: SessionDontExist per playerId={}, mode={}.", playerId, mode);
        } catch (Exception e) {
            logger.info("createGame: Exception per playerId={}, mode={}.", playerId, mode);
        }
        return null;
    }

    public GameLogic GetGame(String mode, String playerId) throws GameModeDontExist {
        try {
            logger.info("getGame: Recupero partita per playerId={}, mode={}.", playerId, mode);
            GameLogic game = sessionService.getGameMode(playerId, mode);
            game.setServiceManager(serviceManager);
            logger.info("getGame: Partita recuperata con successo per playerId={} e modalità={}.", playerId, mode);
            return game;
        } catch ( SessionDontExist e) {
            throw new GameModeDontExist("Game don't exist ");
        }
    }

    public boolean destroyGame(String playerId, String mode) {
        try {
            sessionService.removeGameMode(playerId, mode, java.util.Optional.empty());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean UpdateGame(String playerId, GameLogic game, GameParams updateParams, CompileResult userCompileResult, CompileResult robotCompileResult){
        game.updateState(updateParams, userCompileResult, robotCompileResult);
        logger.error("TEST - UpdateGame: {}", game);
        //return sessionService.updateGameMode(playerId, game);
        sessionService.updateGameMode(playerId, game);
        logger.error("TEST - UPDATED SESSION: {}", GetGame(game.getMode(), playerId));
        return true;
    }

    public CompileResult handleCompile(GameLogic game, String testingClassCode) {
        logger.info("handleCompile: Inizio compilazione per className={}.", game.getClasseUT());
        return new CompileResult(game.getClasseUT(), testingClassCode, game, this.serviceManager);

    }

    /*
    *  Sfrutto T4 per avere i risultati dei robot
    */
    public CompileResult GetRobotCoverage(GameLogic currentGame) {
        try {
            logger.info("Richiesta Coverage robot per testClass={}, robotType={}, difficulty={}.",
                    currentGame.getClasseUT(),
                    currentGame.getTypeRobot(),
                    currentGame.getDifficulty()
            );
            return new CompileResult(currentGame, serviceManager,
                    currentGame.getClasseUT(),
                    currentGame.getTypeRobot(),
                    currentGame.getDifficulty()
            );
        } catch (Exception e) {
            logger.error("[GAMECONTROLLER] GetRobotCoverage:", e);
            return null;
        }
    }

    public void handleGameLogic(int userScore, int robotScore, GameLogic currentGame, GameParams updateParams, CompileResult userCompileResult, CompileResult robotCompileResult) {
        logger.info("handleGameLogic: Avvio logica di gioco per playerId={}.", currentGame.getPlayerID());
        currentGame.NextTurn(userScore, robotScore);
        UpdateGame(currentGame.getPlayerID(), currentGame, updateParams, userCompileResult, robotCompileResult);
    }

    public String[] handleAchievementsUnlocked(GameLogic currentGame, CompileResult user, CompileResult robot) {
        int playerId = Integer.parseInt(currentGame.getPlayerID());
        String gameMode = currentGame.getMode();
        String classUT = currentGame.getClasseUT();
        String robotType = currentGame.getTypeRobot();
        String difficulty = currentGame.getDifficulty();

        MatchStatistics currentMatch = (MatchStatistics) serviceManager.handleRequest("T4", "checkIfAlreadyWon", playerId, gameMode, classUT, robotType, difficulty);
        if (currentMatch.getMatchId() == -1) {
            currentMatch = (MatchStatistics) serviceManager.handleRequest("T4", "newMatch", playerId, gameMode, classUT, robotType, difficulty);
            logger.info("[achievementsUnlocked] Creazione nuovo match per playerId={}.", playerId);
        }
        logger.info("[achievementsUnlocked] Statistiche match corrente: {}", currentMatch);

        logger.info("[achievementsUnlocked] Avvio verifica degli achievement sbloccati");
        Set<String> unlockedAchievements = unlockAchievementService.verifyUnlockedGameModeAchievement(currentGame.gameModeAchievements(), user, robot);
        logger.info("[achievementsUnlocked] Achievement sbloccati nel turno: {}", unlockedAchievements);

        logger.info("[achievementsUnlocked] Avvio fetch degli achievement già sbloccati");
        GameModeAchievements fetchedAchievements = (GameModeAchievements) serviceManager.handleRequest("T4", "getUserMatchAchievements", currentMatch.getMatchId());
        String[] achievements = fetchedAchievements.getAchievements() == null ? new String[0] : fetchedAchievements.getAchievements();
        logger.info("[achievementsUnlocked] Achievement già sbloccati per il match: {}", Arrays.toString(achievements));

        Arrays.asList(achievements).forEach(unlockedAchievements::remove);
        if (unlockedAchievements.isEmpty())
            return new String[0];

        logger.info("[achievementsUnlocked] Nuovi achievement sbloccati: {}", unlockedAchievements);
        logger.info("[achievementsUnlocked] Salvataggio dei nuovi achievement sbloccati.");
        String[] unlocked = unlockedAchievements.toArray(new String[0]);
        fetchedAchievements = (GameModeAchievements) serviceManager.handleRequest("T4", "updateUserMatchAchievements", currentMatch.getMatchId(), unlocked);
        logger.info("[achievementsUnlocked] Achievements aggiornati: {}", fetchedAchievements);

        return unlocked;
    }

    public int handleExperiencePoints(GameLogic currentGame) {
        int playerId = Integer.parseInt(currentGame.getPlayerID());
        String gameMode = currentGame.getMode();
        String classUT = currentGame.getClasseUT();
        String robotType = currentGame.getTypeRobot();
        String difficulty = currentGame.getDifficulty();

        MatchStatistics currentMatch = (MatchStatistics) serviceManager.handleRequest("T4", "checkIfAlreadyWon", playerId, gameMode, classUT, robotType, difficulty);
        logger.info("[achievementsUnlocked] Statistiche match corrente: {}", currentMatch);

        if (currentMatch.isWon()) {
            logger.info("[achievementsUnlocked] L'utente ha già vinto questa sfida, nessun punto esperienza verrà fornito");
            return 0;
        }

        currentMatch = (MatchStatistics) serviceManager.handleRequest("T4", "matchIsWon", playerId, gameMode, classUT, robotType, difficulty);
        logger.info("[achievementsUnlocked] Aggiornamento match corrente come vinto: {}", currentMatch);
        Experience currentExp = (Experience) serviceManager.handleRequest("T4", "getUserExperiencePoints", playerId);
        Experience newExp = (Experience) serviceManager.handleRequest("T4", "updateUserExperiencePoints", playerId, Integer.parseInt(difficulty));
        logger.info("[achievementsUnlocked] Assegnamento di {} punti esperienza, l'utente passa da {} a {} punti esperienza.", difficulty, currentExp.getExperiencePoints(), newExp.getExperiencePoints());

        return Integer.parseInt(difficulty);
    }

    public EndGameResponseDTO handleGameEnd(GameLogic currentGame) {
        logger.info("handleGameEnd: Inizio operazioni di terminazione partita per playerId={}. Avvio aggiornamento progressi e notifiche.", currentGame.getPlayerID());

        /*
         * Verifico lo stato della compilazione che l'utente vuole consegnare (ultima compilazione)
         */
        if (currentGame.getUserCompileResult() == null ||
                !currentGame.getUserCompileResult().hasSuccess() ||
                !currentGame.isWinner()) {
            /*
             * Se l'utente non ha compilato, la compilazione ha generato errori oppure ha perso:
             *  - Chiudo la partita in T4 e chiudo sessione
             *  - Invio la risposta di fallimento al frontend
             */
            EndGame(currentGame, 0);
            return new EndGameResponseDTO(0, 0, false, 0);
        } else {
            /*
             * Se l'utente ha vinto la partita
             *  - Gestisco il calcolo e l'aggiornamento dei punti esperienza
             *  - Gestisco notifiche e trofei
             *  - Chiudo la partita in T4 e chiudo sessione
             *  - Invio la risposta al frontend
             */
            int expGained = handleExperiencePoints(currentGame);
            updateProgressAndNotifications(currentGame.getPlayerID());
            EndGame(currentGame, currentGame.GetScore(currentGame.getUserCompileResult()));
            return new EndGameResponseDTO(
                    currentGame.GetScore(currentGame.getRobotCompileResult()),
                    currentGame.GetScore(currentGame.getUserCompileResult()),
                    currentGame.isWinner(), expGained);
        }
    }

    public void EndGame(GameLogic currentGame, int userscore) {
        logger.info("endGame: Terminazione partita per playerId={}.", currentGame.getPlayerID());
        /*
        *       L'utente ha deciso di terminare la partita o 
        *       la modalità di gioco ha determianto il termine
        *       Salvo la partita 
        *       Distruggo la partita salvata in sessione  
        */
        currentGame.EndRound();
        currentGame.EndGame(userscore);
        destroyGame(currentGame.getPlayerID(), currentGame.getMode());
    }

    //Gestione Trofei e notifiche
    private void updateProgressAndNotifications(String playerId) {
        User user = serviceManager.handleRequest("T23", "GetUser", User.class, playerId);
        String email = user.getEmail();
        List<AchievementProgress> newAchievements = achievementService.updateProgressByPlayer(user.getId().intValue());
        achievementService.updateNotificationsForAchievements(email, newAchievements);
    }

    private void updateExperiencePoints(GameLogic currentGame) {
        MatchStatistics robotBeaten = serviceManager.handleRequest("T4", "checkIfAlreadyWon", MatchStatistics.class,
                currentGame.getPlayerID(), currentGame.getClasseUT(), currentGame.getTypeRobot(), currentGame.getDifficulty());

        if (robotBeaten == null)
            return;

        serviceManager.handleRequest("T4", "addNewWonMatch", MatchStatistics.class,
                currentGame.getPlayerID(), currentGame.getClasseUT(), currentGame.getTypeRobot(), currentGame.getDifficulty());

        serviceManager.handleRequest("T4", "updateUserExperiencePoints", Experience.class, currentGame.getPlayerID(),
                currentGame.getDifficulty());
    }
}
