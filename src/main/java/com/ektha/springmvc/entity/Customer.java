package com.ektha.springmvc.entity;

public class Customer {

	private int id;
	private String name;
	private String expertise;

	public Customer() {
	}

	public Customer(int id, String name, String expertise) {
		super();
		this.id = id;
		this.name = name;
		this.expertise = expertise;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", expertise=" + expertise + "]";
	}

}
