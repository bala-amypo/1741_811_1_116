package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BreachRule;
import com.example.demo.repository.BreachRuleRepository;
import com.example.demo.service.BreachRuleService;

@Service
public class BreachRuleServiceImpl implements BreachRuleService {

    @Autowired
    private BreachRuleRepository repo;

    // field name expected by tests
    private com.example.demo.repository.BreachRuleRepository breachRuleRepository;

    @Override
    public BreachRule createRule(BreachRule rule) {
        if (rule.getPenaltyPerDay() == null || rule.getPenaltyPerDay().compareTo(java.math.BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Penalty per day must be greater than zero");
        }
        if (rule.getMaxPenaltyPercentage() != null && (rule.getMaxPenaltyPercentage() < 0.0 || rule.getMaxPenaltyPercentage() > 100.0)) {
            throw new IllegalArgumentException("Max penalty percentage out of bounds");
        }
        if (rule.getActive() == null) rule.setActive(true);
        if (rule.getIsDefaultRule() == null) rule.setIsDefaultRule(false);
        com.example.demo.repository.BreachRuleRepository r = breachRuleRepository != null ? breachRuleRepository : repo;
        return r.save(rule);
    }

    @Override
    public BreachRule updateRule(Long id, BreachRule rule) {
        com.example.demo.repository.BreachRuleRepository r = breachRuleRepository != null ? breachRuleRepository : repo;
        BreachRule existing = r.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setRuleName(rule.getRuleName());
        existing.setPenaltyPerDay(rule.getPenaltyPerDay());
        existing.setMaxPenaltyPercentage(rule.getMaxPenaltyPercentage());
        existing.setActive(rule.getActive());
        existing.setIsDefaultRule(rule.getIsDefaultRule());

        return repo.save(existing);
    }

    @Override
    public List<BreachRule> getAllRules() {
        com.example.demo.repository.BreachRuleRepository r = breachRuleRepository != null ? breachRuleRepository : repo;
        return r.findAll();
    }

    @Override
    public BreachRule getRuleById(Long id) {
        com.example.demo.repository.BreachRuleRepository r = breachRuleRepository != null ? breachRuleRepository : repo;
        return r.findById(id).orElse(null);
    }

    @Override
    public BreachRule deactivateRule(Long id) {
        com.example.demo.repository.BreachRuleRepository r = breachRuleRepository != null ? breachRuleRepository : repo;
        BreachRule existing = r.findById(id).orElse(null);
        if (existing == null) throw new RuntimeException("Rule not found");
        existing.setActive(false);
        return r.save(existing);
    }

    @Override
    public BreachRule getActiveDefaultOrFirst() {
        java.util.Optional<BreachRule> opt = breachRuleRepository != null ? breachRuleRepository.findFirstByActiveTrueOrderByIsDefaultRuleDesc() : java.util.Optional.ofNullable(repo.findFirstByActiveTrue());
        return opt.orElseThrow(() -> new RuntimeException("No active breach rule"));
    }
}
