package com.payment.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.payment.Model.Payment;
import com.payment.Repository.PaymentRepository;

public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepository repo;

	@Override
	public Payment addPayment(Payment pay) {
		return repo.insert(pay);
	}

	@Override
	public List<Payment> getAllpay() {
		return repo.findAll();
	}

}
