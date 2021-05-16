package com.ektha.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ektha.springmvc.entity.Customer;
import com.ektha.springmvc.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/customer/{id}") // by default Requestmethod is GET
	public String getCustomer(@PathVariable int id, ModelMap customerModel) {
		Customer customer = customerService.getCustomer(id);
		customerModel.addAttribute("customer", customer);
		return "customer";
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String getCustomers(ModelMap customerModel) {
		List<Customer> customers = customerService.getCustomers();
		customerModel.addAttribute("customers", customers);
		return "customers";
	}

	@RequestMapping(value = "addCustomer")
	public String addPage() {
		return "add";
	}

	@RequestMapping(value = "/add/customer", method = RequestMethod.POST)
	public String addCustomer(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "expertise", required = true) String expertise, ModelMap customerModel) {
		Customer customer = new Customer();
		customer.setName(name);
		customer.setExpertise(expertise);
		customerService.addCustomer(customer);
		customerModel.addAttribute("msg", "Customer added successfully");
		List<Customer> customers = customerService.getCustomers();
		customerModel.addAttribute("customers", customers);
		return "customers";
	}

	@RequestMapping(value = "update/customer/{id}", method = RequestMethod.GET)
	public String updatePage(@PathVariable("id") int id, ModelMap customerModel) {
		customerModel.addAttribute("id", id);
		Customer customer = customerService.getCustomer(id);
		customerModel.addAttribute("customer", customer);
		return "update";
	}

	@RequestMapping(value = "/update/customer", method = RequestMethod.POST)
	public String updateCustomer(@RequestParam int id, @RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "expertise", required = true) String expertise, ModelMap customerModel) {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setName(name);
		customer.setExpertise(expertise);
		customerService.updateCustomer(customer);
		List<Customer> customers = customerService.getCustomers();
		customerModel.addAttribute("customers", customers);
		customerModel.addAttribute("id", id);
		customerModel.addAttribute("msg", "Customer updated successfully");
		return "customers";
	}

	@RequestMapping(value = "/delete/customer/{id}")
	public String deleteCustomer(@PathVariable int id, ModelMap customerModel) {
		customerService.deleteCustomer(id);
		List<Customer> customers = customerService.getCustomers();
		customerModel.addAttribute("customers", customers);
		customerModel.addAttribute("msg", "Customer delted successfully");
		return "customers";
	}
}
