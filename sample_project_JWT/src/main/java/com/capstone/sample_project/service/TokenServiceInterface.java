package com.capstone.sample_project.service;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public interface TokenServiceInterface {

    ResponseEntity < ResponseDto > loginSecurity ( User request );

    ResponseEntity< ResponseDto> register ( User user );

    ResponseEntity<ResponseDto > logout(String username);
}
