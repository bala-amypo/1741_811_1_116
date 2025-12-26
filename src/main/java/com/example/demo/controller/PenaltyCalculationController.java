package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PenaltyCalculation;
import com.example.demo.service.PenaltyCalculationService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class PenaltyCalculationController {
    @Autowired
    private PenaltyCalculationService serv;
    
    @PostMapping("/api/penalties/calculate/{contractId}")
    public PenaltyCalculation sendCalculation(@PathVariable Long contractId) {
        return serv.calculatePenalty(contractId);
    }
    
    @GetMapping("/api/penalties/{id}")
    public PenaltyCalculation getCalculationForId(@PathVariable Long id) {
        return serv.getCalculationById(id);
    }
    
    @GetMapping("/api/penalties/contract/{contractId}")
    public java.util.List<PenaltyCalculation> getAllContractCalculations(@PathVariable Long contractId) {
        return serv.getCalculationsForContract(contractId);
    }
    

}
