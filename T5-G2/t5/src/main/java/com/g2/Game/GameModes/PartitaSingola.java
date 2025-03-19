package com.g2.Game.GameModes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.g2.Game.GameFactory.params.GameParams;
import com.g2.Game.GameFactory.params.PartitaSingolaParams;
import com.g2.Game.GameModes.Compile.CompileResult;
import com.g2.Interfaces.ServiceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class PartitaSingola extends GameLogic {

    @JsonIgnore
    private static final Logger logger = LoggerFactory.getLogger(PartitaSingola.class);

    @JsonProperty("currentTurn")
    private int currentTurn;
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
    public PartitaSingola(ServiceManager serviceManager, String PlayerID, String ClasseUT,
                 String type_robot, String difficulty, String gamemode, String testingClassCode) {
        super(serviceManager, PlayerID, ClasseUT, type_robot, difficulty, gamemode, testingClassCode);
        currentTurn = 0;
    }

    public PartitaSingola(ServiceManager serviceManager, String PlayerID, String ClasseUT,
                          String type_robot, String difficulty, String gamemode, String testingClassCode, int remainingTime) {
        super(serviceManager, PlayerID, ClasseUT, type_robot, difficulty, gamemode, testingClassCode);
        currentTurn = 0;
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
    public void NextTurn(int userScore, int robotScore) {
        String Time = ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT);
        currentTurn++;
        this.robotScore = robotScore;
        this.userScore = userScore;
        CreateTurn(Time, userScore);
        System.out.println("[GAME] Turn " + currentTurn + " played. User Score: " + userScore + ", Robot Score: " + robotScore);
    }

    @Override
    public Boolean isGameEnd() {
        return false; //il giocatore può fare quanti turni vuole quindi ritorno sempre false
    }

    @Override
    public Boolean isWinner(){
        return userScore >= robotScore;
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
        return user.getEvosuiteWeakMutation() > robot.getEvosuiteWeakMutation();
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    @Override
    public String toString() {
        return "PartitaSingola{" +
                super.toString() +
                "currentTurn=" + currentTurn +
                ", userScore=" + userScore +
                ", robotScore=" + robotScore +
                ", remainingTime=" + remainingTime +
                '}';
    }
}
