package com.g2.Game.GameDTO.RunGameDTO;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.g2.Game.GameModes.Compile.CompileResult;

public class RunGameResponseDTO {

    @JsonProperty("canWin")
    private boolean canWin;

    @JsonProperty("userScore")
    private int userScore;

    @JsonProperty("robotScore")
    private int robotScore;

    @JsonProperty("userCoverageDetails")
    private CompileResult UserCoverageDetails;

    @JsonProperty("robotCoverageDetails")
    private CompileResult RobotCoverageDetails;

    @JsonProperty("unlockedAchievements")
    private String[] unlockedAchievements;

    public RunGameResponseDTO() {
        //costruttore vuoto 
    }

    /*
     * Costruttore che converte un CompileResult in un GameResponseDTO
     */
    public RunGameResponseDTO(CompileResult UserCompileResult,
                              CompileResult RobotCompileResult,
                              Boolean canWin,
                              int userScore, int robotScore,
                              String[] unlockedAchievements) {
        this.canWin = canWin;
        this.userScore = userScore;
        this.robotScore = robotScore;
        // Dettagli della copertura per l'utente
        // Assegna un valore di fallback se i CompileResult sono null
        this.UserCoverageDetails = Objects.requireNonNullElse(UserCompileResult, CompileResult.DEFAULT);
        this.RobotCoverageDetails = Objects.requireNonNullElse(RobotCompileResult, CompileResult.DEFAULT);
        // Achievement unici sbloccati nel round
        this.unlockedAchievements = unlockedAchievements;
    }

    public CompileResult getUserCoverageDetails() {
        return UserCoverageDetails;
    }

    public void setUserCoverageDetails(CompileResult userCoverageDetails) {
        UserCoverageDetails = userCoverageDetails;
    }

    public CompileResult getRobotCoverageDetails() {
        return RobotCoverageDetails;
    }

    public void setRobotCoverageDetails(CompileResult robotCoverageDetails) {
        RobotCoverageDetails = robotCoverageDetails;
    }

    public String[] getUnlockedAchievements() {
        return unlockedAchievements;
    }

    public void setUnlockedAchievements(String[] unlockedAchievements) {
        this.unlockedAchievements = unlockedAchievements;
    }
}
