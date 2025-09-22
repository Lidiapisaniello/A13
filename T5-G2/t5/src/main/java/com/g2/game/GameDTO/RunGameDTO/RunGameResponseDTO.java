package com.g2.game.GameDTO.RunGameDTO;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.g2.game.GameModes.Compile.CompileResult;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
}
