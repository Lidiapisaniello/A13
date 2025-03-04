package com.g2.Game.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g2.Game.GameDTO.GameResponseDTO;
import com.g2.Game.GameModes.Compile.CompileResult;
import com.g2.Game.GameModes.GameLogic;

@Service
public class GameServiceManager {

    private static final Logger logger = LoggerFactory.getLogger(GameServiceManager.class);
    private final GameService gameService;

    @Autowired
    public GameServiceManager(GameService gameService) {
        this.gameService = gameService;
    }

    public GameLogic CreateGameLogic(String playerId,
            String mode,
            String underTestClassName,
            String type_robot,
            String difficulty) {
        return gameService.CreateGame(playerId, mode, underTestClassName, type_robot, difficulty);
    }

    protected GameLogic GetGameLogic(String playerId, String mode){
        return gameService.GetGame(mode, playerId);
    }

    protected CompileResult compileGame(GameLogic game, String testingClassCode) {
        return gameService.handleCompile(game.getClasseUT(), testingClassCode);
    }

    public GameResponseDTO PlayGame(String playerId, String mode, String testingClassCode, Boolean isGameEnd){
        logger.info("[PlayGame] Inizio esecuzione per playerId={} e mode={}", playerId, mode);
        /*
         * Recupero la sessioen di gioco 
         */
        GameLogic currentGame = GetGameLogic(playerId, mode);
        logger.info("[PlayGame] GameLogic recuperato: gameID={}", currentGame.getGameID());
        /*
         * Compilo il test dell'utente  
         */
        CompileResult Usercompile = compileGame(currentGame, testingClassCode);
        if (Usercompile == null) {
            throw new RuntimeException("compile is null");
        }
        logger.info("[PlayGame] Esito compilazione: success={}", Usercompile.getSuccess());
        /*
        *   getSuccess() mi dà l'esito della compilazione => se l'utente ha scritto un test senza errori 
         */
        if (Usercompile.getSuccess()) {
            /*
             * Recuper i dati del robot da T4
             */
            CompileResult RobotCompile = gameService.GetRobotCoverage(currentGame);
            /*
            *  Lo score è definito dalle performance del file XML del test 
             */
            int userScore = currentGame.GetScore(Usercompile);
            int robotScore = currentGame.GetScore(RobotCompile);
            /*
            *  vado avanti col gioco 
            *  restituisce l'oggetto json che rispecchia lo stato del game
            *  l'utente può imporre la fine del gioco con isGameEnd
             */
            boolean isGameFinished = gameService.handleGameLogic(userScore, robotScore, currentGame, isGameEnd);
            return gameService.handleGameResponse(isGameFinished, currentGame, Usercompile, RobotCompile, userScore, robotScore);
        } else {
            /*
             * Restituisco un Json solo con info parziali 
             */
            return new GameResponseDTO(
                    Usercompile,
                    null,
                    false,
                    0,
                    0,
                    false
            );
        }
    }
}
