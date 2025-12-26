package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class BreachRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ruleName;
    
    private BigDecimal penaltyPerDay;
    private Double maxPenaltyPercentage;
    private Boolean active;
    private Boolean isDefaultRule;

    public BreachRule() {
    }

    public BreachRule(String ruleName, BigDecimal penaltyPerDay, Double maxPenaltyPercentage, 
                     Boolean active, Boolean isDefaultRule) {
        this.ruleName = ruleName;
        this.penaltyPerDay = penaltyPerDay;
        this.maxPenaltyPercentage = maxPenaltyPercentage;
        this.active = active;
        this.isDefaultRule = isDefaultRule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public BigDecimal getPenaltyPerDay() {
        return penaltyPerDay;
    }

    public void setPenaltyPerDay(BigDecimal penaltyPerDay) {
        this.penaltyPerDay = penaltyPerDay;
    }

    public Double getMaxPenaltyPercentage() {
        return maxPenaltyPercentage;
    }

    public void setMaxPenaltyPercentage(Double maxPenaltyPercentage) {
        this.maxPenaltyPercentage = maxPenaltyPercentage;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getIsDefaultRule() {
        return isDefaultRule;
    }

    public void setIsDefaultRule(Boolean isDefaultRule) {
        this.isDefaultRule = isDefaultRule;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long id;
        private String ruleName;
        private java.math.BigDecimal penaltyPerDay;
        private Double maxPenaltyPercentage;
        private Boolean active;
        private Boolean isDefaultRule;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder ruleName(String ruleName) { this.ruleName = ruleName; return this; }
        public Builder penaltyPerDay(java.math.BigDecimal penaltyPerDay) { this.penaltyPerDay = penaltyPerDay; return this; }
        public Builder maxPenaltyPercentage(Double maxPenaltyPercentage) { this.maxPenaltyPercentage = maxPenaltyPercentage; return this; }
        public Builder active(Boolean active) { this.active = active; return this; }
        public Builder isDefaultRule(Boolean isDefaultRule) { this.isDefaultRule = isDefaultRule; return this; }

        public BreachRule build() {
            BreachRule b = new BreachRule();
            b.setId(this.id);
            b.setRuleName(this.ruleName);
            b.setPenaltyPerDay(this.penaltyPerDay);
            b.setMaxPenaltyPercentage(this.maxPenaltyPercentage);
            b.setActive(this.active);
            b.setIsDefaultRule(this.isDefaultRule);
            return b;
        }
    }
}