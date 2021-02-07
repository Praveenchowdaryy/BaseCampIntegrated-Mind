package com.mind.Integrated17;

public class Car {
	private int carId;
	private String name;
	int[] slots = new int[3];
	private double price;

	public Car(int id, String name2, double price2, int[] slots2) {
		carId = id;
		name = name2;
		price = price2;
		slots = slots2;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getSlots() {
		return slots;
	}

	public void setSlots(int[] slots) {
		this.slots = slots;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
