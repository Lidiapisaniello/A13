package com.g2.Game.GameFactory.params;

import com.g2.Game.GameDTO.GameLogicDTO.GameLogicDTO;
import com.g2.Game.GameDTO.GameLogicDTO.PartitaSingolaLogicDTO;
import com.g2.Game.GameDTO.RunGameDTO.RunGameRequestDTO;
import com.g2.Game.GameDTO.RunGameDTO.RunPartitaSingolaRequestDTO;
import com.g2.Game.GameDTO.StartGameDTO.StartGameRequestDTO;
import com.g2.Game.GameDTO.StartGameDTO.StartPartitaSingolaRequestDTO;

public class GameParamsFactory {

    // Inizializza un oggetto GameParams per creare una nuova GameLogic (POST /StartGame)
    public static GameParams createGameParams(StartGameRequestDTO gameRequest) {
        switch (gameRequest.getMode()) {
            case "PartitaSingola":
                try {
                    StartPartitaSingolaRequestDTO request = (StartPartitaSingolaRequestDTO) gameRequest;
                    return new PartitaSingolaParams(request.getPlayerId(), request.getUnderTestClassName(),
                            request.getTypeRobot(), request.getDifficulty(), request.getMode(), request.getRemainingTime());
                } catch (ClassCastException e) {
                    throw new RuntimeException();
                }
            default:
                return new GameParams(gameRequest.getPlayerId(), gameRequest.getUnderTestClassName(),
                        gameRequest.getTypeRobot(), gameRequest.getDifficulty(), gameRequest.getMode());
        }
    }

    // Inizializza un oggetto GameParams per creare una aggiornare una GameLogic esistente (POST /run)
    public static GameParams updateGameParams(RunGameRequestDTO gameRequest) {
        switch (gameRequest.getMode()) {
            case "PartitaSingola":
                try {
                    RunPartitaSingolaRequestDTO request = (RunPartitaSingolaRequestDTO) gameRequest;
                    return new PartitaSingolaParams(request.getTestingClassCode(), request.getRemainingTime());
                } catch (ClassCastException e) {
                    throw new RuntimeException();
                }
            default:
                return new GameParams(gameRequest.getTestingClassCode());
        }
    }


    public static GameParams createGameParams(GameLogicDTO gameRequest) {
        switch (gameRequest.getMode()) {
            case "PartitaSingola":
                try {
                    PartitaSingolaLogicDTO request = (PartitaSingolaLogicDTO) gameRequest;
                    return new PartitaSingolaParams(request.getPlayerId(), request.getUnderTestClassName(),
                            request.getTypeRobot(), request.getDifficulty(), request.getMode(), request.getTestingClassCode(),
                            request.getRemainingTime());
                } catch (ClassCastException e) {
                    throw new RuntimeException();
                }
            default:
                return new GameParams(gameRequest.getPlayerId(), gameRequest.getUnderTestClassName(),
                        gameRequest.getTypeRobot(), gameRequest.getDifficulty(), gameRequest.getMode(), gameRequest.getTestingClassCode());
        }
    }
}
