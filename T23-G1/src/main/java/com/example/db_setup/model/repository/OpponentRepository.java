package com.example.db_setup.model.repository;

import com.example.db_setup.model.Opponent;
import org.springframework.data.jpa.repository.JpaRepository;
import testrobotchallenge.commons.models.opponent.GameMode;
import testrobotchallenge.commons.models.opponent.OpponentDifficulty;
import testrobotchallenge.commons.models.opponent.OpponentType;

import java.util.List;
import java.util.Optional;

public interface OpponentRepository extends JpaRepository<Opponent, Long> {
    Optional<Opponent> findOpponentByGameModeAndClassUTAndTypeAndDifficulty(GameMode gameMode, String classUT, OpponentType type, OpponentDifficulty difficulty);

    List<Opponent> findAllByClassUT(String classUT);
}
