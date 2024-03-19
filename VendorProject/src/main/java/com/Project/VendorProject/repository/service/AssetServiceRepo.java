package com.Project.VendorProject.repository.service;

import com.Project.VendorProject.model.Asset;
import com.Project.VendorProject.repository.AssetRepository;


public interface AssetServiceRepo<A, I extends Number> extends AssetRepository<Asset,Integer> {
}
