package com.paypal.user_service.util;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JWTUtil {

    private static final String SECRET = "secret123secret123secret123secret123";

    private Key getSigninKey(){
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String extractEmail(String token){
        return Jwts.parserBuilder()
                   .setSigningKey(getSigninKey())
                   .build()
                   .parseClaimsJws(token)
                   .getBody()
                   .getSubject();
    }

    public boolean validateToken(String token){
        try {
            extractEmail(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractUsername(String token){
        return Jwts.parserBuilder()
                   .setSigningKey(getSigninKey())
                   .build()
                   .parseClaimsJws(token)
                   .getBody()
                   .getSubject();
    }

    public String generateToken(Long userId, String email, String role){
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("role", role);

        return Jwts.builder()
                   .setClaims(claims)
                   .setSubject(email)
                   .setIssuedAt(new Date(System.currentTimeMillis()))
                   .setExpiration(new Date(System.currentTimeMillis() + 8460000))
                   .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                   .compact();
    }

    public String extractRole(String token){
        Object val = Jwts.parserBuilder()
                         .setSigningKey(getSigninKey())
                         .build()
                         .parseClaimsJws(token)
                         .getBody()
                         .get("role");
        return val == null ? null : val.toString();
    }

    public Long extractUserId(String token){
        Object val = Jwts.parserBuilder()
                         .setSigningKey(getSigninKey())
                         .build()
                         .parseClaimsJws(token)
                         .getBody()
                         .get("userId");
        return val == null ? null : Long.parseLong(val.toString());
    }
}
