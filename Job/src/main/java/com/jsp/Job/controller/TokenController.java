package com.jsp.Job.controller;

import com.jsp.Job.api.TokenApi;
import com.jsp.Job.dto.LoginLogoutDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.User;
import com.jsp.Job.service.Impl.TokenServiceImpl;
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
    public ResponseEntity < ResponseDTO > login ( LoginLogoutDTO request ) {
        return tokenService.loginSecurity (request);
    }

    @Override
    public ResponseEntity < ResponseDTO > register ( User user ) {
        return tokenService.register ( user );
    }

    @Override
    public ResponseEntity < ResponseDTO > logout ( String username ) {
        return tokenService.logout ( username );
    }
}