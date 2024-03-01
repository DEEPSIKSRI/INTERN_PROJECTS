package com.capstone.sample_project.controller;

import com.capstone.sample_project.api.TokenApi;
import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.service.serviceImpl.TokenServiceImpl;
import com.capstone.sample_project.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController implements TokenApi {

    @Autowired
    TokenServiceImpl tokenService;

    @Override
    public ResponseEntity < ResponseDto > login ( User request ) {
        return tokenService.loginSecurity (request);
    }

    @Override
    public ResponseEntity < ResponseDto > register ( User user ) {
        return tokenService.register ( user );
    }

    @Override
    public ResponseEntity < ResponseDto > logout ( String userEmail ) {
        return tokenService.logout ( userEmail );
    }
}
