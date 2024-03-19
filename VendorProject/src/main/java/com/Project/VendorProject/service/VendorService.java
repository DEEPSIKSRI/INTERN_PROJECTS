package com.Project.VendorProject.service;

import com.Project.VendorProject.api.VendorApi;
import com.Project.VendorProject.model.Vendor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface VendorService {

    List<Vendor> vendorGet();

    Vendor vendorSave(Vendor vendor);
}
