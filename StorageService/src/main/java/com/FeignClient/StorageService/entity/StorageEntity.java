package com.FeignClient.StorageService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "StorageService")
@Entity

public class StorageEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String dataName;

    private String storageLocation;

    private long fileSize;

}

