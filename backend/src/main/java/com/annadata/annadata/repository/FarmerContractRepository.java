package com.annadata.annadata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.annadata.annadata.model.FarmerContract;

@Repository
public interface FarmerContractRepository extends JpaRepository<FarmerContract, Long> {
    // You can define custom queries here if needed
}
