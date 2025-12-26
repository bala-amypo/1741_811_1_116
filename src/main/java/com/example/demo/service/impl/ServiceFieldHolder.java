package com.example.demo.service.impl;

import com.example.demo.repository.ContractRepository;
import com.example.demo.repository.DeliveryRecordRepository;

public abstract class ServiceFieldHolder {
    protected ContractRepository contractRepository;
    protected DeliveryRecordRepository deliveryRecordRepository;
}
