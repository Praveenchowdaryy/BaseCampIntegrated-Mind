package com.mind.Integrated7;

public class Subscribers {
	private String name;
	private int age;
	private String mobileNumber;
	private String address;
	private int subscriberID;
	private boolean typeBoth;
	private String newsPaperName;
	private String magazineName;
	

	public Subscribers(String name, int age, String mobileNumber, String address, String newsPaper,
			String magazine, boolean both, int subscriberId) {
		this.name=name;
		this.age=age;
		this.mobileNumber=mobileNumber;
		this.address=address;
		this.newsPaperName=newsPaper;
		this.magazineName=magazine;
		this.typeBoth=both;
		this.subscriberID=subscriberId;
	}

	public String getNewsPaperName() {
		return newsPaperName;
	}

	public void setNewsPaperName(String newsPaperName) {
		this.newsPaperName = newsPaperName;
	}

	public String getMagazineName() {
		return magazineName;
	}

	public void setMagazineName(String magazineName) {
		this.magazineName = magazineName;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSubscriberID() {
		return subscriberID;
	}

	public void setSubscriberID(int subscriberID) {
		this.subscriberID = subscriberID;
	}

	public boolean isTypeBoth() {
		return typeBoth;
	}

	public void setTypeBoth(boolean typeBoth) {
		this.typeBoth = typeBoth;
	}
}

