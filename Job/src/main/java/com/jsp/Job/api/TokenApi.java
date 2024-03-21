package com.jsp.Job.api;

import com.jsp.Job.dto.LoginLogoutDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface TokenApi {
    @PostMapping("/login")
    ResponseEntity < ResponseDTO > login( @RequestBody LoginLogoutDTO request);

    @PostMapping("/register")
    ResponseEntity<ResponseDTO> register(@RequestBody User user);

    @PostMapping("/logout/{username}")
    ResponseEntity<ResponseDTO> logout(@PathVariable(value = "username") String userEmail) ;


}