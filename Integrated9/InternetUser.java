package com.mind.Integrated9;

public class InternetUser {
	private String name;
	private int userId;
	private String mobileNumber;
	private String Address;
	private String planName;

	public InternetUser(String name, int userId, String mobileNumber, String city, String planName) {
		this.name = name;
		this.userId = userId;
		this.mobileNumber = mobileNumber;
		this.Address = city;
		this.planName = planName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}
}

