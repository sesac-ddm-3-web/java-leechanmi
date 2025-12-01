package org.example.simpleboard.common.security;

import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtService {

    private final SecretKey key;

    public JwtService(@Value("${jwt.secret}") String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String createToken(Long memberId) {
        return Jwts.builder()
            .subject(String.valueOf(memberId))
            .signWith(key)
            .compact();
    }

    public Long parseSubject(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token);

            return Long.valueOf(claimsJws.getPayload().getSubject());
        } catch (Exception e) {
            throw new UnauthenticatedException("유효하지 않은 토큰 입니다.", e);
        }
    }
}
