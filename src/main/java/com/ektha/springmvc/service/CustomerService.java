package com.ektha.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ektha.springmvc.dao.CustomerDao;
import com.ektha.springmvc.entity.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;
	public Customer getCustomer(final int id) {
		return customerDao.getCustomer(id);
	}
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}
	public void addCustomer(final Customer customer) {
		customerDao.addCustomer(customer);
	}
	public void updateCustomer(final Customer customer) {
		customerDao.updateCustomer(customer);
	}
	public void deleteCustomer(final int id) {
		customerDao.deleteCustomer(id);
	}
}
