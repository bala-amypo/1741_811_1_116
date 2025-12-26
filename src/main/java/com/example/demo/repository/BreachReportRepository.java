package com.example.demo.repository;

import com.example.demo.entity.BreachReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreachReportRepository extends JpaRepository<BreachReport , Long>{
	java.util.List<BreachReport> findByContractId(Long contractId);

	java.util.Optional<BreachReport> findTopByContractIdOrderByReportGeneratedAtDesc(Long contractId);
}
