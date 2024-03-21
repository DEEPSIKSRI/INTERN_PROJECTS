package com.jsp.Job.service;

import com.jsp.Job.dto.LoginLogoutDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public interface TokenServiceInterface {

    ResponseEntity < ResponseDTO > loginSecurity ( LoginLogoutDTO request );

    ResponseEntity < ResponseDTO > register ( User user );

    ResponseEntity < ResponseDTO > logout ( String username );
}