package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class DeliveryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Contract contract;
    
    private LocalDate deliveryDate;
    private String notes;
    private LocalDateTime createdAt;

    public DeliveryRecord() {
    }

    public DeliveryRecord(Contract contract, LocalDate deliveryDate, String notes) {
        this.contract = contract;
        this.deliveryDate = deliveryDate;
        this.notes = notes;
        this.createdAt = LocalDateTime.now();
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

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long id;
        private Contract contract;
        private LocalDate deliveryDate;
        private String notes;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder contract(Contract contract) { this.contract = contract; return this; }
        public Builder deliveryDate(LocalDate deliveryDate) { this.deliveryDate = deliveryDate; return this; }
        public Builder notes(String notes) { this.notes = notes; return this; }

        public DeliveryRecord build() {
            DeliveryRecord r = new DeliveryRecord();
            r.setId(this.id);
            r.setContract(this.contract);
            r.setDeliveryDate(this.deliveryDate);
            r.setNotes(this.notes);
            return r;
        }
    }
}