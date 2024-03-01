package com.capstone.sample_project.service.serviceImpl;


import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Department;
import com.capstone.sample_project.entity.Role;
import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.repository.DepartmentRepository;
import com.capstone.sample_project.repository.UserRepository;
import com.capstone.sample_project.service.DepartmentService;
import com.capstone.sample_project.service.UserService;
import com.capstone.sample_project.tokenService.AuthenticationResponse;
import com.capstone.sample_project.tokenService.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    @Override
    public ResponseEntity<ResponseDto> getAllUsers( ) {
        List<User> users=userRepository.findAll ();
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Retrived All Users Successfully!",users) );
    }

    @Override
    public ResponseEntity<ResponseDto> saveUser ( User user) {
        user.setPassword ( passwordEncoder.encode (user.getPassword ()) );
        userRepository.save ( user );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"User Information Saved Successfully",user) );
    }

    @Override
    public ResponseEntity<ResponseDto> deleteAllUser ( ) {
        userRepository.deleteAll ( );
        return ResponseEntity.status ( HttpStatus.OK ).body (new ResponseDto ( HttpStatus.OK,"Deleted All Users",null));
    }

    @Override
    public ResponseEntity<ResponseDto> saveDepUser ( User user , String depId ) {
        Optional < Department > department1 = departmentRepository.findById ( depId );

        if ( department1.isPresent ( ) ) {
            user.setDepartment ( department1.get () );
            user.setEmail ( user.getEmail ( ) );
            user.setFirst_name ( user.getFirst_name ( ) );
            user.setLast_name ( user.getLast_name ( ) );
//            user.setDepartment ( user.getDepartment ( ) );
            user.setPassword ( passwordEncoder.encode ( user.getPassword () ) );
        }
             userRepository.save ( user );
             return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"DepId is Added In User Table",user) );
        }

    @Override
    public ResponseEntity<ResponseDto> deleteById ( String email) {
        userRepository.deleteById ( email );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"User Record is Deleted Based on User_Id ",null));
    }

//    @Override
//    public ResponseEntity < ResponseDto > getAll ( String token) {
//        List<User> users=userRepository.findAll ();
//         return ResponseEntity.status( HttpStatus.OK).body(new ResponseDto (HttpStatus.OK, "Get All Users Successfully!", users));
//        }

//        @Override
//    public ResponseEntity < ResponseDto > loginSecurity (User request) {
//        User user = ( User ) userRepository.findByEmail ( request.getEmail ( ) );
//        if ( user.getEmail ().isEmpty () || !passwordEncoder.matches ( request.getPassword ( ) , user.getPassword ( ) ) ) {
//            ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.BAD_REQUEST , "Invalid email or password" , null ) );
//        }
//
//        if ( user.getRole ( ) == Role.ADMIN )
//        {
//            String jwtToken = jwtService.generateToken(user.getEmail(), Role.ADMIN);
//            user.setToken ( jwtToken );
//            userRepository.save ( user );
//            return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK , "Authorized Admins are logged in!!" , AuthenticationResponse.builder ( ).token ( jwtToken ).build ( ) ) );
//        } else if ( user.getRole ( ) == Role.USER )
//        {
//            String jwtToken = jwtService.generateToken(user.getEmail(), Role.USER);
//            user.setToken ( jwtToken );
//            userRepository.save ( user );
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
//
//    @Override
//    public ResponseEntity < ResponseDto > register ( User user ) {
//        user.setPassword ( passwordEncoder.encode ( user.getPassword () ) );
//        userRepository.save ( user );
//        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"User Information Saved Successfully",user) );
//    }
//    @Override
//    public ResponseEntity<ResponseDto> logout(String userEmail) {
//        User user = ( User ) userRepository.findByEmail(userEmail);
//        if (user != null) {
//            user.setToken(null);
//            userRepository.save(user);
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(new ResponseDto(HttpStatus.OK, "User logged out successfully", null));
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(new ResponseDto(HttpStatus.BAD_REQUEST, "User not found", null));
//        }
//    }
}



