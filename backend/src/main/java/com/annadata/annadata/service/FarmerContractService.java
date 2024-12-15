package com.annadata.annadata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annadata.annadata.model.FarmerContract;
import com.annadata.annadata.repository.FarmerContractRepository;

import java.util.List;

@Service
public class FarmerContractService {

    @Autowired
    private FarmerContractRepository farmerContractRepository;

    // Get all farmer contracts
    public List<FarmerContract> getAllFarmerContracts() {
        return farmerContractRepository.findAll();
    }

    // Create a new contract
    public FarmerContract createFarmerContract(FarmerContract contract) {
        return farmerContractRepository.save(contract);
    }

    // Get contract by ID
    public FarmerContract getContractById(Long id) {
        return farmerContractRepository.findById(id).orElse(null);
    }

    // Update an existing contract
    public FarmerContract updateFarmerContract(Long id, FarmerContract contractDetails) {
        if (farmerContractRepository.existsById(id)) {
            contractDetails.setId(id);
            return farmerContractRepository.save(contractDetails);
        }
        return null;
    }

    // Delete a contract
    public void deleteFarmerContract(Long id) {
        farmerContractRepository.deleteById(id);
    }
}

