package com.mind.Integrated10;


import java.util.Scanner;

public class GiftShopApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Inventory[] products = {};
		Buyer[] buyers = {};
		int choice;
		do {
			System.out.println("1. Add a new gift item to the inventory\n" + "2.Bill an item\n"
					+ "3.display the name and special day of the buyers whose birthday or\r\n"
					+ "anniversary is falling in next month\n" + "4.Exit\n\nEnter Your Choice : ");
			choice = intValidate();
			switch (choice) {
			case 1: {
				products = addItems(products);
			}
				break;
			case 2: {
				buyers = billItem(buyers, products);
			}
				break;
			case 3: {
				displayNameAndSpecialDay(buyers);
			}
				break;
			case 4: {
				System.out.println("Thank You !");
			}
				break;
			default: {
				System.out.println("Invalid Input !");
			}
			}
		} while (choice != 4);

	}

	private static void displayNameAndSpecialDay(Buyer[] buyers) {
		int currentMonth = intValidate();
		currentMonth = monthValidate(currentMonth);
		for (int i = 0; i < buyers.length; i++) {
			String date = "";
			int count = 0;
			if (buyers[i].getBirthDay() != null) {
				date = buyers[i].getBirthDay();
				count = 2;
			}
			if (buyers[i].getAnniversary() != null) {
				date = buyers[i].getAnniversary();
				count = 1;
			}
			int month = getMonth(date);
			System.out.println("Enter the current month value :");
			System.out.println("Name\t\tEvent");
			if (month == currentMonth + 1) {
				if (count == 2) {
					System.out.println(buyers[i].getName() + "\t\tBirth Day");
				}
				if (count == 1) {
					System.out.println(buyers[i].getName() + "\t\tMarriage Anniversary");
				}
			}
		}

	}

	private static int monthValidate(int currentMonth) {
		while (!(currentMonth > 0 && currentMonth < 13)) {
			System.out.println("Enter the valid current month value :");
			currentMonth = intValidate();
		}
		return currentMonth;
	}

	private static int getMonth(String date) {
		String month = "";
		month += date.charAt(5);
		month += date.charAt(6);
		int intMonth = ConvertToInteger(month);
		return intMonth;
	}

	private static Buyer[] billItem(Buyer[] buyers, Inventory[] products) {
		display(products);
		System.out.println("Enter The item code : ");
		int itemCode = intValidate();
		if (itemCodeFound(itemCode, products)) {
			System.out.println("Enter Buyer Name : ");
			String name = sc.next();
			System.out.println("Gift fo:\n1.Birthday\n2.Marriage Aniversary\nEnter your choice :");
			int option = intValidate();
			option = optionCheck(option);
			String birthDay = null;
			String anniversary = null;
			double price = 0;
			if (option == 1) {
				System.out.println("Enter your Birth day(yyyy-mm-dd)");
				birthDay = sc.next();
				birthDay = dateValidate(birthDay);
			} else {
				System.out.println("Enter your Birth day(yyyy-mm-dd)");
				anniversary = sc.next();
				anniversary = dateValidate(anniversary);
			}
			System.out.println("Enter the Quantity you want to buy :");
			int quantity = intValidate();
			boolean quantityAvailable = checkQuantity(itemCode, quantity, products);
			if (quantityAvailable) {
				price = getPrice(itemCode, products);
				System.out.println("your total bill = " + (price * quantity));
				buyers = addbuyer(itemCode, name, birthDay, anniversary, quantity, price, buyers);
			} else {
				System.out.println("Quantity Unavailable !");
			}
		} else {
			System.out.println("Item not found !");
		}
		return buyers;
	}

	private static Buyer[] addbuyer(int itemCode, String name, String birthDay, String anniversary, int quantity,
			double price, Buyer[] buyers) {
		Buyer res[] = new Buyer[buyers.length + 1];
		for (int i = 0; i < buyers.length; i++) {
			res[i] = buyers[i];
		}
		res[buyers.length] = new Buyer(itemCode, name, birthDay, anniversary, quantity, price);
		return res;
	}

	private static double getPrice(int itemCode, Inventory[] products) {
		double price = 0;
		for (int i = 0; i < products.length; i++) {
			if (products[i].getItemCode() == itemCode) {
				price = products[i].getPrice();
			}
		}
		return price;
	}

	private static boolean checkQuantity(int itemCode, int quantity, Inventory[] products) {
		for (int i = 0; i < products.length; i++) {
			if (products[i].getItemCode() == itemCode && products[i].getQuantity() >= quantity) {
				products[i].setQuantity(products[i].getQuantity() - quantity);
				return true;
			}
		}
		return false;
	}

	private static boolean itemCodeFound(int itemCode, Inventory[] products) {
		for (int i = 0; i < products.length; i++) {
			if (products[i].getItemCode() == itemCode) {
				return true;
			}
		}
		return false;
	}

	private static void display(Inventory[] products) {
		System.out.println("Product Id\t\tItem Name\t\tQuantity");
		for (int i = 0; i < products.length; i++) {
			System.out.println(products[i].getItemCode() + "\t\t" + products[i].getItemName() + "\t\t"
					+ products[i].getQuantity());
		}

	}

	private static Inventory[] addItems(Inventory[] products) {
		System.out.println("Enter the item code : ");
		int itemCode = intValidate();
		System.out.println("Enter the item name : ");
		String ItemName = sc.next();
		System.out.println("Enter the item price : ");
		double itemPrice = doubleValidate();
		System.out.println("Enter the item category : ");
		String itemCategory = sc.next();
		System.out.println("Enter the item quantity : ");
		int quantity = intValidate();
		products = addProduct(itemCode, ItemName, itemPrice, itemCategory, quantity, products);
		return products;
	}

	private static Inventory[] addProduct(int itemCode, String itemName, double itemPrice, String itemCategory,
			int quantity, Inventory[] products) {
		Inventory res[] = new Inventory[products.length + 1];
		for (int i = 0; i < products.length; i++) {
			res[i] = products[i];
		}
		res[products.length] = new Inventory(itemCode, itemName, itemPrice, itemCategory, quantity);
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

	private static int optionCheck(int option) {
		while (!(option > 0 && option < 3)) {
			System.out.println("1.NewsPaper\n2.Magazine\n\n Select an option : ");
			option = intValidate();
		}
		return option;
	}

	private static String dateValidate(String data) {

		while (!data.matches("((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")) {
			System.out.println("Please retype the Date of Birth");
			data = sc.next();
		}
		return data;
	}

	private static int ConvertToInteger(String string) {
		int num = 0;
		for (int i = 0; i < string.length(); i++) {
			num = num * 10 + ((int) string.charAt(i) - 48);
		}
		return num;
	}

}

