package com.jsp.Job.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Company {

    @Id
    private int companyId;

    private String name;

    private String address;

    private String contactNumber;

    private String status;

    private String companyMission;



}