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

package com.g2.game.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.g2.game.GameDTO.EndGameDTO.EndGameResponseDTO;
import com.g2.game.GameFactory.params.GameParams;
import com.g2.model.*;
import com.g2.model.dto.GameProgressDTO;
import com.g2.model.dto.PlayerProgressDTO;
import com.g2.service.FileOperationService;
import com.g2.service.AchievementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g2.game.GameFactory.GameRegistry;
import com.g2.game.GameModes.Compile.CompileResult;
import com.g2.game.GameModes.GameLogic;
import com.g2.interfaces.ServiceManager;
import com.g2.session.Exceptions.GameModeAlreadyExist;
import com.g2.session.Exceptions.GameModeDontExist;
import com.g2.session.Exceptions.SessionDontExist;
import com.g2.session.SessionService;
import testrobotchallenge.commons.models.dto.score.EvosuiteCoverageDTO;
import testrobotchallenge.commons.models.dto.score.JacocoCoverageDTO;
import testrobotchallenge.commons.models.opponent.GameMode;
import testrobotchallenge.commons.models.opponent.OpponentDifficulty;
import testrobotchallenge.commons.models.opponent.OpponentType;

@Service
public class GameService {

    private final ServiceManager serviceManager;
    private final GameRegistry gameRegistry;
    private final SessionService sessionService;
    private final AchievementService achievementService;
    private final FileOperationService fileOperationService;
    private static final Logger logger = LoggerFactory.getLogger(GameService.class);

    @Autowired
    public GameService(ServiceManager serviceManager,
                        GameRegistry gameRegistry,
                        SessionService sessionService,
                        AchievementService achievementService,
                        FileOperationService fileOperationService) {
        this.serviceManager = serviceManager;
        this.gameRegistry = gameRegistry;
        this.sessionService = sessionService;
        this.achievementService = achievementService;
        this.fileOperationService = fileOperationService;
    }

    public GameLogic CreateGame(GameParams gameParams) throws GameModeAlreadyExist {
        Long playerId = gameParams.getPlayerId();
        GameMode mode = gameParams.getMode();
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
            gameLogic.CreateRound();
            logger.info("createGame: Inizio creazione partita per playerId={}, mode={}.", playerId, mode);
            /*
             * Creo nella sessione i dati di gioco
             */
            sessionService.SetGameMode(playerId, gameLogic);
            logger.info("createGame: sessione aggiornata con successo per playerId={}, mode={}.", playerId, mode);
            /*
             * Creo, se non esiste, lo UserGameProgress che tiene traccia della vittoria e degli obiettivi sbloccati
             * dell'utente per il GameRecord (mode, class, type_robot, difficulty)
             */
            GameProgressDTO progress = (GameProgressDTO) serviceManager.handleRequest("T23", "createPlayerProgressAgainstOpponent", playerId, mode, gameParams.getUnderTestClassName(), gameParams.getType_robot(), gameParams.getDifficulty());
            logger.info("createGame: creato/recuperato con successo progress {} per playerId={}.", progress, playerId);
            return gameLogic;
        } catch (SessionDontExist e) {
            logger.info("createGame: SessionDontExist per playerId={}, mode={}.", playerId, mode);
        } catch (Exception e) {
            logger.info("createGame: Exception per playerId={}, mode={}: {}", playerId, mode, e.getMessage());
        }
        return null;
    }

    public GameLogic GetGame(GameMode mode, Long playerId) throws GameModeDontExist {
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

    public boolean destroyGame(Long playerId, GameMode mode) {
        try {
            sessionService.removeGameMode(playerId, mode, java.util.Optional.empty());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean UpdateGame(Long playerId, GameLogic game, GameParams updateParams, CompileResult userCompileResult, CompileResult robotCompileResult){
        game.updateState(updateParams, userCompileResult, robotCompileResult);
        return sessionService.updateGameMode(playerId, game);
    }

    /*
    public CompileResult handleCompile(GameLogic currentGame, String testingClassCode) {
        logger.info("handleCompile: Inizio compilazione per ClassName={}.", currentGame.getClasseUT());

        String underTestClassName = currentGame.getClasseUT();
        String testingClassName = "Test" + currentGame.getClasseUT();
        String testingClassFileName = testingClassName + ".java";
        String underTestClassFileName = underTestClassName + ".java";

        // Recupero il codice della classe under test
        String underTestClassCode = this.serviceManager.handleRequest("T1", "getClassUnderTest", String.class, underTestClassName);

        // Chiamata a T7 per calcolare jacoco coverage
        String responseT7Raw = this.serviceManager.handleRequest("T7", "CompileCoverage", String.class, testingClassFileName, testingClassCode, underTestClassFileName, underTestClassCode);
        JSONObject response_T7 = new JSONObject(responseT7Raw);

        // Chiamata a T8 per calcolare evosuite coverage solo se il codice è compilabile
        JSONObject response_T8 = new JSONObject();

        if (response_T7.optString("coverage", null) != null) {
            String responseT8Raw = this.serviceManager.handleRequest("T8", "evosuiteUserCoverage", String.class,
                    testingClassName, testingClassCode, underTestClassName, underTestClassCode, "");
            response_T8 = new JSONObject(responseT8Raw);
        }

        // Salvo in VolumeT0 testingClassCode, response_T8 (csv) e response_T7 (xml)
        String suffix = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

        String userDir = String.format("/VolumeT0/FolderTree/StudentTest/Player%s/%s/%s/%s/Game%s/Round%s/Turn%s",
                currentGame.getPlayerID(), currentGame.getGameMode(), currentGame.getClasseUT(), suffix, currentGame.getGameID(), currentGame.getCurrentRound(), currentGame.getCurrentTurn());
        String userCoverageDir = String.format("%s/coverage", userDir);
        String userSrcDir = String.format("%s/project/src/java/main", userDir);
        String userTestDir = String.format("%s/project/src/test/main", userDir);

        fileOperationService.createDirectory(userCoverageDir, userSrcDir, userTestDir);
        fileOperationService.writeTurn(underTestClassCode, underTestClassFileName, testingClassCode, testingClassFileName,
                response_T8.optString("statistics", ""), response_T7.optString("coverage", ""), userSrcDir, userTestDir, userCoverageDir);

        return new CompileResult(response_T8, response_T7);

    }

     */

    public CompileResult handleCompileNew(GameLogic currentGame, String testingClassCode, String compileTypes) {
        logger.info("handleCompile: Inizio compilazione per ClassName={}.", currentGame.getClasseUT());

        String underTestClassName = currentGame.getClasseUT();
        String testingClassName = "Test" + currentGame.getClasseUT();
        String testingClassFileName = testingClassName + ".java";
        String underTestClassFileName = underTestClassName + ".java";

        // Recupero il codice della classe under test
        String underTestClassCode = this.serviceManager.handleRequest("T1", "getClassUnderTest", String.class, underTestClassName);

        // Preparo il percorso per salvare le compilazioni nel volume T0
        String suffix = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String userDir = String.format("/VolumeT0/FolderTree/StudentTest/Player%s/%s/%s/%s/Game%s/Round%s/Turn%s",
                currentGame.getPlayerID(), currentGame.getGameMode(), currentGame.getClasseUT(), suffix, currentGame.getGameID(), currentGame.getCurrentRound(), currentGame.getCurrentTurn());
        String userCoverageDir = String.format("%s/coverage", userDir);
        String userSrcDir = String.format("%s/project/src/java/main", userDir);
        String userTestDir = String.format("%s/project/src/test/main", userDir);
        fileOperationService.createDirectory(userCoverageDir, userSrcDir, userTestDir);

        JacocoCoverageDTO response_T7;
        EvosuiteCoverageDTO response_T8 = null;
        switch (compileTypes) {
            case "T7":
                // Chiamata a T7 per calcolare jacoco coverage
                response_T7 = this.serviceManager.handleRequest("T7", "CompileCoverage", JacocoCoverageDTO.class, testingClassFileName, testingClassCode, underTestClassFileName, underTestClassCode);

                fileOperationService.writeTurnNew(underTestClassCode, underTestClassFileName, testingClassCode, testingClassFileName,
                        response_T7.getCoverage() != null ? response_T7.getCoverage() : "",
                        "coveragetot.xml", userSrcDir, userTestDir, userCoverageDir);

                return new CompileResult(response_T7);
            case "T8":
                // Chiamata a T8 per calcolare evosuite coverage solo se il codice è compilabile
                if (currentGame.getUserCompileResult().getXML_coverage() != null) {
                    response_T8 = this.serviceManager.handleRequest("T8", "evosuiteUserCoverage", EvosuiteCoverageDTO.class,
                            testingClassName, testingClassCode, underTestClassName, underTestClassCode, "");
                }

                fileOperationService.writeTurnNew(underTestClassCode, underTestClassFileName, testingClassCode, testingClassFileName,
                        response_T8 != null ? response_T8.getResultFileContent() : "", "statistics.csv", userSrcDir, userTestDir, userCoverageDir);

                return new CompileResult(currentGame.getUserCompileResult(), response_T8);
            default:
                response_T7 = this.serviceManager.handleRequest("T7", "CompileCoverage", JacocoCoverageDTO.class, testingClassFileName, testingClassCode, underTestClassFileName, underTestClassCode);

                if (response_T7.getCoverage() != null) {
                    response_T8 = this.serviceManager.handleRequest("T8", "evosuiteUserCoverage", EvosuiteCoverageDTO.class,
                            testingClassName, testingClassCode, underTestClassName, underTestClassCode, "");
                }

                fileOperationService.writeTurn(underTestClassCode, underTestClassFileName, testingClassCode, testingClassFileName,
                        response_T8 != null ? response_T8.getResultFileContent() : "",
                        response_T7.getCoverage() != null ? response_T7.getCoverage() : "",
                        userSrcDir, userTestDir, userCoverageDir);

                return new CompileResult(response_T7, response_T8);
        }
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

    public void handleGameLogic(CompileResult userCompileResult, CompileResult robotCompileResult, GameLogic currentGame, GameParams updateParams) {
        logger.info("handleGameLogic: Avvio logica di gioco per playerId={}.", currentGame.getPlayerID());
        currentGame.NextTurn(userCompileResult, robotCompileResult);
        UpdateGame(currentGame.getPlayerID(), currentGame, updateParams, userCompileResult, robotCompileResult);
    }

    public String[] handleGameModeAchievementsUnlocked(GameLogic currentGame, CompileResult user, CompileResult robot) {
        long playerId = currentGame.getPlayerID();
        GameMode gameMode = currentGame.getGameMode();
        String classUT = currentGame.getClasseUT();
        OpponentType robotType = currentGame.getTypeRobot();
        OpponentDifficulty difficulty = currentGame.getDifficulty();

        GameProgressDTO currentGameProgress = (GameProgressDTO) serviceManager.handleRequest("T23", "getPlayerProgressAgainstOpponent", playerId, gameMode, classUT, robotType, difficulty);
        logger.info("[achievementsUnlocked] Progresso sulla partita corrente: {}", currentGameProgress);

        logger.info("[achievementsUnlocked] Avvio verifica degli achievement sbloccati nel turno");
        Set<String> unlockedAchievements = new HashSet<>(achievementService.verifyGameModeAchievement(currentGame.gameModeAchievements(), user, robot));
        logger.info("[achievementsUnlocked] Avvio salvataggio degli achievement sbloccati");
        currentGameProgress = (GameProgressDTO) serviceManager.handleRequest("T23", "updatePlayerProgressAgainstOpponent", playerId, gameMode, classUT, robotType, difficulty, false, unlockedAchievements);

        logger.info("[achievementsUnlocked] Achievement sbloccati: {}", currentGameProgress.getAchievements());
        return currentGameProgress.getAchievements().toArray(new String[0]);
    }

    private String[] handleGlobalAchievementUnlocked(long playerId) {
        logger.info("[globalAchievementsUnlocked] Avvio fetch PlayerProgress per playerId={}", playerId);
        PlayerProgressDTO status = (PlayerProgressDTO) serviceManager.handleRequest("T23", "getPlayerProgressAgainstAllOpponent", playerId);
        logger.info("[globalAchievementsUnlocked] PlayerProgress: {}", status);

        List<OpponentSummary> opponents = (List<OpponentSummary>) serviceManager.handleRequest("T1", "getOpponentsSummary");
        logger.info("[globalAchievementsUnlocked] Avversari disponibili estratti: {}", opponents);

        Set<String> achievementUnlocked = new HashSet<>();

        logger.info("[globalAchievementsUnlocked] Avvio verifica di nuovi achievement globali sbloccati");
        achievementUnlocked.addAll(achievementService.verifyNumberRobotBeaten(status.getGameProgressesDTO()));
        achievementUnlocked.addAll(achievementService.verifyNumberAllRobotForClassBeaten(status.getGameProgressesDTO(), opponents));
        logger.info("[globalAchievementsUnlocked] Salvataggio achievement sbloccati");

        achievementUnlocked = (Set<String>) serviceManager.handleRequest("T23", "updateGlobalAchievements", playerId, achievementUnlocked);

        logger.info("[globalAchievementsUnlocked] Nuovi achievement globali sbloccati: {}", achievementUnlocked);
        return achievementUnlocked.toArray(new String[0]);
    }

    public int handleExperiencePoints(GameLogic currentGame) {
        long playerId = currentGame.getPlayerID();
        GameMode gameMode = currentGame.getGameMode();
        String classUT = currentGame.getClasseUT();
        OpponentType robotType = currentGame.getTypeRobot();
        OpponentDifficulty difficulty = currentGame.getDifficulty();

        GameProgressDTO currentGameProgress = (GameProgressDTO) serviceManager.handleRequest("T23", "getPlayerProgressAgainstOpponent", playerId, gameMode, classUT, robotType, difficulty);
        logger.info("[handleExperiencePoints] Progresso sulla partita corrente: {}", currentGameProgress);

        if (currentGameProgress.isWon()) {
            logger.info("[handleExperiencePoints] L'utente ha già battuto questo avversario, nessun punto esperienza verrà fornito");
            return 0;
        }

        logger.info("[handleExperiencePoints] L'utente non ha ancora battuto questo avversario");
        currentGameProgress = (GameProgressDTO) serviceManager.handleRequest("T23", "updatePlayerProgressAgainstOpponent",
                playerId, gameMode, classUT, robotType, difficulty, true, new HashSet<String>());
        logger.info("[handleExperiencePoints] Aggiornamento match corrente come vinto: {}", currentGameProgress);
        int expGained = difficulty.toInt();
        serviceManager.handleRequest("T23", "incrementUserExp", playerId, expGained);
        logger.info("[handleExperiencePoints] Assegnamento di {} punti esperienza", expGained);

        return expGained;
    }

    public EndGameResponseDTO handleGameEnd(GameLogic currentGame, boolean surrendered) {
        logger.info("handleGameEnd: Inizio operazioni di terminazione partita per playerId={}. Avvio aggiornamento progressi e notifiche.", currentGame.getPlayerID());
        /*
         * Verifico lo stato della compilazione che l'utente vuole consegnare (ultima compilazione)
         */
        if (currentGame.getUserCompileResult() == null ||
                !currentGame.getUserCompileResult().hasSuccess() ||
                surrendered ) {
            /*
             * Se l'utente non ha compilato, la compilazione ha generato errori o si è arreso:
             *  - Chiudo la partita in T4 e chiudo sessione
             *  - Invio la risposta di fallimento al frontend
             */
            EndGame(currentGame, 0);
            return new EndGameResponseDTO(0, 0, false, 0);
        } else if (!currentGame.isWinner()) {
            /*
             * Se l'utente ha perso la partita
             *  - Chiudo la partita in T4 e chiudo sessione
             *  - Invio la risposta al frontend
             */
            EndGame(currentGame, currentGame.GetScore(currentGame.getUserCompileResult()));
            return new EndGameResponseDTO(
                    currentGame.GetScore(currentGame.getRobotCompileResult()),
                    currentGame.GetScore(currentGame.getUserCompileResult()),
                    currentGame.isWinner(), 0);
        } else {
            /*
             * Se l'utente ha vinto la partita
             *  - Gestisco il calcolo e l'aggiornamento dei punti esperienza
             *  - Gestisco notifiche e trofei
             *  - Verifico gli achievement globali sbloccati
             *  - Chiudo la partita in T4 e chiudo sessione
             *  - Invio la risposta al frontend
             */
            int expGained = handleExperiencePoints(currentGame);
            EndGame(currentGame, currentGame.GetScore(currentGame.getUserCompileResult()));
            List<String> achievementsUnlocked = List.of(handleGlobalAchievementUnlocked(currentGame.getPlayerID()));
            return new EndGameResponseDTO(
                    currentGame.GetScore(currentGame.getRobotCompileResult()),
                    currentGame.GetScore(currentGame.getUserCompileResult()),
                    currentGame.isWinner(), expGained, achievementsUnlocked);
        }
    }

    public void EndGame(GameLogic currentGame, int userscore) {
        logger.info("EndGame: Terminazione partita per playerId={}.", currentGame.getPlayerID());
        /*
        *       L'utente ha deciso di terminare la partita o 
        *       la modalità di gioco ha determinato il termine
        *       Salvo la partita 
        *       Distruggo la partita salvata in sessione  
        */
        currentGame.EndRound();
        currentGame.EndGame();
        destroyGame(currentGame.getPlayerID(), currentGame.getGameMode());
    }
}
