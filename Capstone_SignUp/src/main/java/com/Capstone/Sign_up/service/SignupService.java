package com.Capstone.Sign_up.service;

import com.Capstone.Sign_up.dto.ResponseDto;
import com.Capstone.Sign_up.entity.Signup;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public interface SignupService {
//    boolean isValidateEmail ( String email );
//
//    boolean isValidateName(String firstname);
//
//    boolean isValidateLastName(String lastName);

    boolean isAlreadyExists(String email);
    ResponseEntity < ResponseDto > newUser ( Signup signup ) ;

    String verifyUser(String verify,Signup signup);

    Signup sendAttachment ( Signup signup ) throws MessagingException;

    Signup sendHtmlTableFormat ( Signup signup ) throws MessagingException;
}
