package com.capstone.sample_project.service.serviceImpl;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Role;
import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.repository.UserRepository;
import com.capstone.sample_project.service.TokenServiceInterface;
import com.capstone.sample_project.tokenService.AuthenticationResponse;
import com.capstone.sample_project.tokenService.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service

public class TokenServiceImpl implements TokenServiceInterface {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;


    @Override
       public ResponseEntity < ResponseDto > loginSecurity (User request) {
        User user = userRepository.findByEmail ( request.getEmail ( ) );
        if ( user.getEmail ().isEmpty () || !passwordEncoder.matches ( request.getPassword ( ) , user.getPassword ( ) ) ) {
            ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.BAD_REQUEST , "Invalid email or password" , null ) );
        }
        if ( user.getRole ( ) ==  Role.ADMIN )
        {
            String jwtToken = jwtService.generateToken(user.getEmail(), Role.ADMIN);
            user.setToken ( jwtToken );
            userRepository.save ( user );
            return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK , "Authorized Admins are logged in!!" , AuthenticationResponse.builder ( ).token ( jwtToken ).build ( ) ) );
        } else if ( user.getRole ( ) == Role.USER )
        {
            String jwtToken = jwtService.generateToken(user.getEmail(), Role.USER);
            user.setToken ( jwtToken );
            userRepository.save ( user );
            return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK , "Authorized User are Logged in!!" , AuthenticationResponse.builder ( ).token ( jwtToken ).build ( ) ) );

        }
        else
        {

            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDto ( HttpStatus.BAD_REQUEST , "Unauthorized: Only users are allowed to log in" , null ) );
        }

    }

    @Override
    public ResponseEntity < ResponseDto > register ( User user ) {
        user.setPassword ( passwordEncoder.encode ( user.getPassword () ) );
        userRepository.save ( user );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"User Information Saved Successfully",user) );
    }
    @Override
    public ResponseEntity<ResponseDto> logout(String userEmail) {
        User user = ( User ) userRepository.findByEmail(userEmail);
        if (user != null) {
            user.setToken(null);
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto( HttpStatus.OK, "User logged out successfully", null));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDto(HttpStatus.BAD_REQUEST, "User not found", null));
        }
    }

}
