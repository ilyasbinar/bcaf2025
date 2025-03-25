package id.co.bcaf.pinjol_keren.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class JwtBlacklist {

    @Autowired
    private BlacklistedTokenRepository repository;

    public void add(String token, LocalDateTime expiryDate) {
        BlacklistedToken blacklistedToken = new BlacklistedToken(token, expiryDate);
        repository.save(blacklistedToken);
    }

    public boolean isBlacklisted(String token) {
        return repository.existsByToken(token);
    }
}