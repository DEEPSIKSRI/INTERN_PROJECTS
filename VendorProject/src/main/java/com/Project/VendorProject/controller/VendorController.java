package com.Project.VendorProject.controller;

import com.Project.VendorProject.api.VendorApi;
import com.Project.VendorProject.model.Vendor;
import com.Project.VendorProject.service.VendorService;
import com.Project.VendorProject.service.implementation.VendorServiceImpl;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vendor")

public class VendorController implements VendorApi {

    @Autowired
    VendorService vendorService;

    public List<Vendor> getVendor()
    {
        return vendorService.vendorGet();
    }

    @Override
    public Vendor saveVendor(Vendor vendor) {
        return vendorService.vendorSave(vendor);
    }

}
