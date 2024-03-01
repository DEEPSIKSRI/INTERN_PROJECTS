package com.FeignClient.DataService.controller;

import com.FeignClient.DataService.api.DataServiceApi;
import com.FeignClient.DataService.dto.ResponseDto;
import com.FeignClient.DataService.entity.DataEntity;
import com.FeignClient.DataService.service.impl.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class DataServiceController implements DataServiceApi {

    @Autowired
    DataServiceImpl dataServiceImpl;
    @Override
    public ResponseEntity < List <DataEntity> > getAllData ( ) {
        return dataServiceImpl.getAllData() ;
    }

    @Override
    public ResponseEntity < ResponseDto > saveData ( DataEntity data ) {
        return dataServiceImpl.saveData(data);
    }

    @Override
    public ResponseEntity < DataEntity > updateData ( String uuid , DataEntity data ) {
        return dataServiceImpl.updateData(uuid,data);
    }

}

