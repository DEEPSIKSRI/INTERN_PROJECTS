package com.Project.VendorProject.service.implementation;

import com.Project.VendorProject.model.Asset;
import com.Project.VendorProject.model.Vendor;
import com.Project.VendorProject.repository.AssetRepository;
import com.Project.VendorProject.repository.VendorRepository;
import com.Project.VendorProject.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    VendorRepository vendorRepository;

    @Override
    public List<Asset> assetGet() {
        return assetRepository.findAll();
    }

    @Override
    public Asset assetSave(Asset asset) {
        return (Asset) assetRepository.save(asset);
    }

    @Override
    public Object assetStore(Integer assetSiNo, Vendor vendor) {
        Optional<Asset> optionalAsset = assetRepository.findById(assetSiNo);
        if (optionalAsset.isPresent()) {
            Asset asset = optionalAsset.get();
            Set<Vendor> vendor1= null;
            Vendor savedVendor = vendorRepository.save(vendor);
            vendor1.add(savedVendor);
            asset.setVendor((Vendor) vendor1);
            return assetRepository.save(asset);
        }
        return null;
    }


}