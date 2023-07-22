package com.evaluation.user.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {

    public String generateToken(String email) {
    	
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expirationDateTime = now.plusMinutes(1440);

        Date issuedAt = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        Date expirationDate = Date.from(expirationDateTime.atZone(ZoneId.systemDefault()).toInstant());

        byte[] secretKeyBytes = Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded();

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(issuedAt)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secretKeyBytes)
                .compact();
    }

    public String getSubjectFromToken(String token) {
        byte[] secretKeyBytes = Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded();

        Claims claims = Jwts.parser()
                .setSigningKey(secretKeyBytes)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

}
