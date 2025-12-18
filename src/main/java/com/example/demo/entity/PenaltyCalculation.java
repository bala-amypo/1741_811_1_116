package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class PenaltyCalculation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Contract contract;
    
    private Integer daysDelayed;
    private BigDecimal calculatedPenalty;
    
    @ManyToOne
    private BreachRule appliedRule;

    private LocalDateTime calculatedAt;

    public PenaltyCalculation() {
    }

    public PenaltyCalculation(Contract contract, Integer daysDelayed, 
                            BigDecimal calculatedPenalty, BreachRule appliedRule) {
        this.contract = contract;
        this.daysDelayed = daysDelayed;
        this.calculatedPenalty = calculatedPenalty;
        this.appliedRule = appliedRule;
        this.calculatedAt = LocalDateTime.now();
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

    public LocalDateTime getCalculatedAt() {
        return calculatedAt;
    }

    public void setCalculatedAt(LocalDateTime calculatedAt) {
        this.calculatedAt = calculatedAt;
    }
}