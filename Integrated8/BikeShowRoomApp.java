package com.mind.Integrated8;


import java.util.Scanner;

public class BikeShowRoomApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BikeShowRoom[] bikes = {};
		int choice;
		do {
			System.out.println("1. Add a new bike\n" + "2. Display the bikes sorted by Make\n"
					+ "3. Display the bikes sorted by first Type and then Make\n"
					+ "4.Find the least and most expensive bikes in the store\n" + "5.Exit");
			System.out.println("Enter your choice : ");
			choice = intValidate();
			switch (choice) {
			case 1: {
				bikes = addBikes(bikes);
			}
				break;
			case 2: {
				sortedByMake(bikes);
			}
				break;
			case 3: {
				sortedByTypeAndMake(bikes);
			}
				break;
			case 4: {
				findLeastAndMostExpenciveBikes(bikes);
			}
				break;
			case 5: {
				System.out.println("Thank you !");
			}
				break;
			default: {
				System.out.println("Invalid Input!");
			}
			}
		} while (choice != 5);

	}

	private static void findLeastAndMostExpenciveBikes(BikeShowRoom[] bikes) {
		BikeShowRoom leastExpensiveBike = getLeastExpensiveBike(bikes);
		BikeShowRoom mostExpensiveBike = getMostExpensiveBike(bikes);
		System.out.println("Least Price Bike is : \n");
		display(leastExpensiveBike);
		System.out.println("\nMost Price Bike is : \n");
		display(mostExpensiveBike);
	}

	private static void display(BikeShowRoom leastExpensiveBike) {

		System.out.println("Make : " + leastExpensiveBike.getMake());
		System.out.println("Model : " + leastExpensiveBike.getModel());
		System.out.println("Type : " + leastExpensiveBike.getType());
		System.out.println("EngineCC : " + leastExpensiveBike.getEngineCC());
		System.out.println("Price : " + leastExpensiveBike.getPrice());
	}

	private static BikeShowRoom getMostExpensiveBike(BikeShowRoom[] bikes) {
		double mostPrice = bikes[0].getPrice();
		BikeShowRoom bike = bikes[0];
		for (int i = 0; i < bikes.length; i++) {
			if (mostPrice < bikes[i].getPrice()) {
				mostPrice = bikes[i].getPrice();
				bike = bikes[i];
			}
		}
		return bike;
	}

	private static BikeShowRoom getLeastExpensiveBike(BikeShowRoom[] bikes) {
		double leastPrice = bikes[0].getPrice();
		BikeShowRoom bike = bikes[0];
		for (int i = 0; i < bikes.length; i++) {
			if (leastPrice > bikes[i].getPrice()) {
				leastPrice = bikes[i].getPrice();
				bike = bikes[i];
			}
		}
		return bike;
	}

	private static void sortedByTypeAndMake(BikeShowRoom[] bikes) {
		BikeShowRoom[] sorted = insertionSortByType(bikes);
		sorted = sortByMake(sorted);
		System.out.println("Make\tModel\tType\t\tEngineCC\tPrice");
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].getMake() + "\t" + sorted[i].getModel() + "\t" + sorted[i].getType() + "\t\t"
					+ sorted[i].getEngineCC() + "\t" + sorted[i].getPrice());
		}
	}

	private static BikeShowRoom[] sortByMake(BikeShowRoom[] sorted) {
		int endIndex = 0;
		int startIndex = 0;
		sorted = setIndex(endIndex, startIndex, sorted);
		return sorted;
	}

	private static BikeShowRoom[] setIndex(int endIndex, int startIndex, BikeShowRoom[] sorted) {
		for (int i = startIndex; i < sorted.length; i++) {
			if (sorted[i].getType().compareToIgnoreCase(sorted[i].getType()) == 0 && i!=sorted.length-1) {
				endIndex++;
			} else {
				sorted = sortByMake(sorted, startIndex, endIndex);
				startIndex = endIndex;
				setIndex(endIndex, startIndex, sorted);
			}
		}
		return sorted;
	}

	private static BikeShowRoom[] sortByMake(BikeShowRoom[] sorted, int startIndex, int endIndex) {
		for (int i = startIndex + 1; i < endIndex; i++) {
			BikeShowRoom key = sorted[i];
			int j = i - 1;
			while (j >= 0 && sorted[j].getMake().compareToIgnoreCase(key.getMake()) > 0) {
				sorted[j + 1] = sorted[j];
				j = j - 1;
			}
			sorted[j + 1] = key;
		}
		return sorted;
	}

	private static BikeShowRoom[] insertionSortByType(BikeShowRoom[] bikes) {
		for (int i = 1; i < bikes.length; i++) {
			BikeShowRoom key = bikes[i];
			int j = i - 1;
			while (j >= 0 && bikes[j].getType().compareToIgnoreCase(key.getType()) > 0) {
				bikes[j + 1] = bikes[j];
				j = j - 1;
			}
			bikes[j + 1] = key;
		}
		return bikes;
	}

	private static void sortedByMake(BikeShowRoom[] bikes) {
		BikeShowRoom[] sorted = insertionSortByMake(bikes);
		System.out.println("Make\tModel\tType\t\tEngineCC\tPrice");
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].getModel() + "\t" + sorted[i].getType() + "\t\t" + sorted[i].getEngineCC()
					+ "\t" + sorted[i].getPrice());
		}

	}

	private static BikeShowRoom[] insertionSortByMake(BikeShowRoom[] bikes) {
		for (int i = 1; i < bikes.length; i++) {
			BikeShowRoom key = bikes[i];
			int j = i - 1;
			while (j >= 0 && bikes[j].getMake().compareToIgnoreCase(key.getMake()) > 0) {
				bikes[j + 1] = bikes[j];
				j = j - 1;
			}
			bikes[j + 1] = key;
		}
		return bikes;
	}

	private static BikeShowRoom[] addBikes(BikeShowRoom[] bikes) {
		System.out.println("Enter Bike Maker Name : ");
		String make = sc.next();
		System.out.println("Enter Bike Model");
		String model = sc.next();
		System.out.println("Enter Bike Type  (Standard, Street, Sport, Touring, Sport Touring, Cruiser)");
		String type = sc.next();
		type = typeValidate(type);
		System.out.println("Enter Bike EngineCC");
		int engineCC = intValidate();
		System.out.println("Enter Bike Price");
		double price = doubleValidate();
		bikes = addBike(make, model, type, engineCC, price, bikes);
		return bikes;
	}

	private static BikeShowRoom[] addBike(String make, String model, String type, int engineCC, double price,
			BikeShowRoom[] bikes) {
		BikeShowRoom res[] = new BikeShowRoom[bikes.length + 1];
		for (int i = 0; i < bikes.length; i++) {
			res[i] = bikes[i];
		}
		res[bikes.length] = new BikeShowRoom();
		res[bikes.length].setEngineCC(engineCC);
		res[bikes.length].setMake(make);
		res[bikes.length].setModel(model);
		res[bikes.length].setPrice(price);
		res[bikes.length].setType(type);
		return res;
	}

	private static String typeValidate(String type) {
		while (!(type.compareToIgnoreCase("Standard") == 0 || type.compareToIgnoreCase("Street") == 0
				|| type.compareToIgnoreCase("Sport") == 0 || type.compareToIgnoreCase("Touring") == 0
				|| type.compareToIgnoreCase("Sport Touring") == 0 || type.compareToIgnoreCase("Cruiser") == 0)) {
			System.out.println("Enter Bike Type  (Standard, Street, Sport, Touring, Sport Touring, Cruiser)");
			type = sc.next();
		}
		return type;
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
