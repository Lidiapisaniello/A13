package com.g2.game.GameModes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.g2.game.GameFactory.params.GameParams;
import com.g2.game.GameFactory.params.PartitaSingolaParams;
import com.g2.game.GameModes.Compile.CompileResult;
import com.g2.interfaces.ServiceManager;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testrobotchallenge.commons.models.opponent.GameMode;
import testrobotchallenge.commons.models.opponent.OpponentDifficulty;
import testrobotchallenge.commons.models.opponent.OpponentType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@Getter
@Setter
@ToString
public class PartitaSingola extends GameLogic {

    @JsonIgnore
    private static final Logger logger = LoggerFactory.getLogger(PartitaSingola.class);

    @JsonProperty("userScore")
    private int userScore;
    @JsonProperty("robotScore")
    private int robotScore;
    @JsonProperty("remainingTime")
    private int remainingTime;

    public PartitaSingola(){
        //Costruttore vuoto
    }

    //Questa classe si specializza in una partita singola basata sui turni, prende il nome di Partita Singola nella UI
    public PartitaSingola(ServiceManager serviceManager, Long PlayerID, String ClasseUT,
                          OpponentType type_robot, OpponentDifficulty difficulty, GameMode gameMode, String testingClassCode) {
        super(serviceManager, PlayerID, ClasseUT, type_robot, difficulty, gameMode, testingClassCode);
    }

    public PartitaSingola(ServiceManager serviceManager, Long PlayerID, String ClasseUT,
                          OpponentType type_robot, OpponentDifficulty difficulty, GameMode gamemode, String testingClassCode, int remainingTime) {
        super(serviceManager, PlayerID, ClasseUT, type_robot, difficulty, gamemode, testingClassCode);
        this.remainingTime = remainingTime;
    }

    @Override
    public void updateState(GameParams gameParams, CompileResult userCompileResult, CompileResult robotCompileResult) {
        if (!(gameParams instanceof PartitaSingolaParams))
            throw new IllegalArgumentException("Impossibile aggiornare la logica corrente, i parametri ricevuti non son istanza di PartitaSingolaParams");
        super.updateState(gameParams, userCompileResult, robotCompileResult);
        this.remainingTime = ((PartitaSingolaParams) gameParams).getRemainingTime();
    }

    @Override
    public void NextTurn(CompileResult userCompileResult, CompileResult robotScore) {
        this.robotScore = GetScore(userCompileResult);
        this.userScore = GetScore(userCompileResult);
        CreateTurn();
        logger.info("Created turn {} for game {}", this.getCurrentTurn(), this.getGameID());
        EndTurn(userCompileResult);
        System.out.println("[GAME] Turn " + getCurrentTurn() + " played. User Score: " + userScore + ", Robot Score: " + robotScore);
    }

    @Override
    public Boolean isGameEnd() {
        return false; //il giocatore può fare quanti turni vuole quindi ritorno sempre false
    }

    @Override
    public Boolean isWinner(){
        return userScore > 0 && robotScore > 0 && userScore >= robotScore;
    }

    @Override
    public int GetScore(CompileResult compileResult) {
        // Se loc è 0, il punteggio è sempre 0
        int coverage = compileResult.getInstructionCoverage().getCovered();
        if (coverage == 0) {
            return 0;
        }
        // Calcolo della percentuale
        int total = coverage + compileResult.getInstructionCoverage().getMissed();
        double locPerc = (double) coverage / (double) total;
        return (int) Math.ceil(locPerc * 100);
    }

    @Override
    public Map<String, BiFunction<CompileResult, CompileResult, Boolean>> gameModeAchievements() {
        Map<String, BiFunction<CompileResult, CompileResult, Boolean>> verifyBeaten = new HashMap<>();
        verifyBeaten.put("instructions", this::beatOnJacocoInstructionCoverage);
        verifyBeaten.put("instructionsAndWeakMutation", (user, robot) ->
                beatOnJacocoInstructionCoverage(user, robot) && beatOnEvosuiteWeakMutationCoverage(user, robot));

        logger.info("gameModeAchievement: {}", verifyBeaten);
        return verifyBeaten;
    }

    private Boolean beatOnJacocoInstructionCoverage(CompileResult user, CompileResult robot) {
        return user.getInstructionCoverage().getCovered() > robot.getInstructionCoverage().getCovered();
    }

    private Boolean beatOnEvosuiteWeakMutationCoverage(CompileResult user, CompileResult robot) {
        return user.getEvosuiteWeakMutation().getCovered() > robot.getEvosuiteWeakMutation().getCovered();
    }
}
