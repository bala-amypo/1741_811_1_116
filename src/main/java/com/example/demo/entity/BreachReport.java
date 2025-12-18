package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class BreachReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Contract contract;

    private LocalDateTime reportGeneratedAt;
    private Integer daysDelayed;
    private BigDecimal penaltyAmount;
    private String remarks;
    
    public BreachReport() {
    }

    public BreachReport(Long id, Contract contract, LocalDateTime reportGeneratedAt, Integer daysDelayed,
            BigDecimal penaltyAmount, String remarks) {
        this.id = id;
        this.contract = contract;
        this.reportGeneratedAt = reportGeneratedAt;
        this.daysDelayed = daysDelayed;
        this.penaltyAmount = penaltyAmount;
        this.remarks = remarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public LocalDateTime getReportGeneratedAt() {
        return reportGeneratedAt;
    }

    public void setReportGeneratedAt(LocalDateTime reportGeneratedAt) {
        this.reportGeneratedAt = reportGeneratedAt;
    }

    public Integer getDaysDelayed() {
        return daysDelayed;
    }

    public void setDaysDelayed(Integer daysDelayed) {
        this.daysDelayed = daysDelayed;
    }

    public BigDecimal getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setPenaltyAmount(BigDecimal penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
