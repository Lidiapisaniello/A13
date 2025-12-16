/*
 * Copyright (c) 2024 Stefano Marano
 */
package com.g2.interfaces;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.g2.model.NotificationResponse;
import com.g2.model.User;
import com.g2.model.dto.GameProgressDTO;
import com.g2.model.dto.PlayerProgressDTO;
import com.g2.model.dto.UpdateGameProgressDTO;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import testrobotchallenge.commons.models.dto.auth.JwtValidationResponseDTO;
import testrobotchallenge.commons.models.opponent.GameMode;
import testrobotchallenge.commons.models.opponent.OpponentDifficulty;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class T23Service extends BaseService {

    private static final Logger logger = LoggerFactory.getLogger(T23Service.class);
    private static final String EMAIL_FIELD = "email"; 
    
    private static final String BASE_URL = "http://api_gateway-controller:8090";
    private static final String SERVICE_PREFIX = "userService";
    private final ObjectMapper mapper = new ObjectMapper();

    @SuppressWarnings("unchecked")
    public T23Service(RestTemplate restTemplate) {
        super(restTemplate, BASE_URL + "/" + SERVICE_PREFIX);

        // Configurazione per evitare crash su campi sconosciuti
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        registerAction("GetAuthenticated", new ServiceActionDefinition(
                params -> getAuthenticated((String) params[0]),
                String.class
        ));

        registerNotificationActions();
        registerGetUserActions();
        registerUserProfileActions();
        registerPlayerStatusActions();
    }

    // metodo per l'autenticazione
    private JwtValidationResponseDTO getAuthenticated(String jwt) {
        final String endpoint = "/auth/validateToken";
        if (jwt == null || jwt.isEmpty()) {
            throw new IllegalArgumentException("[GETAUTHENTICATED] Errore, token nullo o vuoto");
        }
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("jwt", jwt);
        return callRestPost(endpoint, formData, null, JwtValidationResponseDTO.class);
    }

    // registrazione azioni relative al profilo utente
    private void registerUserProfileActions() {
        // Registrazione UpdateProfile con 5 parametri (JWT incluso)
        registerAction("UpdateProfile", new ServiceActionDefinition(
            params -> updateProfile(
                (String) params[0], // JWT
                (String) params[1], // Email
                (String) params[2], // Bio
                (String) params[3], // Nickname
                (String) params[4]  // ImagePath
            ),
            String.class, String.class, String.class, String.class, String.class
        ));

        registerAction("followUser", new ServiceActionDefinition(
                params -> followUser((Integer) params[0], (Integer) params[1]),
                Integer.class, Integer.class
        ));
        registerAction("getFollowers", new ServiceActionDefinition(
                params -> getFollowers((String) params[0]),
                String.class
        ));
        registerAction("getFollowing", new ServiceActionDefinition(
                params -> getFollowing((String) params[0]),
                String.class
        ));
    }

    private void registerNotificationActions() {
        registerAction("NewNotification", new ServiceActionDefinition(
                params -> newNotification((String) params[0], (String) params[1], (String) params[2]),
                String.class, String.class, String.class
        ));
        registerAction("getNotifications", new ServiceActionDefinition(
                params -> getNotifications((String) params[0], (Integer) params[1], (Integer) params[2]),
                String.class, Integer.class, Integer.class
        ));
        registerAction("updateNotification", new ServiceActionDefinition(
                params -> updateNotification((String) params[0], (String) params[1]),
                String.class, String.class
        ));
        registerAction("deleteNotification", new ServiceActionDefinition(
                params -> deleteNotification((String) params[0], (String) params[1]),
                String.class, String.class
        ));
        registerAction("clearNotifications", new ServiceActionDefinition(
                params -> clearNotifications((String) params[0]),
                String.class
        ));
    }

private void registerGetUserActions() {
        registerAction("GetUsers", new ServiceActionDefinition(params -> getUsers()));
        
        registerAction("GetUser", new ServiceActionDefinition(
                params -> getUser(String.valueOf(params[0])), 
                String.class
        ));

        registerAction("GetUsersByList", new ServiceActionDefinition(
                params -> getUserByList((List<String>) params[0]),
                List.class
        ));

        registerAction("GetUserByEmail", new ServiceActionDefinition(
                params -> getUserByEmail((String) params[0]),
                String.class
        ));

        // ricerca profili utente con doppia autenticazione
        registerAction("searchUserProfiles", new ServiceActionDefinition(
                params -> searchUserProfiles((String) params[0], (String) params[1], (Integer) params[2], (Integer) params[3]),
                String.class, String.class, Integer.class, Integer.class
        ));
    }

    //metodo di ricerca profili utente con doppia autenticazione
    private Object searchUserProfiles(String jwt, String searchTerm, int page, int size) {
        final String endpoint = "/profile/searchUserProfiles";
        
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/" + SERVICE_PREFIX + endpoint)
                .queryParam("searchTerm", searchTerm)
                .queryParam("page", page)
                .queryParam("size", size)
                .toUriString();

        try {
             HttpHeaders headers = new HttpHeaders();
             
             if (jwt != null && !jwt.isEmpty()) {
                 String cleanJwt = jwt.trim();
                 
                 headers.set("Authorization", "Bearer " + cleanJwt);
                 
                 headers.set("Cookie", "jwt=" + cleanJwt);
             }
             
             HttpEntity<?> entity = new HttpEntity<>(headers);

             // Chiediamo un Object generico
             ResponseEntity<Object> response = restTemplate.exchange(
                    url, 
                    HttpMethod.GET, 
                    entity, 
                    Object.class
             );
             return response.getBody();
        } catch (Exception e) {
            logger.error("Errore ricerca T23", e);
            return null;
        }
    }

    private void registerPlayerStatusActions() {
        registerAction("createPlayerProgressAgainstOpponent", new ServiceActionDefinition(
                params -> createPlayerProgressAgainstOpponent((long) params[0], (GameMode) params[1], (String) params[2], (String) params[3], (OpponentDifficulty) params[4]),
                Long.class, GameMode.class, String.class, String.class, OpponentDifficulty.class
        ));
        registerAction("getPlayerProgressAgainstOpponent", new ServiceActionDefinition(
                params -> getPlayerProgressAgainstOpponent((long) params[0], (GameMode) params[1], (String) params[2], (String) params[3], (OpponentDifficulty) params[4]),
                Long.class, GameMode.class, String.class, String.class, OpponentDifficulty.class
        ));
        registerAction("updatePlayerProgressAgainstOpponent", new ServiceActionDefinition(
                params -> updatePlayerProgressAgainstOpponent((long) params[0], (GameMode) params[1], (String) params[2],
                        (String) params[3], (OpponentDifficulty) params[4], (boolean) params[5], (Set<String>) params[6]),
                Long.class, GameMode.class, String.class, String.class, OpponentDifficulty.class, Boolean.class, Set.class
        ));
        registerAction("getPlayerProgressAgainstAllOpponent", new ServiceActionDefinition(
                params -> getPlayerProgressAgainstAllOpponent((long) params[0]),
                Long.class
        ));
        registerAction("incrementUserExp", new ServiceActionDefinition(
                params -> incrementUserExp((long) params[0], (int) params[1]),
                Long.class, Integer.class
        ));
        registerAction("updateGlobalAchievements", new ServiceActionDefinition(
                params -> updateGlobalAchievements((long) params[0], (Set<String>) params[1]), Long.class, Set.class
        ));
    }

// metodo per l'aggiornamento del profilo utente con doppia autenticazione
    private Boolean updateProfile(String jwt, String email, String bio, String nickname, String imagePath) {
        final String endpoint = "/profile/updateProfile"; 

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("email", email);
        formData.add("bio", bio);
        formData.add("nickname", nickname);
        formData.add("profilePicturePath", imagePath);

        try {
             String url = BASE_URL + "/" + SERVICE_PREFIX + endpoint;
             
             HttpHeaders headers = new HttpHeaders();
             headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
             
             if (jwt != null && !jwt.isEmpty()) {
                 // Rimuoviamo eventuali spazi extra
                 String cleanJwt = jwt.trim();

                 headers.set("Authorization", "Bearer " + cleanJwt);
                 
                 headers.set("Cookie", "jwt=" + cleanJwt);
                 
                 logger.info("T23Service: Token allegato alla richiesta verso T23 (Header + Cookie).");
             } else {
                 logger.warn("T23Service: ATTENZIONE! Il token JWT è nullo o vuoto!");
             }

             HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formData, headers);
             
             ResponseEntity<Boolean> response = restTemplate.postForEntity(url, requestEntity, Boolean.class);
             
             return response.getBody();
        } catch (Exception e) {
            logger.error("Errore chiamata T23 updateProfile", e);
            return false;
        }
    }

    
    private User getUserByEmail(String userEmail) {
        final String endpoint = "/profile/user_by_email";
        Map<String, String> queryParams = Map.of(EMAIL_FIELD, userEmail);
        try {
            String jsonRaw = callRestGET(endpoint, queryParams, String.class);
            if (jsonRaw == null || jsonRaw.trim().isEmpty()) return null;
            JsonNode root = mapper.readTree(jsonRaw);
            if (root.isArray()) {
                if (root.size() > 0) return mapper.treeToValue(root.get(0), User.class);
                else return null;
            } else if (root.isObject()) {
                return mapper.treeToValue(root, User.class);
            }
        } catch (Exception e) { logger.error("Errore parsing user", e); }
        return null;
    }

    private GameProgressDTO createPlayerProgressAgainstOpponent(long playerId, GameMode gameMode, String classUT, String type, OpponentDifficulty difficulty) {
        final String endpoint = "/players/%s/progression/against".formatted(playerId);
        JSONObject requestBody = new JSONObject();
        requestBody.put("classUT", classUT);
        requestBody.put("gameMode", gameMode.name());
        requestBody.put("type", type);
        requestBody.put("difficulty", difficulty.name());
        return callRestPost(endpoint, requestBody, null, null, GameProgressDTO.class);
    }

    private GameProgressDTO getPlayerProgressAgainstOpponent(long playerId, GameMode gameMode, String classUT, String type, OpponentDifficulty difficulty) {
        final String endpoint = "/players/%s/progression/against/%s/%s/%s/%s".formatted(playerId, gameMode.name(), classUT, type, difficulty.name());
        return callRestGET(endpoint, null, GameProgressDTO.class);
    }

    private GameProgressDTO updatePlayerProgressAgainstOpponent(long playerId, GameMode gameMode, String classUT, String type, OpponentDifficulty difficulty, boolean isWinner, Set<String> unlockedAchievements) {
        final String endpoint = "/players/%s/progression/against/%s/%s/%s/%s".formatted(playerId, gameMode.name(), classUT, type, difficulty.name());
        UpdateGameProgressDTO dto = new UpdateGameProgressDTO(isWinner, unlockedAchievements);
        JSONObject requestBody;
        try {
            requestBody = new JSONObject(mapper.writeValueAsString(dto));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return callRestPut(endpoint, requestBody, null, null, GameProgressDTO.class);
    }

    private PlayerProgressDTO getPlayerProgressAgainstAllOpponent(long playerId) {
        final String endpoint = "/players/%s/progression".formatted(playerId);
        try {
            String jsonRaw = callRestGET(endpoint, null, String.class);
            if (jsonRaw == null || jsonRaw.trim().isEmpty()) return null;
            return mapper.readValue(jsonRaw, PlayerProgressDTO.class);
        } catch (Exception e) { return null; }
    }

    private int incrementUserExp(long playerId, int expGained) {
        final String endpoint = "/players/%s/progression/experience".formatted(playerId);
        JSONObject requestBody = new JSONObject();
        requestBody.put("experiencePoints", expGained);
        return callRestPut(endpoint, requestBody, null, null, Integer.class);
    }

    private Set<String> updateGlobalAchievements(long playerId, Set<String> achievements) {
        final String endpoint = "/players/%s/progression/achievements/global".formatted(playerId);
        JSONObject requestBody = new JSONObject();
        requestBody.put("unlockedAchievements", achievements);
        return (Set<String>) callRestPut(endpoint, requestBody, null, null, Set.class);
    }

    private List<User> getUsers() {
        final String endpoint = "/student/students_list";
        return callRestGET(endpoint, null, new ParameterizedTypeReference<List<User>>() {});
    }

// metodo per ottenere un utente tramite ID
    private User getUser(String userId) {
        // NUOVO ENDPOINT (Quello che abbiamo appena creato in T23)
        final String endpoint = "/profile/user_by_id";
        Map<String, String> queryParams = Map.of("id", userId);
        
        try {
            // chiamata per ottenere il JSON grezzo
            String jsonRaw = callRestGET(endpoint, queryParams, String.class);
            
            if (jsonRaw == null || jsonRaw.trim().isEmpty()) return null;
            
            // conversione del JSON in User
            JsonNode root = mapper.readTree(jsonRaw);
            
            if (root.isArray()) {
                if (root.size() > 0) return mapper.treeToValue(root.get(0), User.class);
                else return null;
            } else if (root.isObject()) {
                return mapper.treeToValue(root, User.class);
            }
        } catch (Exception e) { 
            logger.error("Errore parsing user by ID", e); 
        }
        return null;
    }

    private List<User> getUserByList(List<String> idsStudenti) {
        final String endpoint = "/student/getStudentiTeam";
        HttpEntity<List<String>> requestEntity = new HttpEntity<>(idsStudenti);
        ResponseEntity<?> responseEntity = restTemplate.exchange(
                BASE_URL + "/" + SERVICE_PREFIX + endpoint,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<List<User>>() {}
        );
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return (List<User>) responseEntity.getBody();
        } else {
            return null;
        }
    }

    private String newNotification(String userEmail, String title, String message) {
        final String endpoint = "/notification/new_notification";
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add(EMAIL_FIELD, userEmail);
        map.add("title", title);
        map.add("message", message);
        return callRestPost(endpoint, map, null, String.class);
    }

    public NotificationResponse getNotifications(String userEmail, int page, int size) {
        final String endpoint = "/notification/notifications";
        Map<String, String> queryParams = Map.of(
                EMAIL_FIELD, userEmail,
                "page", String.valueOf(page),
                "size", String.valueOf(size)
        );
        ResponseEntity<NotificationResponse> response = restTemplate.exchange(
                buildUri(endpoint, queryParams), HttpMethod.GET, null, NotificationResponse.class
        );
        return (response == null) ? new NotificationResponse() : response.getBody();
    }

    public String updateNotification(String userEmail, String notificationID) {
        final String endpoint = "/notification/update_notification";
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add(EMAIL_FIELD, userEmail);
        formData.add("id notifica", notificationID);
        return callRestPost(endpoint, formData, null, String.class);
    }

    public String deleteNotification(String userEmail, String notificationID) {
        final String endpoint = "/notification/delete_notification";
        Map<String, String> queryParams = Map.of(EMAIL_FIELD, userEmail, "idnotifica", notificationID);
        return callRestDelete(endpoint, queryParams);
    }

    public String clearNotifications(String userEmail) {
        final String endpoint = "/notification/clear_notifications";
        Map<String, String> queryParams = Map.of(EMAIL_FIELD, userEmail);
        return callRestDelete(endpoint, queryParams);
    }

    public String followUser(Integer targetUserId, Integer authUserId) {
        final String endpoint = "/profile/toggle_follow";
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("targetUserId", String.valueOf(targetUserId));
        map.add("authUserId", String.valueOf(authUserId));
        return callRestPost(endpoint, map, null, String.class);
    }

// metodo per ottenere la lista dei follower e dei following di un utente
    public List<Map<String, Object>> getFollowers(String userId) {
        final String endpoint = "/profile/followers";
        Map<String, String> queryParams = Map.of("userId", userId);
        // Usiamo ParameterizedTypeReference per dire: "Prendi tutto il JSON così com'è"
        return callRestGET(endpoint, queryParams, new ParameterizedTypeReference<List<Map<String, Object>>>() {});
    }

    public List<Map<String, Object>> getFollowing(String userId) {
        final String endpoint = "/profile/following";
        Map<String, String> queryParams = Map.of("userId", userId);
        return callRestGET(endpoint, queryParams, new ParameterizedTypeReference<List<Map<String, Object>>>() {});
    }
}

