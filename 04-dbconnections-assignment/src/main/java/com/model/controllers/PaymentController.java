package com.model.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.model.entity.Payment;
import com.model.service.PaymentService;

@RestController
@RequestMapping("/app")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }
    
    @GetMapping("/payments/{paymentId}")
    public ResponseEntity<Payment> getPayment(@PathVariable int paymentId) {
        return ResponseEntity.ok(paymentService.getPayment(paymentId));
    }
    
    @PostMapping("/payments")
    public String addPayment(@RequestBody Payment payment) {
        paymentService.addPayment(payment);
        return "Payment added successfully";
    }
}
