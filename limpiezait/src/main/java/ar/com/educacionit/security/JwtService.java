package ar.com.educacionit.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class JwtService {

    private final SecretKey key;
    private final long expirationMinutes;

    public JwtService(
        @Value("${app.jwt.secret}") String secretBase64,
        @Value("${app.jwt.expiration-minutes:60}") long expirationMinutes
    ) {
        byte[] keyBytes = Decoders.BASE64.decode(secretBase64); // <- usa la secret en Base64
        if (keyBytes.length < 32) { // 32 bytes = 256 bits
            throw new IllegalArgumentException("JWT secret must be >= 256 bits (32 bytes). Provided: " + (keyBytes.length * 8) + " bits");
        }
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.expirationMinutes = expirationMinutes;
    }

    public String generateToken(String username, List<String> roles) {
        Instant now = Instant.now();
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(expirationMinutes, ChronoUnit.MINUTES)))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Jws<Claims> validateAndParse(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
    }

    public String extractUsername(String token) {
        return validateAndParse(token).getBody().getSubject();
    }

    @SuppressWarnings("unchecked")
    public List<String> extractRoles(String token) {
        var roles = validateAndParse(token).getBody().get("roles", List.class);
        return roles == null ? List.of() : roles;
    }
}
