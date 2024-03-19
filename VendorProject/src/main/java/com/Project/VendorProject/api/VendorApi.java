package com.Project.VendorProject.api;

import com.Project.VendorProject.model.Vendor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendor")
public interface VendorApi {

    @GetMapping("/get")
    List<Vendor> getVendor();

    @PostMapping("/save")
    Vendor saveVendor(@RequestBody Vendor vendor);

}
