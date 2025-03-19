package com.g2.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameModeAchievements {
    @JsonProperty("match_id")
    private long matchId;
    @JsonProperty(value = "achievements")
    private String[] achievements;

    public GameModeAchievements() {
    }

    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

    public String[] getAchievements() {
        return achievements;
    }

    public void setAchievements(String[] achievements) {
        this.achievements = achievements;
    }
}
