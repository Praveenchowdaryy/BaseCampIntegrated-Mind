package com.mind.Integrated2;

public class Museum {
	private String name;
	private int age;
	private String gender;
	private int entryFee;

	public Museum(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public Museum() {
		// TODO Auto-generated constructor stub
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

	public int getEntryFee() {
		return entryFee;
	}

	public void setEntryFee(int entryFee) {
		this.entryFee = entryFee;
	}
}

