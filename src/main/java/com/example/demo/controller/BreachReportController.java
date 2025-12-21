package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BreachReport;
import com.example.demo.service.BreachReportService;

@RestController
public class BreachReportController {

    @Autowired
    BreachReportService service;

    @PostMapping("/api/reports/generate/{contractId}")
    public BreachReport generateReport(@PathVariable Long contractId) {
        return service.generateReport(contractId);
    }

    @GetMapping("/api/reports/{id}")
    public BreachReport getReport(@PathVariable Long id) {
        return service.getReportById(id);
    }

    @GetMapping("/api/reports/contract/{contractId}")
    public BreachReport getReportsForContract(@PathVariable Long contractId) {
        return service.getReportsForContract(contractId);
    }

    @GetMapping("/api/reports/")
    public List<BreachReport> getAllReports() {
        return service.getAllReports();
    }
    
}
