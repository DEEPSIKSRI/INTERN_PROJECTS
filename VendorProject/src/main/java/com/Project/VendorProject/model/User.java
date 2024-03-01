package com.Project.VendorProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="app_user")
public class User {
    @Id
    private String email_id;
    private String Name;
    private String Emp_No;
    private String designation;
//    @OneToOne
//    @JsonIgnore
//    @JoinColumn(name = "asset_id")
//    private Asset asset;
}

