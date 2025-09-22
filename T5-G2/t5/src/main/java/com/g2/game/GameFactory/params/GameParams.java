package com.g2.game.GameFactory.params;

import testrobotchallenge.commons.models.opponent.GameMode;
import testrobotchallenge.commons.models.opponent.OpponentDifficulty;
import testrobotchallenge.commons.models.opponent.OpponentType;

public class GameParams {
    private final Long playerId;
    private final String underTestClassName;
    private final OpponentType type_robot;
    private final OpponentDifficulty difficulty;
    private final GameMode mode;
    private final String testingClassCode;

    // Costruttore che inizializza l'oggetto GameParams per creare una nuova GameLogic
    public GameParams(Long playerId, String underTestClassName, OpponentType type_robot, OpponentDifficulty difficulty, GameMode mode) {
        this.playerId = playerId;
        this.underTestClassName = underTestClassName;
        this.type_robot = type_robot;
        this.difficulty = difficulty;
        this.mode = mode;
        this.testingClassCode = null;
    }

    // Costruttore che inizializza l'oggetto GameParams per aggiornare una GameLogic esistente
    public GameParams(String testingClassCode) {
        this.testingClassCode = testingClassCode;
        this.playerId = null;
        this.underTestClassName = null;
        this.type_robot = null;
        this.difficulty = null;
        this.mode = null;
    }

    public GameParams(Long playerId, String underTestClassName, OpponentType type_robot, OpponentDifficulty difficulty, GameMode mode, String testingClassCode) {
        this.playerId = playerId;
        this.underTestClassName = underTestClassName;
        this.type_robot = type_robot;
        this.difficulty = difficulty;
        this.mode = mode;
        this.testingClassCode = testingClassCode;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public String getUnderTestClassName() {
        return underTestClassName;
    }

    public OpponentType getType_robot() {
        return type_robot;
    }

    public OpponentDifficulty getDifficulty() {
        return difficulty;
    }

    public GameMode getMode() {
        return mode;
    }

    public String getTestingClassCode() {
        return testingClassCode;
    }

    @Override
    public String toString() {
        return "GameParams{" +
                "playerId='" + playerId + '\'' +
                ", underTestClassName='" + underTestClassName + '\'' +
                ", type_robot='" + type_robot + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", mode='" + mode + '\'' +
                ", testingClassCode='" + testingClassCode + '\'' +
                '}';
    }
}
