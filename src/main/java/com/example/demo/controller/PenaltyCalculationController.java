package com.example.demo.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PenaltyCalculation;
import com.example.demo.service.PenaltyCalculationService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class PenaltyCalculationController {
    @Autowired
    private PenaltyCalculationService serv;
    
    @PostMapping("/api/penalties/calculate/{contractId}")
    public BigDecimal sendCalculation(@PathVariable Long contractId) {
        return serv.calculatePenalty(contractId);
    }
    
    @GetMapping("/api/penalties/{id}")
    public PenaltyCalculation getCalculationForId(@RequestParam Long id) {
        return serv.getCalculationbyId(id);
    }
    
    @GetMapping("/api/penalties/contract/{contractId}")
    public BigDecimal getAllContractCalculations(@PathVariable Long contractId) {
        return serv.getCalculationsForContract(contractId);
    }
    

}
