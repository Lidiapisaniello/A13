package com.g2.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameConfigData {
    @JsonProperty("max_level")
    private int maxLevel;
    @JsonProperty("exp_per_level")
    private int expPerLevel;
    @JsonProperty("starting_level")
    private int startingLevel;

    public GameConfigData() {
    }

    public GameConfigData(int maxLevel, int expPerLevel, int startingLevel) {
        this.maxLevel = maxLevel;
        this.expPerLevel = expPerLevel;
        this.startingLevel = startingLevel;
    }

    public int getMaxLevel() { return maxLevel; }
    public void setMaxLevel(int maxLevel) { this.maxLevel = maxLevel; }

    public int getExpPerLevel() { return expPerLevel; }
    public void setExpPerLevel(int expPerLevel) { this.expPerLevel = expPerLevel; }

    public int getStartingLevel() { return startingLevel; }
    public void setStartingLevel(int startingLevel) { this.startingLevel = startingLevel; }

}
