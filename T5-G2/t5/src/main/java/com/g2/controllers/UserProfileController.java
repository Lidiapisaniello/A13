package com.g2.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.g2.components.GenericObjectComponent;
import com.g2.components.PageBuilder;
import com.g2.interfaces.ServiceManager;
import com.g2.model.GameConfigData;
import com.g2.model.User;
import com.g2.model.dto.ResponseTeamComplete; 
import com.g2.model.dto.PlayerProgressDTO;
import com.g2.security.JwtRequestContext;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.http.MediaType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
public class UserProfileController {

    private static final Logger logger = LoggerFactory.getLogger(UserProfileController.class);
    private final ServiceManager serviceManager;
    private GameConfigData gameConfigData = null;

    @Value("${config.gamification.file}")
    private String gamificationConFile;

    @Autowired
    public UserProfileController(ServiceManager serviceManager) {
        this.serviceManager = serviceManager;
    }

    @PostConstruct
    public void init() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("%s/%s".formatted(System.getProperty("user.dir"), gamificationConFile.replace("/", File.separator)));
            this.gameConfigData = objectMapper.readValue(file, GameConfigData.class);
        } catch (IOException e) {
            this.gameConfigData = new GameConfigData(10, 5, 1);
        }
    }

    // visualizzazione profilo personale
    @GetMapping("/profile")
    public String profilePagePersonal(Model model, @CookieValue(name = "jwt", required = false) String jwt) {
        if (jwt == null) jwt = JwtRequestContext.getJwtToken();
        PageBuilder profilePage = new PageBuilder(serviceManager, "profile", model, jwt);
        String userEmail = extractEmailFromJwt(jwt);

        if (userEmail == null) return "redirect:/login";

        try {
            User user = (User) serviceManager.handleRequest("T23", "GetUserByEmail", userEmail);
            if (user != null) {
                model.addAttribute("user", user);
                model.addAttribute("userInfo", user);
                model.addAttribute("isFriendProfile", false);
                model.addAttribute("stockImages", getProfilePictures());

                // recupero statistiche di gioco
                try {
                    PlayerProgressDTO progress = (PlayerProgressDTO) serviceManager.handleRequest("T23", "getPlayerProgressAgainstAllOpponent", user.getId());
                    model.addAttribute("playerProgress", progress);

                    if (progress != null) {
                        // Passiamo le stesse variabili che usa Achivement.html
                        model.addAttribute("userCurrentExperience", progress.getExperiencePoints());
                    } else {
                        model.addAttribute("userCurrentExperience", 0);
                    }
                    
                    // configurazioni gamification
                    if (gameConfigData != null) {
                        model.addAttribute("startingLevel", gameConfigData.getStartingLevel());
                        model.addAttribute("expPerLevel", gameConfigData.getExpPerLevel());
                        model.addAttribute("maxLevel", gameConfigData.getMaxLevel());
                    } else {
                        // Fallback se la config non è caricata
                        model.addAttribute("startingLevel", 1);
                        model.addAttribute("expPerLevel", 100);
                        model.addAttribute("maxLevel", 100);
                    }

                } catch (Exception ex) {
                    logger.warn("Impossibile caricare statistiche", ex);
                }

                profilePage.setObjectComponents(new GenericObjectComponent("user", user));
            }
        } catch (Exception e) {
            logger.error("Errore caricamento profilo", e);
        }
        return profilePage.handlePageRequest();
    }

    // aggiornamento profilo personale
    @PostMapping("/profile")
    public String updateProfile(
            @RequestParam(value = "bio", required = false) String bio,
            @RequestParam("email") String email,
            @RequestParam(value = "selectedImage", required = false) String selectedImage, 
            @CookieValue(name = "jwt", required = false) String jwt, 
            RedirectAttributes redirectAttributes
            ) {

        logger.info("=== UPDATE PROFILE (STOCK IMAGES) ===");
        
        if (jwt == null || jwt.isEmpty()) return "redirect:/login";

        try {
            String safeBio = (bio != null) ? bio : "";
            
            // Se l'utente ha cliccato un'immagine, usiamo quella. Altrimenti default.
            String imageToSend = (selectedImage != null && !selectedImage.isEmpty()) ? selectedImage : "default.png";

            String currentNickname = "Player";
            try {
                User currentUser = (User) serviceManager.handleRequest("T23", "GetUserByEmail", email);
                if (currentUser != null && currentUser.getUserProfile() != null && currentUser.getUserProfile().getNickname() != null) {
                    currentNickname = currentUser.getUserProfile().getNickname();
                }
            } catch (Exception ex) { logger.warn("Nickname non recuperato", ex); }

            Boolean result = (Boolean) serviceManager.handleRequest(
                    "T23", 
                    "UpdateProfile", 
                    jwt,                
                    email, 
                    safeBio, 
                    currentNickname, 
                    imageToSend 
            );

            if (Boolean.TRUE.equals(result)) {
                redirectAttributes.addFlashAttribute("successMsg", "Profilo aggiornato con successo!");
            } else {
                redirectAttributes.addFlashAttribute("errorMsg", "Errore: Il database ha rifiutato i dati.");
            }

        } catch (Exception e) {
            logger.error("Errore salvataggio", e);
            redirectAttributes.addFlashAttribute("errorMsg", "Errore Server: " + e.getMessage());
        }
        return "redirect:/profile";
    }

    // metodo di utilità per estrarre email da JWT
    private String extractEmailFromJwt(String jwt) {
        try {
            if (jwt == null || jwt.isEmpty()) return null;
            String[] parts = jwt.split("\\.");
            if (parts.length < 2) return null;
            byte[] decodedBytes = Base64.getDecoder().decode(parts[1]);
            String payload = new String(decodedBytes);
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> map = mapper.readValue(payload, Map.class);
            if (map.containsKey("sub")) return (String) map.get("sub");
            if (map.containsKey("email")) return (String) map.get("email");
            return null;
        } catch (Exception e) { return null; }
    }

    private List<String> getProfilePictures() {
        List<String> images = new ArrayList<>();
        images.add("default.png");
        images.add("men-1.png");
        images.add("men-2.png");
        images.add("men-3.png");
        images.add("men-4.png");
        images.add("women-1.png");
        images.add("women-2.png");
        images.add("women-3.png");
        images.add("women-4.png");
        return images;
    }


    
    // endpoint modificati per followers/following
    @GetMapping("/profile/followers") 
    public ResponseEntity<?> getFollowers(@RequestParam String userId) {
        try {
            return ResponseEntity.ok(serviceManager.handleRequest("T23", "getFollowers", userId));
        } catch (Exception e) {
            return ResponseEntity.ok(new ArrayList<>());
        }
    }

    @GetMapping("/profile/following")
    public ResponseEntity<?> getFollowing(@RequestParam String userId) {
        try {
            return ResponseEntity.ok(serviceManager.handleRequest("T23", "getFollowing", userId));
        } catch (Exception e) {
            return ResponseEntity.ok(new ArrayList<>());
        }
    }

    // ricerca utenti
    @GetMapping("/profile/search_api")
    @ResponseBody
    public ResponseEntity<?> searchUserProfiles(
            @RequestParam String searchTerm,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @CookieValue(name = "jwt", required = false) String jwt) {
        
        try {
            if (jwt == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

            Object result = serviceManager.handleRequest("T23", "searchUserProfiles", jwt, searchTerm, page, size);
            
            // Restituisci JSON vuoto se il risultato è null
            if (result == null) {
                return ResponseEntity.ok(Map.of("content", List.of(), "totalPages", 0));
            }

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error("Errore controller ricerca", e);
            // Restituisci JSON vuoto anche in caso di errore
            return ResponseEntity.ok(Map.of("content", List.of(), "totalPages", 0));
        }
    }

    @GetMapping("/edit_profile")
    public String showEditProfile(Model model, @CookieValue(name = "jwt", required = false) String jwt) {
       if (jwt == null) jwt = JwtRequestContext.getJwtToken();
       PageBuilder editPage = new PageBuilder(serviceManager, "edit_profile", model, jwt);
       String email = extractEmailFromJwt(jwt);
       if (email == null) return "redirect:/login";
       User user = (User) serviceManager.handleRequest("T23", "GetUserByEmail", email);
       if(user != null) {
           model.addAttribute("user", user);
           model.addAttribute("userInfo", user);
           model.addAttribute("stockImages", getProfilePictures());
           model.addAttribute("bio", user.getUserProfile().getBio());
           model.addAttribute("propic", user.getUserProfile().getProfilePicturePath());
           editPage.setObjectComponents(new GenericObjectComponent("user", user), new GenericObjectComponent("images", getProfilePictures()));
       }
       return editPage.handlePageRequest();
    }

@GetMapping("/friend/{playerID}")
    public String friendProfilePage(Model model, @PathVariable("playerID") Long playerID, @CookieValue(name = "jwt", required = false) String jwt) {
        logger.info("=== FRIEND PROFILE PAGE for ID: {} ===", playerID);
        if (jwt == null) jwt = JwtRequestContext.getJwtToken();
        PageBuilder profile = new PageBuilder(serviceManager, "friend_profile", model, jwt);
        
        // carica me stesso
        String myEmail = extractEmailFromJwt(jwt);
        User myself = null;
        if (myEmail != null) {
            try {
                myself = (User) serviceManager.handleRequest("T23", "GetUserByEmail", myEmail);
                if (myself != null) model.addAttribute("userInfo", myself);
            } catch (Exception e) {}
        }

        // carica amico
        try {
            User friend = (User) serviceManager.handleRequest("T23", "GetUser", String.valueOf(playerID));
            logger.info("Friend loaded: {}", friend);
            if (friend != null) {
                model.addAttribute("user", friend);
                
                // Statistiche
                try {
                     PlayerProgressDTO progress = (PlayerProgressDTO) serviceManager.handleRequest("T23", "getPlayerProgressAgainstAllOpponent", friend.getId());
                     // Se progress è null, creiamo un oggetto vuoto o gestiamo nel template
                     model.addAttribute("playerProgress", progress); 
                } catch (Exception ex) {
                     model.addAttribute("playerProgress", null); // Assicura che sia null esplicito
                }

                // Social e Calcolo amIFollowing
                boolean amIFollowing = false;
                logger.info("Checking if myself follows friend...");
                try {
                    String friendIdStr = String.valueOf(friend.getUserProfile().getId());
                    List<Map<String, Object>> followers = (List<Map<String, Object>>) serviceManager.handleRequest("T23", "getFollowers", friendIdStr);
                    logger.info("Followers of {}: {}", friendIdStr, followers);
                    
                    if (myself != null && followers != null) {
                        String myIdStr = String.valueOf(myself.getId());
                        for(Map<String, Object> f : followers) {
                            Object fId = f.get("userId");
                            // Gestione sicura del tipo 
                            logger.info("Checking follower ID: {}, {}, {}, isEqual: {}", fId, String.valueOf(fId), myIdStr, fId != null ? String.valueOf(fId).equals(myIdStr) : "fId is null");
                            if (fId != null && String.valueOf(fId).equals(myIdStr)) {
                                amIFollowing = true;
                                break;
                            }
                        }
                    }
                } catch (Exception ex) { logger.warn("Err social friend", ex); }
                
                model.addAttribute("amIFollowing", amIFollowing);

                profile.setObjectComponents(new GenericObjectComponent("user", friend));
            } else {
                // Se l'amico non esiste, reindirizza o mostra errore
                return "redirect:/profile"; 
            }
        } catch (Exception e) { 
            logger.error("Errore profilo amico", e);
            return "redirect:/profile";
        }
        
        return profile.handlePageRequest();
    }



    @GetMapping("/Team")
    public String profileTeamPage(Model model) {
        PageBuilder teamPage = new PageBuilder(serviceManager, "Team", model, JwtRequestContext.getJwtToken());
        ResponseTeamComplete team = (ResponseTeamComplete) serviceManager.handleRequest("T1", "OttieniTeamCompleto", teamPage.getUserId());
        if (team != null) {
            @SuppressWarnings("unchecked")
            List<User> membri = (List<User>) serviceManager.handleRequest("T23", "GetUsersByList", team.getTeam().getStudenti());
            model.addAttribute("response", team);
            model.addAttribute("membri", membri);
        }
        return teamPage.handlePageRequest();
    }

    @GetMapping("/Achievement")
    public String showAchievements(Model model) {
        PageBuilder achievement = new PageBuilder(serviceManager, "Achivement", model, JwtRequestContext.getJwtToken());
        Long userId = achievement.getUserId();
        if(userId == null) return "redirect:/login";
        PlayerProgressDTO playerProgress = (PlayerProgressDTO) serviceManager.handleRequest("T23", "getPlayerProgressAgainstAllOpponent", userId);
        if (playerProgress != null) {
            model.addAttribute("gamemode_achievements", playerProgress.getGameProgressesDTO());
            model.addAttribute("general_achievements", playerProgress.getGlobalAchievements());
            model.addAttribute("userCurrentExperience", playerProgress.getExperiencePoints());
        }
        model.addAttribute("startingLevel", gameConfigData.getStartingLevel());
        model.addAttribute("expPerLevel", gameConfigData.getExpPerLevel());
        model.addAttribute("maxLevel", gameConfigData.getMaxLevel());
        return achievement.handlePageRequest();
    }

    @GetMapping("/SearchFriend")
    public String showSearchFriendPage(Model model) {
        return new PageBuilder(serviceManager, "search", model, JwtRequestContext.getJwtToken()).handlePageRequest();
    }
    @GetMapping("/Notification")
    public String showProfileNotificationPage(Model model) {
        return new PageBuilder(serviceManager, "notification", model, JwtRequestContext.getJwtToken()).handlePageRequest();
    }
    @GetMapping("/Games")
    public String showGameHistory(Model model) {
        return new PageBuilder(serviceManager, "GameHistory", model, JwtRequestContext.getJwtToken()).handlePageRequest();
    }
}