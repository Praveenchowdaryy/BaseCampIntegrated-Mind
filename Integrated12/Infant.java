package com.mind.Integrated12;

public class Infant {
	private int id;
	private int age;
	private String name;
	private String gender;
	private int weight;
	private String[] vaccine = { "vac1", "vac2", "vac3", "vac4", "vac5", "vac6" };

	public Infant(int id, int age, String name, int weight, String gender) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.weight = weight;
		this.gender = gender;
	}

	public String[] getVaccine() {
		return vaccine;
	}

	public void setVaccine(String[] vaccine) {
		this.vaccine = vaccine;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
