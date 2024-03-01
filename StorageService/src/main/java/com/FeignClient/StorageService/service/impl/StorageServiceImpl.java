package com.FeignClient.StorageService.service.impl;

import com.FeignClient.StorageService.dto.DataEntityDto;
import com.FeignClient.StorageService.dto.ResponseDto;
import com.FeignClient.StorageService.entity.StorageEntity;
import com.FeignClient.StorageService.feign.DataClient;
import com.FeignClient.StorageService.repository.StorageServiceRepo;
import com.FeignClient.StorageService.service.StorageServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class StorageServiceImpl implements StorageServiceInterface {
    @Autowired
    StorageServiceRepo storageServiceRepo;

    @Autowired
    DataClient dataClient;

    @Override
    public ResponseEntity<ResponseDto> storeDataFromDataService() {
        List<StorageEntity> storageServiceList= dataClient.getAllData ().getBody ();
        List<StorageEntity> list=storageServiceRepo.saveAll ( storageServiceList );
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK, "Stored Data From DataService!!", list));
    }

    @Override
    public ResponseEntity < ResponseDto > getAllStorage ( ) {
        List<StorageEntity> list=storageServiceRepo.findAll ();
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK,"retrived All the Data From Storage Service!!",list ) );
    }

    @Override
    public ResponseEntity < ResponseDto > updateStorage ( String id, DataEntityDto dto  ) {
        Optional < StorageEntity > oldRecord=storageServiceRepo.findById ( id );
         StorageEntity oldData= dataClient.updateData (id,dto ).getBody ( );
         System.out.println (oldRecord+"   oldRecord" );
         StorageEntity storageEntity=new StorageEntity ();
         storageEntity.setDataName ( oldData.getDataName ( ) );

         storageServiceRepo.save ( storageEntity );

        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Updated All the Data!!",oldData) );
    }

}
