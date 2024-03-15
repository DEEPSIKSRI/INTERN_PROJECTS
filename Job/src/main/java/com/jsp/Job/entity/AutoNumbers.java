package com.jsp.Job.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.Id;

@Entity
@Data
public class AutoNumbers {

    @Id
    private int autoId;

    private String autoKey;

    private int autoEnd;

    private int autoInc;

    private String autoStart;
}