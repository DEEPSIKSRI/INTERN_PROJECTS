package com.capstone.sample_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Address")

public class Address {

    @Id
    private String addressId;

    private String city;

    private String street;

    private String pincode;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
