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

import java.io.Serializable;
import java.util.*;
import java.util.function.BiFunction;

import com.g2.game.GameFactory.params.GameParams;
import com.g2.model.PlayerResult;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.g2.game.GameModes.Compile.CompileResult;
import com.g2.interfaces.ServiceManager;
import testrobotchallenge.commons.models.opponent.GameMode;
import testrobotchallenge.commons.models.opponent.OpponentDifficulty;
import testrobotchallenge.commons.models.opponent.OpponentType;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public abstract class GameLogic implements Serializable {

    private static final long serialVersionUID = 1L;

    // Setter per reiniettare il serviceManager dopo deserializzazione, se necessario
    // Il serviceManager non deve essere serializzato (lo reinietteremo se necessario)
    @Setter
    @JsonIgnore
    private transient ServiceManager serviceManager;

    // IDs e attributi del gioco
    @JsonProperty("game_id")
    private long gameID;

    @JsonProperty("current_round")
    private int currentRound;

    @JsonProperty("current_turn")
    private int currentTurn;

    @JsonProperty("player_id")
    private Long playerID;

    @JsonProperty("class_ut")
    private String classeUT;

    @JsonProperty("type_robot")
    private OpponentType typeRobot;

    @JsonProperty("difficulty")
    private OpponentDifficulty difficulty;

    @JsonProperty("mode")
    private GameMode gameMode;

    @JsonProperty("testingClassCode")
    private String testingClassCode;

    @JsonProperty("userCompileResult")
    private CompileResult userCompileResult;

    @JsonProperty("robotCompileResult")
    private CompileResult robotCompileResult;



    // Costruttore con ServiceManager (utilizzato in produzione)
    public GameLogic(ServiceManager serviceManager, Long playerID, String classeUT,
                     OpponentType typeRobot, OpponentDifficulty difficulty, GameMode gameMode, String testingClassCode) {
        this.serviceManager = serviceManager;
        this.playerID = playerID;
        this.classeUT = classeUT;
        this.typeRobot = typeRobot;
        this.difficulty = difficulty;
        this.gameMode = gameMode;
        this.testingClassCode = testingClassCode;
    }

    // Costruttore senza argomenti (necessario per la deserializzazione JSON)
    public GameLogic() {
    }

    // Metodi astratti che ogni gioco deve implementare
    public abstract void NextTurn(CompileResult userScore, CompileResult robotScore);

    public abstract Boolean isGameEnd();

    public abstract int GetScore(CompileResult compileResult);

    public abstract Boolean isWinner();

    // Metodo per aggiornare lo stato di GameLogic in seguito alla richiesta POST /run
    // Da sovrascrivere in ogni sottoclasse per aggiornare i parametri specifici della stessa da mantenere nella sessione
    public void updateState(GameParams gameParams, CompileResult userCompileResult, CompileResult robotCompileResult) {
        this.testingClassCode = gameParams.getTestingClassCode();
        this.userCompileResult = userCompileResult;
        this.robotCompileResult = robotCompileResult;
    }

    // Metodo per inizializzare gli achievement specifici della modalità di gioco
    // Da sovrascrivere nella modalità specifica
    public Map<String, BiFunction<CompileResult, CompileResult, Boolean>> gameModeAchievements() {
        return new HashMap<>();
    }

    // Metodo per creare la partita
    public void CreateGame() {
        this.gameID = serviceManager.handleRequest("T4", "CreateGame", Long.class, this.gameMode, this.playerID);
    }

    public void CreateRound() {
        this.currentRound = serviceManager.handleRequest("T4", "CreateRound", Integer.class, this.gameID, this.classeUT, this.typeRobot, this.difficulty);
    }

    // Crea un nuovo turno
    protected void CreateTurn() {
        this.currentTurn = serviceManager.handleRequest("T4", "CreateTurn", Integer.class, this.gameID, this.playerID);
    }

    // Gestisce e chiude il turno
    protected void EndTurn(Object userScore) {
        serviceManager.handleRequest("T4", "EndTurn", this.gameID, this.playerID, this.currentTurn, userScore);
    }

    // Conclude il round corrente
    public void EndRound() {
        serviceManager.handleRequest("T4", "EndRound", this.gameID);
    }

    // Conclude la partita
    public void EndGame() {
        int score = GetScore(this.userCompileResult);
        HashMap<Long, PlayerResult> results = new HashMap<Long, PlayerResult>();
        results.put(this.playerID, new PlayerResult(isWinner(), score));
        serviceManager.handleRequest("T4", "EndGame", this.gameID, results);
    }

    @Override
    public String toString() {
        return "GameLogic{" +
                "serviceManager=" + serviceManager +
                ", gameID=" + gameID +
                ", roundID=" + currentRound +
                ", turnID=" + currentTurn +
                ", playerID='" + playerID + '\'' +
                ", classeUT='" + classeUT + '\'' +
                ", typeRobot='" + typeRobot + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", gamemode='" + gameMode + '\'' +
                ", testingClassCode='" + testingClassCode + '\'' +
                ", userCompileResult=" + userCompileResult +
                ", robotCompileResult=" + robotCompileResult +
                '}';
    }
}
