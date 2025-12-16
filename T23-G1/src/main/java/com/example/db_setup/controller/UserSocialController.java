package com.example.db_setup.controller;

import com.example.db_setup.model.Player;
import com.example.db_setup.model.UserProfile;
import com.example.db_setup.service.PlayerService;
import com.example.db_setup.service.UserSocialService;
import com.example.db_setup.service.exception.UserNotFoundException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/profile")
public class UserSocialController {

    @Autowired
    private UserSocialService userSocialService;
    @Autowired
    private PlayerService playerService;


    // Funzione di ricerca profilo
 @GetMapping("/searchUserProfiles")
    public ResponseEntity<Map<String, Object>> searchUserProfiles(
            @RequestParam String searchTerm,
            @RequestParam int page,
            @RequestParam int size) {
        
        // Log per debug
        System.out.println("T23 SEARCH: Cercando '" + searchTerm + "'");

        Page<UserProfile> pageResult = userSocialService.searchUserProfiles(searchTerm, page, size);
        
        System.out.println("T23 SEARCH: Trovati " + pageResult.getTotalElements() + " risultati");
        
        // Costruzione manuale della risposta per evitare problemi di serializzazione
        Map<String, Object> response = new HashMap<>();
        
        response.put("content", pageResult.getContent());      
        response.put("totalPages", pageResult.getTotalPages());   
        response.put("totalElements", pageResult.getTotalElements()); 
        
        return ResponseEntity.ok(response);
    }

    // metodo per ottenere un utente tramite email
    @GetMapping("/user_by_email")
    @ResponseBody
    public ResponseEntity<?> getUserByEmail(@RequestParam("email") String email) {
        try {
            // Recupera il profilo dal database
            UserProfile profile = playerService.findProfileByEmail(email);
            
            if (profile == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utente non trovato");
            }
            
            // Costruiamo la risposta manualmente per T5
            Map<String, Object> response = new HashMap<>();
            
            // Gestiamo il caso in cui getUserId() possa essere null
            Long safeId = 0L;
            try {

                if (profile.getUserId() != null) {
                     safeId = profile.getUserId();
                }
            } catch (Exception e) {
                
                safeId = (long) email.hashCode();
            }
            
            response.put("id", safeId);
            response.put("email", email);
            response.put("userProfile", profile);
        
            // Campi extra per sicurezza
            response.put("name", profile.getName());
            response.put("surname", profile.getSurname());
            response.put("nickname", profile.getNickname());
            
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore server T23: " + e.getMessage());
        }
    }


    // nuovo metodo per visualizzare l'utente tramite ID
    @GetMapping("/user_by_id")
    public ResponseEntity<?> getUserById(@RequestParam("id") Long id) {
        try {
            
            com.example.db_setup.model.Player player = playerService.getUserByID(id);
            
            if (player == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utente non trovato");
            }
            
            // risposta identica a getUserByEmail
            Map<String, Object> response = new HashMap<>();
            response.put("id", player.getID());
            response.put("email", player.getEmail());
            response.put("userProfile", player.getUserProfile());
            
            response.put("name", player.getName());
            response.put("surname", player.getSurname());
            
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore: " + e.getMessage());
        }
    }


    @PostMapping("/getStudentiTeam")
    public ResponseEntity<?> getStudentiTeam(@RequestBody List<String> idsStudenti) {
        return playerService.getStudentiTeam(idsStudenti);
    }

    // --- SOCIAL (Followers/Following) ---
    @GetMapping("/followers")
    public ResponseEntity<?> getFollowers(@RequestParam String userId) {
        try {
            return ResponseEntity.ok(userSocialService.getFollowers(userId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore");
        }
    }

    @GetMapping("/following")
    public ResponseEntity<?> getFollowing(@RequestParam String userId) {
        log.info("Ricevuta richiesta di getFollowing per userId: " + userId);
        try {
            return ResponseEntity.ok(userSocialService.getFollowing(userId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore");
        }
    }

    @GetMapping("/isFollowing")
    public ResponseEntity<?> isFollowing(@RequestParam String followerId, @RequestParam String followingId) {
        try {
            boolean result = userSocialService.isFollowing(followerId, followingId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore");
        }
    }

    @PostMapping("/toggle_follow")
    public ResponseEntity<?> toggleFollow(@RequestParam String followerId, @RequestParam String followingId) {
        log.info("Ricevuta richiesta di toggleFollow: followerId=" + followerId + ", followingId=" + followingId);
        try {
            boolean FollowState = userSocialService.toggleFollow(followerId, followingId);
            return ResponseEntity.ok(FollowState);
        } catch (Exception e) {
            log.error("Errore durante il toggleFollow", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore");
        }
    }

    // Metodo per aggiornare il profilo utente
    @PostMapping("/updateProfile")
    public ResponseEntity<Boolean> editProfile(
            @RequestParam("email") String email,
            @RequestParam("bio") String bio,
            @RequestParam("profilePicturePath") String profilePicturePath,
            @RequestParam(value = "nickname", required = false) String nickname) {
        
        System.out.println("--- T23: Ricevuta richiesta di update per " + email + " ---");
        System.out.println("Dati: Bio='" + bio + "', Nick='" + nickname + "', Img='" + profilePicturePath + "'");

        try {
            // recupero del profilo esistente
            UserProfile profile = playerService.findProfileByEmail(email);
            
            if (profile == null) {
                System.out.println("ERRORE T23: Profilo non trovato per email " + email);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
            }
            
            // aggionrnamento dei campi
            profile.setBio(bio);
            profile.setProfilePicturePath(profilePicturePath);
            
            if (nickname != null && !nickname.isEmpty()) {
                profile.setNickname(nickname);
            }
            
            // salvataggio del profilo aggiornato
            System.out.println("T23: Tentativo salvataggio...");
            playerService.saveProfile(profile);
            System.out.println("T23: Salvataggio riuscito!");
            
            return ResponseEntity.ok(true);
            
        } catch (Exception e) {
            // stampa dell'eccezione per debug
            System.err.println("ECCEZIONE GRAVE IN T23 UPDATE:");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
}