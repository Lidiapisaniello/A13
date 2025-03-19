package com.g2.Game.GameDTO.RunGameDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RunPartitaSingolaRequestDTO extends RunGameRequestDTO {
    @JsonProperty("remainingTime")
    private int remainingTime;

    public RunPartitaSingolaRequestDTO() {
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
}
