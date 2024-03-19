package com.Project.VendorProject.service.implementation;

import com.Project.VendorProject.model.Vendor;
import com.Project.VendorProject.repository.VendorRepository;
import com.Project.VendorProject.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    VendorRepository vendorRepository;

    @Override
    public List<Vendor> vendorGet() {
        return vendorRepository.findAll();
    }

    @Override
    public Vendor vendorSave(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

}
