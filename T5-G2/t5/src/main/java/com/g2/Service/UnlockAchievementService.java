package com.g2.Service;

import com.g2.Game.GameModes.Compile.CompileResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

@Service
public class UnlockAchievementService {

    private static final Logger logger = LoggerFactory.getLogger(UnlockAchievementService.class);

    public Set<String> verifyUnlockedGameModeAchievement(
            Map<String, BiFunction<CompileResult, CompileResult, Boolean>> achievements,
            CompileResult user,
            CompileResult robot) {

        Set<String> unlocked = new HashSet<>();
        logger.info("verifyAchievements: {}", achievements);
        for (var entry : achievements.entrySet()) {
            if (entry.getValue().apply(user, robot)) {
                unlocked.add(entry.getKey());
            }
        }

        return unlocked;

    }
}
