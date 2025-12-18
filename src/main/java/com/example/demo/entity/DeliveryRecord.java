package com.example.demo.entity;

import java.sql.Date;
import java.time.Instant;
import jakarta.persistence.Entity;

@Entity
public class DeliveryRecord {
    private Long id;
    private Contract contract;
    private Date deliveryDate;
    private String notes;
    private Instant createdAt;


    public DeliveryRecord(Long id, Contract contract, Date deliveryDate, String notes, Instant createdAt) {
        this.id = id;
        this.contract = contract;
        this.deliveryDate = deliveryDate;
        this.notes = notes;
        this.createdAt = createdAt;
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
    public Date getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}
