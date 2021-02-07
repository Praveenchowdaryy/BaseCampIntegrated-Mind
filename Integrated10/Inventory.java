package com.mind.Integrated10;

public class Inventory {
	private int itemCode;
	private String itemName;
	private double price;
	private String catagory;
	private int quantity;

	public Inventory(int itemCode, String itemName, double itemPrice, String itemCategory, int quantity) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.price = itemPrice;
		this.catagory = itemCategory;
		this.quantity = quantity;
	}

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
