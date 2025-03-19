package com.g2.Game.GameDTO.RunGameDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "mode", include = JsonTypeInfo.As.EXISTING_PROPERTY, visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = RunPartitaSingolaRequestDTO.class, name = "PartitaSingola") // Se "mode" è "PartitaSingola", usa questa classe
})
public class RunGameRequestDTO {
    @JsonProperty(value = "testingClassCode", required = false, defaultValue = "")
    String testingClassCode;

    @JsonProperty("playerId")
    String playerId;

    @JsonProperty("mode")
    String mode;

    public RunGameRequestDTO() {}

    public String getTestingClassCode() {
        return testingClassCode;
    }

    public void setTestingClassCode(String testingClassCode) {
        this.testingClassCode = testingClassCode;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
