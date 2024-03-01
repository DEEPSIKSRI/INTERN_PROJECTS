package com.FeignClient.DataService.api;


import com.FeignClient.DataService.dto.ResponseDto;
import com.FeignClient.DataService.entity.DataEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
public interface DataServiceApi {

    @GetMapping("/getAllData")
    ResponseEntity< List <DataEntity> > getAllData();

    @PostMapping("/saveData")
    ResponseEntity<ResponseDto> saveData( @RequestBody DataEntity data );

    @PutMapping("/updateData/{id}")
    ResponseEntity<DataEntity> updateData(@PathVariable (value = "id") String uuid,
                                           @RequestBody DataEntity data);
}
