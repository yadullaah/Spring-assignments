package com.model.repository;

import java.util.List;
import com.model.entity.Payment;

public interface PaymentRepository {

	List<Payment> getAllPayments();

	Payment getPayment(int paymentId);

	void addPayment(Payment payment);
}
