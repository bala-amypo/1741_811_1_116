package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.DeliveryRecordService;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    @Autowired
    private DeliveryRecordRepository repo;

    @Override
    public DeliveryRecord createDeliveryRecord(DeliveryRecord record) {
        record.setCreatedAt(LocalDateTime.now());
        return repo.save(record);
    }

    @Override
    public List<DeliveryRecord> getDeliveryRecordsForContracts(Long contractId) {
        return repo.findAllByContractId(contractId);
    }

    @Override
    public DeliveryRecord getLatestDeliveryRecord(Long contractId) {
        return repo.findTopByContractIdOrderByDeliveryDateDesc(contractId);
    }

    @Override
    public DeliveryRecord getDeliveryRecordById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
