package com.g2.util.AchievementDefinition;

import com.g2.Model.UserGameProgress;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class NumberRobotBeaten {

    public static Map<String, Function<List<UserGameProgress>, Boolean>> getAchievementFunctions() {
        Map<String, Function<List<UserGameProgress>, Boolean>> verifyBeaten = new HashMap<>();
        verifyBeaten.put("firstMatchWon", NumberRobotBeaten::firstMatchWon);
        verifyBeaten.put("thirdMatchWon", NumberRobotBeaten::thirdMatchWon);

        return verifyBeaten;
    }

    private static Boolean firstMatchWon(List<UserGameProgress> userGameProgresses) {
        return userGameProgresses != null && userGameProgresses.stream().anyMatch(UserGameProgress::isWon);
    }

    private static Boolean thirdMatchWon(List<UserGameProgress> userGameProgresses) {
        return userGameProgresses != null && userGameProgresses.stream().filter(UserGameProgress::isWon).count() >= 3;
    }
}
