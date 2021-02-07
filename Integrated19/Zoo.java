package com.mind.Integrated19;

public class Zoo {
	private int id = 0;
	private int numberOfCages = 1;
	private String location;
	private boolean isPresent;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Zoo(int id, String location, int cages, boolean isPresent, String name) {
		this.id = id;
		this.location = location;
		this.numberOfCages = cages;
		this.isPresent = isPresent;
		this.name = name;
	}

	public boolean isPresent() {
		return isPresent;
	}

	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberOfCages() {
		return numberOfCages;
	}

	public void setNumberOfCages(int numberOfCages) {
		this.numberOfCages = numberOfCages;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
