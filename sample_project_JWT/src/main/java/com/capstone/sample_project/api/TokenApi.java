package com.capstone.sample_project.api;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface TokenApi {
    @PostMapping("/login")
    ResponseEntity < ResponseDto > login( @RequestBody User request);

    @PostMapping("/register")
    ResponseEntity<ResponseDto> register(@RequestBody User user);

    @PostMapping("/logout/{email}")
    ResponseEntity<ResponseDto> logout(@PathVariable(value = "email") String userEmail) ;


}
