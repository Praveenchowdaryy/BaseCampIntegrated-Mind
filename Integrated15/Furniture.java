package com.mind.Integrated15;

public class Furniture {
	private String name;
	private String catagory;
	private double price;
	private double discount;

	public Furniture(String catagory, String name, double price) {
		this.name = name;
		this.catagory = catagory;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
}

