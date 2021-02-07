package com.mind.Integrated4;

import java.util.Scanner;

public class SuperMarketApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("To Load the products, Enter number of products you want to load : \n");
		int size = intValidate();
		size = checkIfPositive(size);
		SuperMarket[] products = new SuperMarket[size];
		for (int i = 0; i < products.length; i++) {
			products[i] = new SuperMarket();
			System.out.println("Enter the product ID " + (i + 1) + " : ");
			int productId = intValidate();
			productId = checkIfPositive(productId);
			products[i].setProductId(productId);
			System.out.println("Enter the price of the product " + (i + 1) + " : ");
			double price = doubleValidate();
			price = checkIfPositive(price);
			products[i].setPrice(price);
			System.out.println("Enter the total quantity of the product " + (i + 1) + " : ");
			int quantity = intValidate();
			quantity = checkIfPositive(quantity);
			products[i].setProductQuantity(quantity);
			System.out.println("Enter the discount to the product " + (i + 1) + " : ");
			double discount = doubleValidate();
			discount = checkIfPositive(discount);
			products[i].setDiscount(discount);
			products[i].setItemSaleCount(0);

		}
		int choice;
		double price = 0;
		double discount = 0;
		int productId = 0;
		int productQuantity = 0;
		do {
			System.out.println(
					"1.Add items to a bill\n2. Calculate offer discount on an item ( if any )\n3.  Calculate the total bill\n4. Find the most sold items\n5. Find the most valued customer\n6.Exit");
			System.out.println("Enter the Choice :");
			choice = intValidate();
			if (choice > 1 && choice < 4) {
				System.out.println("You need to give raw information to go for advanced steps!");
				choice = 1;
			}
			int customerId;
			switch (choice) {
			case 1: {
				System.out.println("Enter the customer ID : ");
				customerId = intValidate();
				boolean buyMore = true;
				while (buyMore) {
					System.out.println("Available products and there quantites are : \n");
					displayProducts(products);

					System.out.println("Enter the productId you want to buy:");
					productId = intValidate();
					if (productIdPresent(productId, products)) {
						System.out.println("Enter the product quantity of productId you want to buy:");
						productQuantity = intValidate();
						if (productQuantyPresent(productQuantity, products, productId)) {
							System.out.println("Enter customer Mobile number :");
							String phoneNumber = sc.nextLine();
							phoneNumber = phoneValidate(phoneNumber);
							products = addItemsToCart(customerId, productId, productQuantity, products, phoneNumber);
							price += getprice(productId, productQuantity, products);
							System.out.println("Total price of customer" + customerId + " = " + price);
						} else {
							System.out.println("Product quantity unavailable!");
						}
					} else {
						System.out.println("Product unavailable!");
					}
					System.out.println("Do you want to buy more (True/False):");
					buyMore = sc.nextBoolean();
				}

			}

			case 2: {

				discount = calculateOfferDiscount(productId, products);
				System.out.println("The discount on this item is " + discount + "%");

			}

			case 3: {
				double totalBill = calculateTotalBill(productId, productQuantity, products);
				System.out.println("Total bill is :" + totalBill);
			}
				break;
			case 4: {
				int maximumSoldItem = findMostSoldItems(products);
				System.out.println("The maximum sold item is : " + maximumSoldItem);
			}
				break;
			case 5: {
				int mostValuedCustomer = findMostValuedCustomer(products);
				System.out.println("Most valued customer is : " + mostValuedCustomer);
			}
				break;
			case 6: {

				System.out.println("Thank you");
			}
				break;
			default: {
				System.out.println("Invalid input !");
			}

			}
		} while (choice != 6);

	}

	private static int findMostValuedCustomer(SuperMarket[] products) {
		double maxPurchase = 0;
		int mostValuedCustomer = 0;
		for (int i = 0; i < products.length; i++) {
			if (products[i].getTotalBill() > maxPurchase) {
				maxPurchase = products[i].getTotalBill();
				mostValuedCustomer = products[i].getCustomerId();
			}
		}
		return mostValuedCustomer;
	}

	private static int findMostSoldItems(SuperMarket[] products) {
		int max = 0;
		int productId = 0;
		for (int i = 0; i < products.length; i++) {
			if (products[i].getItemSaleCount() > max) {
				max = products[i].getItemSaleCount();
				productId = products[i].getProductId();
			}
		}
		return productId;
	}

	private static double calculateOfferDiscount(int productId, SuperMarket[] products) {
		double discount = 0;
		for (int i = 0; i < products.length; i++) {
			if (productId == products[i].getProductId()) {
				discount = products[i].getDiscount();
			}
		}
		return discount;
	}

	private static double getprice(int productId, int productQuantity, SuperMarket[] products) {
		double price = 0;
		for (int i = 0; i < products.length; i++) {
			if (products[i].getProductId() == productId) {
				price = productQuantity * products[i].getPrice();
			}
		}
		return price;
	}

	private static String phoneValidate(String data) {

		while (!data.matches("[0-9]+")) {
			if (!data.isEmpty()) {
				System.out.println("Please retype the alphabetical string");
			}
			data = sc.nextLine();
		}
		return data;
	}

	private static double calculateTotalBill(int productId, int productQuantity, SuperMarket[] products) {
		double totalBill = 0;
		for (int i = 0; i < products.length; i++) {
			if (products[i].getProductId() == productId) {
				double discount = products[i].getDiscount();
				double price = productQuantity * products[i].getPrice();
				totalBill = price - (discount * 100) / price;
				products[i].setTotalBill(totalBill);
			}
		}
		return totalBill;
	}

	private static SuperMarket[] addItemsToCart(int customerId, int productId, int productQuantity,
			SuperMarket[] products, String phoneNumber) {
		for (int i = 0; i < products.length; i++) {
			if (products[i].getProductId() == productId) {
				products[i].setProductQuantity(products[i].getProductQuantity() - productQuantity);
				products[i].setCustomerId(customerId);
				products[i].setCustomerPhoneNumber(phoneNumber);
				products[i].setItemSaleCount(products[i].getItemSaleCount() + productQuantity);
			}
		}
		return products;
	}

	private static boolean productQuantyPresent(int productQuantity, SuperMarket[] products, int productId) {
		for (int i = 0; i < products.length; i++) {
			if (productId == products[i].getProductId()) {
				if (productQuantity <= products[i].getProductQuantity()) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean productIdPresent(int productId, SuperMarket[] products) {
		for (int i = 0; i < products.length; i++) {
			if (productId == products[i].getProductId()) {
				return true;
			}
		}
		return false;
	}

	private static void displayProducts(SuperMarket[] products) {
		System.out.println("Product ID\tProduct Quantity");
		for (int i = 0; i < products.length; i++) {
			System.out.println(products[i].getProductId() + "\t\t" + products[i].getProductQuantity());
		}

	}

	private static double checkIfPositive(double data) {
		while (data < 0) {
			System.out.println("you didn't type a valid input : ");
			data = sc.nextDouble();
		}
		return data;

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

	private static int checkIfPositive(int integer) {
		while (integer < 0) {
			System.out.println("you didn't type an integer value ! please type an integer");
			integer = sc.nextInt();
		}
		return integer;
	}

}

