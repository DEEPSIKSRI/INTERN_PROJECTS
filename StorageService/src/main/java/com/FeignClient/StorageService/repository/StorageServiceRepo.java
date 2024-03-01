package com.FeignClient.StorageService.repository;

import com.FeignClient.StorageService.entity.StorageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageServiceRepo extends JpaRepository< StorageEntity,String > {
}
