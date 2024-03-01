//package com.capstone.sample_project.tokenService;
//
//import com.capstone.sample_project.dto.ResponseDto;
//import com.capstone.sample_project.entity.Role;
//import com.capstone.sample_project.entity.User;
//import com.capstone.sample_project.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//
//public class AuthenticationService {
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final JwtService jwtService;
//
//
//    public User register ( User request ) {
//        var user = User.builder ( )
//                .email ( request.getEmail ( ) )
//                .password ( passwordEncoder.encode ( request.getPassword ( ) ) )
//                .role (request.getRole () )
//                .first_name ( request.getFirst_name ( ) )
//                .last_name ( request.getLast_name ( ) )
//                .build ( );
//        return userRepository.save ( user );
//    }
//
//    public ResponseEntity < ResponseDto > loginSecurity (User request) {
//        User user = ( User ) userRepository.findByEmail ( request.getEmail ( ) );
//
//        if ( user.getEmail ().isEmpty () || !passwordEncoder.matches ( request.getPassword ( ) , user.getPassword ( ) ) ) {
//            ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.BAD_REQUEST , "Invalid email or password" , null ) );
//        }
//
//        if ( user.getRole ( ) == Role.ADMIN )
//        {
//            String jwtToken = jwtService.generateToken(user.getEmail(), Role.ADMIN);
//            return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK , "Authorized Admins are logged in!!" , AuthenticationResponse.builder ( ).token ( jwtToken ).build ( ) ) );
//        } else if ( user.getRole ( ) == Role.USER )
//        {
//            String jwtToken = jwtService.generateToken(user.getEmail(), Role.USER);
//            return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK , "Authorized User are Logged in!!" , AuthenticationResponse.builder ( ).token ( jwtToken ).build ( ) ) );
//
//        }
//        else
//        {
//
//            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDto ( HttpStatus.BAD_REQUEST , "Unauthorized: Only users are allowed to log in" , null ) );
//        }
//
//    }
//}
//
//
//
