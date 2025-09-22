package com.g2.util.achievement;

import com.g2.model.dto.GameProgressDTO;
import com.g2.model.OpponentSummary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class NumberAllRobotForClassBeaten {

    private NumberAllRobotForClassBeaten() {
        throw new IllegalStateException("Classe utility che verifica quali achievement di tipo \"Numero di Robot battuti per classe\" " +
                "sono stato sbloccati nella partita");
    }

    public static Map<String, BiFunction<Map<String, List<GameProgressDTO>>, Map<String, List<OpponentSummary>>, Boolean>> getAchievementFunctions() {
        Map<String, BiFunction<Map<String, List<GameProgressDTO>>, Map<String, List<OpponentSummary>>, Boolean>> verifyBeaten = new HashMap<>();

        verifyBeaten.put("allBeatenOneClass", NumberAllRobotForClassBeaten::beatAllRobotForOneClassUT);
        verifyBeaten.put("allBeatenTwoClass", NumberAllRobotForClassBeaten::beatAllRobotForTwoClassUT);

        return verifyBeaten;
    }

    private static Boolean beatAllRobotForOneClassUT(Map<String, List<GameProgressDTO>> gameProgressesByClass, Map<String, List<OpponentSummary>> availableRobotsByClass) {
        for (String classUT : gameProgressesByClass.keySet()) {
            if (availableRobotsByClass.containsKey(classUT) && gameProgressesByClass.get(classUT).size() == availableRobotsByClass.get(classUT).size())
                return true;
        }
        return false;
    }

    private static Boolean beatAllRobotForTwoClassUT(Map<String, List<GameProgressDTO>> gameProgressesByClass, Map<String, List<OpponentSummary>> availableRobotsByClass) {
        int beaten = 0;
        for (String classUT : gameProgressesByClass.keySet()) {
            if (availableRobotsByClass.containsKey(classUT) && gameProgressesByClass.get(classUT).size() == availableRobotsByClass.get(classUT).size())
                beaten++;
        }
        return beaten >= 2;
    }
}
