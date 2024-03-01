package com.Project.VendorProject.repository;

import com.Project.VendorProject.model.Vendor;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VendorRepository extends JpaRepository<Vendor,Integer> {
}
