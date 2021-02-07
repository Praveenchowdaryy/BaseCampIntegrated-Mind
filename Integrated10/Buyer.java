package com.mind.Integrated10;

public class Buyer {
	private int itemCode;
	private String name;
	private String birthDay;
	private String anniversary;
	private int quantity;
	private double totalPrice;

	public Buyer(int itemCode, String name, String birthDay, String anniversary, int quantity, double price) {
		this.name = name;
		this.itemCode = itemCode;
		this.birthDay = birthDay;
		this.anniversary = anniversary;
		this.quantity = quantity;
		this.totalPrice = price;
	}

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getAnniversary() {
		return anniversary;
	}

	public void setAnniversary(String anniversary) {
		this.anniversary = anniversary;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
