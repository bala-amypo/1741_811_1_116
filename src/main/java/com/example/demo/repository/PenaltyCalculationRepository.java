package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PenaltyCalculation;
import org.springframework.stereotype.Repository;

@Repository
public interface PenaltyCalculationRepository extends JpaRepository<PenaltyCalculation , Long>{

    List<PenaltyCalculation> findByContractId(Long contractId);

}
