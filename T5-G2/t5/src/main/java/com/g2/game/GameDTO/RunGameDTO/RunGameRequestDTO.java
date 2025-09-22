package com.g2.game.GameDTO.RunGameDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import testrobotchallenge.commons.models.opponent.GameMode;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "mode", include = JsonTypeInfo.As.EXISTING_PROPERTY, visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = RunPartitaSingolaRequestDTO.class, name = "PartitaSingola"), // Se "mode" è "PartitaSingola", usa questa classe
        @JsonSubTypes.Type(value = RunGameRequestDTO.class, name = "Allenamento"),
        @JsonSubTypes.Type(value = RunGameRequestDTO.class, name = "ScalataGame"),
        @JsonSubTypes.Type(value = RunGameRequestDTO.class, name = "Sfida")
})
public class RunGameRequestDTO {
    @JsonProperty(value = "testingClassCode", required = false, defaultValue = "")
    String testingClassCode;

    @JsonProperty("playerId")
    Long playerId;

    @JsonProperty("mode")
    GameMode mode;

    public RunGameRequestDTO() {}

    public String getTestingClassCode() {
        return testingClassCode;
    }

    public void setTestingClassCode(String testingClassCode) {
        this.testingClassCode = testingClassCode;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public GameMode getMode() {
        return mode;
    }

    public void setMode(GameMode mode) {
        this.mode = mode;
    }
}
