package com.payment.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.payment.Model.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {

}
