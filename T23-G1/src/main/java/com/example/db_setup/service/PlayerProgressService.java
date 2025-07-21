package com.example.db_setup.service;

import com.example.db_setup.model.GameProgress;
import com.example.db_setup.model.Opponent;
import com.example.db_setup.model.Player;
import com.example.db_setup.model.PlayerProgress;
import com.example.db_setup.model.repository.GameProgressRepository;
import com.example.db_setup.model.repository.PlayerProgressRepository;
import com.example.db_setup.model.repository.PlayerRepository;
import com.example.db_setup.service.exception.GameProgressNotFoundException;
import com.example.db_setup.service.exception.PlayerProgressNotFoundException;
import com.example.db_setup.service.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testrobotchallenge.commons.models.opponent.GameMode;
import testrobotchallenge.commons.models.opponent.OpponentDifficulty;
import testrobotchallenge.commons.models.opponent.OpponentType;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PlayerProgressService {

    private final PlayerProgressRepository playerProgressRepository;
    private final PlayerRepository playerRepository;
    private final GameProgressRepository gameProgressRepository;
    private final OpponentService opponentService;

    private static final Logger logger = LoggerFactory.getLogger(PlayerProgressService.class);


    public PlayerProgressService(PlayerProgressRepository playerProgressRepository, PlayerRepository playerRepository, GameProgressRepository gameProgressRepository, OpponentService opponentService) {
        this.playerProgressRepository = playerProgressRepository;
        this.playerRepository = playerRepository;
        this.gameProgressRepository = gameProgressRepository;
        this.opponentService = opponentService;
    }

    @Transactional
    public PlayerProgress createNewPlayerProgress(Player player) {
        PlayerProgress playerProgress = new PlayerProgress(player);
        return playerProgressRepository.save(playerProgress);
    }

    public PlayerProgress getProgressByPlayerId(long playerId) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isEmpty()) {
            logger.error("[ERROR] Player with id {} not found", playerId);
            throw new UserNotFoundException();
        }

        Optional<PlayerProgress> progress = playerProgressRepository.findByPlayer(player.get());
        if (progress.isEmpty()) {
            logger.error("[ERROR] PlayerProgress for player with id {} not found", playerId);
            throw new PlayerProgressNotFoundException();
        }

        return progress.get();
    }

    public GameProgress getPlayerGameProgressAgainstOpponent(long playerId, GameMode gameMode, String classUT, OpponentType type, OpponentDifficulty difficulty) {
        Optional<GameProgress> gameProgress = gameProgressRepository.findByPlayerAndOpponentParams(playerId, gameMode, classUT, type, difficulty);
        if (gameProgress.isEmpty())
            throw new GameProgressNotFoundException();

        return gameProgress.get();
    }

    public int getPlayerExperience(long playerId) {
        PlayerProgress progress = getProgressByPlayerId(playerId);
        return progress.getExperiencePoints();
    }

    public Set<String> getPlayerGlobalAchievements(long playerId) {
        PlayerProgress progress = getProgressByPlayerId(playerId);
        return progress.getGlobalAchievements();
    }

    public int updatePlayerExperience(long playerId, int gainedExp) {
        PlayerProgress progress = getProgressByPlayerId(playerId);
        progress.setExperiencePoints(progress.getExperiencePoints() + gainedExp);
        playerProgressRepository.save(progress);

        return progress.getExperiencePoints();
    }

    public GameProgress createPlayerGameProgressAgainstOpponent(long playerId, GameMode gameMode, String classUT,
                                                                OpponentType type, OpponentDifficulty difficulty) {

        PlayerProgress progress = getProgressByPlayerId(playerId);
        Opponent opponent = opponentService.getOpponent(gameMode, classUT, type, difficulty);

        Optional<GameProgress> exists = gameProgressRepository.getGameProgressByPlayerProgressAndOpponent(progress, opponent);
        return exists.orElseGet(() -> gameProgressRepository.save(new GameProgress(progress, opponent)));
    }

    public Pair<Boolean, Set<String>> updatePlayerGameProgressAgainstOpponent(long playerId, GameMode gameMode, String classUT, OpponentType type,
                                                        OpponentDifficulty difficulty, boolean isWinner, Set<String> unlockedAchievements) {

        GameProgress gameProgress = getPlayerGameProgressAgainstOpponent(playerId, gameMode, classUT, type, difficulty);
        Set<String> alreadyUnlocked = new HashSet<>(gameProgress.getAchievements());
        Set<String> newlyUnlocked = unlockedAchievements.stream()
                .filter(achievement -> !alreadyUnlocked.contains(achievement))
                .collect(Collectors.toSet());

        gameProgress.getAchievements().addAll(newlyUnlocked);
        logger.info("Setting winner as {}", gameProgress.isWinner() || isWinner);
        gameProgress.setWinner(gameProgress.isWinner() || isWinner);
        gameProgressRepository.save(gameProgress);

        return Pair.of(gameProgress.isWinner(), newlyUnlocked);
    }

    @Transactional
    public Set<String> updatePlayerGlobalAchievements(long playerId, Set<String> unlockedAchievements) {
        PlayerProgress progress = getProgressByPlayerId(playerId);

        Set<String> alreadyUnlocked = new HashSet<>(progress.getGlobalAchievements());
        Set<String> newlyUnlocked = new HashSet<>();
        if (unlockedAchievements != null) {
            newlyUnlocked = unlockedAchievements.stream()
                    .filter(achievement -> !alreadyUnlocked.contains(achievement))
                    .collect(Collectors.toSet());
        }

        progress.getGlobalAchievements().addAll(newlyUnlocked);

        return newlyUnlocked;
    }

}
