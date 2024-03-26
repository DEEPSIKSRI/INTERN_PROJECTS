package com.jsp.Job.filter;

import com.jsp.Job.service.Impl.TokenServiceImpl;
import com.jsp.Job.service.Impl.UserServiceImpl;
import com.jsp.Job.tokenService.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
@EnableMethodSecurity
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    private final UserDetailsService userDetailsService;

    private final UserServiceImpl userService;
    private final TokenServiceImpl tokenService;

    @Override
    protected void doFilterInternal (
            @NonNull HttpServletRequest request ,
            @NonNull HttpServletResponse response ,
            @NonNull FilterChain filterChain ) throws ServletException, IOException {
        final String authHeader = request.getHeader ( "Authorization" );
        final String jwt;
        final String userEmail;
        log.info ( authHeader );
        if ( authHeader == null || !authHeader.startsWith ( "Bearer " ) ) {
            filterChain.doFilter ( request , response );
            return;
        }
        jwt = authHeader.substring ( 7 );
        String name = jwtService.extractUsername ( jwt );
        log.info ( name );


        log.info ( SecurityContextHolder.getContext ( ).toString ( ) );
        if ( name != null && SecurityContextHolder.getContext ( ).getAuthentication ( ) == null ) {
            UserDetails userDetails = userDetailsService.loadUserByUsername ( name );
            log.info ( userDetails.toString ( ) );
            try {
                if ( jwtService.isTokenValidate ( jwt , userDetails ) ) {
                    if ( !jwtService.isTokenExpired ( jwt ) ) {
                        UsernamePasswordAuthenticationToken authenticationToken =
                                new UsernamePasswordAuthenticationToken ( userDetails , null , userDetails.getAuthorities ( ) );
                        authenticationToken.setDetails ( new WebAuthenticationDetailsSource ( ).buildDetails ( request ) );
                        SecurityContextHolder.getContext ( ).setAuthentication ( authenticationToken );
                        log.info ( SecurityContextHolder.getContext ( ).toString ( ) );
                    } else {
                        tokenService.logout ( name );
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException ( e );
            }
            filterChain.doFilter ( request , response );
        }
    }
}