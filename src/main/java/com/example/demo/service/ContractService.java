package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Contract;

public interface ContractService {
    public Contract createContract(Contract contract);
    public Contract updateContract(Long id , Contract contract);
    public Contract getContractById(Long id);
    public List<Contract> getAllContracts();
    public String updateContractStatus(Long contractId);
}
