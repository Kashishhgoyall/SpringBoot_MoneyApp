package com.example.demo.dao;

import com.example.demo.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("upi")
public class UPIPaymentDAO implements PaymentDAO {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public void acceptPayment(String accountHolderName, double amount) {
        bankRepository.credit(accountHolderName, amount);
    }

    @Override
    public double getBalance(String accountHolderName) {
        return bankRepository.getBalance(accountHolderName);
    }
}
