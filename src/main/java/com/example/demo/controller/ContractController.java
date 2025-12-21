package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Contract;
import com.example.demo.service.ContractService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class ContractController {
    @Autowired
    ContractService serv;

    @PostMapping("/")
    public Contract createContract(@RequestBody Contract entity) {
        return serv.createContract(entity);
    }

    @PutMapping("/{id}")
    public Contract putContract(@PathVariable Long id, @RequestBody Contract contract) {
        return serv.updateContract(id, contract);
    }

    @GetMapping("/{id}")
    public Contract getContract(@RequestParam Long id) {
        return serv.getContractById(id);
    }
    
    @GetMapping("/")
    public List<Contract> getAll() {
        return serv.getAllContracts();
    }
    
    @PutMapping("/{id}/update-status")
    public String updateStatus(@PathVariable Long id) {
        return serv.updateContractStatus(id);
    }
    
}
