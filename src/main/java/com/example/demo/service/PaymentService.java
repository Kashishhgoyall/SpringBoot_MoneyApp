package com.example.demo.service;

import com.example.demo.dao.PaymentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    @Qualifier("upi")
    private PaymentDAO paymentDAO;

    public void acceptPayment(String name, double amount) {

        if (name == null || name.isEmpty()) {
            throw new RuntimeException("Account holder name is required");
        }

        if (amount <= 0) {
            throw new RuntimeException("Amount must be greater than zero");
        }

        paymentDAO.acceptPayment(name, amount);
    }

    public double getBalance(String name) {
        return paymentDAO.getBalance(name);
    }
}
