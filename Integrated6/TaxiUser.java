package com.mind.Integrated6;

public class TaxiUser {
	private String name;
	private int age;
	private String gender;
	private String mobileNumber;
	private double distance;

	public TaxiUser(String name, int age, String gender, String mobileNumber, double distance) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.distance = distance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

}

