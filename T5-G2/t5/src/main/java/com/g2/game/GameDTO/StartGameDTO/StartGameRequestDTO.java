package com.g2.game.GameDTO.StartGameDTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotBlank;
import testrobotchallenge.commons.models.opponent.GameMode;
import testrobotchallenge.commons.models.opponent.OpponentDifficulty;
import testrobotchallenge.commons.models.opponent.OpponentType;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "mode", include = JsonTypeInfo.As.EXISTING_PROPERTY, visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = StartPartitaSingolaRequestDTO.class, name = "PartitaSingola"),// Se "mode" è "PartitaSingola", usa questa classe
        @JsonSubTypes.Type(value = StartGameRequestDTO.class, name = "Allenamento"),
        @JsonSubTypes.Type(value = StartGameRequestDTO.class, name = "ScalataGame"),
        @JsonSubTypes.Type(value = StartGameRequestDTO.class, name = "Sfida")
})
public class StartGameRequestDTO {

    @JsonProperty("playerId")
    private Long playerId;

    @JsonProperty("typeRobot")
    @JsonAlias({"type_robot", "typeRobot"})
    private OpponentType typeRobot;

    @JsonProperty("difficulty")
    private OpponentDifficulty difficulty;

    @JsonProperty("mode")
    private GameMode mode;

    @JsonProperty("underTestClassName")
    @NotBlank(message = "underTestClassName is required")
    private String underTestClassName;

    // Getters e Setters
    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
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

    public GameMode getMode() {
        return mode;
    }

    public void setMode(GameMode mode) {
        this.mode = mode;
    }

    public String getUnderTestClassName() {
        return underTestClassName;
    }

    public void setUnderTestClassName(String underTestClassName) {
        this.underTestClassName = underTestClassName;
    }
}
