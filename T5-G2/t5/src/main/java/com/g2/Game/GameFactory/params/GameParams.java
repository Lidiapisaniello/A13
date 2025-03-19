package com.g2.Game.GameFactory.params;

public class GameParams {
    private final String playerId;
    private final String underTestClassName;
    private final String type_robot;
    private final String difficulty;
    private final String mode;
    private final String testingClassCode;

    // Costruttore che inizializza l'oggetto GameParams per creare una nuova GameLogic
    public GameParams(String playerId, String underTestClassName, String type_robot, String difficulty, String mode) {
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

    public GameParams(String playerId, String underTestClassName, String type_robot, String difficulty, String mode, String testingClassCode) {
        this.playerId = playerId;
        this.underTestClassName = underTestClassName;
        this.type_robot = type_robot;
        this.difficulty = difficulty;
        this.mode = mode;
        this.testingClassCode = testingClassCode;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getUnderTestClassName() {
        return underTestClassName;
    }

    public String getType_robot() {
        return type_robot;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getMode() {
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
