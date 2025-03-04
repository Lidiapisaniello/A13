package com.g2.Game.GameModes.Compile;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.g2.Interfaces.ServiceManager;

public class CompileResult {

    /*
     * Istanza di default 
     */
    public static final CompileResult DEFAULT = new CompileResult(
            "", // XML_coverage vuoto
            "", // Compile output vuoto
            null, // CoverageService nullo
            null // ServiceManager nullo
    );
    /*
     * Campi 
     */
    @JsonProperty("compileOutput")
    private String compileOutput;
    @JsonProperty("XML_coverage")
    private String XML_coverage;
    /*
     * Dettagli della coverage JaCoCo
     */
    @JsonProperty("line")
    private CoverageResult LineCoverage = null;
    @JsonProperty("branch")
    private CoverageResult BranchCoverage = null;
    @JsonProperty("instruction")
    private CoverageResult InstructionCoverage = null;
    /*
     * Servizi usati 
     */
    @JsonIgnore
    private ServiceManager serviceManager;
    @JsonIgnore
    private CoverageService coverageService;

    // Logger per la classe
    private static final Logger logger = LoggerFactory.getLogger(CompileResult.class);

    //Costruttore Vuoto
    public CompileResult(){
    }

    // Costruttore con XML coverage
    public CompileResult(String XML_coverage, String compileOutput, CoverageService coverageService, ServiceManager serviceManager) {
        this.serviceManager = serviceManager;
        this.coverageService = coverageService;
        this.compileOutput = compileOutput;
        this.XML_coverage = XML_coverage;
        calculateCoverage(); // Calcola coverage
    }

    // Costruttore con richiesta a T1 e T7 per l'utente 
    public CompileResult(String ClassName, String testingClassCode, ServiceManager serviceManager) {
        String testingClassName = "Test" + ClassName + ".java";
        String underTestClassName = ClassName + ".java";
        this.serviceManager = serviceManager;
        // Recupero il codice della classe under test
        String underTestClassCode = this.serviceManager.handleRequest("T1", "getClassUnderTest", String.class, ClassName);
        // Chiamata a T7 per calcolare coverage
        String response_T7 = this.serviceManager.handleRequest("T7", "CompileCoverage", String.class, testingClassName, testingClassCode, underTestClassName, underTestClassCode);
        // Estraggo i valori dalla risposta
        JSONObject responseObj = new JSONObject(response_T7);
        this.XML_coverage = responseObj.optString("coverage", null);
        this.compileOutput = responseObj.optString("outCompile", null);
        this.coverageService = new CoverageService();
        calculateCoverage(); // Calcolo coverage
    }

    // Costruttore che chiama T4 per i robot 
    public CompileResult(ServiceManager serviceManager, String testClass, String robot_type, String difficulty) {
        this.serviceManager = serviceManager;
        String response_T4 = this.serviceManager.handleRequest("T4", "GetRisultati",
                String.class, testClass, robot_type, difficulty);

        JSONObject JsonResponseT4 = new JSONObject(response_T4);

        this.XML_coverage = JsonResponseT4.get("coverage").toString();
        this.compileOutput = "Robot no console output";
        this.coverageService = null;

        this.LineCoverage = new CoverageResult(
                JsonResponseT4.getInt("jacocoLineCovered"),
                JsonResponseT4.getInt("jacocoLineMissed")
        );

        this.BranchCoverage = new CoverageResult(
                JsonResponseT4.getInt("jacocoBranchCovered"),
                JsonResponseT4.getInt("jacocoBranchMissed")
        );

        this.InstructionCoverage = new CoverageResult(
                JsonResponseT4.getInt("jacocoInstructionCovered"),
                JsonResponseT4.getInt("jacocoInstructionMissed")
        );
    }

    private void calculateCoverage() {
        if (this.XML_coverage != null && !this.XML_coverage.isEmpty()) {
            this.LineCoverage = coverageService.getCoverage(this.XML_coverage, "LINE");
            this.BranchCoverage = coverageService.getCoverage(this.XML_coverage, "BRANCH");
            this.InstructionCoverage = coverageService.getCoverage(this.XML_coverage, "INSTRUCTION");
        } else {
            logger.warn("XML coverage è nulla. Coverage results sarà nulla");
            this.LineCoverage = new CoverageResult(0, 0);
            this.BranchCoverage = new CoverageResult(0, 0);
            this.InstructionCoverage = new CoverageResult(0, 0);
        }
    }

    public Boolean getSuccess() {
        //Se true Il test dell'utente è stato compilato => nessun errore di compilazione nel test
        return !(getXML_coverage() == null || getXML_coverage().isEmpty());
    }

    // Getter per il risultato della copertura
    public String getXML_coverage() {
        return XML_coverage;
    }

    // Getter per il risultato della compilazione
    public String getCompileOutput() {
        return compileOutput;
    }

    public CoverageResult getBranchCoverage() {
        return BranchCoverage;
    }

    public void setBranchCoverage(CoverageResult BranchCoverage) {
        this.BranchCoverage = BranchCoverage;
    }

    public CoverageResult getInstructionCoverage() {
        return InstructionCoverage;
    }

    public CoverageResult getLineCoverage() {
        return LineCoverage;
    }

    public void setLineCoverage(CoverageResult LineCoverage) {
        this.LineCoverage = LineCoverage;
    }

    public void setCompileOutput(String compileOutput) {
        this.compileOutput = compileOutput;
    }

    public void setXML_coverage(String XML_coverage) {
        this.XML_coverage = XML_coverage;
    }

}
