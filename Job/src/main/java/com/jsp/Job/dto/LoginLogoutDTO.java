package com.jsp.Job.dto;

import lombok.Data;

@Data
public class LoginLogoutDTO {

    private String userName;

    private String password;

    private String role;
}