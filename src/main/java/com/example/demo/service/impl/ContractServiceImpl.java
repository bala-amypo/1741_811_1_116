package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Contract;
import com.example.demo.entity.DeliveryRecord;
import com.example.demo.repository.ContractRepository;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.ContractService;

@Service
public class ContractServiceImpl implements ContractService{

    @Autowired
    ContractRepository repo;

    @Autowired
    DeliveryRecordRepository deliver;

    @Override
    public Contract createContract(Contract contract){
        repo.save(contract);
        return contract;
    }
    @Override
    public Contract updateContract(Long id , Contract contract){
        Contract existing = repo.findById(id).orElse(null);
        existing.setContractNumber(contract.getContractNumber());
        existing.setAgreedDeliveryDate(contract.getAgreedDeliveryDate());
        existing.setBaseContractValue(contract.getBaseContractValue());
        existing.setCounterpartyName(contract.getCounterpartyName());
        existing.setStatus(contract.getStatus());
        existing.setTitle(contract.getTitle());
        existing.setUpdatedAt(LocalDateTime.now());
        repo.save(existing);
        return existing;
    }

    @Override
    public Contract getContractById(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Contract> getAllContracts(){
        return repo.findAll();
    }

    @Override
    public Contract updateContractStatus(Long contractId){
        Contract contract = repo.findById(contractId).orElse(null);
        DeliveryRecord delivery = deliver.findByContractId(contractId);

        String stat;

        if(delivery == null ) stat = "ACTIVE";
        else if (delivery.getDeliveryDate().isAfter(contract.getAgreedDeliveryDate())) stat = "BREACHED";
        else stat = "COMPLETED";

        contract.setStatus(stat);
        contract.setUpdatedAt(LocalDateTime.now());
        repo.save(contract);
        return stat;
    }
}
