package com.Capstone.Sign_up.serviceTest;

import com.Capstone.Sign_up.dto.ResponseDto;
import com.Capstone.Sign_up.entity.Signup;
import com.Capstone.Sign_up.repository.SignupRepository;
import com.Capstone.Sign_up.service.implementation.SignupServiceImpl;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SignupServiceTest {

    @Mock
    SignupRepository signupRepository;

    @Mock
    JavaMailSender javaMailSender;

    @InjectMocks
    SignupServiceImpl signupService;

    String subject = "subject";
    String body = "Body of the mail ";

    String attachement="Downloads/Frontend Fundamentals.pdf";

    @Test
    void testIsAlreadyExist()
    {
        String email="deepsiganesh@gmail.com";
        when ( signupRepository.existsByEmailIgnoreCase ( email ) ).thenReturn ( true );

        Boolean respone=signupService.isAlreadyExists ( email );

        assertEquals ( true,respone );
    }
    @Test
    void testNewUser()
    {
        Signup signup=new Signup ("deepsiganesh@gmail.com","Deepsi","G","123","female","27/04/2003");
        when ( signupRepository.save ( signup ) ).thenReturn ( signup );

        ResponseEntity<ResponseDto> response=signupService.newUser ( signup );

       assertEquals ( signup,response.getBody ().getData () );
       assertEquals ( "Verification Link sent to Email",response.getBody ().getMessage () );
    }

    @Test
    void testEmailValid()
    {
        Signup signup=new Signup ("deepsiganesh@gmail.com","Deepsi","G","123","female","27/04/2003");
        when (signupRepository.existsByEmailIgnoreCase ( signup.getEmail () ) ).thenReturn ( true );

        ResponseEntity<ResponseDto> response=signupService.newUser ( signup);

        assertEquals ( signup,response.getBody ().getData () );
        assertEquals ( HttpStatus.OK,response.getStatusCode () );
      //  assertEquals ( "Email is not Valid",response.getBody ().getMessage () );
    }

    @Test
    void sendEmail_InvalidEmail_ReturnsNull() {
        String email = "invalidemail";


        ResponseEntity<ResponseDto> result = signupService.sendEmail(email, "Subject", "Body");
        assertNull(result);
    }

@Test
public void testVerifyUserSuccess() {
        String verify="Ok";
    Signup mockSignup = new Signup();
    mockSignup.setFirstname("deepsi");
    mockSignup.setLastname("D");
    mockSignup.setEmail("deepsiganesh@gmail");
    mockSignup.setGender("female");
    mockSignup.setDate_of_birth("1990-01-01");
    when(signupRepository.save(mockSignup)).thenReturn(mockSignup);

    String response= signupService.verifyUser ( verify,mockSignup);
    assertEquals("Verification successful. User information saved.", response);
}

@Test
    void testVerifyUserFail()
{
    String verify="ok";
    Signup mockSignup = new Signup();
    mockSignup.setFirstname("deepsi");
    mockSignup.setLastname("D");
    mockSignup.setEmail("deepsiganesh@gmail");
    mockSignup.setGender("female");
    mockSignup.setDate_of_birth("1990-01-01");
    when(signupRepository.save(mockSignup)).thenReturn(mockSignup);

    String response= signupService.verifyUser ( verify,mockSignup);
    assertEquals("Verification failed. User information not saved.", response);

}
    @Test
    void testAttachement() throws MessagingException {
        Signup signup=new Signup ("deepsiganesh@gmail.com","Deepsi","G","123","female","27/04/2003");


        JavaMailSender javaMailSender= mock ( JavaMailSender.class );
        MimeMessage message=javaMailSender.createMimeMessage ();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper ( message,true );

        FileSystemResource fileSystemResource=mock ( FileSystemResource.class );

        mimeMessageHelper.setFrom ( "yujkil@gmail.com" );
        mimeMessageHelper.setReplyTo (anyString ());
        mimeMessageHelper.setSubject ( subject );
        mimeMessageHelper.setText ( body );

       when ( fileSystemResource.getFilename () ).thenReturn (attachement );
        when ( signupRepository.save ( signup ) ).thenReturn ( signup);

        Signup signup1=signupService.sendAttachment ( signup );

        assertEquals ( signup,signup1 );

    }
    @Test
    void testSendAttachment() throws MessagingException {
        Signup signup=new Signup ("deepsiganesh@gmail.com","Deepsi","G","123","female","27/04/2003");

        when (signupRepository.save ( signup ) ).thenReturn ( signup );

        Signup signup1=signupService.sendAttachment ( signup );

        assertEquals ( signup,signup1 );
    }
}
