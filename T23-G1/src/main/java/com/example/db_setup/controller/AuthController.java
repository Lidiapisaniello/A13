package com.example.db_setup.controller;

import testrobotchallenge.commons.models.dto.auth.JwtValidationResponseDTO;
import testrobotchallenge.commons.models.user.Role;
import com.example.db_setup.model.dto.auth.*;

import com.example.db_setup.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.Locale;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;

    @PostMapping("/register")
    @Operation(summary = "Register a new player user", description = "Registers a new player with provided personal details and credentials.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Player registered successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input or validation error"),
            @ApiResponse(responseCode = "409", description = "Email already in use")
    })
    public ResponseEntity<Object> registerUser(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {
        authService.registerPlayer(userRegistrationDTO.getName(), userRegistrationDTO.getSurname(),
                userRegistrationDTO.getEmail(), userRegistrationDTO.getPassword(), userRegistrationDTO.getPasswordCheck(),
                userRegistrationDTO.getStudies());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/admin/register")
    public ResponseEntity<Object> registerAdmin(@Valid @RequestBody AdminRegistrationDTO adminRegistrationDTO) {
        authService.registerAdmin(adminRegistrationDTO.getName(), adminRegistrationDTO.getSurname(),
                adminRegistrationDTO.getEmail(), adminRegistrationDTO.getPassword(),
                adminRegistrationDTO.getPasswordCheck());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@Valid @RequestBody LoginDTO loginDTO) {
        logger.info("[POST /auth/login] request: {}", loginDTO);
        String[] cookies = authService.loginPlayer(loginDTO.getEmail(), loginDTO.getPassword());

        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, cookies[0])
                .header(HttpHeaders.SET_COOKIE, cookies[1])
                .build();
    }

    @PostMapping("/admin/login")
    public ResponseEntity<Object> loginAdmin(@Valid @RequestBody LoginDTO loginDTO) {
        String[] cookies = authService.loginAdmin(loginDTO.getEmail(), loginDTO.getPassword());

        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, cookies[0])
                .header(HttpHeaders.SET_COOKIE, cookies[1])
                .build();
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@CookieValue(value = "jwt") String jwtToken, @CookieValue(value = "jwt-refresh") String refreshToken) {
        String[] cookies = authService.logout(jwtToken, refreshToken);

        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, cookies[0])
                .header(HttpHeaders.SET_COOKIE, cookies[1])
                .build();
    }

    @PostMapping("/validateToken")
    public ResponseEntity<JwtValidationResponseDTO> checkValidityToken(@RequestParam("jwt") String token) {
        logger.info("[POST /auth/validateToken] Received request: {}", token);
        JwtValidationResponseDTO response = authService.validateToken(token);
        logger.info("[POST /auth/validateToken] Request validation result: {}", response);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<String> refreshJwtToken(@CookieValue(value = "jwt-refresh") String token) {
        String cookie = authService.refreshToken(token);

        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, cookie)
                //.header(HttpHeaders.SET_COOKIE, newRefreshCookie.toString())
                .body("");
    }

    @PostMapping("/reset_password")
    public ResponseEntity<Object> resetPasswordUser(@RequestParam String email, Locale locale) throws MessagingException {
        authService.requestResetPassword(email, Role.PLAYER, locale);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/reset_password")
    public ResponseEntity<Object> resetPasswordAdmin(@RequestParam String email, Locale locale) throws MessagingException {
        authService.requestResetPassword(email, Role.ADMIN, locale);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/change_password")
    public ResponseEntity<Object> changePasswordUser(@Valid @RequestBody ChangePasswordRequestDTO changePasswordRequestDTO) {
        authService.changePassword(changePasswordRequestDTO.getEmail(), changePasswordRequestDTO.getPassword(),
            changePasswordRequestDTO.getPasswordCheck(), changePasswordRequestDTO.getPasswordResetToken(), Role.PLAYER);
        
        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/change_password")
    public ResponseEntity<Object> changePasswordAdmin(@Valid @RequestBody ChangePasswordRequestDTO changePasswordRequestDTO) {
        authService.changePassword(changePasswordRequestDTO.getEmail(), changePasswordRequestDTO.getPassword(),
            changePasswordRequestDTO.getPasswordCheck(), changePasswordRequestDTO.getPasswordResetToken(), Role.ADMIN);

        return ResponseEntity.ok().build();
    }
}
