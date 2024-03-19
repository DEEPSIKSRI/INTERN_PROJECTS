package com.Project.VendorProject.controller;

import com.Project.VendorProject.api.AssetApi;
import com.Project.VendorProject.model.Asset;
import com.Project.VendorProject.model.Vendor;
import com.Project.VendorProject.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asset")
public class AssetController implements AssetApi {

    @Autowired
    AssetService assetService;

    @Override
    public List<Asset> getAsset()
    {
        return assetService.assetGet();
    }

    @Override
    public Asset saveAsset(Asset asset) {
        return assetService.assetSave(asset);
    }

    @Override
    public Asset storeVendor(Integer asset_si_no, Vendor vendor)
    {
    return (Asset) assetService.assetStore(asset_si_no,vendor);
    }
}
