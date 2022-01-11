package com.payment.Model;

import org.springframework.data.annotation.Id;

public class Payment {
	
	@Id
	private String name;
	private int cvv;
	private long cardNo;
	
	
	public Payment(String name, int cvv, long cardNo) {
		super();
		this.name = name;
		this.cvv = cvv;
		this.cardNo = cardNo;
		
	}
	public Payment() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public long getCardNo() {
		return cardNo;
	}
	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	
	@Override
	public String toString() {
		return "Payment [name=" + name + ", cvv=" + cvv + ", cardNo=" + cardNo + "]";
	}

}
