package com.mind.Integrated15;


import java.util.Scanner;

public class FurnitureApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Furniture furnitures[] = {};
		int choice;
		do {
			System.out.println(
					"1.Add Furniture\n2.View by catagory\n3.Sort by price\n4.apply discount during sale times\n5.Exit\n\nEnter your choice : ");
			choice = intValidate();
			switch (choice) {
			case 1: {
				furnitures = addFurnitures(furnitures);
			}
				break;
			case 2: {
				viewBasedOnCategory(furnitures);
			}
				break;
			case 3: {
				sortBasedOnPrice(furnitures);
			}
				break;
			case 4: {
				saleItem(furnitures);
			}
				break;
			case 5: {
				System.out.println("Thank you!");
			}
				break;
			default: {
				System.out.println("Invalid Input !");
			}
			}
		} while (choice != 5);
	}

	private static void saleItem(Furniture[] furnitures) {
		display(furnitures);
		System.out.println("Enter the name of the product : ");
		String name = sc.next();
		double totalBill = sellTheProduct(name, furnitures);
		if (totalBill > 0) {
			System.out.println("Your bill is : " + totalBill);
		} else {
			System.out.println("Product not found !");
		}

	}

	private static double sellTheProduct(String name, Furniture[] furnitures) {
		double price = 0;
		for (int i = 0; i < furnitures.length; i++) {
			if (furnitures[i].getName().compareToIgnoreCase(name) == 0) {
				System.out.println("Enter the discount to the product : ");
				double discount = doubleValidate();
				price = furnitures[i].getPrice() - ((discount * 100) / furnitures[i].getPrice());
				furnitures[i].setDiscount(discount);
				break;
			}
		}
		return price;
	}

	private static void sortBasedOnPrice(Furniture[] furnitures) {
		Furniture[] sorted = insertionSortBasedOnPrice(furnitures);
		display(sorted);

	}

	private static Furniture[] insertionSortBasedOnPrice(Furniture[] furnitures) {
		for (int i = 1; i < furnitures.length; i++) {
			Furniture key = furnitures[i];
			int j = i - 1;
			while (j >= 0 && furnitures[j].getPrice() > key.getPrice()) {
				furnitures[j + 1] = furnitures[j];
				j = j - 1;
			}
			furnitures[j + 1] = key;
		}
		return furnitures;
	}

	private static void viewBasedOnCategory(Furniture[] furnitures) {
		display(furnitures);
		System.out.println("Enter the Catagory name : ");
		String name = sc.next();
		displayBasedOnCategory(name, furnitures);

	}

	private static void displayBasedOnCategory(String name, Furniture[] furnitures) {
		System.out.println("Catagory\t\tName\t\tPrice");
		for (int i = 0; i < furnitures.length; i++) {
			if (furnitures[i].getCatagory().compareToIgnoreCase(name) == 0) {
				System.out.println(furnitures[i].getCatagory() + "\t\t" + furnitures[i].getName() + "\t\t"
						+ furnitures[i].getPrice());
			}
		}

	}

	private static void display(Furniture[] furnitures) {
		System.out.println("Catagory\t\tName\t\tPrice");
		for (int i = 0; i < furnitures.length; i++) {
			System.out.println(
					furnitures[i].getCatagory() + "\t\t" + furnitures[i].getName() + "\t\t" + furnitures[i].getPrice());
		}

	}

	private static Furniture[] addFurnitures(Furniture[] furnitures) {
		System.out.println("Enter furniture catagory : ");
		String catagory = sc.next();
		System.out.println("Enter furniture name : ");
		String name = sc.next();
		System.out.println("Enter furniture price : ");
		double price = doubleValidate();
		furnitures = addfurniture(catagory, name, price, furnitures);
		return furnitures;
	}

	private static Furniture[] addfurniture(String catagory, String name, double price, Furniture[] furnitures) {
		Furniture res[] = new Furniture[furnitures.length + 1];
		for (int i = 0; i < furnitures.length; i++) {
			res[i] = furnitures[i];
		}
		res[furnitures.length] = new Furniture(catagory, name, price);
		return res;
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
