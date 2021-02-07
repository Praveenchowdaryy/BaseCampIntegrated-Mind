package com.mind.Integrated16;


import java.util.Scanner;

public class HotelApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Hotel[] customers = {};
		int choice;
		do {
			System.out.println(
					"1.Add customers\n2.Show Available Discounts\n3.Print bill amount on booking\n4.Exit\n\nEnter your Choice : ");
			choice = intValidate();
			switch (choice) {
			case 1: {
				customers = addCustomers(customers);
			}
				break;
			case 2: {
				showAvailableDiscounts();
			}
				break;
			case 3: {
				printBill(customers);
			}
				break;
			case 4: {
				System.out.println("Thank you !");
			}
				break;
			default: {
				System.out.println("Invalid Input !");
			}
			}
		} while (choice != 4);

	}

	private static void printBill(Hotel[] customers) {
		System.out.println("Enter mobile number to book ticket : ");
		String mobileNumber = sc.next();
		mobileNumber = phoneValidate(mobileNumber);
		double bill = mobileNumberFound(mobileNumber, customers);
		if (bill > 0) {
			System.out.println("Booking Successfull totalbill is : " + bill);
		} else {
			System.out.println("Customer not found!");
		}

	}

	private static double mobileNumberFound(String mobileNumber, Hotel[] customers) {
		double bill = 0;
		System.out.println("Enter the price per day : ");
		double price = doubleValidate();
		for (int i = 0; i < customers.length; i++) {
			if (customers[i].getMobileNumber().compareTo(mobileNumber) == 0) {
				bill = (customers[i].getTodate() - customers[i].getFromDate()) * price;
			}
		}
		return bill;
	}

	private static void showAvailableDiscounts() {
		System.out.println("Platinum : 20%");
		System.out.println("Gold : 15%");
		System.out.println("Silver : 10%");
		System.out.println("None : 10%");
	}

	private static Hotel[] addCustomers(Hotel[] customers) {
		System.out.println("Enter Customer Name : ");
		String name = sc.next();
		System.out.println("Enter Customer Mobile Number : ");
		String mobileNumber = sc.next();
		mobileNumber = phoneValidate(mobileNumber);
		String memberShip = getMembership();
		System.out.println("you can book only for this month ! ");
		System.out.println("Enter Customer From Day (in this month) ex :(1,2,3..) : ");
		int fromDate = intValidate();

		System.out.println("Enter Customer To Day (in this month) ex :(21,22,3..) : ");
		int toDate = intValidate();
		if (dateCheck(fromDate, toDate))
			customers = addCustomer(name, mobileNumber, memberShip, fromDate, toDate, customers);
		return customers;
	}

	private static boolean dateCheck(int fromDate, int toDate) {
		while (!((fromDate < toDate) && (fromDate > 0 && fromDate < 31) && (toDate > 0 && toDate < 31))) {
			System.out.println("you can book only for this month ! ");
			System.out.println("Enter Customer From Day (in this month) ex :(1,2,3..) : ");
			fromDate = intValidate();
			System.out.println("Enter Customer To Day (in this month) ex :(21,22,3..) : ");
			toDate = intValidate();
		}
		return true;
	}

	private static Hotel[] addCustomer(String name, String mobileNumber, String memberShip, int fromDate, int toDate,
			Hotel[] customers) {
		Hotel res[] = new Hotel[customers.length + 1];
		for (int i = 0; i < customers.length; i++) {
			res[i] = customers[i];
		}
		res[customers.length] = new Hotel(name, mobileNumber, memberShip, fromDate, toDate);
		return res;
	}

	private static String getMembership() {
		System.out.println("1.Premium\n2.Gold\n3.Silver\n4.None\n\nSelect your membership : ");
		int option = intValidate();
		option = optionValidate(option);
		String memberShip = getMemberShip(option);
		return memberShip;
	}

	private static String getMemberShip(int option) {
		String memberShip = "";
		if (option == 1) {
			memberShip = "Premium";
		}
		if (option == 2) {
			memberShip = "Gold";
		}
		if (option == 3) {
			memberShip = "Silver";
		}
		if (option == 4) {
			memberShip = "None";
		}
		return memberShip;
	}

	private static int optionValidate(int option) {
		while (!(option > 0 && option < 5)) {
			System.out.println("1.Premium\n2.Gold\n3.Silver\n4.None\n\nSelect your membership : ");
			option = intValidate();
		}
		return option;
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

	private static String phoneValidate(String data) {

		while (!data.matches("[0-9]+")) {
			if (!data.isEmpty()) {
				System.out.println("Please retype the phone Number");
			}
			data = sc.next();
		}
		return data;
	}
}
