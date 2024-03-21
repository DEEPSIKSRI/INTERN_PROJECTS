package com.jsp.Job.api;

import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public interface UserApi {

    @PreAuthorize("hasAnyRole('ADMIN')"  )
    @PostMapping("/addUser")
    ResponseEntity< ResponseDTO >  addUser( @RequestBody UserDTO userDTO );

    @PreAuthorize ( "hasAnyRole('ADMIN')" )
    @GetMapping("/getAllUsers")
    ResponseEntity<ResponseDTO> getAllUser();

    @PreAuthorize ( "hasAnyRole('ADMIN')" )
    @DeleteMapping("/deleteAllUsers")
    ResponseEntity<ResponseDTO> deleteAllUsers();

    @PreAuthorize ( "hasAnyRole('ADMIN')" )
    @DeleteMapping("/deleteParticularUser/{username}")
    ResponseEntity<ResponseDTO> deleteParticularUser(@PathVariable String username);
}