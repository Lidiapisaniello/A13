package com.example.db_setup.controller.advice;

import com.example.db_setup.service.AuthService;
import com.example.db_setup.service.exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestControllerAdvice
public class AuthExceptionHandler {

    private final MessageSource messageSource;

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    public AuthExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(PasswordMismatchException.class)
    public ResponseEntity<Map<String, Object>> handlePasswordMismatchException(PasswordMismatchException e, Locale locale) {
        return ResponseEntity.badRequest().body(
                Map.of("errors", List.of(Map.of("field", e.getField(),
                        "message", messageSource.getMessage("UserRegistrationDTO.password.mismatch", null, locale)))));
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handleUserAlreadyExistsException(UserAlreadyExistsException e, Locale locale) {
        return ResponseEntity.badRequest().body(
                Map.of("errors", List.of(Map.of("field",  e.getField(),
                        "message", messageSource.getMessage("UserRegistrationDTO.email.taken", null, locale)))));
    }

    @ExceptionHandler(ServiceNotAvailableException.class)
    public ResponseEntity<Map<String, Object>> handleServiceNotAvailableException(ServiceNotAvailableException e, Locale locale) {
        return ResponseEntity.internalServerError().body(
                Map.of("errors", List.of(Map.of("field",  e.getField(),
                        "error", messageSource.getMessage("experience.init.error", null, locale)))));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFoundException(UserNotFoundException e, Locale locale) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("errors", List.of(Map.of("field", e.getField(),
                        "error", messageSource.getMessage("LoginDTO.user.notfound", null, locale)))));

    }

    @ExceptionHandler(MessagingException.class)
    public ResponseEntity<Map<String, Object>> handleMessagingException(MessagingException e, Locale locale) {
        logger.error("[requestResetPassword] Failed to send reset password email", e);

        return ResponseEntity.internalServerError().body(
                Map.of("errors", List.of(Map.of("field", "none",
                        "error", messageSource.getMessage("emailService.messagingException", null, locale)))));
    }

    @ExceptionHandler(PasswordResetTokenNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlePasswordResetTokenNotFoundException(PasswordResetTokenNotFoundException e, Locale locale) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                Map.of("errors", List.of(Map.of("field", e.getField(),
                        "error", messageSource.getMessage("passwordResetToken.incorrect", null, locale)))));
    }

    @ExceptionHandler(IncompatibleEmailException.class)
    public ResponseEntity<Map<String, Object>> handleIncompatibleEmailException(IncompatibleEmailException e, Locale locale) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                Map.of("errors", List.of(Map.of("field", e.getField(),
                        "error", messageSource.getMessage("passwordResetToken.incorrect", null, locale)))));

    }

    @ExceptionHandler(InvalidRefreshTokenException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidRefreshTokenException(InvalidRefreshTokenException e, Locale locale) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                Map.of("errors", List.of(Map.of("field", e.getField(),
                        "error", messageSource.getMessage("refreshToken.incorrect", null, locale)))));

    }
}
