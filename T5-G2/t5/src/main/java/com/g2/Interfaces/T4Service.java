/*
 *   Copyright (c) 2024 Stefano Marano https://github.com/StefanoMarano80017
 *   All rights reserved.

 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at

 *   http://www.apache.org/licenses/LICENSE-2.0

 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.g2.Interfaces;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.g2.Model.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class T4Service extends BaseService {

    // Costante che definisce l'URL di base per le richieste REST
    private static final String BASE_URL = "http://api_gateway-controller:8090";
    //private static final String BASE_URL = "http://127.0.0.1:8090";

    private static final String SERVICE_PREFIX = "gamerepo";


    // Costruttore della classe, inizializza il servizio con il RestTemplate e l'URL
    // di base
    public T4Service(RestTemplate restTemplate) {
        // Inizializzazione del servizio base con RestTemplate e URL specificato
        super(restTemplate, BASE_URL + "/" + SERVICE_PREFIX);

        registerAction("getUserExperiencePoints", new ServiceActionDefinition(
                params -> getUserExperiencePoints((int) params[0]),
                        Integer.class
        ));

        registerAction("updateUserExperiencePoints", new ServiceActionDefinition(
                params -> updateUserExperiencePoints((int) params[0], (int) params[1]),
                Integer.class, Integer.class
        ));

        registerAction("getUserGameProgress", new ServiceActionDefinition(
                params -> getUserGameProgress((int) params[0], (String) params[1], (String) params[2],
                        (String) params[3], (String) params[4]), Integer.class, String.class, String.class, String.class, String.class
                ));

        registerAction("getGlobalAchievements", new ServiceActionDefinition(
                params -> getGlobalAchievements((int) params[0]), Integer.class
        ));

        registerAction("updateGlobalAchievements", new ServiceActionDefinition(
                params -> updateGlobalAchievements((int) params[0], (String[]) params[1]), Integer.class, String[].class
        ));

        registerAction("getAllUserGameProgresses", new ServiceActionDefinition(
                params -> getAllUserGameProgresses((int) params[0]), Integer.class
        ));

        registerAction("updateUserRecordForVictory", new ServiceActionDefinition(
                params -> updateUserRecordForVictory((int) params[0], (String) params[1], (String) params[2],
                        (String) params[3], (String) params[4]), Integer.class, String.class, String.class, String.class, String.class
        ));

        registerAction("createUserGameProgress", new ServiceActionDefinition(
                params -> createUserGameProgress((int) params[0], (String) params[1], (String) params[2],
                        (String) params[3], (String) params[4]), Integer.class, String.class, String.class, String.class, String.class
        ));

        registerAction("updateUserGameProgressAchievements", new ServiceActionDefinition(
                params -> updateUserGameProgressAchievements((int) params[0], (String) params[1], (String) params[2],
                        (String) params[3], (String) params[4], (String[]) params[5]), Integer.class, String.class, String.class, String.class, String.class, String[].class
        ));

        registerAction("getAvailableRobots", new ServiceActionDefinition(
                params -> getAvailableRobots()
        ));

        registerAction("getGames", new ServiceActionDefinition(
                params -> getGames((int) params[0]),
                Integer.class
        ));

        registerAction("getStatisticsProgresses", new ServiceActionDefinition(
                params -> getStatisticsProgresses((int) params[0]),
                Integer.class
        ));

        registerAction("getHashStatisticsProgresses", new ServiceActionDefinition(
            params -> getHashStatisticsProgresses((int) params[0]),
            Integer.class
        ));

        registerAction("updateStatisticProgress", new ServiceActionDefinition(
                params -> updateStatisticProgress((int) params[0], (String) params[1], (float) params[2]),
                Integer.class, String.class, Float.class));

        registerAction("CreateGame", new ServiceActionDefinition(
                params -> CreateGame((String) params[0], (String) params[1], (String) params[2], (String) params[3],
                        (String) params[4], (String) params[5]),
                String.class, String.class, String.class, String.class, String.class, String.class));

        registerAction("EndGame", new ServiceActionDefinition(
                params -> EndGame((int) params[0], (String) params[1], (int) params[2], (Boolean) params[3]),
                Integer.class, String.class, Integer.class, Boolean.class));

        registerAction("CreateRound", new ServiceActionDefinition(
                params -> CreateRound((int) params[0], (String) params[1], (String) params[2]),
                Integer.class, String.class, String.class));

        registerAction("EndRound", new ServiceActionDefinition(
                params -> EndRound((String) params[0], (int) params[1]),
                String.class, Integer.class));

        registerAction("CreateTurn", new ServiceActionDefinition(
                params -> CreateTurn((String) params[0], (int) params[1], (String) params[2]),
                String.class, Integer.class, String.class));

        registerAction("EndTurn", new ServiceActionDefinition(
                params -> EndTurn((String) params[0], (String) params[1], (String) params[2]),
                String.class, String.class, String.class));

        registerAction("CreateScalata", new ServiceActionDefinition(
                params -> CreateScalata((String) params[0], (String) params[1], (String) params[2], (String) params[3]),
                String.class, String.class, String.class, String.class));

        registerAction("GetRisultati", new ServiceActionDefinition(
                params -> GetRisultati((String) params[0], (String) params[1], (String) params[2]),
                String.class, String.class, String.class));

        registerAction("evosuiteRobotCoverage", new ServiceActionDefinition(
                params -> evosuiteRobotCoverage((String) params[0], (String) params[1], (String) params[2]),
                String.class, String.class, String.class));
    }

    /*
     * ENDPOINT /progress
     */
    // Usa POST /progress per creare un nuovo GameRecord (se non esiste) e il relativo UserGameProgress (se non esiste)
    private UserGameProgress createUserGameProgress(int playerId, String gameMode, String classUT, String robotType, String difficulty) {
        final String endpoint =  "/progress";

        JSONObject requestBody = new JSONObject();
        requestBody.put("player_id", playerId);
        requestBody.put("game_mode", gameMode);
        requestBody.put("class_ut", classUT);
        requestBody.put("robot_type", robotType);
        requestBody.put("difficulty", difficulty);
        return callRestPost(endpoint, requestBody, null, null, UserGameProgress.class);
    }

    // Usa GET /progress/{playerId}/{gameMode}/{classUT}/{robotType}/{difficulty} per ottenere il progresso dell'utente
    // "playerId" per il GameRecord identificato dalla modalità "gameMode", dal robot "robotType", dalla difficoltà
    // "difficulty" e dalla classe "classUT"
    private UserGameProgress getUserGameProgress(int playerId, String gameMode, String classUT, String robotType, String difficulty) {
        final String endpoint =  String.format("/progress/%s/%s/%s/%s/%s", playerId, gameMode, classUT, robotType, difficulty);
        return callRestGET(endpoint, null, UserGameProgress.class);
    }

    // Usa GET /progress/{playerId} per ottenere tutti i progressi dell'utente
    private List<UserGameProgress> getAllUserGameProgresses(int playerId) {
        final String endpoint =  String.format("/progress/%s", playerId);
        return callRestGET(endpoint, null, new ParameterizedTypeReference<List<UserGameProgress>>() {
        });
    }

    private GeneralAchievement getGlobalAchievements(int playerId) {
        final String endpoint =  String.format("/progress/global-achievements/%s", playerId);
        return callRestGET(endpoint, null, GeneralAchievement.class);
    }

    private GeneralAchievement updateGlobalAchievements(int playerId, String[] achievements) {
        final String endpoint =  String.format("/progress/global-achievements/%s", playerId);

        JSONObject requestBody = new JSONObject();
        requestBody.put("achievements", achievements);
        return callRestPut(endpoint, requestBody, null, null, GeneralAchievement.class);
    }

    // Usa PUT /progress/achievements/{matchId} per aggiungere nuovi achievement ottenuti dall'utente su quel match
    private UserGameProgress updateUserGameProgressAchievements(int playerId, String gameMode, String classUT, String robotType, String difficulty, String[] achievements) {
        final String endpoint =  String.format("/progress/achievements/%s/%s/%s/%s/%s", playerId, gameMode, classUT, robotType, difficulty);

        JSONObject requestBody = new JSONObject();
        requestBody.put("achievements", achievements);
        return callRestPut(endpoint, requestBody, null, null, UserGameProgress.class);
    }

    // Usa PUT /progress/state/{playerId}/{gameMode}/{classUT}/{robotType}/{difficulty} per settare che l'utente ha vinto
    // quel GameRecord
    private UserGameProgress updateUserRecordForVictory(int playerId, String gameMode, String classUT, String robotType, String difficulty) {
        final String endpoint =  String.format("/progress/state/%s/%s/%s/%s/%s", playerId, gameMode, classUT, robotType, difficulty);

        JSONObject requestBody = new JSONObject();
        requestBody.put("has_won", true);
        return callRestPut(endpoint, requestBody, null, null, UserGameProgress.class);
    }

    /*
     * ENDPOINT /experience
     */
    // Usa GET /experience/{playerId} per ottenere i punti esperienza dell'utente identificato da "playerId"
    private Experience getUserExperiencePoints(int playerId) {
        final String endpoint = "/experience/" + playerId;
        return callRestGET(endpoint, null, Experience.class);
    }

    // Usa PUT /experience/{playerId} per aggiornare i punti esperienza dell'utente identificato da "playerId", sommando
    // "experiencePoints" ai punti già presenti
    private Experience updateUserExperiencePoints(int playerId, int experiencePoints) {
        final String endpoint = "/experience/" + playerId;

        JSONObject requestBody = new JSONObject();
        requestBody.put("experience_points", experiencePoints);
        return callRestPut(endpoint, requestBody, null, null, Experience.class);
    }

    // usa /robots/all per ottenere tutti i robot disponibili
    private List<AvailableRobot> getAvailableRobots() {
        final String endpoint = "/robots/all";
        return callRestGET(endpoint, null, new ParameterizedTypeReference<List<AvailableRobot>>() {
        });
    }

    // usa /games per ottenere una lista di giochi
    private List<Game> getGames(int playerId) {
        final String endpoint = "/games/player/" + playerId;
        return callRestGET(endpoint, null, new ParameterizedTypeReference<List<Game>>() {
        });
    }

    private List<StatisticProgress> getStatisticsProgresses(int playerID) {
        Map<String, String> formData = new HashMap<>();
        formData.put("pid", String.valueOf(playerID));

        String endpoint = "/phca/" + playerID;

        List<StatisticProgress> response = callRestGET(endpoint, formData, new ParameterizedTypeReference<List<StatisticProgress>>() {
        });
        return response;
    }

    private Set<StatisticProgress> getHashStatisticsProgresses(int playerID) {
        Map<String, String> formData = new HashMap<>();
        formData.put("pid", String.valueOf(playerID));
        String endpoint = "/phca/" + playerID;
        // Recupera la risposta come una lista
        List<StatisticProgress> response = callRestGET( endpoint, 
                                                        formData, 
                                                        new ParameterizedTypeReference<List<StatisticProgress>>() {
                                                       });
        // Converti la lista in un HashSet per rimuovere eventuali duplicati
        Set<StatisticProgress> responseSet = new HashSet<>(response);
        return responseSet;
    }

    private String updateStatisticProgress(int playerID, String statisticID, float progress) {
        JSONObject obj = new JSONObject();
        obj.put("playerId", playerID);
        obj.put("statistic", statisticID);
        obj.put("progress", progress);

        String endpoint = "/phca/" + playerID + "/" + statisticID;
        String response = callRestPut(endpoint, obj, null, null, String.class);
        return response;
    }

    /*
    private String updateStatisticProgress(int playerID, String statisticID, float progress) {
        try {
            MultiValueMap<String, String> jsonMap = new LinkedMultiValueMap<>();
            jsonMap.put("playerId", Collections.singletonList(String.valueOf(playerID)));
            jsonMap.put("statistic", Collections.singletonList(statisticID));
            jsonMap.put("progress", Collections.singletonList(String.valueOf(progress)));

            String endpoint = "/phca/" + playerID + "/" + statisticID;

            String response = callRestPut(endpoint, jsonMap, new HashMap<>(), String.class);

            return response;
        } catch (Exception e) {
            System.out.println("[updateStatisticProgress] Errore nell'update delle statistiche: " + e.getMessage());
            return "errore UPDATESTATISTICPROGRESS";
        }
    }
     */
    // usa /robots per ottenere dati
    private String GetRisultati(String className, String robot_type, String difficulty) {
        Map<String, String> formData = new HashMap<>();
        formData.put("testClassId", className); // Nome della classe
        formData.put("type", robot_type); // Tipo di robot
        formData.put("difficulty", difficulty); // Livello di difficoltà corrente

        String response = callRestGET("/robots", formData, String.class);
        return response;
    }

    private String evosuiteRobotCoverage(String className, String robot_type, String difficulty) {
        final String endpoint = "/robots/evosuitecoverage";

        Map<String, String> formData = new HashMap<>();
        formData.put("testClassId", className); // Nome della classe
        formData.put("robotType", robot_type); // Tipo di robot
        formData.put("difficulty", difficulty); // Livello di difficoltà corrente

        return callRestGET(endpoint, formData, String.class);
    }

    private int CreateGame(String Time, String difficulty, String name, String description, String id, String classUT) {
        final String endpoint = "/games";
        JSONObject obj = new JSONObject();
        obj.put("difficulty", difficulty);
        obj.put("name", name);
        /*
         * Stiamo usando descrizione per salvare la modalità di gioco
         * Stiamo usando username per salvare la classe sotto test
         */
        obj.put("description", description);
        obj.put("username", classUT);

        obj.put("startedAt", Time);
        JSONArray playersArray = new JSONArray();
        playersArray.put(String.valueOf(id));
        obj.put("players", playersArray);
        // Questa chiamata in risposta dà anche i valori che hai fornito, quindi faccio
        // parse per avere l'id
        String respose = callRestPost(endpoint, obj, null, null, String.class);
        // Parsing della stringa JSON
        JSONObject jsonObject = new JSONObject(respose);
        // Estrazione del valore di id
        return jsonObject.getInt("id");
    }

    private String EndGame(int gameid, String closedAt, int Score, Boolean isWinner) {
        final String endpoint = "/games/" + String.valueOf(gameid);
        /*
         * La chiamata sovrascrive perchè è una put, devi ridare tutti i dati 
            CurrentRound int        `json:"currentRound"`
            Name         string     `json:"name"`
            Username     string     `json:"username"`
            Description  string     `json:"description"`
            Score        float64    `json:"score"`
            IsWinner     bool       `json:"isWinner"`
            StartedAt    *time.Time `json:"startedAt,omitempty"`
            ClosedAt     *time.Time `json:"closedAt,omitempty"`
         */
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("closedAt", closedAt);
        jsonObject.put("score", Score);
        jsonObject.put("isWinner", isWinner);

        System.out.println(jsonObject);
        String respose = callRestPut(endpoint, jsonObject, null, null, String.class);
        return respose;
    }

    /*
    private String EndGame(int gameid, String username, String closedAt, int Score, Boolean isWinner){
        final String endpoint = "/games/" + String.valueOf(gameid);
        JSONObject formData = new JSONObject();
        formData.put("closedAt", closedAt);
        formData.put("username", username);
        formData.put("score", Integer.toString(Score));
        formData.put("isWinner", isWinner ? "true" : "false");
        try {
            String respose = callRestPut(endpoint, formData, null, null, String.class);
            return respose;
        } catch (Exception e) {
            throw new IllegalArgumentException("[CreateGame]: " + e.getMessage());
        }
    }
     */

    private int CreateRound(int game_id, String ClasseUT, String Time) {
        final String endpoint = "/rounds";
        JSONObject obj = new JSONObject();
        obj.put("gameId", game_id);
        obj.put("testClassId", ClasseUT);
        obj.put("startedAt", Time);
        String respose = callRestPost(endpoint, obj, null, null, String.class);
        // Parsing della stringa JSON
        JSONObject jsonObject = new JSONObject(respose);
        // Estrazione del valore di id
        return jsonObject.getInt("id");
    }

    private String EndRound(String Time, int roundId) {
        //Anche qui non è stato previsto un parametro per la chiamata rest e quindi va costruito a mano
        final String endpoint = "/rounds/" + String.valueOf(roundId);
        try {
            JSONObject formData = new JSONObject();
            formData.put("closedAt", Time);
            String response = callRestPut(endpoint, formData, null, null, String.class);
            return response;
        } catch (Exception e) {
            throw new IllegalArgumentException("[EndRound]: " + e.getMessage());
        }
    }

    private String CreateTurn(String Player_id, int Round_id, String Time) {
        final String endpoint = "/turns";
        JSONObject obj = new JSONObject();
        JSONArray playersArray = new JSONArray();
        playersArray.put(Player_id);
        obj.put("players", playersArray);
        obj.put("roundId", Round_id);
        obj.put("startedAt", Time);
        String respose = callRestPost(endpoint, obj, null, null, String.class);
        return respose;
    }

    private String EndTurn(String user_score, String Time, String turnId) {
        // Anche qui non è stato previsto un parametro per la chiamata rest e quindi va
        // costruito a mano
        final String endpoint = "/turns/" + turnId;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("TurnID", turnId);
        jsonObject.put("scores", user_score);
        jsonObject.put("closedAt", Time);
        String response = callRestPut(endpoint, jsonObject,null, null, String.class);
        return response;
    }

    // Questa chiamata non è documentata nel materiale di caterina
    private String CreateScalata(String player_id, String scalata_name, String creation_Time, String creation_date) {
        final String endpoint = "/turns";
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("playerID", player_id);
        formData.add("scalataName", scalata_name);
        formData.add("creationTime", creation_Time);
        formData.add("creationDate", creation_date);
        String respose = callRestPost(endpoint, formData, null, String.class);
        return respose;
    }

}
