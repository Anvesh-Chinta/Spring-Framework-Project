package com.jps.spring.core.service;

public class PaymentService {

	// Payment Service class has dependency on instance of type IPayment, that
	// dependency will be defined in the XML configuration.
	private IPayment payment;

	public void performPayment() {

		payment.executePayment();

	}

	public IPayment getPayment() {

		return payment;

	}

	public void setPayment(IPayment payment) {

		this.payment = payment;

	}

}
