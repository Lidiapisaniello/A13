package com.g2.Game.GameDTO.EndGameDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EndGameResponseDTO {

    @JsonProperty("robotScore")
    private int robotScore;

    @JsonProperty("userScore")
    private int userScore;

    @JsonProperty("isWinner")
    private Boolean isWinner;

    @JsonProperty("expGained")
    private int expGained;

    public EndGameResponseDTO(int robotScore, int userScore, Boolean isWinner, int expGained) {
        this.robotScore = robotScore;
        this.userScore = userScore;
        this.isWinner = isWinner;
        this.expGained = expGained;
    }

    public int getRobotScore() {
        return robotScore;
    }

    public void setRobotScore(int robotScore) {
        this.robotScore = robotScore;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public Boolean getWinner() {
        return isWinner;
    }

    public void setWinner(Boolean winner) {
        isWinner = winner;
    }

    public int getExpGained() {
        return expGained;
    }

    public void setExpGained(int expGained) {
        this.expGained = expGained;
    }
}
