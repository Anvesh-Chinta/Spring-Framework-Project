package com.jps.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jps.spring.core.service.PaymentService;

public class App {
  
	public static void main(String[] args) {
    
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appcontext.xml");
		PaymentService paymentService = context.getBean("payServiceBean", PaymentService.class);
		paymentService.performPayment();
		context.close();

  }
	
}
