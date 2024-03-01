package com.capstone.sample_project.config;

import com.capstone.sample_project.entity.Role;
import com.capstone.sample_project.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.HttpSecurityDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Repository;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain ( HttpSecurity httpSecurity ) throws Exception {
        httpSecurity
                .csrf ( AbstractHttpConfigurer::disable )
                .authorizeHttpRequests ( authorizeRequests ->
                        authorizeRequests.requestMatchers ( "/token/**" , "/department/getAllDepartment" ).permitAll ()
//                                .requestMatchers ( "/admin/**" ).hasRole ( "ROLE_ADMIN" )
//                                .requestMatchers ( "/user/**" ).hasAnyRole ( "ROLE_USER", "ROLE_ADMIN" )
                                .anyRequest ( ).authenticated ( )
                )
                .sessionManagement ( )
                .sessionCreationPolicy ( SessionCreationPolicy.STATELESS )
                .and ( )
                .authenticationProvider ( authenticationProvider )
                .addFilterBefore ( jwtAuthenticationFilter , UsernamePasswordAuthenticationFilter.class );
        return httpSecurity.build ( );
    }
}

