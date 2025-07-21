package com.example.db_setup.service;

import com.example.db_setup.model.Opponent;
import com.example.db_setup.model.repository.OpponentRepository;
import com.example.db_setup.service.exception.OpponentNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testrobotchallenge.commons.models.opponent.GameMode;
import testrobotchallenge.commons.models.opponent.OpponentDifficulty;
import testrobotchallenge.commons.models.opponent.OpponentType;

import java.util.List;
import java.util.Optional;

@Service
public class OpponentService {

    private final OpponentRepository opponentRepository;

    public OpponentService(OpponentRepository opponentRepository) {
        this.opponentRepository = opponentRepository;
    }

    public Opponent getOpponent(GameMode gameMode, String classUT, OpponentType type, OpponentDifficulty difficulty) {
        Optional<Opponent> opponent = opponentRepository.findOpponentByGameModeAndClassUTAndTypeAndDifficulty(gameMode, classUT, type, difficulty);
        if (opponent.isEmpty())
            throw new OpponentNotFoundException();

        return opponent.get();
    }

    public Opponent addNewOpponent(GameMode gameMode, String classUT, OpponentType type, OpponentDifficulty difficulty) {
        Optional<Opponent> existing = opponentRepository.findOpponentByGameModeAndClassUTAndTypeAndDifficulty(
                gameMode, classUT, type, difficulty
        );

        if (existing.isEmpty()) {
            return opponentRepository.save(new Opponent(gameMode, classUT, type, difficulty));
        } else {
            Opponent opponent = existing.get();
            opponent.setActive(true);
            return opponentRepository.save(opponent);
        }
    }

    @Transactional
    public int deleteAllOpponentsForClassUT(String classUT) {
        List<Opponent> opponents = opponentRepository.findAllByClassUT(classUT);
        for (Opponent opponent : opponents) {
            opponent.setActive(false);
            opponentRepository.save(opponent);
        }
        return opponents.size();
    }
}
