package com.example.demo.service;

import java.math.BigDecimal;

import com.example.demo.entity.PenaltyCalculation;

public interface PenaltyCalculationService {
    public BigDecimal calculatePenalty(Long contractId);
    public PenaltyCalculation getCalculationbyId(Long id);
    public BigDecimal getCalculationsForContract(Long contractId);
}
