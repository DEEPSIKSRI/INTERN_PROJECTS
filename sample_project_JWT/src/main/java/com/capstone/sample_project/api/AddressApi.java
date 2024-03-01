package com.capstone.sample_project.api;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Address;
import com.capstone.sample_project.exception.Exception.UserNotFoundException;
import com.capstone.sample_project.repository.AddressRepository;
import org.aspectj.lang.annotation.DeclareError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")


public interface AddressApi {

    @GetMapping("/getAddress")
    ResponseEntity < ResponseDto > getAllAddress();

    @PostMapping("/saveAdd")
    ResponseEntity < ResponseDto > saveAddress( @RequestBody Address address );

    @DeleteMapping("/deleteAdd/{addressId}")
    ResponseEntity < ResponseDto > deleteAddress(@PathVariable (value = "addressId") String addressId);

    @DeleteMapping("/deleteAll")
    ResponseEntity < ResponseDto > deleteAllAddress();

    @PostMapping("/storeUser/{userId}")
    ResponseEntity < ResponseDto > storeUserAdd(@PathVariable (value = "userId") String userId,@RequestBody Address address) throws UserNotFoundException;



}
