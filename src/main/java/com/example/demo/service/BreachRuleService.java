package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.BreachRule;

public interface BreachRuleService {
    public BreachRule createRule(BreachRule rule);
    public BreachRule updateRule(Long id , BreachRule rule);
    public List<BreachRule> getAllRules();
    public BreachRule getRuleById(Long Id);
    public BreachRule deactivateRule(Long id);
    // public BreachRule getActiveDefaultOrFirst();
}
