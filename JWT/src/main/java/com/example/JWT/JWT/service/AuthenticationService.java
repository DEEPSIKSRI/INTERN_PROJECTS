package com.example.JWT.JWT.service;

import com.example.JWT.JWT.config.JwtService;
import com.example.JWT.JWT.controller.AuthenticateRequest;
import com.example.JWT.JWT.controller.AuthenticateionResponse;
import com.example.JWT.JWT.controller.RegisterRequest;
import com.example.JWT.JWT.model.JwtModel;
import com.example.JWT.JWT.model.Role;
import com.example.JWT.JWT.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthenticationService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public JwtModel register(AuthenticateRequest request) {
        var user = JwtModel.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        System.out.println(user + "  role");
        return userRepository.save(user);

    }
    public AuthenticateionResponse loginSecurity(RegisterRequest request) throws Exception {
        JwtModel user = (JwtModel) userRepository.findByEmail(request.getEmail());
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String jwtToken = jwtService.generateToken(user.getEmail());

        // Create and return the authentication response
        return AuthenticateionResponse.builder()
                .token(jwtToken)
                .build();
    }

    //    public AuthenticateionResponse loginSecurity(AuthenticateRequest request) {
//        JwtModel user = (JwtModel) userRepository.findByEmail(request.getEmail());
//        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//            throw new RuntimeException("Invalid password");
//        }
//        String jwtToken = jwtService.generateToken(user.getEmail());
//         AuthenticateionResponse.builder()
//                .token(jwtToken)
//                .build();
//        return user;
//
//    }

    public AuthenticateionResponse login(AuthenticateRequest request) {
        var user=JwtModel.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
        userRepository.save(user);
        System.out.println(user+"  role");
        var jwtToken = jwtService.generateToken(request.getEmail());
        return AuthenticateionResponse.builder()
                .token(jwtToken)
                .build();

    }


    public AuthenticateionResponse authenticate(AuthenticateRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getPassword(),
                        request.getEmail()
                )
        );
        if (authentication.isAuthenticated()) {
            return AuthenticateionResponse.builder()
                    .token(jwtService.generateToken(request.getEmail()))
                    .build();

        }
        else {
            throw new UsernameNotFoundException("Username not found");
        }
    }
}



