package com.mind.Integrated12;

import java.util.Scanner;

public class InfantApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Infant[] infants = {};
		infants = addDetails(infants);
		displayinfantDetails(infants);

	}

	private static void displayinfantDetails(Infant[] infants) {
		for (int i = 0; i < infants.length; i++) {
			System.out.println(infants[i].getId() + "," + infants[i].getName() + "," + infants[i].getAge() + ","
					+ infants[i].getGender() + ",");
			int index = getVaccinationDetails(infants[i].getAge());
			System.out.println("InCompleted Vaccine : ");
			for (int j = index; j < infants[i].getVaccine().length; j++) {
				System.out.println(infants[i].getVaccine()[j]);
			}
			System.out.println("Completed Vaccine :");
			for (int j = 0; j < index; j++) {
				System.out.println(infants[i].getVaccine()[j]);
			}
		}
	}

	private static int getVaccinationDetails(int age) {
		int index = 0;
		if (age >= 0 && age <= 6) {
			index = 0;
		}
		if (age >= 7 && age <= 12) {
			index = 2;
		}
		if (age >= 12 && age <= 24) {
			index = 4;
		}
		return index;
	}

	private static Infant[] addDetails(Infant[] infants) {
		System.out.println("Enter id :");
		int id = intValidate();
		System.out.println("Enter age in months(0-24):");
		int age = intValidate();
		age = ageValidate(age);
		String name = "NULL";
		int weight = 0;
		String gender = "NULL";
		int choice;
		do {
			System.out.println("1.Enter Name\n2.Enter Weight\n3.gender\n4.none\n\nEnter your Choice:");
			choice = intValidate();

			switch (choice) {
			case 1: {
				name = sc.next();
			}
				break;
			case 2: {
				weight = sc.nextInt();
			}
				break;
			case 3: {
				gender = getGender();
			}
				break;
			case 4: {

			}
				break;
			default: {
				System.out.println("Invalid Input!");
			}
			}
		} while (choice != 4);
		infants = addDetail(id, age, name, weight, gender, infants);
		return infants;
	}

	private static Infant[] addDetail(int id, int age, String name, int weight, String gender, Infant[] infants) {
		Infant res[] = new Infant[infants.length + 1];
		for (int i = 0; i < infants.length; i++) {
			res[i] = infants[i];
		}
		res[infants.length] = new Infant(id, age, name, weight, gender);
		return res;
	}

	private static int ageValidate(int age) {
		while (!(age >= 0 && age <= 24)) {
			System.out.println("Enter age in months(0-24):");
			age = intValidate();
		}
		return age;
	}

	private static int intValidate() {

		int data = 0;
		boolean validation = false;
		while (validation == false) {
			if (sc.hasNextInt()) {
				data = sc.nextInt();
				validation = true;
			} else if (!sc.hasNextInt()) {
				System.out.println("you didn't type an integer value ! please type an integer");
				sc.next();
			}
		}
		return data;
	}

	private static String getGender() {
		System.out.println("1.Male\n2.Female\n3.TransGender\n\nSelect gender:");
		int option = intValidate();
		option = optionCheck(option);
		String gender = "";
		if (option == 1) {
			gender = "Male";
		}
		if (option == 2) {
			gender = "Female";
		}
		if (option == 3) {
			gender = "Trans Gender";
		}
		return gender;
	}

	private static int optionCheck(int option) {
		while (!(option > 0 && option < 4)) {
			System.out.println("1.Male\n2.Female\n3.TransGender\n\nSelect gender:");
			option = intValidate();
		}
		return option;
	}
}

