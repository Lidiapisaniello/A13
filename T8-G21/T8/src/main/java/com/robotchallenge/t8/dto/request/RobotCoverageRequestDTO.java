package com.robotchallenge.t8.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RobotCoverageRequestDTO {
    @JsonProperty("classUTName")
    private String classUTName;

    @JsonProperty("classUTPath")
    private String classUTPath;

    @JsonProperty("classUTPackage")
    private String classUTPackage;

    @JsonProperty("unitTestPath")
    private String unitTestPath;

    @JsonProperty("evosuiteWorkingDir")
    private String evosuiteWorkingDir;

    public RobotCoverageRequestDTO() {}

    @Override
    public String toString() {
        return "RobotCoverageRequestDTO{" +
                "classUTName='" + classUTName + '\'' +
                ", classUTPath='" + classUTPath + '\'' +
                ", classUTPackage='" + classUTPackage + '\'' +
                ", unitTestPath='" + unitTestPath + '\'' +
                ", evoSuiteWorkingDir='" + evosuiteWorkingDir + '\'' +
                '}';
    }
}
