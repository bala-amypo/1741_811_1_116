package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
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

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long id;
        private Contract contract;
        private java.time.LocalDateTime reportGeneratedAt;
        private Integer daysDelayed;
        private java.math.BigDecimal penaltyAmount;
        private String remarks;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder contract(Contract contract) { this.contract = contract; return this; }
        public Builder reportGeneratedAt(java.time.LocalDateTime reportGeneratedAt) { this.reportGeneratedAt = reportGeneratedAt; return this; }
        public Builder daysDelayed(Integer daysDelayed) { this.daysDelayed = daysDelayed; return this; }
        public Builder penaltyAmount(java.math.BigDecimal penaltyAmount) { this.penaltyAmount = penaltyAmount; return this; }
        public Builder remarks(String remarks) { this.remarks = remarks; return this; }

        public BreachReport build() {
            BreachReport r = new BreachReport();
            r.setId(this.id);
            r.setContract(this.contract);
            r.setReportGeneratedAt(this.reportGeneratedAt);
            r.setDaysDelayed(this.daysDelayed);
            r.setPenaltyAmount(this.penaltyAmount);
            r.setRemarks(this.remarks);
            return r;
        }
    }
}
