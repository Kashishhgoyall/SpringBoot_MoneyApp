package com.example.demo.dao;

public interface PaymentDAO {

    void acceptPayment(String accountHolderName, double amount);

    double getBalance(String accountHolderName);
}
