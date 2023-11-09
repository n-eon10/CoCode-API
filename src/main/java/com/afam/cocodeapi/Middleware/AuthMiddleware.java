package com.afam.cocodeapi.Middleware;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.core.env.Environment;

import java.util.Date;

public class AuthMiddleware {

    private final Environment environment;

    public AuthMiddleware(Environment environment) {
        this.environment = environment;
    }

    public String generateToken(String subject) {
        String secretKey = environment.getProperty("SECRET");

        long expiration = System.currentTimeMillis() + 604800000;

        return  Jwts.builder().setSubject(subject)
                .setExpiration(new Date(expiration))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean verifyToken(String token) {
        String secretKey = environment.getProperty("SECRET");

        try {
            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);

            return !claimsJws.getBody().getExpiration().before(new Date());

        } catch (Exception e) {
            return false;
        }
    }

}
