package com.g2.game.GameDTO.GameLogicDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import testrobotchallenge.commons.models.opponent.GameMode;
import testrobotchallenge.commons.models.opponent.OpponentDifficulty;
import testrobotchallenge.commons.models.opponent.OpponentType;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "mode", include = JsonTypeInfo.As.EXISTING_PROPERTY, visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PartitaSingolaLogicDTO.class, name = "PartitaSingola"), // Se "mode" è "PartitaSingola", usa questa classe
        @JsonSubTypes.Type(value = GameLogicDTO.class, name = "Allenamento"),
        @JsonSubTypes.Type(value = GameLogicDTO.class, name = "ScalataGame"),
        @JsonSubTypes.Type(value = GameLogicDTO.class, name = "Sfida")
})
public class GameLogicDTO {

    @JsonProperty("mode")
    private GameMode mode;

    @JsonProperty("playerId")
    private Long playerId;

    @JsonProperty("underTestClassName")
    private String underTestClassName;

    @JsonProperty("type_robot")
    private OpponentType typeRobot;

    @JsonProperty("difficulty")
    private OpponentDifficulty difficulty;

    @JsonProperty("testingClassCode")
    private String testingClassCode;;

    // Costruttore vuoto (necessario per la deserializzazione)
    public GameLogicDTO() {
    }

    // Costruttore con tutti i campi
    public GameLogicDTO(GameMode mode, Long playerId, String underTestClassName,
                        OpponentType typeRobot, OpponentDifficulty difficulty, String testingClassCode) {
        this.mode = mode;
        this.playerId = playerId;
        this.underTestClassName = underTestClassName;
        this.typeRobot = typeRobot;
        this.difficulty = difficulty;
        this.testingClassCode = testingClassCode;
    }

    // Getters e Setters

    public GameMode getMode() {
        return mode;
    }

    public void setMode(GameMode mode) {
        this.mode = mode;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getUnderTestClassName() {
        return underTestClassName;
    }

    public void setUnderTestClassName(String underTestClassName) {
        this.underTestClassName = underTestClassName;
    }

    public OpponentType getTypeRobot() {
        return typeRobot;
    }

    public void setTypeRobot(OpponentType typeRobot) {
        this.typeRobot = typeRobot;
    }

    public OpponentDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(OpponentDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getTestingClassCode() {
        return testingClassCode;
    }

    public void setTestingClassCode(String testingClassCode) {
        this.testingClassCode = testingClassCode;
    }
}
