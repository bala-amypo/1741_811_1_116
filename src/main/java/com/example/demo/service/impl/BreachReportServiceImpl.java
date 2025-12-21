package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BreachReport;
import com.example.demo.entity.Contract;
import com.example.demo.entity.DeliveryRecord;
import com.example.demo.entity.BreachRule;
import com.example.demo.repository.BreachReportRepository;
import com.example.demo.repository.ContractRepository;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.repository.BreachRuleRepository;
import com.example.demo.service.BreachReportService;

@Service
public class BreachReportServiceImpl implements BreachReportService {

    @Autowired
    BreachReportRepository reportRepo;

    @Autowired
    ContractRepository contractRepo;

    @Autowired
    DeliveryRecordRepository deliveryRepo;

    @Autowired
    BreachRuleRepository ruleRepo;

    @Override
    public BreachReport generateReport(Long contractId) {
        Contract contract = contractRepo.findById(contractId).orElse(null);
        if(contract == null) return null;

        DeliveryRecord latestDelivery = deliveryRepo.findTopByContractIdOrderByDeliveryDateDesc(contractId);
        if(latestDelivery == null) return null;

        int daysDelayed = (int) java.time.temporal.ChronoUnit.DAYS.between(
                contract.getAgreedDeliveryDate(), latestDelivery.getDeliveryDate());
        if(daysDelayed < 0) daysDelayed = 0;

        BreachRule rule = ruleRepo.findAll().stream()
                            .filter(r -> r.getActive() && r.getIsDefaultRule())
                            .findFirst()
                            .orElse(null);
        if(rule == null) return null;

        BigDecimal penalty = rule.getPenaltyPerDay().multiply(BigDecimal.valueOf(daysDelayed));
        BigDecimal maxPenalty = contract.getBaseContractValue()
                                .multiply(BigDecimal.valueOf(rule.getMaxPenaltyPercentage()/100));
        if(penalty.compareTo(maxPenalty) > 0) penalty = maxPenalty;

        BreachReport report = new BreachReport();
        report.setContract(contract);
        report.setReportGeneratedAt(LocalDateTime.now());
        report.setDaysDelayed(daysDelayed);
        report.setPenaltyAmount(penalty);
        report.setRemarks(daysDelayed > 0 ? "Delayed" : "On time");

        return reportRepo.save(report);
    }

    @Override
    public BreachReport getReportById(Long id) {
        return reportRepo.findById(id).orElse(null);
    }

    @Override
    public BreachReport getReportsForContract(Long contractId) {
        return reportRepo.findAll().stream()
                .filter(r -> r.getContract().getId().equals(contractId))
                .sorted((r1, r2) -> r2.getReportGeneratedAt().compareTo(r1.getReportGeneratedAt()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<BreachReport> getAllReports() {
        return reportRepo.findAll();
    }
}
