package com.example.demo.controller;

import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/acceptPayment")
    public String acceptPayment(
            @RequestParam String accountHolderName,
            @RequestParam double amountCredited,
            @RequestParam String modeOfPayment
    ) {
        paymentService.acceptPayment(accountHolderName, amountCredited);
        return "Payment successful via " + modeOfPayment;
    }

    @GetMapping("/getBalance")
    public double getBalance(
            @RequestParam String accountHolderName
    ) {
        return paymentService.getBalance(accountHolderName);
    }
}
