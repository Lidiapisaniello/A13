package com.g2.service;

import com.g2.game.GameModes.Compile.CompileResult;
import com.g2.model.dto.GameProgressDTO;
import com.g2.model.OpponentSummary;
import com.g2.util.achievement.NumberAllRobotForClassBeaten;
import com.g2.util.achievement.NumberRobotBeaten;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

@Service
public class AchievementService {

    private static final Logger logger = LoggerFactory.getLogger(AchievementService.class);

    public Set<String> verifyGameModeAchievement(
            Map<String, BiFunction<CompileResult, CompileResult, Boolean>> achievements,
            CompileResult user,
            CompileResult robot) {

        Set<String> unlocked = new HashSet<>();
        logger.info("[verifyAchievements]: {}", achievements);
        for (var entry : achievements.entrySet()) {
            if (entry.getValue().apply(user, robot)) {
                unlocked.add(entry.getKey());
            }
        }

        return unlocked;
    }

    public Set<String> verifyNumberRobotBeaten(List<GameProgressDTO> gameProgresses) {
        Map<String, Function<List<GameProgressDTO>, Boolean>> achievements = NumberRobotBeaten.getAchievementFunctions();
        Set<String> unlocked = new HashSet<>();
        for (var entry : achievements.entrySet()) {
            if (entry.getValue().apply(gameProgresses)) {
                unlocked.add(entry.getKey());
            }
        }

        return unlocked;
    }

    public Set<String> verifyNumberAllRobotForClassBeaten(
            List<GameProgressDTO> gameProgress,
            List<OpponentSummary> robots
    ) {
        Map<String, BiFunction<Map<String, List<GameProgressDTO>>, Map<String, List<OpponentSummary>>, Boolean>> achievements =
                NumberAllRobotForClassBeaten.getAchievementFunctions();
        Map<String, List<OpponentSummary>> availableRobotsByClass = new HashMap<>();
        Map<String, List<GameProgressDTO>> gameProgressesByClass = new HashMap<>();

        for (OpponentSummary robot : robots) {
            if (!availableRobotsByClass.containsKey(robot.getClassUT())) {
                ArrayList<OpponentSummary> arrayList = new ArrayList<>();
                arrayList.add(robot);
                availableRobotsByClass.put(robot.getClassUT(), arrayList);
            } else {
                availableRobotsByClass.get(robot.getClassUT()).add(robot);
            }
        }

        for (GameProgressDTO progress : gameProgress) {
            if (!gameProgressesByClass.containsKey(progress.getClassUT())) {
                ArrayList<GameProgressDTO> arrayList = new ArrayList<>();
                arrayList.add(progress);
                gameProgressesByClass.put(progress.getClassUT(), arrayList);
            } else {
                gameProgressesByClass.get(progress.getClassUT()).add(progress);
            }
        }

        Set<String> unlocked = new HashSet<>();
        for (var entry : achievements.entrySet()) {
            if (entry.getValue().apply(gameProgressesByClass, availableRobotsByClass)) {
                unlocked.add(entry.getKey());
            }
        }

        return unlocked;
    }
}
