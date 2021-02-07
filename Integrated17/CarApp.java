package com.mind.Integrated17;

import java.util.Scanner;

public class CarApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Car[] details = {};
		int choice;
		do {
			System.out.println(
					"1.Add car\n2.Book a Test drive\n3.Find available time slot based on car id\n4.Display options\n5.Exit\nEnter your choice : ");
			choice = intValidate();
			switch (choice) {
			case 1: {
				details = addCars(details);
			}
				break;
			case 2: {
				BookTestDrive(details);
			}
				break;
			case 3: {
				findAvailableSlots(details);
			}
				break;
			case 4: {
				display(details);
			}
				break;
			case 5: {
				System.out.println("Thank you !");
			}
				break;
			default: {
				System.out.println("Invalid option !");
			}
			}
		} while (choice != 5);

	}

	private static void display(Car[] details) {
		int choice;
		do {
			System.out.println(
					"1.Add car\n2.Book a Test drive\n3.Find available time slot based on car id\n4.Display options\n5.Exit\nEnter your choice : ");
			choice = intValidate();
			switch (choice) {
			case 1: {
				displayBySortedPrice(details);
			}
				break;
			case 2: {
				displayByPriceRange(details);
			}
				break;
			case 3: {
				displayCars(details);
			}
				break;

			case 4: {
				System.out.println("Thank you !");
			}
				break;
			default: {
				System.out.println("Invalid option !");
			}
			}
		} while (choice != 5);
	}

	private static void displayByPriceRange(Car[] details) {
		System.out.println("Enter lower bound : ");
		double fromPrice = doubleValidate();
		System.out.println("Enter upper bound : ");
		double toPrice = doubleValidate();
		while (fromPrice >= toPrice) {
			System.out.println("Enter valid input : ");
			System.out.println("Enter lower bound : ");
			fromPrice = doubleValidate();
			System.out.println("Enter upper bound : ");
			toPrice = doubleValidate();
		}
		displayCars(fromPrice, toPrice, details);

	}

	private static void displayCars(double fromPrice, double toPrice, Car[] details) {
		System.out.println("Id\t\tName\t\tPrice");
		for (int i = 0; i < details.length; i++) {
			if (details[i].getPrice() >= fromPrice && details[i].getPrice() >= toPrice) {
				display(details[i]);
			}
		}

	}

	private static void display(Car car) {
		System.out.println(car.getCarId() + "\t\t" + car.getName() + "\t\t" + car.getPrice());

	}

	private static void displayBySortedPrice(Car[] details) {
		Car[] sortedByPrice = insertionSort(details);
		displayCars(sortedByPrice);
	}

	private static Car[] insertionSort(Car[] details) {
		for (int i = 1; i < details.length; i++) {
			Car key = details[i];
			int j = i - 1;
			while (j >= 0 && details[j].getPrice() > key.getPrice()) {
				details[j + 1] = details[j];
				j = j - 1;
			}
			details[j + 1] = key;
		}

		return details;
	}

	private static void displayCars(Car[] details) {
		System.out.println("Id\t\tName\t\tPrice");
		for (int i = 0; i < details.length; i++) {
			System.out.println(details[i].getCarId() + "\t\t" + details[i].getName() + details[i].getPrice());
		}

	}

	private static void findAvailableSlots(Car[] details) {
		System.out.println("Enter the car id : ");
		int id = intValidate();
		if (available(id, details)) {
			System.out.println("Slots Available");
		} else {
			System.out.println("Car id not found ");
		}
	}

	private static boolean available(int id, Car[] details) {
		boolean present = false;
		for (int i = 0; i < details.length; i++) {
			if (details[i].getCarId() == id) {
				for (int j = 0; i < details[i].getSlots().length; j++) {
					System.out.print(details[i].getSlots()[j]);
					present = true;
				}
			}
		}
		return present;
	}

	private static void BookTestDrive(Car[] details) {
		System.out.println("Enter the car id : ");
		int id = intValidate();
		System.out.println("Enter the slot to book ex(12,23)");
		int slot = intValidate();
		slot = slotValidate(slot);
		if (booked(id, slot, details)) {
			System.out.println("Slot Booked ");
		} else {
			System.out.println("Car id not found ");
		}

	}

	private static boolean booked(int id, int slot, Car[] details) {
		for (int i = 0; i < details.length; i++) {
			if (details[i].getCarId() == id) {
				for (int j = 0; i < details[i].getSlots().length; j++) {
					if (slot == details[i].getSlots()[j]) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static int slotValidate(int slot) {
		while (!(slot > 0 && slot < 25)) {
			System.out.println("Enter the slot to book ex(12,23)");
			slot = intValidate();
		}
		return slot;
	}

	private static Car[] addCars(Car[] details) {
		System.out.println("Enter car : ");
		int id = intValidate();
		System.out.println("Enter car : ");
		String name = sc.next();
		System.out.println("Enter car : ");
		double price = doubleValidate();
		int[] slots = getSlots();
		details = addDetails(id, name, price, slots, details);
		return details;
	}

	private static Car[] addDetails(int id, String name, double price, int[] slots, Car[] details) {
		Car res[] = new Car[details.length + 1];
		for (int i = 0; i < details.length; i++) {
			res[i] = details[i];
		}
		res[details.length] = new Car(id, name, price, slots);
		return res;
	}

	private static int[] getSlots() {
		int[] slots = new int[3];
		System.out.println("Enter Student Marks: ");
		for (int i = 0; i < slots.length; i++) {
			System.out.println("Enter slot " + (i + 1) + " : ");
			slots[i] = sc.nextInt();
			slots[i] = slotValidate(slots[i]);
		}
		return slots;
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

	private static double doubleValidate() {

		double data = 0;
		boolean validation = false;
		while (validation == false) {
			if (sc.hasNextDouble()) {
				data = sc.nextDouble();
				validation = true;
			} else if (!sc.hasNextDouble()) {
				System.out.println("you didn't type an integer value ! please type an integer");
				sc.next();
			}
		}
		return data;
	}

}

