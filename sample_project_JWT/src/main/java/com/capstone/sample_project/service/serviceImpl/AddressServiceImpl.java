package com.capstone.sample_project.service.serviceImpl;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Address;
import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.exception.Exception.UserNotFoundException;
import com.capstone.sample_project.repository.AddressRepository;
import com.capstone.sample_project.repository.UserRepository;
import com.capstone.sample_project.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseEntity < ResponseDto > getAllAddress ( ) {
        List<Address> addresses=addressRepository.findAll ();
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Retrieved All the Address Successfully!!",addresses) );
    }

    @Override
    public ResponseEntity < ResponseDto > saveAddress ( Address address ) {
         addressRepository.save ( address );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Saved All the Address Successfully!!",address) );

    }

    @Override
    public ResponseEntity < ResponseDto > deleteById ( String addressId ) {
         addressRepository.deleteById ( addressId );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Address Deleted Based on Id",null) );

    }

    @Override
    public ResponseEntity < ResponseDto > deleteAllAddress ( ) {
        addressRepository.deleteAll ();
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Address Deleted",null) );

    }

    @Override
    public ResponseEntity < ResponseDto > storeAddUser ( String userId , Address address ) throws UserNotFoundException {
       Optional < User > optionalUser=userRepository.findById (  userId);

       if ( optionalUser.isPresent () )
       {
           address.setAddressId ( address.getAddressId () );
           address.setCity ( address.getCity () );
           address.setStreet ( address.getStreet ());
           address.setPincode ( address.getPincode () );
           address.setUser (optionalUser.get () );

            addressRepository.save ( address );
           return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"User is stored in Address Successfully!",address) );

       }
       else
       {
           throw new UserNotFoundException ("User with email " + optionalUser + " not found");

       }
    }
}
