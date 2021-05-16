package com.ektha.springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ektha.springmvc.entity.Customer;
import com.ektha.springmvc.mapper.CustomerRowMapper;

@Repository
@Transactional
public class CustomerDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Customer getCustomer(final int id) {
		Customer customer = jdbcTemplate.queryForObject("select * from ektha.customer where id = ?", new Object[] { id },
				new CustomerRowMapper());
		return customer;
	}

	public List<Customer> getCustomers() {
		List<Customer> customers = jdbcTemplate.query("select * from ektha.customer", new CustomerRowMapper());
		return customers;
	}

	public void addCustomer(final Customer customer) {
		jdbcTemplate.update("insert into ektha.customer(name, expertise) values(?, ?)",
				new Object[] { customer.getName(), customer.getExpertise() });
	}

	public void updateCustomer(final Customer customer) {
		jdbcTemplate.update("update ektha.customer set name = ?, expertise = ? where id = ?",
				new Object[] { customer.getName(), customer.getExpertise(), customer.getId() });
	}

	public void deleteCustomer(final int id) {
		jdbcTemplate.update("delete from ektha.customer where id = ?", new Object[] { id });
	}

}
