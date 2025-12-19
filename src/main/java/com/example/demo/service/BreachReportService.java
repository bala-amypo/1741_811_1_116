package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.BreachReport;

public interface BreachReportService {
    public BreachReport generateReport(Long contractId);
    public BreachReport getReportById(Long id);
    public BreachReport getReportsForContract(Long contractId);
    public List<BreachReport> getAllReports();
}
