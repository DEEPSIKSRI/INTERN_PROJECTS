package com.FeignClient.StorageService.controller;

import com.FeignClient.StorageService.api.StorageServiceApi;
import com.FeignClient.StorageService.dto.DataEntityDto;
import com.FeignClient.StorageService.dto.ResponseDto;
import com.FeignClient.StorageService.service.impl.StorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class StorageServiceController implements StorageServiceApi {

    @Autowired
    StorageServiceImpl service;
    @Override
    public ResponseEntity < ResponseDto > storeData ( ) {
        return service.storeDataFromDataService();
    }

    @Override
    public ResponseEntity < ResponseDto > getAllStorage ( ) {
        return service.getAllStorage();
    }

    @Override
    public ResponseEntity < ResponseDto > updateStorage ( String id, DataEntityDto dto) {
        return service.updateStorage(id,dto);

    }
}
