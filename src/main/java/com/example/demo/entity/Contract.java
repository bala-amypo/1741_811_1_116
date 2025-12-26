package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column( unique = true)
    private String contractNumber;
    
    private String title;
    private String counterpartyName;
    private LocalDate agreedDeliveryDate;
    private BigDecimal baseContractValue;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Contract() {
    }

    public Contract(String contractNumber, String title, String counterpartyName, 
                   LocalDate agreedDeliveryDate, BigDecimal baseContractValue, 
                   String status) {
        this.contractNumber = contractNumber;
        this.title = title;
        this.counterpartyName = counterpartyName;
        this.agreedDeliveryDate = agreedDeliveryDate;
        this.baseContractValue = baseContractValue;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCounterpartyName() {
        return counterpartyName;
    }

    public void setCounterpartyName(String counterpartyName) {
        this.counterpartyName = counterpartyName;
    }

    public LocalDate getAgreedDeliveryDate() {
        return agreedDeliveryDate;
    }

    public void setAgreedDeliveryDate(LocalDate agreedDeliveryDate) {
        this.agreedDeliveryDate = agreedDeliveryDate;
    }

    public BigDecimal getBaseContractValue() {
        return baseContractValue;
    }

    public void setBaseContractValue(BigDecimal baseContractValue) {
        this.baseContractValue = baseContractValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String contractNumber;
        private String title;
        private String counterpartyName;
        private LocalDate agreedDeliveryDate;
        private BigDecimal baseContractValue;
        private String status;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder contractNumber(String contractNumber) { this.contractNumber = contractNumber; return this; }
        public Builder title(String title) { this.title = title; return this; }
        public Builder counterpartyName(String counterpartyName) { this.counterpartyName = counterpartyName; return this; }
        public Builder agreedDeliveryDate(LocalDate agreedDeliveryDate) { this.agreedDeliveryDate = agreedDeliveryDate; return this; }
        public Builder baseContractValue(BigDecimal baseContractValue) { this.baseContractValue = baseContractValue; return this; }
        public Builder status(String status) { this.status = status; return this; }

        public Contract build() {
            Contract c = new Contract();
            c.setId(this.id);
            c.setContractNumber(this.contractNumber);
            c.setTitle(this.title);
            c.setCounterpartyName(this.counterpartyName);
            c.setAgreedDeliveryDate(this.agreedDeliveryDate);
            c.setBaseContractValue(this.baseContractValue);
            c.setStatus(this.status);
            return c;
        }
    }
}