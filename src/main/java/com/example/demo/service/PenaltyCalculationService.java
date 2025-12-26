package com.example.demo.service;

import com.example.demo.entity.PenaltyCalculation;

public interface PenaltyCalculationService {
    public PenaltyCalculation calculatePenalty(Long contractId);
    public PenaltyCalculation getCalculationById(Long id);
    public java.util.List<PenaltyCalculation> getCalculationsForContract(Long contractId);
}
