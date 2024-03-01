package com.Capstone.Sign_up.service.implementation;

import com.Capstone.Sign_up.dto.ResponseDto;
import com.Capstone.Sign_up.entity.Signup;
import com.Capstone.Sign_up.repository.SignupRepository;
import com.Capstone.Sign_up.service.SignupService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Optional;

@Service
public class SignupServiceImpl implements SignupService {
    @Autowired
    private SignupRepository signRepo;
    @Autowired
    private JavaMailSender javaMailSender;

    String subject = "Verify Your Email";
    String body = "Click the following link to verify your email: https://www.baeldung.com/spring-email#mail-server-properties";

    String attachement="/home/divum/Downloads/Frontend Fundamentals.pdf";




    public ResponseEntity < ResponseDto > sendEmail( String email , String subject, String body) {
        if (!isValidEmail(email)) {
           System.out.println("Invalid email address: " + email);
            return null;
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("deepsiganesh@gmail.com");
        message.setTo(email);
        message.setText(body);
        message.setSubject(subject);

        javaMailSender.send(message);

        System.out.println ("Mail sent Successfully" +message);
        return null;
    }



    private boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }

//    @Override
//    public boolean isValidateEmail ( String email ) {
//        String EMAIL_REGEX ="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
//        Pattern pattern = Pattern.compile(EMAIL_REGEX);
//        Matcher matcher = pattern.matcher(email);
//        return matcher.matches();
//
//    }
//
//    @Override
//    public boolean isValidateName ( String firstname) {
//       String NAME_REGEX="^[a-zA-Z]";
//       Pattern pattern=Pattern.compile ( NAME_REGEX );
//       Matcher matcher=pattern.matcher ( firstname );
//       return matcher.matches ();
//
//    }
//
//    @Override
//    public boolean isValidateLastName ( String lastName ) {
//        String LAST_NAME_REGEX="^[A-Z]";
//        Pattern pattern=Pattern.compile ( LAST_NAME_REGEX );
//        Matcher matcher=pattern.matcher ( lastName);
//        return matcher.matches ();
//    }

    @Override
    public boolean isAlreadyExists ( String email ) {
        return signRepo.existsByEmailIgnoreCase ( email );
    }


    @Override
    public ResponseEntity < ResponseDto > newUser( Signup signup) {
//        if (isValidateEmail(signup.getEmail())) {
//            isValidateName(signup.getFirstname());
//            isValidateLastName(signup.getLastname());
//
//            if (signup.getEmail().equals ( true )  &&
//                    signup.getFirstname ().equals ( true ) &&
//                    signup.getLastname ().equals ( true ) &&
//                    signup.getEmail ().equals ( true) ) {

        Optional < Signup > signup1 = signRepo.findById ( signup.getEmail ( ) );
//        if ( signup1.isEmpty ( ) ) {
            signup.setEmail ( signup.getEmail ( ) );
            signup.setFirstname ( signup.getFirstname ( ) );
            signup.setLastname ( signup.getLastname ( ) );
            signup.setGender ( signup.getGender ( ) );
            signup.setDate_of_birth ( signup.getDate_of_birth ( ) );
            sendEmail ( signup.getEmail ( ) , subject , body );
            return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.CREATED , "Verification Link sent to Email" , signup ) );
        }

          //else
//        {
//
//            System.out.println ( isValidateName ( signup.getFirstname ( ) ) + "  firstname54678" );
//            return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.BAD_REQUEST , "Email is not Valid" , null ) );
//
//
//        }
  //  }

    @Override
    public String verifyUser(String verify,Signup signup) {
        if ("Ok".equals(verify) && signup.equals ( signup )) {
            signup.setFirstname ( signup.getFirstname () );
            signup.setEmail ( signup.getEmail () );
            signup.setLastname ( signup.getLastname () );
            signup.setGender ( signup.getGender ());
            signup.setDate_of_birth ( signup.getDate_of_birth () );
             signRepo.save ( signup );
            return "Verification successful. User information saved.";
        } else {
            return "Verification failed. User information not saved.";
        }
    }

    @Override
    public Signup sendAttachment ( Signup signup ) throws MessagingException {
        sendMailAttachment ( signup.getEmail (),subject,body, attachement);
        return signRepo.save ( signup );

    }

    @Override
    public Signup sendHtmlTableFormat ( Signup signup ) throws MessagingException {
    sendHtml ( signup.getEmail (),subject );
    return signRepo.save ( signup );
    }

    private void sendHtml ( String email , String subject) throws MessagingException {
        MimeMessage message=javaMailSender.createMimeMessage ();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper ( message,true );
        mimeMessageHelper.setFrom ( "deepsiganesh@gmail.com" );
        mimeMessageHelper.setTo ( email );
        mimeMessageHelper.setSubject ( subject );
        mimeMessageHelper.setText ( getHtmlContent (),true );

        javaMailSender.send ( message );
        
    }

    private String getHtmlContent() {

        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Email Table Example</title>\n" +
                "    <style>\n" +
                "        table {\n" +
                "            border-collapse: collapse;\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "\n" +
                "        th, td {\n" +
                "            border: 1px solid #dddddd;\n" +
                "            text-align: left;\n" +
                "            padding: 8px;\n" +
                "        }\n" +
                "\n" +
                "        th {\n" +
                "            background-color: #f2f2f2;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "    <h2>Example Table in Email</h2>\n" +
                "\n" +
                "    <table>\n" +
                "        <thead>\n" +
                "            <tr>\n" +
                "                <th>ID</th>\n" +
                "                <th>Name</th>\n" +
                "                <th>Email</th>\n" +
                "            </tr>\n" +
                "        </thead>\n" +
                "        <tbody>\n" +
                "            <tr>\n" +
                "                <td>1</td>\n" +
                "                <td>Deepsi/td>\n" +
                "                <td>deepsi@example.com</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td>2</td>\n" +
                "                <td>Mathu</td>\n" +
                "                <td>mathu@example.com</td>\n" +
                "        </tbody>\n" +
                "    </table>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }

    public void sendMailAttachment(String email,String body,String subject,String attachment) throws MessagingException {
        MimeMessage message=javaMailSender.createMimeMessage ();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper ( message,true );

        mimeMessageHelper.setFrom ( "deepsiganesh@gmail.com" );
        mimeMessageHelper.setTo ( email );
        mimeMessageHelper.setSubject ( subject );
        mimeMessageHelper.setText ( body );

        FileSystemResource fileSystemResource=new FileSystemResource ( new File ( attachment ) );
        mimeMessageHelper.addAttachment (fileSystemResource.getFilename (),fileSystemResource );
        javaMailSender.send ( message );
    }

}
