package com.example.demo.service.impl;

import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BreachRule;
import com.example.demo.entity.Contract;
import com.example.demo.entity.DeliveryRecord;
import com.example.demo.entity.PenaltyCalculation;
import com.example.demo.repository.BreachRuleRepository;
import com.example.demo.repository.ContractRepository;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.repository.PenaltyCalculationRepository;
import com.example.demo.service.PenaltyCalculationService;

@Service
public class PenaltyCalculationServiceImpl implements PenaltyCalculationService {

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    DeliveryRecordRepository deliveryRecordRepository;

    @Autowired
    BreachRuleRepository breachRuleRepository;

    @Autowired
    PenaltyCalculationRepository penaltyCalculationRepository;

    @Override
    public PenaltyCalculation calculatePenalty(Long contractId) {
        Contract contract = contractRepository.findById(contractId).orElseThrow(() -> new RuntimeException("Contract not found"));

        java.util.Optional<DeliveryRecord> optDelivery = deliveryRecordRepository.findFirstByContractIdOrderByDeliveryDateDesc(contractId);
        if (optDelivery.isEmpty()) throw new RuntimeException("No delivery record");
        DeliveryRecord deliveryRecord = optDelivery.get();

        java.util.Optional<BreachRule> optRule = breachRuleRepository.findFirstByActiveTrueOrderByIsDefaultRuleDesc();
        BreachRule rule = optRule.orElseThrow(() -> new RuntimeException("No breach rule"));

        long daysDelayed = ChronoUnit.DAYS.between(contract.getAgreedDeliveryDate(), deliveryRecord.getDeliveryDate());
        if (daysDelayed < 0) daysDelayed = 0;

        java.math.BigDecimal penaltyByDays = rule.getPenaltyPerDay() == null ? java.math.BigDecimal.ZERO : rule.getPenaltyPerDay().multiply(java.math.BigDecimal.valueOf(daysDelayed));
        java.math.BigDecimal maxPenalty = java.math.BigDecimal.ZERO;
        if (contract.getBaseContractValue() != null && rule.getMaxPenaltyPercentage() != null) {
            maxPenalty = contract.getBaseContractValue().multiply(java.math.BigDecimal.valueOf(rule.getMaxPenaltyPercentage())).divide(java.math.BigDecimal.valueOf(100));
        }

        java.math.BigDecimal finalPenalty = penaltyByDays.compareTo(maxPenalty) > 0 ? maxPenalty : penaltyByDays;

        PenaltyCalculation calc = new PenaltyCalculation();
        calc.setContract(contract);
        calc.setDaysDelayed((int) daysDelayed);
        calc.setCalculatedPenalty(finalPenalty);
        calc.setAppliedRule(rule);

        PenaltyCalculation saved = penaltyCalculationRepository.save(calc);
        return saved;
    }

    @Override
    public PenaltyCalculation getCalculationById(Long id) {
        return penaltyCalculationRepository.findById(id).orElseThrow(() -> new RuntimeException("Calculation not found"));
    }

    @Override
    public java.util.List<PenaltyCalculation> getCalculationsForContract(Long contractId) {
        return penaltyCalculationRepository.findByContractId(contractId);
    }
}
