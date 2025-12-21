package com.example.demo.service.impl;

import java.math.BigDecimal;
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
    public BigDecimal calculatePenalty(Long contractId) {

        Contract contract = contractRepository.findById(contractId).orElse(null);
        if (contract == null) return BigDecimal.ZERO;

        DeliveryRecord deliveryRecord = deliveryRecordRepository.findTopByContractIdOrderByDeliveryDateDesc(contract.getId());

        if (deliveryRecord == null) {
            return BigDecimal.ZERO;
        }

        BreachRule rule =
                breachRuleRepository
                        .findAll()
                        .stream()
                        .filter(r -> Boolean.TRUE.equals(r.getActive()))
                        .findFirst()
                        .orElse(null);

        if (rule == null) {
            return BigDecimal.ZERO;
        }

        long daysDelayed =
                ChronoUnit.DAYS.between(
                        contract.getAgreedDeliveryDate(),
                        deliveryRecord.getDeliveryDate()
                );

        if (daysDelayed <= 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal penaltyByDays =
                rule.getPenaltyPerDay()
                        .multiply(BigDecimal.valueOf(daysDelayed));

        BigDecimal maxPenalty =
                contract.getBaseContractValue()
                        .multiply(BigDecimal.valueOf(rule.getMaxPenaltyPercentage()))
                        .divide(BigDecimal.valueOf(100));

        BigDecimal finalPenalty = penaltyByDays.min(maxPenalty);

        PenaltyCalculation calculation = new PenaltyCalculation();
        calculation.setContract(contract);
        calculation.setDaysDelayed((int) daysDelayed);
        calculation.setCalculatedPenalty(finalPenalty);
        calculation.setAppliedRule(rule);

        penaltyCalculationRepository.save(calculation);

        return finalPenalty;
    }

    @Override
    public PenaltyCalculation getCalculationbyId(Long id) {
        return penaltyCalculationRepository.findById(id).orElse(null);
    }

    @Override
    public BigDecimal getCalculationsForContract(Long contractId) {

        return penaltyCalculationRepository.findAll()
                .stream()
                .filter(c -> c.getContract() != null)
                .filter(c -> c.getContract().getId().equals(contractId))
                .map(PenaltyCalculation::getCalculatedPenalty)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
