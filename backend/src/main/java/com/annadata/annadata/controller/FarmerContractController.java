package com.annadata.annadata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.annadata.annadata.model.FarmerContract;
import com.annadata.annadata.service.FarmerContractService;

import java.util.List;

@RestController
@RequestMapping("farmer-contracts")
public class FarmerContractController {

    @Autowired
    private FarmerContractService farmerContractService;

    // Get all farmer contracts
    @GetMapping("/all")
    public List<FarmerContract> getAllContracts() {
        return farmerContractService.getAllFarmerContracts();
    }

    // Get a specific contract by ID
    @GetMapping("/{id}")
    public FarmerContract getContractById(@PathVariable Long id) {
        return farmerContractService.getContractById(id);
    }

    // Create a new farmer contract
    @PostMapping
    public FarmerContract createContract(@RequestBody FarmerContract contract) {
        return farmerContractService.createFarmerContract(contract);
    }

    // Update an existing farmer contract
    @PutMapping("/{id}")
    public FarmerContract updateContract(@PathVariable Long id, @RequestBody FarmerContract contract) {
        return farmerContractService.updateFarmerContract(id, contract);
    }

    // Delete a farmer contract
    @DeleteMapping("/{id}")
    public void deleteContract(@PathVariable Long id) {
        farmerContractService.deleteFarmerContract(id);
    }
}

