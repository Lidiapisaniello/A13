package com.example.db_setup.service;

import com.example.db_setup.model.*;
import com.example.db_setup.model.repository.PasswordResetTokenRepository;
import com.example.db_setup.security.AuthenticationPropertiesConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import testrobotchallenge.commons.models.user.Role;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class PasswordResetTokenService {

    private final AuthenticationPropertiesConfig authProperties;
    private final PasswordResetTokenRepository passwordResetTokenRepository;

    private static final Logger logger = LoggerFactory.getLogger(PasswordResetTokenService.class);

    public PasswordResetTokenService(AuthenticationPropertiesConfig authProperties, PasswordResetTokenRepository passwordResetTokenRepository) {
        this.authProperties = authProperties;
        this.passwordResetTokenRepository = passwordResetTokenRepository;
    }

    public PasswordResetToken generateRefreshToken(Player player) {
        String token = UUID.randomUUID().toString();
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setRole(Role.PLAYER);
        passwordResetToken.setPlayer(player);
        passwordResetToken.setToken(token);
        passwordResetToken.setExpiryDate(Instant.now().plusMillis(authProperties.getJwtRefreshCookieExpirationMs()));

        List<PasswordResetToken> oldPasswordResetTokens = passwordResetTokenRepository.findByPlayer(player);
        for (PasswordResetToken oldToken : oldPasswordResetTokens)
            this.rotate(oldToken);

        passwordResetTokenRepository.save(passwordResetToken);
        return passwordResetToken;
    }

    public PasswordResetToken generateRefreshToken(Admin admin) {
        String token = UUID.randomUUID().toString();
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setRole(Role.ADMIN);
        passwordResetToken.setAdmin(admin);
        passwordResetToken.setToken(token);
        passwordResetToken.setExpiryDate(Instant.now().plusMillis(authProperties.getJwtRefreshCookieExpirationMs()));

        List<PasswordResetToken> oldPasswordResetTokens = passwordResetTokenRepository.findByAdmin(admin);
        for (PasswordResetToken oldToken : oldPasswordResetTokens)
            this.rotate(oldToken);

        passwordResetTokenRepository.save(passwordResetToken);
        return passwordResetToken;
    }

    public PasswordResetToken verifyToken(String tokenValue) {
        return passwordResetTokenRepository.findByToken(tokenValue)
                .map(token -> {
                    logger.info("Password reset token found: {}", token);
                    if (token.getExpiryDate().isAfter(Instant.now()) && !token.isRevoked()) {
                        logger.info("Password reset token valid");
                        return token;
                    }
                    logger.info("Password reset token invalid: revoked {}, expired {}", token.getExpiryDate().isAfter(Instant.now()), !token.isRevoked());
                    token.setRevoked(true);
                    passwordResetTokenRepository.save(token);
                    return null;
                })
                .orElse(null);
    }


    private PasswordResetToken rotate(PasswordResetToken oldToken) {
        oldToken.setRevoked(true);
        return passwordResetTokenRepository.save(oldToken);
    }

}
