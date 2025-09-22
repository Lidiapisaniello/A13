package com.g2.game.GameDTO.EndGameDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class EndGameResponseDTO {

    @JsonProperty("robotScore")
    private int robotScore;

    @JsonProperty("userScore")
    private int userScore;

    @JsonProperty("isWinner")
    private Boolean isWinner;

    @JsonProperty("expGained")
    private int expGained;

    @JsonProperty("achievementsUnlocked")
    List<String> achievementsUnlocked;

    public EndGameResponseDTO(int robotScore, int userScore, Boolean isWinner, int expGained) {
        this.robotScore = robotScore;
        this.userScore = userScore;
        this.isWinner = isWinner;
        this.expGained = expGained;
        this.achievementsUnlocked = new ArrayList<>();
    }

    public EndGameResponseDTO(int robotScore, int userScore, Boolean isWinner, int expGained, List<String> achievementsUnlocked) {
        this.robotScore = robotScore;
        this.userScore = userScore;
        this.isWinner = isWinner;
        this.expGained = expGained;
        this.achievementsUnlocked = achievementsUnlocked;
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

    public List<String> getAchievementsUnlocked() {
        return achievementsUnlocked;
    }

    public void setAchievementsUnlocked(List<String> achievementsUnlocked) {
        this.achievementsUnlocked = achievementsUnlocked;
    }

    @Override
    public String toString() {
        return "EndGameResponseDTO{" +
                "robotScore=" + robotScore +
                ", userScore=" + userScore +
                ", isWinner=" + isWinner +
                ", expGained=" + expGained +
                ", achievementsUnlocked=" + achievementsUnlocked +
                '}';
    }
}
