package com.capstone.sample_project.repository;

import com.capstone.sample_project.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository

public interface AddressRepository extends JpaRepository< Address,String > {
}
