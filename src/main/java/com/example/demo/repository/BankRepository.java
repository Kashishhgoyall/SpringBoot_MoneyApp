package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BankRepository {

    private Map<String, Double> bank = new HashMap<>();

    public void credit(String name, double amount) {
        bank.put(name, bank.getOrDefault(name, 0.0) + amount);
    }

    public double getBalance(String name) {
        return bank.getOrDefault(name, 0.0);
    }
}
