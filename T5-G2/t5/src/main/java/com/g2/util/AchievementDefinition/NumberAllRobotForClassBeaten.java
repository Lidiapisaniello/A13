package com.g2.util.AchievementDefinition;

import com.g2.Model.AvailableRobot;
import com.g2.Model.UserGameProgress;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class NumberAllRobotForClassBeaten {

    public static Map<String, BiFunction<Map<String, List<UserGameProgress>>, Map<String, List<AvailableRobot>>, Boolean>> getAchievementFunctions() {
        Map<String, BiFunction<Map<String, List<UserGameProgress>>, Map<String, List<AvailableRobot>>, Boolean>> verifyBeaten = new HashMap<>();

        verifyBeaten.put("allBeatenOneClass", NumberAllRobotForClassBeaten::beatAllRobotForOneClassUT);
        verifyBeaten.put("allBeatenTwoClass", NumberAllRobotForClassBeaten::beatAllRobotForTwoClassUT);

        return verifyBeaten;
    }


    private static Boolean beatAllRobotForOneClassUT(Map<String, List<UserGameProgress>> userGameProgressesByClass, Map<String, List<AvailableRobot>> availableRobotsByClass) {
        for (String classUT : userGameProgressesByClass.keySet()) {
            if (availableRobotsByClass.containsKey(classUT) && userGameProgressesByClass.get(classUT).size() == availableRobotsByClass.get(classUT).size())
                return true;
        }
        return false;
    }

    private static Boolean beatAllRobotForTwoClassUT(Map<String, List<UserGameProgress>> userGameProgressesByClass, Map<String, List<AvailableRobot>> availableRobotsByClass) {
        int beaten = 0;
        for (String classUT : userGameProgressesByClass.keySet()) {
            if (availableRobotsByClass.containsKey(classUT) && userGameProgressesByClass.get(classUT).size() == availableRobotsByClass.get(classUT).size())
                beaten++;
        }
        return beaten >= 2;
    }
}
