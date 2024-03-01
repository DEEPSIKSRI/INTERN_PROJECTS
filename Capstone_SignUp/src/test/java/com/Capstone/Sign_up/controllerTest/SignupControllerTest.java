package com.Capstone.Sign_up.controllerTest;

import com.Capstone.Sign_up.controller.SignupController;
import com.Capstone.Sign_up.dto.ResponseDto;
import com.Capstone.Sign_up.entity.Signup;
import com.Capstone.Sign_up.service.implementation.SignupServiceImpl;
import jakarta.activation.DataSource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest

public class SignupControllerTest {

    @Mock
    private SignupServiceImpl signupService;

    @InjectMocks
    private SignupController signupController;
    String subject = "subject";
    String body = "Body of the mail ";

    String attachement="Downloads/Frontend Fundamentals.pdf";


    @Test
    void testSaveNewUser()
    {
        Signup signup=new Signup ("deepsiganesh@gmail.com","Deepsi","G","123","female","27/04/2003");
        when(signupService.newUser ( signup )).thenReturn ( ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (  HttpStatus.CREATED,"Verification Link sent to Email",signup ) ) );

        ResponseEntity<ResponseDto> response=signupController.saveNewUser ( signup );

        assertEquals(HttpStatus.OK,response.getStatusCode ());
        assertEquals ( "Verification Link sent to Email",response.getBody ().getMessage () );
    }

    @Test
    void testisAlreadyExist()
    {
        Signup signup=new Signup ("deepsiganesh@gmail.com","Deepsi","G","123","female","27/04/2003");
        when ( signupService.isAlreadyExists ( signup.getEmail () ) ).thenReturn (true  );

        ResponseEntity<ResponseDto> response=signupController.saveNewUser (signup ) ;

        assertEquals (HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Email already Exist",response.getBody ().getMessage () );
    }

    @Test
    void testVerifyLink()
    {
        String verify="Ok";
        Signup signup=new Signup ("deepsiganesh@gmail.com","Deepsi","G","123","female","27/04/2003");
       Map<String,Object> response=new HashMap <> (  );
        response.put("verify", verify);
        response.put("signup", signup);
       when (signupService.verifyUser ( verify,signup ) ).thenReturn ( "Verification successful. User information saved." );

       String actual=signupController.verifyLink ( response );

       assertEquals ( "Verification successful. User information saved.",actual );
    }

    @Test
    void testLinkFailed()
    {
        String verify="Failed";
        Signup signup=new Signup ("deepsiganesh@gmail.com","Deepsi","G","123","female","27/04/2003");
        Map<String,Object> response=new HashMap <> (  );
        response.put("verify", verify);
        response.put("signup", signup);
        when (signupService.verifyUser ( verify,signup ) ).thenReturn ( "Verification successful. User information saved." );

        String actual=signupController.verifyLink ( response );

        assertEquals ( "Verification successful. User information saved.",actual );
    }
    @Test
    void testAttachement() throws MessagingException {
        Signup signup=new Signup ("deepsiganesh@gmail.com","Deepsi","G","123","female","27/04/2003");

//        JavaMailSender javaMailSender=mock ( JavaMailSender.class );
//        MimeMessage message=mock ( MimeMessage.class );
//        MimeMessageHelper mimeMessageHelper=mock ( MimeMessageHelper.class );
//        FileSystemResource fileSystemResource=mock ( FileSystemResource.class );
//
//        mimeMessageHelper.setFrom ( "yujkil@gmail.com" );
//        mimeMessageHelper.setTo (signup.getEmail ()  );
//        mimeMessageHelper.setSubject ( subject );
//        mimeMessageHelper.setText ( body );
//
//        when ( fileSystemResource.getFilename () ).thenReturn (attachement );
       when ( signupService.sendAttachment ( signup ) ).thenReturn ( signup);

       Signup signup1=signupController.sendAttachement ( signup );

       assertEquals ( signup,signup1 );

}
}
