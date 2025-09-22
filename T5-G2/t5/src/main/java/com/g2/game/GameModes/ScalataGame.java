/*
 *   Copyright (c) 2024 Stefano Marano https://github.com/StefanoMarano80017
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

package com.g2.game.GameModes;

import java.util.ArrayList;
import java.util.List;

import com.g2.game.GameModes.Compile.CompileResult;
import com.g2.interfaces.ServiceManager;
import testrobotchallenge.commons.models.opponent.GameMode;
import testrobotchallenge.commons.models.opponent.OpponentDifficulty;
import testrobotchallenge.commons.models.opponent.OpponentType;

public class ScalataGame extends GameLogic {
    private final List<Sfida> games;
    private int currentRound;
    private int currentGameIndex;

    public ScalataGame(ServiceManager serviceManager, Long playerID, String classeUT,
                       List<OpponentType> typesRobot, List<OpponentDifficulty> difficulties, GameMode mode, String testingClassCode) {
        super(serviceManager, playerID, classeUT, typesRobot.get(0), difficulties.get(0), mode, testingClassCode);
        this.games = new ArrayList<>();
        this.currentRound = 1; // Inizia dal round 1
        this.currentGameIndex = 0; // Indice del gioco corrente

        for (int i = 0; i < typesRobot.size(); i++) {
            OpponentType typeRobot = typesRobot.get(i);
            OpponentDifficulty difficulty = difficulties.get(i);
            games.add(new Sfida(serviceManager, playerID, classeUT, typeRobot, difficulty, mode, testingClassCode));
        }
    }

    @Override
    public void NextTurn(CompileResult userScore, CompileResult robotScore) {
        if (currentGameIndex < games.size()) {
            Sfida currentGame = games.get(currentGameIndex);
            currentGame.NextTurn(userScore, robotScore);

            // Verifica se il gioco corrente è finito
            if (currentGame.isGameEnd()) {
                System.out.println("Round " + currentRound + " completed.");
                currentGameIndex++; // Passa al gioco successivo
                currentRound++; // Incrementa il contatore dei round
            }
        } else {
            System.out.println("All games have been played.");
        }
    }

    @Override
    public Boolean isGameEnd() {
        return currentGameIndex >= games.size();
    }

    @Override
    public int GetScore(CompileResult compileResult) {
        // Implementa la logica per calcolare il punteggio totale tra tutti i giochi
        int totalScore = 0;
        for (Sfida game : games) {
            totalScore += game.GetScore(compileResult); // Calcola il punteggio per ogni gioco
        }
        return totalScore;
    }

    @Override
    public Boolean isWinner(){
        return true;
    }

    // Altri metodi necessari per gestire la logica del gioco

}
