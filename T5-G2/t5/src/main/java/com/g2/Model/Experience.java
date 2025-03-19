package com.g2.Model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Experience {
    @JsonProperty("player_id")
    private int playerId;
    @JsonProperty("experience_points")
    private int experiencePoints;

    public Experience() {
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }
}
