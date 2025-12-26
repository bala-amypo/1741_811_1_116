package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.DeliveryRecord;

public interface DeliveryRecordService {
    public DeliveryRecord createDeliveryRecord(DeliveryRecord record);
    public List<DeliveryRecord> getDeliveryRecordsForContracts(Long contractId);
    public DeliveryRecord getLatestDeliveryRecord(Long contractId);
    public DeliveryRecord getDeliveryRecordById(Long id);
    public DeliveryRecord getRecordById(Long id);
}
