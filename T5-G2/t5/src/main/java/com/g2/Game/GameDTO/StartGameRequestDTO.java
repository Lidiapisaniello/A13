package com.g2.Game.GameDTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StartGameRequestDTO {

    @JsonProperty("playerId")
    @NotNull(message = "playerId is required")
    private String playerId;

    @JsonProperty("typeRobot")
    @NotBlank(message = "typeRobot is required")
    @JsonAlias({"type_robot", "typeRobot"})
    private String typeRobot;


    @JsonProperty("difficulty")
    @NotBlank(message = "difficulty is required")
    private String difficulty;


    @JsonProperty("mode")
    @NotBlank(message = "mode is required")
    private String mode;


    @JsonProperty("underTestClassName")
    @NotBlank(message = "underTestClassName is required")
    private String underTestClassName;

    // Getters e Setters
    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getUnderTestClassName() {
        return underTestClassName;
    }

    public void setUnderTestClassName(String underTestClassName) {
        this.underTestClassName = underTestClassName;
    }
}
