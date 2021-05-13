package com.jps.spring.core.service;

public class CashPayment implements IPayment {

	@Override
	public void executePayment() {
		
		System.out.println("Perform Cash Payment");
	}

}
