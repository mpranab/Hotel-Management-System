package com.payment.Services;

import java.util.List;

import com.payment.Model.Payment;

public interface PaymentService {
	
	Payment addPayment(Payment pay);
	List<Payment>getAllpay();
	
}
