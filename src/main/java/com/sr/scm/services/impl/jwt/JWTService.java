package com.sr.scm.services.impl.jwt;

import com.sr.scm.dtos.UserDTO;
import com.sr.scm.entities.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class JWTService {

    private static final Log logger = LogFactory.getLog(JWTService.class);
    private String key;

    public JWTService() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk = keyGen.generateKey();
            key = Base64.getEncoder().encodeToString(sk.getEncoded());
        } catch (Exception e) {
            logger.error("unable to generate key");
        }
    }

    public String generateToken(Users users) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder().claims(claims)
                .subject(users.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 5))
                .signWith(getKey())
                .compact();
    }

    public String generateToken(UserDTO user) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder().claims(claims)
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 5))
                .signWith(getKey())
                .compact();
    }

    public Key getKey() {
        return Keys.hmacShaKeyFor(Base64.getDecoder().decode(key));
    }
}
