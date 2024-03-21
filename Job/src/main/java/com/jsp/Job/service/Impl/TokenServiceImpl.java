package com.jsp.Job.service.Impl;

import com.jsp.Job.dto.LoginLogoutDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.User;
import com.jsp.Job.repository.service.UserServiceRepo;
import com.jsp.Job.service.TokenServiceInterface;
import com.jsp.Job.tokenService.AuthenticationResponse;
import com.jsp.Job.tokenService.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenServiceInterface {


    private  final UserServiceRepo userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    @Override
       public ResponseEntity < ResponseDTO > loginSecurity ( LoginLogoutDTO loginLogoutDTO) {
        User user = userRepository.findByUsername ( loginLogoutDTO.getUserName ( ) );

        if(user==null)
        {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDTO ( false,HttpStatus.BAD_REQUEST,"User Not Found","" ) );
        }

        else if ( user.getUsername ().isEmpty () || !passwordEncoder.matches(loginLogoutDTO.getPassword(), user.getPassword()) ) {
           return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( false,HttpStatus.BAD_REQUEST , "Invalid email or password" , null ) );
        }
       else if ( user.getRole ( ).equals ( "ADMIN" ))
        {
            String jwtToken = jwtService.generateToken(user.getUsername (), "ADMIN");
            user.setToken ( jwtToken );
            userRepository.save ( user );
            return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true,HttpStatus.OK , "Authorized Admins are logged in!!" , AuthenticationResponse.builder ( ).token ( jwtToken ).build ( ) ) );
        } else if ( user.getRole ( ).equals ( "USER" ) )
        {
            String jwtToken = jwtService.generateToken(user.getUsername (), "USER");
            user.setToken ( jwtToken );
            userRepository.save ( user );
            return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true,HttpStatus.OK , "Authorized User are Logged in!!" , AuthenticationResponse.builder ( ).token ( jwtToken ).build ( ) ) );

        }
        else
        {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDTO ( true,HttpStatus.BAD_REQUEST , "Unauthorized: Only users are allowed to log in" , null ) );
        }

    }

    public ResponseEntity < ResponseDTO > register ( User user ) {
        user.setPassword ( passwordEncoder.encode ( user.getPassword () ) );
        userRepository.save ( user );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO (true,HttpStatus.OK,"User Information Saved Successfully",user) );
    }
    @Override
    public ResponseEntity < ResponseDTO > logout( String userName) {
        User user = ( User ) userRepository.findByUsername (userName);
        if (user != null) {
            user.setToken(null);
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDTO( true,HttpStatus.OK, "User logged out successfully", null));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO(true,HttpStatus.BAD_REQUEST, "User not found", null));
        }
    }

}