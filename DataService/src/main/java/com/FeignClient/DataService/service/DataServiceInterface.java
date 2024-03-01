package com.FeignClient.DataService.service;

import com.FeignClient.DataService.dto.ResponseDto;
import com.FeignClient.DataService.entity.DataEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface DataServiceInterface {

    ResponseEntity< List <DataEntity> > getAllData ( );

    ResponseEntity< ResponseDto> saveData ( DataEntity dataService );

    ResponseEntity< DataEntity> updateData ( String uuid , DataEntity data );
}
