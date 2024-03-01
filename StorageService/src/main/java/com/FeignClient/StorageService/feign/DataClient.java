package com.FeignClient.StorageService.feign;

import com.FeignClient.StorageService.dto.DataEntityDto;
import com.FeignClient.StorageService.dto.ResponseDto;
import com.FeignClient.StorageService.entity.StorageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service

@FeignClient(name = "DATASERVICE", path = "/data")
public interface DataClient{

    @GetMapping("/getAllData")
    ResponseEntity < List < StorageEntity > > getAllData();

    @PutMapping("/updateData/{id}")
    ResponseEntity<StorageEntity> updateData(@PathVariable(value = "id") String uuid,
                                             @RequestBody DataEntityDto data);

}
