package com.robotchallenge.t8.controller;

import com.robotchallenge.t8.config.CustomExecutorConfiguration;
import com.robotchallenge.t8.dto.request.RobotCoverageRequestDTO;
import com.robotchallenge.t8.dto.request.StudentCoverageRequestDTO;
import com.robotchallenge.t8.service.CoverageService;
import com.robotchallenge.t8.util.BuildResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import testrobotchallenge.commons.models.dto.score.EvosuiteCoverageDTO;

import java.util.concurrent.*;

@Controller
@CrossOrigin
public class CoverageController {

    private static final Logger logger = LoggerFactory.getLogger(CoverageController.class);
    private final CustomExecutorConfiguration.CustomExecutorService compileExecutor;
    private final CoverageService coverageService;

    public CoverageController(CustomExecutorConfiguration.CustomExecutorService compileExecutor,
                              CoverageService coverageService) {
        this.compileExecutor = compileExecutor;
        this.coverageService = coverageService;
    }

    @PostMapping(value = "/coverage/opponent", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EvosuiteCoverageDTO> calculateRobotEvosuiteCoverage(@RequestBody RobotCoverageRequestDTO request) {
        logger.info("[CoverageController] [POST /score/opponent] Ricevuta richiesta con body: {}", request);
        String result = coverageService.calculateRobotCoverage(request);

        EvosuiteCoverageDTO responseBody = BuildResponse.buildExtendedDTO(result);

        logger.info("[CoverageController] [POST /score/opponent] Risultato: {}", responseBody);
        logger.info("[CoverageController] [POST /score/opponent] OK 200");
        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(responseBody);
    }

    @PostMapping(value = "/coverage/player", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> calculateStudentEvosuiteCoverage(@RequestBody StudentCoverageRequestDTO request) {
        logger.info("[CoverageController] [POST /coverage/player] Ricevuta richiesta");

        Callable<String> compilationTimedTask = () -> coverageService.calculatePlayerCoverage(request);

        Future<String> future;
        try {
            future = compileExecutor.submitTask(compilationTimedTask);
        } catch (RejectedExecutionException e) {
            logger.warn("[CoverageController] Task rifiutato: sistema sovraccarico: {}", e.getStackTrace()[0]);
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                    .body("Il sistema è temporaneamente sovraccarico. Riprova più tardi.");
        }

        String score;
        try {
            score = future.get();
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

        EvosuiteCoverageDTO responseBody = BuildResponse.buildExtendedDTO(score);

        logger.info("[CoverageController] [POST /coverage/player] Risultato: {}", responseBody);
        logger.info("[CoverageController] [POST /coverage/player] OK 200");
        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(responseBody);

    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        logger.error("[RuntimeException] Internal Server Error: ", e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
