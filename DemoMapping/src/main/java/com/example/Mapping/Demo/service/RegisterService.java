package com.example.Mapping.Demo.service;

import com.example.Mapping.Demo.controller.AuthenticateRequest;
import com.example.Mapping.Demo.controller.AuthentictaionResponse;
import com.example.Mapping.Demo.entity.RegisterRequest;
import com.example.Mapping.Demo.entity.Role;
import com.example.Mapping.Demo.entity.Student;
import com.example.Mapping.Demo.repository.StudentRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;

@Builder
@Service
@RequiredArgsConstructor
public class RegisterService {

    private final StudentRepository studentRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

      public AuthentictaionResponse authenticate( AuthenticateRequest request) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getPassword(),
                            request.getEmail()
                    )
            );
            if (authentication.isAuthenticated()) {
                return AuthentictaionResponse.builder()
                        .token(jwtService.generateToken(request.getEmail()))
                        .build();
            } else {
                throw new UsernameNotFoundException("Username not found");
            }
        }
    public AuthentictaionResponse registers(RegisterRequest request) {
        var user=Student.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        studentRepository.save(user);
        var jwtToken = jwtService.generateToken(request.getEmail());
        return AuthentictaionResponse.builder()
                .token(jwtToken)
                .build();

    }


}
