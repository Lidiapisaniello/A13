package com.g2.Game.GameFactory.params;

public class PartitaSingolaParams extends GameParams {
    int remainingTime;

    public PartitaSingolaParams(String playerId, String underTestClassName, String type_robot, String difficulty, String mode, int remainingTime) {
        super(playerId, underTestClassName, type_robot, difficulty, mode);
        this.remainingTime = remainingTime;
    }

    public PartitaSingolaParams(String testingClassCode, int remainingTime) {
        super(testingClassCode);
        this.remainingTime = remainingTime;
    }

    public PartitaSingolaParams(String playerId, String underTestClassName, String type_robot, String difficulty, String mode,
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
