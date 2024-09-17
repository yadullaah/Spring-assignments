package com.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.entity.Payment;
import com.model.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepo.getAllPayments();
    }

    @Override
    public Payment getPayment(int paymentId) {
        return paymentRepo.getPayment(paymentId);
    }

    @Override
    public void addPayment(Payment payment) {
        paymentRepo.addPayment(payment);
    }
}
