package com.payment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.Model.Payment;
import com.payment.Model.PaymentList;
import com.payment.Repository.PaymentRepository;
import com.payment.Services.PaymentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentRepository repo;
	
//	@Autowired()
//	private PaymentService service;
	
	@PostMapping("/add")
	public Payment addPay(@RequestBody Payment pay) {
//		return this.service.addPayment(pay);
		return this.repo.insert(pay);
	}
	
	@GetMapping("/get")
	public PaymentList getPayment() {
		PaymentList list = new PaymentList();
//		list.setAlldept(this.service.getAllpay());
//		return list;
		list.setAllpay(this.repo.findAll());
		return list;
	}

}
