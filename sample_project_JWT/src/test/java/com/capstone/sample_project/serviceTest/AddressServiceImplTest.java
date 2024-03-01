package com.capstone.sample_project.serviceTest;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Address;
import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.exception.Exception.UserNotFoundException;
import com.capstone.sample_project.repository.AddressRepository;
import com.capstone.sample_project.repository.UserRepository;
import com.capstone.sample_project.service.serviceImpl.AddressServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

 class AddressServiceImplTest {

     @Mock
     AddressRepository addressRepository;

     @Mock
     UserRepository userRepository;

     @InjectMocks
     AddressServiceImpl addressService;


     @BeforeEach
     void setUp ( ) {
         MockitoAnnotations.openMocks ( this );
     }

     @Test
     void testGetAllAddress ( ) {

         Address address = mock ( Address.class );
         List < Address > addressArrayList = new ArrayList <> ( );
         addressArrayList.add ( address );
         when ( addressRepository.findAll ( ) ).thenReturn ( addressArrayList );
         ResponseEntity < ResponseDto > response = addressService.getAllAddress ( );

         assertEquals ( HttpStatus.OK , response.getStatusCode ( ) );
         assertEquals ( "Retrieved All the Address Successfully!!" , response.getBody ( ).getMessage ( ) );
     }

     @Test
     void testSaveAddress ( ) {
         Address address = mock ( Address.class );
         when ( addressRepository.save ( address ) ).thenReturn ( address );

         ResponseEntity < ResponseDto > response = addressService.saveAddress ( address );

         assertEquals ( HttpStatus.OK , response.getStatusCode ( ) );
         assertEquals ( "Saved All the Address Successfully!!" , response.getBody ( ).getMessage ( ) );
     }

     @Test
     void testDeleteAll ( ) {

         ResponseEntity < ResponseDto > response = addressService.deleteAllAddress ( );

         assertEquals ( HttpStatus.OK , response.getStatusCode ( ) );
         assertEquals ( "Address Deleted" , response.getBody ( ).getMessage ( ) );
     }

     @Test
     void testDeleteById ( ) {
         String id = "1";
         ResponseEntity < ResponseDto > response = addressService.deleteById ( id );

         assertEquals ( HttpStatus.OK , response.getStatusCode ( ) );
         assertEquals ( "Address Deleted Based on Id" , response.getBody ( ).getMessage ( ) );

     }


     @Test
     void testStoreAddUser ( ) throws UserNotFoundException {
         // Arrange
          String id="sdfghjkl";
         Address address = mock ( Address.class );

         User user = mock ( User.class );
         when ( userRepository.findById ( id ) ).thenReturn ( Optional.of ( user ) );

         // Act
         ResponseEntity < ResponseDto > response = addressService.storeAddUser ( id , address );

         // Assert
         assertEquals ( HttpStatus.OK , response.getStatusCode ( ) );
         assertEquals ( "User is stored in Address Successfully!" , response.getBody ( ).getMessage ( ) );

     }

     @Test
     void testStoreAddUserWhenUserNotFound() {
         // Arrange
         String id="fghjkl";
         Address address = new Address ( );

         when ( userRepository.findById ( Mockito.eq ( id ) ) ).thenReturn ( Optional.empty ( ) );

         // Act and Assert
         assertThrows ( UserNotFoundException.class , ( ) -> {addressService.storeAddUser ( id , address );
         } );

     }
 }
