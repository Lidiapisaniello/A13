package com.example.db_setup.services;

import com.example.db_setup.model.RefreshToken;
import com.example.db_setup.model.User;
import com.example.db_setup.model.repositories.RefreshTokenRepository;
import com.example.db_setup.security.AuthenticationPropertiesConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final AuthenticationPropertiesConfig authProperties;

    public ResponseCookie generateRefreshToken(User user) {
        String token = UUID.randomUUID().toString();
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(token);
        refreshToken.setUser(user);
        refreshToken.setExpiryDate(Instant.now().plusMillis(authProperties.getJwtRefreshCookieExpirationMs()));

        List<RefreshToken> oldUserRefreshTokens = refreshTokenRepository.findByUser(user);
        for (RefreshToken oldRefreshToken : oldUserRefreshTokens)
            this.rotate(oldRefreshToken);

        refreshTokenRepository.save(refreshToken);
        return ResponseCookie.from(authProperties.getJwtRefreshCookieName(), refreshToken.getToken()).path("/").maxAge(refreshToken.getExpiryDate().toEpochMilli()).build();
    }

    public RefreshToken verifyToken(String refreshToken) {
        Optional<RefreshToken> savedToken = refreshTokenRepository.findByToken(refreshToken);
        if (savedToken.isPresent() && savedToken.get().getExpiryDate().isAfter(Instant.now()))
            return savedToken.get();

        return null;
    }

    public void invalidAllUserRefreshTokens(User user) {
        List<RefreshToken> oldUserRefreshTokens = refreshTokenRepository.findByUser(user);
        for (RefreshToken oldRefreshToken : oldUserRefreshTokens)
            this.rotate(oldRefreshToken);
    }

    private RefreshToken rotate(RefreshToken oldRefreshToken) {
        oldRefreshToken.setRevoked(true);
        return refreshTokenRepository.save(oldRefreshToken);
    }
}
