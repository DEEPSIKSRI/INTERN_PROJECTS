package com.security.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/security")
@RestController
public class SecurityController {

    @GetMapping
    public ResponseEntity<String> springSecurity()
    {
        return ResponseEntity.ok("Demo Project for Spring Security ");
    }
    @GetMapping("/demo")
    public ResponseEntity<String> getSecurity()
    {
        return ResponseEntity.ok("Spring Security ");
    }

}
