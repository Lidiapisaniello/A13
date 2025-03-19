package com.groom.manvsclass.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestEvosuiteCoverageDTO {
    @JsonProperty("classUTName")
    private String classUTName;

    @JsonProperty("classUTPath")
    private String classUTPath;

    @JsonProperty("classUTPackage")
    private String classUTPackage;

    @JsonProperty("unitTestPath")
    private String unitTestPath;

    @JsonProperty("evoSuiteWorkingDir")
    private String evoSuiteWorkingDir;

    public RequestEvosuiteCoverageDTO() {}
}
