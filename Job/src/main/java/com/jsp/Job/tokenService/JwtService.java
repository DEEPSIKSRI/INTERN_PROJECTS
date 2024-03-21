package com.jsp.Job.tokenService;

import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders   ;

@Service
@RequiredArgsConstructor
public class JwtService {

    private static final String SECRET_KEY = "3c791e362f498b46b0a1e158be23a146c6546a08e834270abfe496f08be045bb";

    public String extractUsername ( String token ) {
        return extractClaim ( token , Claims::getSubject );
    }

    public < T > T extractClaim ( String token , Function < Claims, T > claimsResolver ) {
        final Claims claims = extractAllClaims ( token );
        return claimsResolver.apply ( claims );
    }

    public Claims extractAllClaims ( String token ) {
        return Jwts
                .parser ( )
                .setSigningKey ( getSignInKey ( ) )
//                .build ( )
                .parseClaimsJws ( token )
                .getBody ( );
    }


    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public boolean isTokenValidate ( String token , UserDetails userDetails ) {
        if ( userDetails == null ) {
            return false;
        }
        final String username = extractUsername ( token );
        return (username.equals ( userDetails.getUsername ( ) )) && !isTokenExpired ( token );

    }

    public boolean isTokenExpired ( String token ) {
        return extractExpiration ( token ).before ( new Date ( ) );
    }

    private Date extractExpiration ( String token ) {
        return extractClaim ( token , Claims::getExpiration );
    }


    public String generateToken ( String username , String role ) {
        Map < String, Object > claims = new HashMap <> ( );
        claims.put ( "role" , "ROLE_" + role );
        return generateTokens ( claims , username );
    }

    public String generateTokens ( Map < String, Object > extraClaims , String username ) {
        return Jwts.builder ( )
                .setClaims ( extraClaims )
                .setSubject ( username )
                .setIssuedAt ( new Date ( System.currentTimeMillis ( ) ) )
                .setExpiration ( new Date ( System.currentTimeMillis ( ) + 1000 * 60 * 24 ) )
                .signWith ( getSignInKey ( ) , SignatureAlgorithm.HS256 )
                .compact ( );

    }
    public boolean isAdmin(String token) {
        try {
            Object roles = extractAllClaims(token).get("role");

            if (roles instanceof String userRole) {
                return "ADMIN".equalsIgnoreCase (userRole);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}