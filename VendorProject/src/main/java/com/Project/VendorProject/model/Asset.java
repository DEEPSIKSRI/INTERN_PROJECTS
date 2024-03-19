package com.Project.VendorProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="asset")
@Entity

public class Asset {
    @Id
    @GeneratedValue
    private int asset_si_no ;
    private String asset_type;
    private String asset_name;
    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

}
