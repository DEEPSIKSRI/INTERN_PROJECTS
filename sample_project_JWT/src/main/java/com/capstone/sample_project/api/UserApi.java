//package com.capstone.sample_project.api;
//
//import com.capstone.sample_project.dto.ResponseDto;
//import com.capstone.sample_project.entity.Department;
//import com.capstone.sample_project.entity.User;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RequestMapping("user")
//@RestController
//
//public interface UserApi {
//
//    @GetMapping("/getAllUser")
//    ResponseEntity<ResponseDto> getAllUser();
//
//    @PostMapping("saveUser")
//    ResponseEntity<ResponseDto> saveUser(@RequestBody User user);
//
//    @DeleteMapping("/deleteAllUser")
//    ResponseEntity<ResponseDto> deleteAllUser();
//
//    @DeleteMapping("/deleteById/{email}")
//    ResponseEntity<ResponseDto>  deleteById(@PathVariable (value = "email") String email);
//
//    @PostMapping("/saveDepInUser/{depId}")
//    ResponseEntity<ResponseDto> saveDepInUser(@RequestBody User user,@PathVariable (value = "depId") String depId);
//
//    @GetMapping("/getAll")
//    ResponseEntity < ResponseDto > getAll();
//
//}

package com.capstone.sample_project.api;
import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public interface UserApi {


    @PreAuthorize ( "hasAnyAuthority('ROLE_ADMIN','ROLE_USER')" )
    @GetMapping("/getAllUser")
    ResponseEntity < ResponseDto > getAllUser ();

    @PreAuthorize ( "hasAnyAuthority('ROLE_ADMIN')" )
    @PostMapping("saveUser")
    ResponseEntity < ResponseDto > saveUser ( @RequestBody User user);

    @PreAuthorize ( "hasAnyAuthority('ROLE_ADMIN')" )
    @DeleteMapping("/deleteAllUser")
    ResponseEntity < ResponseDto > deleteAllUser ( );

   @PreAuthorize ( "hasAnyAuthority('ROLE_ADMIN')" )
   @DeleteMapping("/deleteById/{email}")
    ResponseEntity < ResponseDto > deleteById ( @PathVariable(value = "email") String email);


   @PreAuthorize ( "hasAnyAuthority('ROLE_ADMIN')" )
   @PostMapping("/saveDepInUser/{depId}")
    ResponseEntity < ResponseDto > saveDepInUser ( @RequestBody User user , @PathVariable(value = "depId") String depId  );

//    @GetMapping("/getAll")
//    ResponseEntity < ResponseDto > getAll ( @RequestHeader("Authorization") String token );

}
