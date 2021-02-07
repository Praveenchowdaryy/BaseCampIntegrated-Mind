package com.mind.Integrated19;

import java.util.Scanner;

public class ZooApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Zoo[] details = {};
		int choice;
		do {
			System.out.println(
					"1.Create zoo details\n2.Update Zoo details\n3.Delete Zoo details\n4.Display options\n5.Exit\n\nEnter your choice : ");
			choice = intValidate();
			switch (choice) {
			case 1: {
				details = createZooDetails(details);
			}
				break;
			case 2: {
				updateZooDetails(details);
			}
				break;
			case 3: {
				deleteZooDetails(details);
			}
				break;
			case 4: {
				display(details);
			}
				break;
			case 5: {
				System.out.println("Thank you!");
			}
				break;
			default: {
				System.out.println("Invalid Input!");
			}
			}
		} while (choice != 4);

	}

	private static void display(Zoo[] details) {
		int choice;
		do {
			System.out.println(
					"1.Display all the zoo details\n2.Display zoo details sorted based on Id\n3.Display sorted zoo details based on location\n4.Exit\nEnter your choice :");
			choice = intValidate();
			switch (choice) {
			case 1: {
				displayZoo(details);
			}
				break;
			case 2: {
				sortedById(details);
			}
				break;
			case 3: {
				sortedByLocation(details);
			}
				break;
			case 4: {
				System.out.println("Thank you!");
			}
				break;
			default: {
				System.out.println("Invalid input !");
			}
			}

		} while (choice != 4);

	}

	private static void sortedByLocation(Zoo[] details) {
		Zoo[] sortedByLocation = insertionSortByLocation(details);
		Zoo[] sortedByName = insertionSortByName(sortedByLocation);
		displayZoo(sortedByName);

	}

	private static Zoo[] insertionSortByName(Zoo[] details) {
		for (int i = 1; i < details.length; i++) {
			Zoo key = details[i];
			int j = i - 1;
			while (j >= 0 && details[j].getName().compareToIgnoreCase(key.getName()) > 0) {
				details[j + 1] = details[j];
				j = j - 1;
			}
			details[j + 1] = key;
		}

		return details;
	}

	private static Zoo[] insertionSortByLocation(Zoo[] details) {
		for (int i = 1; i < details.length; i++) {
			Zoo key = details[i];
			int j = i - 1;
			while (j >= 0 && details[j].getLocation().compareToIgnoreCase(key.getLocation()) > 0) {
				details[j + 1] = details[j];
				j = j - 1;
			}
			details[j + 1] = key;
		}

		return details;
	}

	private static void sortedById(Zoo[] details) {
		Zoo[] sortedById = insertionSortById(details);
		displayZoo(sortedById);

	}

	private static Zoo[] insertionSortById(Zoo[] details) {
		for (int i = 1; i < details.length; i++) {
			Zoo key = details[i];
			int j = i - 1;
			while (j >= 0 && details[j].getId() > key.getId()) {
				details[j + 1] = details[j];
				j = j - 1;
			}
			details[j + 1] = key;
		}

		return details;
	}

	private static void displayZoo(Zoo[] details) {
		System.out.println("ID\t\tName\t\tLocation\t\tNumber of Cages");
		for (int i = 0; i < details.length; i++) {
			System.out.println(details[i].getId() + "\t\t" + details[i].getName() + "\t\t" + details[i].getLocation()
					+ "\t\t" + details[i].getNumberOfCages());
		}

	}

	private static void deleteZooDetails(Zoo[] details) {
		System.out.println("Enter Zoo Id : ");
		int id = intValidate();
		if (idCheckAndDelete(id, details)) {
			System.out.println("Details Deleted !");
		} else {
			System.out.println("Invalid ID !");
		}

	}

	private static boolean idCheckAndDelete(int id, Zoo[] details) {
		for (int i = 0; i < details.length; i++) {
			if (details[i].getId() == id) {
				details[i].setPresent(false);
				return true;
			}
		}
		return false;

	}

	private static void updateZooDetails(Zoo[] details) {
		System.out.println("Enter Zoo Id : ");
		int id = intValidate();
		System.out.println("Enter number of cages : ");
		int cages = intValidate();
		if (idCheck(id, cages, details)) {
			System.out.println("Details Updated !");
		} else {
			System.out.println("Invalid ID !");
		}

	}

	private static boolean idCheck(int id, int cages, Zoo[] details) {
		for (int i = 0; i < details.length; i++) {
			if (details[i].getId() == id) {
				details[i].setNumberOfCages(cages);
				return true;
			}
		}
		return false;

	}

	private static Zoo[] createZooDetails(Zoo[] details) {
		System.out.println("Enter the Zoo Id : ");
		int id = intValidate();
		System.out.println("Enter the Zoo Name : ");
		String name = sc.next();
		if (idCheck(id, details)) {
			System.out.println("Invalid ID !");
		} else {
			System.out.println("Enter the Zoo location : ");
			String location = sc.next();
			System.out.println("Enter number of cages : ");
			int cages = intValidate();
			boolean isPresent = true;
			details = addDetails(id, location, cages, isPresent, details, name);
		}
		return details;
	}

	private static Zoo[] addDetails(int id, String location, int cages, boolean isPresent, Zoo[] details, String name) {
		Zoo res[] = new Zoo[details.length + 1];
		for (int i = 0; i < details.length; i++) {
			res[i] = details[i];
		}
		res[details.length] = new Zoo(id, location, cages, isPresent, name);
		return res;
	}

	private static boolean idCheck(int id, Zoo[] details) {
		for (int i = 0; i < details.length; i++) {
			if (details[i].getId() == id) {
				return true;
			}
		}
		return false;
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

}

