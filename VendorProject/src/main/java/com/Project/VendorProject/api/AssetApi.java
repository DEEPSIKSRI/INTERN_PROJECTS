package com.Project.VendorProject.api;

import com.Project.VendorProject.model.Asset;
import com.Project.VendorProject.model.Vendor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asset")
public interface AssetApi {

    @GetMapping("/get")
    List<Asset> getAsset();

    @PostMapping("/save")
    Asset saveAsset(@RequestBody Asset asset);

    @PostMapping("/storeVendor/{asset_si_no}")
    Asset storeVendor(@PathVariable (value="asset_si_no") Integer asset_si_no,
                      @RequestBody Vendor vendor);
}
