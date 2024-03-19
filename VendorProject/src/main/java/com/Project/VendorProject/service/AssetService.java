package com.Project.VendorProject.service;

import com.Project.VendorProject.model.Asset;
import com.Project.VendorProject.model.Vendor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssetService {

    List<Asset> assetGet();

    Asset assetSave(Asset asset);


    Object assetStore(Integer assetSiNo, Vendor vendor);
}
