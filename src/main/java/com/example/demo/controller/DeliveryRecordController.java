package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DeliveryRecord;
import com.example.demo.service.ContractService;
import com.example.demo.service.DeliveryRecordService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class DeliveryRecordController {
    @Autowired
    DeliveryRecordService service;

    @Autowired
    ContractService contractService;

    @PostMapping("/api/delivery-records/")
    public DeliveryRecord createRecord(@RequestBody DeliveryRecord newRecord) {
        newRecord.setDeliveryDate(LocalDate.now());
        DeliveryRecord saved = service.createDeliveryRecord(newRecord);
        contractService.updateContractStatus(saved.getContract().getId());
        return saved;
    }
    
    @GetMapping("/api/delivery-records/{id}")
    public DeliveryRecord getMethodName(@PathVariable Long id) {
        return service.getDeliveryRecordById(id);
    }

    @GetMapping("/api/delivery-records/contract/{contractId}")
    public List<DeliveryRecord> getContractRecords(@PathVariable Long id) {
        return service.getDeliveryRecordsForContracts(id);
    }
    

}
