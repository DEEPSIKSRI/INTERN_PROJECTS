package com.FeignClient.StorageService.service;

import com.FeignClient.StorageService.dto.DataEntityDto;
import com.FeignClient.StorageService.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public interface StorageServiceInterface{
    ResponseEntity< ResponseDto> storeDataFromDataService ( );

    ResponseEntity< ResponseDto> getAllStorage ( );

    ResponseEntity < ResponseDto > updateStorage ( String id, DataEntityDto dto);
}
