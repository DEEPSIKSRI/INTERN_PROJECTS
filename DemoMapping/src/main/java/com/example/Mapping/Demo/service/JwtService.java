package com.example.Mapping.Demo.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY = "a8c8208fe6fdfbb2ff7643d13171e8814fad617d0bec4fd55861b3875bf7ac01";

    public String extractUsername(String token) throws Exception {
        return extractClaim(token, Claims::getSubject);

    }

    public String generateToken(String username) {
        return generateToken(new HashMap<>(), username);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) throws Exception {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token) throws Exception {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyByttes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyByttes);
    }

    // Generating /checking token
    public String generateToken(
            Map<String, Object> extraClaims,
            String UserDetails) {

        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(UserDetails)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) throws Exception {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token, userDetails);
    }

    public boolean isTokenExpired(String token, UserDetails userDetails) throws Exception {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) throws Exception {
        return extractClaim(token, Claims::getExpiration);
    }

}
