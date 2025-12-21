package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BreachRule;
import com.example.demo.service.BreachRuleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class BreachRuleController {
    @Autowired
    BreachRuleService serv;

    @PostMapping("/api/breach-rules")
    public BreachRule createRule(@RequestBody BreachRule entity) {
        return serv.createRule(entity);
    }
    
    @PutMapping("/api/breach-rules/{id}")
    public BreachRule updateRule(@PathVariable Long id, @RequestBody BreachRule entity) {
        return serv.updateRule(id, entity);
    }

    @GetMapping("/api/breach-rules/{id}")
    public BreachRule getRuleById(@PathVariable Long id) {
        return serv.getRuleById(id);
    }

    @GetMapping("/api/breach-rules/")
    public List<BreachRule> getAll() {
        return serv.getAllRules();
    }
    
    @PutMapping("/api/breach-rules/{id}/deactivate")
    public BreachRule deactivateRuleById(@PathVariable Long id) {
        return serv.deactivateRule(id);
    }
    
}
