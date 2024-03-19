package com.example.JWT.JWT.config;

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
    private static final String SECRET_KEY="a8c8208fe6fdfbb2ff7643d13171e8814fad617d0bec4fd55861b3875bf7ac01";
    public String extractUsername(String token) {
        return  extractClaim(token,Claims::getSubject);
    }
    public <T> T extractClaim(String token, Function<Claims ,  T> claimsResolver)
    {
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    public boolean isTokenValidate(String token, UserDetails userDetails) throws Exception {
        if (userDetails == null) {
            return false;
        }
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token, userDetails);
    }

    public String generateToken(String username){
        return generateToken(new HashMap<>(),username);
    }
    public String generateToken(
            Map<String,Object> extraClaims,
            String userDetails
    ){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
//    public boolean isTokenValidate(String token,UserDetails userDetails)
//    {
//        final String username=extractUsername(token);
//        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token, userDetails);
//    }
    public boolean isTokenExpired(String token, UserDetails userDetails)
    {
        return extractExpiration(token).before(new Date());
    }
    private Date extractExpiration(String token)
    {
        return  extractClaim(token,Claims::getExpiration);
    }

    public Claims extractAllClaims(String token)
    {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
