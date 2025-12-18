package com.example.demo.entity;

import java.math.BigDecimal;
import java.security.Timestamp;

public class PenaltyCalculation {
    Long id;
    Contract contract;
    Integer daysDelayed;
    BigDecimal calculatedPenalty;
    BreachRule appliedRule;
    Timestamp calculatedAt;

    public PenaltyCalculation(Long id, Contract contract, Integer daysDelayed, BigDecimal calculatedPenalty,
            BreachRule appliedRule, Timestamp calculatedAt) {
        this.id = id;
        this.contract = contract;
        this.daysDelayed = daysDelayed;
        this.calculatedPenalty = calculatedPenalty;
        this.appliedRule = appliedRule;
        this.calculatedAt = calculatedAt;
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
    public Integer getDaysDelayed() {
        return daysDelayed;
    }
    public void setDaysDelayed(Integer daysDelayed) {
        this.daysDelayed = daysDelayed;
    }
    public BigDecimal getCalculatedPenalty() {
        return calculatedPenalty;
    }
    public void setCalculatedPenalty(BigDecimal calculatedPenalty) {
        this.calculatedPenalty = calculatedPenalty;
    }
    public BreachRule getAppliedRule() {
        return appliedRule;
    }
    public void setAppliedRule(BreachRule appliedRule) {
        this.appliedRule = appliedRule;
    }
    public Timestamp getCalculatedAt() {
        return calculatedAt;
    }
    public void setCalculatedAt(Timestamp calculatedAt) {
        this.calculatedAt = calculatedAt;
    }

}