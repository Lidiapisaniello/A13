package com.g2.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;


public class GeneralAchievement {
    @JsonProperty("player_id")
    private String playerId;
    @JsonProperty("global_achievements")
    private String[] achievements;

    public GeneralAchievement() {}

    public GeneralAchievement(String playerId, String[] achievements) {
        this.playerId = playerId;
        this.achievements = achievements;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String[] getAchievements() {
        return achievements;
    }

    public void setAchievements(String[] achievements) {
        this.achievements = achievements;
    }

    @Override
    public String toString() {
        return "GlobalAchievement{" +
                "playerId='" + playerId + '\'' +
                ", achievements=" + Arrays.toString(achievements) +
                '}';
    }
}
