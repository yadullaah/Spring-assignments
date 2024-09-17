package com.model.service;

import java.util.List;
import com.model.entity.Payment;

public interface PaymentService {
    
    List<Payment> getAllPayments();
    
    Payment getPayment(int paymentId);
    
    void addPayment(Payment payment);
}
