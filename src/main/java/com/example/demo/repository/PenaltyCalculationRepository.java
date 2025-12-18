package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PenaltyCalculation;

public interface PenaltyCalculationRepository extends JpaRepository<PenaltyCalculation , Long>{

}
