package com.example.Mapping.Demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class RegisterRequest {
        private String Stud_name;
        private String email;
        private String password;
    }

