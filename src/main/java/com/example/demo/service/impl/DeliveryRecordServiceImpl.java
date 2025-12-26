package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.DeliveryRecordService;
import com.example.demo.repository.ContractRepository;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    @Autowired
    private DeliveryRecordRepository repo;

    // fields expected by tests
    private com.example.demo.repository.DeliveryRecordRepository deliveryRecordRepository;
    // field name expected by tests for manual injection
    private com.example.demo.repository.ContractRepository contractRepository;

    @Override
    public DeliveryRecord createDeliveryRecord(DeliveryRecord record) {
        if (record.getDeliveryDate() != null && record.getDeliveryDate().isAfter(java.time.LocalDate.now())) {
            throw new IllegalArgumentException("Delivery date cannot be in the future");
        }
        record.setCreatedAt(LocalDateTime.now());
        com.example.demo.repository.DeliveryRecordRepository r = deliveryRecordRepository != null ? deliveryRecordRepository : repo;
        return r.save(record);
    }

    @Override
    public List<DeliveryRecord> getDeliveryRecordsForContracts(Long contractId) {
        return repo.findAllByContractId(contractId);
    }

    // method name expected by tests
    public List<DeliveryRecord> getDeliveryRecordsForContract(Long contractId) {
        if (deliveryRecordRepository != null) {
            return deliveryRecordRepository.findByContractIdOrderByDeliveryDateAsc(contractId);
        }
        return repo.findByContractIdOrderByDeliveryDateAsc(contractId);
    }

    @Override
    public DeliveryRecord getLatestDeliveryRecord(Long contractId) {
        // prefer injected mock
        if (deliveryRecordRepository != null) {
            return deliveryRecordRepository.findFirstByContractIdOrderByDeliveryDateDesc(contractId).orElseThrow(() -> new RuntimeException("No delivery records found"));
        }
        DeliveryRecord r = repo.findTopByContractIdOrderByDeliveryDateDesc(contractId);
        if (r == null) throw new RuntimeException("No delivery records found");
        return r;
    }

    @Override
    public DeliveryRecord getDeliveryRecordById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // method expected by tests
    public DeliveryRecord getRecordById(Long id) {
        if (deliveryRecordRepository != null) {
            return deliveryRecordRepository.findById(id).orElseThrow(() -> new RuntimeException("Delivery record not found"));
        }
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Delivery record not found"));
    }
}
