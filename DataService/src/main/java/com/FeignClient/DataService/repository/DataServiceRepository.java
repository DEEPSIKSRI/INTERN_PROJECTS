package com.FeignClient.DataService.repository;

import com.FeignClient.DataService.entity.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DataServiceRepository extends JpaRepository< DataEntity,String > {
}
