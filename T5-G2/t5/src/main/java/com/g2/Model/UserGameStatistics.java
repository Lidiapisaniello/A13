package com.g2.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserGameStatistics {
    @JsonProperty("match_id")
    private long matchId;
    @JsonProperty("player_id")
    private long playerId;
    @JsonProperty("game_mode")
    private String gameMode;
    @JsonProperty("class_ut")
    private String classUT;
    @JsonProperty("robot_type")
    private String robotType;
    @JsonProperty("difficulty")
    private String difficulty;
    @JsonProperty("has_won")
    private boolean won;
    @JsonProperty(value = "achievements")
    private String[] achievements;

    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public String getClassUT() {
        return classUT;
    }

    public void setClassUT(String classUT) {
        this.classUT = classUT;
    }

    public String getRobotType() {
        return robotType;
    }

    public void setRobotType(String robotType) {
        this.robotType = robotType;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public String[] getAchievements() {
        return achievements;
    }

    public void setAchievements(String[] achievements) {
        this.achievements = achievements;
    }
}
