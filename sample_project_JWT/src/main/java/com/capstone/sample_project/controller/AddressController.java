package com.capstone.sample_project.controller;

import com.capstone.sample_project.api.AddressApi;
import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Address;
import com.capstone.sample_project.exception.Exception.UserNotFoundException;
import com.capstone.sample_project.service.serviceImpl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("address")

public class AddressController implements AddressApi {

    @Autowired
    AddressServiceImpl addressService;
    @Override
    public ResponseEntity < ResponseDto > getAllAddress ( ) {
        return addressService.getAllAddress();
    }

    @Override
    public  ResponseEntity < ResponseDto > saveAddress ( Address address ) {
        return addressService.saveAddress(address);

    }

    @Override
    public  ResponseEntity < ResponseDto > deleteAddress ( String addressId ) {
        return addressService.deleteById(addressId);
    }

    @Override
    public  ResponseEntity < ResponseDto > deleteAllAddress ( ) {
        return addressService.deleteAllAddress();
    }

    @Override
    public  ResponseEntity < ResponseDto > storeUserAdd ( String userId , Address address ) throws UserNotFoundException {
        return addressService.storeAddUser(userId,address);
    }
}
