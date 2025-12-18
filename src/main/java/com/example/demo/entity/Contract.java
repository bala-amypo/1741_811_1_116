package com.example.demo.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import jakarta.persistence.Entity;

@Entity
public class Contract {
    private Long id;
    private String contractNumber;
    private String title;
    private String counterpartyName;
    private Date agreedDeliveryDate;
    private BigDecimal baseContractValue;
    private String status;
    private Instant createdAt;
    private Instant updatedAt;

    public Contract(Long id, String contractNumber, String title, String counterpartyName, Date agreedDeliveryDate,
            BigDecimal baseContractValue, String status, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.contractNumber = contractNumber;
        this.title = title;
        this.counterpartyName = counterpartyName;
        this.agreedDeliveryDate = agreedDeliveryDate;
        this.baseContractValue = baseContractValue;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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
    public Date getAgreedDeliveryDate() {
        return agreedDeliveryDate;
    }
    public void setAgreedDeliveryDate(Date agreedDeliveryDate) {
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
    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
    public Instant getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

}
