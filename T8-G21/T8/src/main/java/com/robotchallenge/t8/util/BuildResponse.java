package com.robotchallenge.t8.util;

import testrobotchallenge.commons.models.dto.score.basic.CoverageDTO;
import testrobotchallenge.commons.models.dto.score.basic.EvosuiteScoreDTO;
import testrobotchallenge.commons.models.dto.score.EvosuiteCoverageDTO;
import testrobotchallenge.commons.util.ExtractScore;

public class BuildResponse {

    // Costruttore privato aggiunto per rimuovere l'issue "Utility classes should not have public constructors"
    // identificata da SonaQube IDE
    private BuildResponse() {
        throw new IllegalStateException("Utility class");
    }

    public static EvosuiteScoreDTO buildDTO(String result) {
        int[][] score = ExtractScore.fromEvosuite(result);

        EvosuiteScoreDTO responseBody = new EvosuiteScoreDTO();
        responseBody.setLineCoverageDTO(new CoverageDTO(
                score[0][0], score[0][1]
        ));
        responseBody.setBranchCoverageDTO(new CoverageDTO(
                score[1][0], score[1][1]
        ));
        responseBody.setExceptionCoverageDTO(new CoverageDTO(
                score[2][0], score[2][1]
        ));
        responseBody.setWeakMutationCoverageDTO(new CoverageDTO(
                score[3][0], score[3][1]
        ));
        responseBody.setOutputCoverageDTO(new CoverageDTO(
                score[4][0], score[4][1]
        ));
        responseBody.setMethodCoverageDTO(new CoverageDTO(
                score[5][0], score[5][1]
        ));
        responseBody.setMethodNoExceptionCoverageDTO(new CoverageDTO(
                score[6][0], score[6][1]
        ));
        responseBody.setCBranchCoverageDTO(new CoverageDTO(
                score[7][0], score[7][1]
        ));

        return responseBody;
    }

    public static EvosuiteCoverageDTO buildExtendedDTO(String result) {
        EvosuiteCoverageDTO responseBody = new EvosuiteCoverageDTO();
        responseBody.setEvosuiteScoreDTO(buildDTO(result));
        responseBody.setResultFileContent(result);

        return responseBody;
    }


}
