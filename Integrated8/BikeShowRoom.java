package com.mind.Integrated8;

public class BikeShowRoom {
	private String make;
	private String model;
	private String type;
	private int engineCC;
	private double price;

	public BikeShowRoom(String make, String model, String type, int engineCC, double price) {
		this.make = make;
		this.model = model;
		this.type = type;
		this.engineCC = engineCC;
		this.price = price;
	}

	public BikeShowRoom() {
		// TODO Auto-generated constructor stub
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getEngineCC() {
		return engineCC;
	}

	public void setEngineCC(int engineCC) {
		this.engineCC = engineCC;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}

