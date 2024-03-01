package com.capstone.sample_project.controllerTest;

import com.capstone.sample_project.controller.AddressController;
import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Address;
import com.capstone.sample_project.exception.Exception.UserNotFoundException;
import com.capstone.sample_project.service.serviceImpl.AddressServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressControllerTest {
    @Mock
    AddressServiceImpl addressService;

    @InjectMocks
    AddressController addressController;


    @BeforeEach
    void setUp ( ) {
        MockitoAnnotations.openMocks ( this );
    }

    @Test
    void testGetAllAddress() throws Exception {
        Address address=mock ( Address.class );
        List <Address> skillsList = Collections.singletonList(address);
        ResponseEntity < ResponseDto > responseEntity = ResponseEntity.status( HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK, "Retrieved All the Address Successfully!!", skillsList));

        when(addressService.getAllAddress ()).thenReturn(responseEntity);

        ResponseEntity<ResponseDto> response=addressController.getAllAddress ();
        assertEquals(HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Retrieved All the Address Successfully!!",response.getBody ().getMessage () );
    }
    @Test
    void testSaveAddress()
    {
        Address address=mock ( Address.class );
        when ( addressService.saveAddress ( address ) ).thenReturn ( ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK,"Saved All the Address Successfully!!",address ) ) );

        ResponseEntity<ResponseDto> response=addressController.saveAddress ( address );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Saved All the Address Successfully!!",response.getBody ().getMessage () );
    }

    @Test
    void testDeleteAll()
    {
        Address address=mock ( Address.class );
        when ( addressService.deleteAllAddress (  ) ).thenReturn ( ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK,"Address Deleted",null ) ) );

        ResponseEntity<ResponseDto> response=addressController.deleteAllAddress (  );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Address Deleted",response.getBody ().getMessage () );
    }
    @Test
    void testDeleteById()
    {
        String id="1";
        when ( addressService.deleteById ( id ) ).thenReturn ( ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Address Deleted Based on Id",null) ) );

        ResponseEntity<ResponseDto> response=addressController.deleteAddress ( id );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Address Deleted Based on Id",response.getBody ().getMessage () );

    }

    @Test
    void testStoreAddUser() throws UserNotFoundException {
        Address address=mock ( Address.class );
        String id="rtyui";

        when ( addressService.storeAddUser ( id,address ) ).thenReturn ( ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK,"User is stored in Address Successfully!",address ) ) );

        ResponseEntity<ResponseDto> response=addressController.storeUserAdd (id,address );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "User is stored in Address Successfully!",response.getBody ().getMessage () );

    }


}
