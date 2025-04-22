package com.robotchallenge.t8.controller;

import com.robotchallenge.t8.config.CustomExecutorConfiguration;
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
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

@Controller
@CrossOrigin
public class CoverageController {

    private static final Logger logger = LoggerFactory.getLogger(CoverageService.class);
    private final CustomExecutorConfiguration.CustomExecutorService compileExecutor;
    private final CoverageService coverageService;

    public CoverageController(CustomExecutorConfiguration.CustomExecutorService compileExecutor,
                              CoverageService coverageService) {
        this.compileExecutor = compileExecutor;
        this.coverageService = coverageService;
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

        Callable<String> compilationTimedTask = () -> coverageService.calculateStudentCoverage(request);

        Future<String> future;
        try {
            future = compileExecutor.submitTask(compilationTimedTask);
        } catch (RejectedExecutionException e) {
            logger.warn("[CoverageController] Task rifiutato: sistema sovraccarico: {}", e.getStackTrace()[0]);
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                    .body("Il sistema è temporaneamente sovraccarico. Riprova più tardi.");
        }

        String result;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("[CoverageController] Il processo è stato interrotto: {}", e.getStackTrace()[0]);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Il processo è stato interrotto.");
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof TimeoutException) {
                logger.warn("[CoverageController] Timeout: il task ha impiegato troppo tempo: {}", e.getStackTrace()[0]);
                return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT)
                        .body("Il task ha superato il tempo massimo disponibile.");
            } else {
                logger.error("[CoverageController] Errore interno durante l'esecuzione: ", e);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Errore durante la compilazione o l'esecuzione.");
            }
        }

        int[] evoSuiteStatistics = result != null
                ? coverageService.getCoveragePercentageStatistics(result)
                : new int[]{0, 0, 0, 0, 0, 0, 0, 0};

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
