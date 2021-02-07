package com.mind.Integrated9;

public class InternetProvider {
	private String planName;
	private double internetSpeed;
	private double monthlyLimit;
	private double price;

	public InternetProvider(String name, double speed, double limit, double price) {
		this.planName = name;
		this.internetSpeed = speed;
		this.monthlyLimit = limit;
		this.price = price;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public double getInternetSpeed() {
		return internetSpeed;
	}

	public void setInternetSpeed(double internetSpeed) {
		this.internetSpeed = internetSpeed;
	}

	public double getMonthlyLimit() {
		return monthlyLimit;
	}

	public void setMonthlyLimit(double monthlyLimit) {
		this.monthlyLimit = monthlyLimit;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}

