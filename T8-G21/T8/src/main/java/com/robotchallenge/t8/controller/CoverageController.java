package com.robotchallenge.t8.controller;

import com.robotchallenge.t8.dto.request.RobotCoverageRequestDTO;
import com.robotchallenge.t8.dto.request.StudentCoverageRequestDTO;
import com.robotchallenge.t8.service.CoverageService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

@Controller
@CrossOrigin
public class CoverageController {

    @Autowired
    @Qualifier("compileExecutor")
    private ThreadPoolTaskExecutor compileExecutor;

    CoverageService coverageService;

    private static final Logger logger = LoggerFactory.getLogger(CoverageService.class);

    public CoverageController(CoverageService coverageService, ThreadPoolTaskExecutor compileExecutor) {
        this.coverageService = coverageService;
        this.compileExecutor = compileExecutor;
    }

    @PostMapping(value = "/coverage/randoop", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> calculateRobotEvosuiteCoverage(@RequestBody RobotCoverageRequestDTO request) {
        logger.info("[CoverageController] [POST /coverage/randoop] Ricevuta richiesta con body: {}", request);
        String coverage = coverageService.calculateRobotCoverage(request);

        JSONObject response = new JSONObject();
        response.put(request.getClassUTPackage(), coverage);
        logger.info("[CoverageController] [POST /coverage/randoop] Risultato: {}", response);
        logger.info("[CoverageController] [POST /coverage/randoop] OK 200");
        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(response.toString());
    }

    @PostMapping(value = "/api/VolumeT0", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> calculateStudentEvosuiteCoverage(@RequestBody StudentCoverageRequestDTO request) {
        logger.info("[CoverageController] [POST /api/VolumeT0] Ricevuta richiesta");

        Future<String> future = compileExecutor
                .getThreadPoolExecutor()
                .submit(() -> coverageService.calculateStudentCoverage(request));

        String result = null;
        try {
            result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            logger.error("[StudentCoverage]", e);
            throw new RuntimeException("Errore durante il calcolo della coverage", e);
        }

        int[] evoSuiteStatistics = result != null ? coverageService.getCoveragePercentageStatistics(result) : new int[]{0, 0, 0, 0, 0, 0, 0, 0};

        JSONObject response = new JSONObject();
        response.put("statistics", result);
        response.put("evoSuiteLine", evoSuiteStatistics[0]);
        response.put("evoSuiteBranch", evoSuiteStatistics[1]);
        response.put("evoSuiteException", evoSuiteStatistics[2]);
        response.put("evoSuiteWeakMutation", evoSuiteStatistics[3]);
        response.put("evoSuiteOutput", evoSuiteStatistics[4]);
        response.put("evoSuiteMethod", evoSuiteStatistics[5]);
        response.put("evoSuiteMethodNoException", evoSuiteStatistics[6]);
        response.put("evoSuiteCBranch", evoSuiteStatistics[7]);

        logger.info("[CoverageController] [POST /api/VolumeT0] Risultato: {}", response);
        logger.info("[CoverageController] [POST /api/VolumeT0] OK 200");
        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(response.toString());

    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        logger.error("[RuntimeException] Internal Server Error: ", e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
