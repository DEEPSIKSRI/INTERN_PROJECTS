package com.Capstone.Sign_up.api;

import com.Capstone.Sign_up.dto.ResponseDto;
import com.Capstone.Sign_up.entity.Signup;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public interface SignupApi {

//    @PostMapping("/checkEmail")
//    String checkEmailExists( String email) ;


    @PostMapping("/newUser")
    ResponseEntity < ResponseDto > saveNewUser ( @RequestBody Signup signup );

    @PostMapping("/verifyLink")
    String verifyLink ( @RequestBody Map < String, Object > requestBody );

   //File Attachment
   @PostMapping("/sendAttachement")
    Signup sendAttachement(@RequestBody Signup signup) throws MessagingException;

   //HTML Attachment
    @PostMapping("/sendTableFormat")
    Signup sendTableFormat(@RequestBody Signup signup) throws MessagingException;

}

