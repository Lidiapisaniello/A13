package com.robotchallenge.t8.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentCoverageRequestDTO {
    @JsonProperty("testCode")
    String testCode;

    @JsonProperty("classUTName")
    private String classUTName;

    @JsonProperty("classUTPath")
    private String classUTPath;

    @JsonProperty("classUTPackage")
    private String classUTPackage;

    @JsonProperty("userDir")
    private String userDir;

    @JsonProperty("coverageSavePath")
    private String coverageSavePath;

    @JsonProperty("playerId")
    private long playerId;

    public StudentCoverageRequestDTO() {}
}
