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

    @Override
    public BreachRule createRule(BreachRule rule) {
        if (rule.getActive() == null) {
            rule.setActive(true);
        }
        if (rule.getIsDefaultRule() == null) {
            rule.setIsDefaultRule(false);
        }
        return repo.save(rule);
    }

    @Override
    public BreachRule updateRule(Long id, BreachRule rule) {
        BreachRule existing = repo.findById(id).orElse(null);
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
        return repo.findAll();
    }

    @Override
    public BreachRule getRuleById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public BreachRule deactivateRule(Long id) {
        BreachRule existing = repo.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setActive(false);
        return repo.save(existing);
    }
}
