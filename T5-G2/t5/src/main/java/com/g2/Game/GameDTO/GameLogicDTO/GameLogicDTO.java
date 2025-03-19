package com.g2.Game.GameDTO.GameLogicDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "mode", include = JsonTypeInfo.As.EXISTING_PROPERTY, visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PartitaSingolaLogicDTO.class, name = "PartitaSingola") // Se "mode" è "PartitaSingola", usa questa classe
})
public class GameLogicDTO {

    @JsonProperty("mode")
    private String mode;

    @JsonProperty("playerId")
    private String playerId;

    @JsonProperty("underTestClassName")
    private String underTestClassName;

    @JsonProperty("type_robot")
    private String typeRobot;

    @JsonProperty("difficulty")
    private String difficulty;

    @JsonProperty("testingClassCode")
    private String testingClassCode;;

    // Costruttore vuoto (necessario per la deserializzazione)
    public GameLogicDTO() {
    }

    // Costruttore con tutti i campi
    public GameLogicDTO(String mode, String playerId, String underTestClassName, 
                        String typeRobot, String difficulty, String testingClassCode) {
        this.mode = mode;
        this.playerId = playerId;
        this.underTestClassName = underTestClassName;
        this.typeRobot = typeRobot;
        this.difficulty = difficulty;
        this.testingClassCode = testingClassCode;
    }

    // Getters e Setters

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getUnderTestClassName() {
        return underTestClassName;
    }

    public void setUnderTestClassName(String underTestClassName) {
        this.underTestClassName = underTestClassName;
    }

    public String getTypeRobot() {
        return typeRobot;
    }

    public void setTypeRobot(String typeRobot) {
        this.typeRobot = typeRobot;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getTestingClassCode() {
        return testingClassCode;
    }

    public void setTestingClassCode(String testingClassCode) {
        this.testingClassCode = testingClassCode;
    }
}
