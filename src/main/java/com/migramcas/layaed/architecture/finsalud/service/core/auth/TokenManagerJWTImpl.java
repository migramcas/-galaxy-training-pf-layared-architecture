package com.migramcas.layaed.architecture.finsalud.service.core.auth;

import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static io.jsonwebtoken.Jwts.builder;
import static io.jsonwebtoken.Jwts.parser;

@Service
public class TokenManagerJWTImpl implements TokenManager {

    private static final String KEY = "ClaveSecreta_Segura-a65s-@4d6asd132!asd1&6as4dq(3q)wed";

    public static final String CLAIM_ID = "id";
    public static final String CLAIM_USERNAME = "username";

    private static Key getSigningKey() {
        return Keys.hmacShaKeyFor(KEY.getBytes());
    }


    private static final long EXPIRATION_TIME_IN_MILISECONDS = 3600000;


    @Override
    public String createToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME_IN_MILISECONDS);

        Map<String, String> payload = new HashMap<>();
        payload.put(CLAIM_ID, String.valueOf(user.getId().getValue()));
        payload.put(CLAIM_USERNAME, user.getEmail());

        return builder()
                .claims(payload)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(getSigningKey())
                .compact();
    }

    @Override
    public boolean validate(String token) {
        try {
            parser()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Map<String, String> getPayload(String token) {
        try {
            return parser()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .entrySet()
                    .stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().toString()));
        } catch (SignatureException e) {
            throw new IllegalArgumentException("Invalid JWT signature", e);
        }
    }

}
