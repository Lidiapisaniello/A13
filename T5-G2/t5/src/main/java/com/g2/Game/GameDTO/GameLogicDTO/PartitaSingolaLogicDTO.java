package com.g2.Game.GameDTO.GameLogicDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PartitaSingolaLogicDTO extends GameLogicDTO {
    @JsonProperty("remainingTime")
    private int remainingTime;

    public PartitaSingolaLogicDTO() {

    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
}
