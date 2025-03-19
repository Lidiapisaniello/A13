package com.g2.Game.GameDTO.StartGameDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class StartPartitaSingolaRequestDTO extends StartGameRequestDTO {
    @JsonProperty("remainingTime")
    @NotBlank(message = "remainingTime is required")
    private int remainingTime;

    public StartPartitaSingolaRequestDTO() {

    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
}
