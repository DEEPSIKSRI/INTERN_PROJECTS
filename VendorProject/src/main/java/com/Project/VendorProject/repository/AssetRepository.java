package com.Project.VendorProject.repository;

import com.Project.VendorProject.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository<A, I extends Number> extends JpaRepository<Asset,Integer> {
}
