package com.Project.VendorProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Vendor")
public class Vendor {

    @Id
    private String vendor_email_id;

    private String vendor_name;

    private String ph_no;

    private String contact_add;

//   @OneToMany(mappedBy = "vendor")
//    private List<Asset> asset;


}
