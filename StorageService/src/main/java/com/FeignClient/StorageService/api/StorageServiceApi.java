package com.FeignClient.StorageService.api;

import com.FeignClient.StorageService.dto.DataEntityDto;
import com.FeignClient.StorageService.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/storage")

public interface StorageServiceApi {

   @PostMapping("/storeData")
    ResponseEntity< ResponseDto > storeData();

   @GetMapping("/getAllStorage")
    ResponseEntity<ResponseDto> getAllStorage();

   @PutMapping("/updateStorage/{id}")
   ResponseEntity < ResponseDto > updateStorage( @PathVariable (value = "id") String id,@RequestBody DataEntityDto dto);

}
