package com.QuickNotesAPI.QuickNotes.util;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.QuickNotesAPI.QuickNotes.model.Users;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

/**
 * Utility class to generate and validate JSON Web Tokens (JWT) in the context
 * of authentication.
 * This class is responsible for creating, extracting and verifying the JWT
 * tokens used in the application.
 */
@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String SECRET_KEY;

    private Key secretKey;

    /**
     * Method that initializes the secret key at class construction time.
     * Automatically invoked after bean construction.
     */
    @PostConstruct
    public void init() {
        // Converts the secret key into a Key object using the HMAC SHA algorithm
        this.secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Method that generates a JWT based on user information.
     *
     * @param user The user for which the JWT will be generated.
     * @return generated JWT token, preceded by the "Bearer" prefix.
     */
    public String generateJWT(Users user) {
        Map<String, Object> headers = new HashMap<>();

        headers.put("alg", "HS256");
        headers.put("typ", "JWT");

        return "Bearer " + Jwts.builder()
                .setHeader(headers)
                .setSubject(user.getEmail())
                .claim("id", user.getUsersId())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                // Set the expiration date (6 hours)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 6))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Method that extracts the email from the JWT.
     *
     * @param token The JWT token from which the email will be extracted.
     * @return user's email extracted from the JWT.
     */
    public String extractEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    /**
     * Method that extracts the user's role from the JWT.
     *
     * @param token The JWT token from which the role will be extracted.
     * @return the user's role extracted from the JWT.
     */
    public String extractRole(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class);
    }

    /**
     * Method that checks if the token has expired.
     *
     * @param token The JWT token to verify.
     * @return "true" if the token has expired, "false" if not.
     */
    public boolean isTokenExpired(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }
}
