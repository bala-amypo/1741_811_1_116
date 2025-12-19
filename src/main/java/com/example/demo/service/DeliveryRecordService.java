package com.example.demo.service;

import com.example.demo.entity.DeliveryRecord;

public interface DeliveryRecordService {
    public DeliveryRecord createDeliveryRecord(DeliveryRecord record);
    public DeliveryRecord getDeliveryRecordsForContracts(Long contractId);
    public DeliveryRecord getLatestDeliveryRecord(Long contractId);
    public DeliveryRecord getDeliveryRecordById(Long id);
}
