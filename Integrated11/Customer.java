package com.mind.Integrated11;

public class Customer {
	private int customerId;
	private String name;
	private String gender;
	private String serviceType;
	private double price;
	private int minutes;

	public Customer(int customerId, String name, String gender, String serviceOpted, int minutes, double price) {
		this.customerId = customerId;
		this.name = name;
		this.gender = gender;
		this.serviceType = serviceOpted;
		this.minutes = minutes;
		this.price = price;

	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
