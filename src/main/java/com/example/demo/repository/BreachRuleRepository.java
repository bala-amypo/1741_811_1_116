package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BreachRule;

@Repository
public interface BreachRuleRepository extends JpaRepository<BreachRule, Long> {
    
    BreachRule findFirstByActiveTrue();

    java.util.Optional<BreachRule> findFirstByActiveTrueOrderByIsDefaultRuleDesc();
}
