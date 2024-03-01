package com.capstone.sample_project.service;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Address;
import com.capstone.sample_project.exception.Exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public interface AddressService {

    ResponseEntity < ResponseDto > getAllAddress();

    ResponseEntity < ResponseDto > saveAddress ( Address address );

    ResponseEntity < ResponseDto > deleteById ( String addressId );

    ResponseEntity < ResponseDto > deleteAllAddress ( );

    ResponseEntity < ResponseDto > storeAddUser ( String userId , Address address ) throws UserNotFoundException;
}
