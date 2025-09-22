package com.g2.game.GameFactory.params;

import testrobotchallenge.commons.models.opponent.GameMode;
import testrobotchallenge.commons.models.opponent.OpponentDifficulty;
import testrobotchallenge.commons.models.opponent.OpponentType;

public class PartitaSingolaParams extends GameParams {
    int remainingTime;

    public PartitaSingolaParams(Long playerId, String underTestClassName, OpponentType type_robot, OpponentDifficulty difficulty, GameMode mode, int remainingTime) {
        super(playerId, underTestClassName, type_robot, difficulty, mode);
        this.remainingTime = remainingTime;
    }

    public PartitaSingolaParams(String testingClassCode, int remainingTime) {
        super(testingClassCode);
        this.remainingTime = remainingTime;
    }

    public PartitaSingolaParams(Long playerId, String underTestClassName, OpponentType type_robot, OpponentDifficulty difficulty, GameMode mode,
                                String testingClassCode, int remainingTime) {
        super(playerId, underTestClassName, type_robot, difficulty, mode, testingClassCode);
        this.remainingTime = remainingTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    @Override
    public String toString() {
        return "PartitaSingolaParams{" +
                super.toString() +
                "remainingTime=" + remainingTime +
                '}';
    }
}
