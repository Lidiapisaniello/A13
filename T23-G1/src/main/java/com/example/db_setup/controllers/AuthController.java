package com.example.db_setup.controllers;

import com.example.db_setup.model.RefreshToken;
import com.example.db_setup.model.repositories.RefreshTokenRepository;
import com.example.db_setup.security.AuthenticationPropertiesConfig;
import com.example.db_setup.services.RefreshTokenService;
import com.example.db_setup.services.RegistrationService;
import com.example.db_setup.UserRepository;
import com.example.db_setup.model.User;
import com.example.db_setup.model.dto.LoginDTO;
import com.example.db_setup.model.dto.RegistrationDTO;
import com.example.db_setup.security.jwt.JwtProvider;
import com.example.db_setup.security.services.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AuthenticationManager authenticationManager;
    private final  UserRepository userRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder encoder;
    private final RegistrationService registrationService;
    private final  RefreshTokenService refreshTokenService;
    private final AuthenticationPropertiesConfig authProperties;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegistrationDTO registrationDTO) {
        if (userRepository.findByUserProfileEmail((registrationDTO.getEmail())).isPresent()) {
            return ResponseEntity.badRequest().body("Error: Username is already taken");
        }

        // Creo il nuovo account utente
        User user = new User(registrationDTO.getName(), registrationDTO.getSurname(),
                registrationDTO.getEmail(), encoder.encode(registrationDTO.getPassword()),
                registrationDTO.getStudies());

        // Richiedo l'inizializzazione dei punti esperienza per il nuovo utente. Se la richiesta fallisce restituisco un
        // errore e non registro l'utente
        if (! registrationService.initializeExperiencePoints(user.getID())) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error initializing experience points. Please retry to subscribe.");
        }

        userRepository.save(user);

        return ResponseEntity.ok().body("Successfully registered");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginDTO, HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("[POST /auth/login] request: {}", loginDTO);

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtProvider.generateJwtCookie(userDetails.getEmail(), userDetails.getId());

        Optional<User> userOpt = userRepository.findByUserProfileEmail((loginDTO.getEmail()));

        if (!userOpt.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");

        User user = userOpt.get();
        ResponseCookie refreshCookie = refreshTokenService.generateRefreshToken(user);

        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .header(HttpHeaders.SET_COOKIE, refreshCookie.toString())
                .body("");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@CookieValue(value = "jwt") String token) {
        ResponseCookie cookie = jwtProvider.getCleanJwtCookie();
        logger.info("[POST /auth/logout] clean cookie: {}", cookie);

        String userEmail = jwtProvider.getUserEmailFromJwtToken(token);
        userRepository.findByUserProfileEmail(userEmail).ifPresent(refreshTokenService::invalidAllUserRefreshTokens);

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body("You've been signed out!");
    }

    @PostMapping("/validateToken")
    public ResponseEntity<Boolean> checkValidityToken(@RequestParam("jwt") String token) {
        return ResponseEntity.ok(jwtProvider.validateJwtToken(token));
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<String> refreshJwtToken(@CookieValue(value = "jwt-refresh") String token) {
        RefreshToken refreshToken = refreshTokenService.verifyToken(token);
        if (refreshToken == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid refresh token");
        }

        ResponseCookie jwtCookie = jwtProvider.generateJwtCookie(refreshToken.getUser().getEmail(), refreshToken.getUser().getID());
        ResponseCookie newRefreshCookie = refreshTokenService.generateRefreshToken(refreshToken.getUser());

        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .header(HttpHeaders.SET_COOKIE, newRefreshCookie.toString())
                .body("");
    }
}
