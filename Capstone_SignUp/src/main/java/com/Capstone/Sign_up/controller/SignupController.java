package com.Capstone.Sign_up.controller;

import com.Capstone.Sign_up.api.SignupApi;
import com.Capstone.Sign_up.dto.ResponseDto;
import com.Capstone.Sign_up.entity.Signup;
import com.Capstone.Sign_up.service.implementation.SignupServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/mail")

public class SignupController implements SignupApi {


    @Autowired
    SignupServiceImpl signupService;

    String subject = "Verify Your Email";
    String body = "Click the following link to verify your email: https://www.baeldung.com/spring-email#mail-server-properties";


    @Override
    public ResponseEntity < ResponseDto > saveNewUser( Signup signup)  {

        if (isAlreadyExists(signup.getEmail())) {
            return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.BAD_REQUEST ,"Email already Exist",null) );

        }
        else {
            signupService.newUser(signup);
           // signupService.sendEmail ( signup.getEmail (),subject,body );
            return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.CREATED,"Verification Link sent to Email",signup ) );
        }

    }



    public String verifyLink(@RequestBody Map<String, Object> requestBody) {
        String verify = (String) requestBody.get("verify");
        ObjectMapper objectMapper = new ObjectMapper();
        Signup signup = objectMapper.convertValue(requestBody.get("signup"), Signup.class);

        System.out.println("verify: " + verify);
        return signupService.verifyUser(verify, signup);
    }

    @Override
    public Signup sendAttachement ( Signup signup ) throws MessagingException {
        return signupService.sendAttachment(signup );
    }

    @Override
    public Signup sendTableFormat ( Signup signup ) throws MessagingException {
        return signupService.sendHtmlTableFormat(signup);
    }


    private boolean isAlreadyExists ( String email ) {
        return signupService.isAlreadyExists ( email );
    }


}



