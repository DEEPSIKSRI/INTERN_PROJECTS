package com.FeignClient.DataService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DataService")
@Entity

public class DataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String dataName;

    private String description;

    private String creationDate;


}
