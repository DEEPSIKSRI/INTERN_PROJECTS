package com.example.JWT.JWT.controller;

import com.example.JWT.JWT.model.JwtModel;
import com.example.JWT.JWT.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<JwtModel> register(@RequestBody AuthenticateRequest request) {
        System.out.println(request.getFirstName() + "<-------------");
        System.out.println(request.getPassword() + "<-------------");
        System.out.println(request.getEmail() + "<-------------");
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticateionResponse> authenticate(
            @RequestBody AuthenticateRequest request) {
        System.out.println(request.getEmail() + "<-------------");
        return ResponseEntity.ok(authenticationService.authenticate(request));

    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticateionResponse> login(@RequestBody AuthenticateRequest request) {
        System.out.println(request.getPassword() + "<-------------");
        System.out.println(request.getEmail() + "<-------------");
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @PostMapping("/loginSecurity")
    public ResponseEntity<AuthenticateionResponse> loginSecurity(@RequestBody RegisterRequest request) throws Exception {
        return ResponseEntity.ok(authenticationService.loginSecurity(request));

    }
}
