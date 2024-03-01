package com.FeignClient.DataService.service.impl;

import com.FeignClient.DataService.dto.ResponseDto;
import com.FeignClient.DataService.entity.DataEntity;
import com.FeignClient.DataService.exception.ResourceNotFoundException;
import com.FeignClient.DataService.repository.DataServiceRepository;
import com.FeignClient.DataService.service.DataServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DataServiceImpl implements DataServiceInterface {

    @Autowired
    DataServiceRepository dataServiceRepository;

    @Override
    public ResponseEntity <List< DataEntity >> getAllData ( ) {
        List<DataEntity> dataServiceList= dataServiceRepository.findAll ();
        return new ResponseEntity<>(dataServiceList,HttpStatus.OK);
//         return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK,"Data are Retrieved From DataService!!",dataServiceList) );
    }

    @Override
    public ResponseEntity < ResponseDto > saveData ( DataEntity data ) {
        dataServiceRepository.save ( data );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK,"Saved All the Data!!" ,data) );
    }

    @Override
    public ResponseEntity < DataEntity > updateData ( String uuid , DataEntity data ) {
        DataEntity oldData=dataServiceRepository.findById(uuid).orElseThrow(()->new ResourceNotFoundException ("Id not found"));
        oldData.setDataName ( data.getDataName () );
        oldData.setDescription ( data.getDescription () );
        oldData.setCreationDate (data.getCreationDate ());

        
         dataServiceRepository.save ( oldData );
         return new ResponseEntity<> ( oldData,HttpStatus.OK );

    }
}
