package com.mind.Integrated6;


import java.util.Scanner;

public class TaxiApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		TaxiDriver[] taxis = new TaxiDriver[2];
		TaxiUser[] taxiUsers = {};
		int choice;
		do {
			System.out.println(
					"1. Add 10 taxies\n2. Add a taxi user\n3. Book a taxi for the user\n4. Exit\n\nChoose an option");
			choice = intValidate();
			switch (choice) {
			case 1: {
				for (int i = 0; i < taxis.length; i++) {
					taxis[i] = new TaxiDriver();
					taxis[i] = addTaxiDetails(taxis[i]);
				}
			}
				break;
			case 2: {
				taxiUsers = addTaxiUser(taxiUsers);
			}
				break;
			case 3: {
				String taxiNumber = bookTaxi(taxiUsers, taxis);
				System.out.println("you are allocated with taxi number " + taxiNumber);
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

	private static String bookTaxi(TaxiUser[] taxiUsers, TaxiDriver[] taxis) {
		String taxiNumber = null;
		System.out.println("Enter the mobile number :");
		String mobileNumber = sc.next();
		mobileNumber = phoneValidate(mobileNumber);
		boolean mobileNumberFound = findMobileNumber(mobileNumber, taxiUsers);
		if (mobileNumberFound) {
			taxiNumber = getBookedTaxi(mobileNumber, taxiUsers, taxis);
		} else {
			System.out.println("Customer Not Found!");

		}
		return taxiNumber;
	}

	private static boolean findMobileNumber(String mobileNumber, TaxiUser[] taxiUsers) {
		for (int i = 0; i < taxiUsers.length; i++) {
			if (taxiUsers[i].getMobileNumber().compareTo(mobileNumber) == 0) {
				return true;
			}
		}
		return false;
	}

	private static String getBookedTaxi(String mobileNumber, TaxiUser[] taxiUsers, TaxiDriver[] taxis) {
		double userDistance = 0;
		String taxiNumber = "";
		for (int i = 0; i < taxiUsers.length; i++) {
			if (taxiUsers[i].getMobileNumber().compareTo(mobileNumber) == 0) {
				userDistance = taxiUsers[i].getDistance();
				break;
			}
		}
		taxiNumber = getTaxiNumber(userDistance, taxis);
		taxis = setTaxiAvailability(taxiNumber, taxis);
		return taxiNumber;
	}

	private static TaxiDriver[] setTaxiAvailability(String taxiNumber, TaxiDriver[] taxis) {
		for (int i = 0; i < taxis.length; i++) {
			if (taxis[i].getTaxiNumber().compareToIgnoreCase(taxiNumber) == 0) {
				taxis[i].setTaxiAvailable(false);
			}
		}
		return taxis;
	}

	private static String getTaxiNumber(double userDistance, TaxiDriver[] taxis) {
		String taxiNumber = "";
		double minimumDistance = userDistance - taxis[0].getDistance();
		for (int i = 1; i < taxis.length; i++) {
			if (minimumDistance > userDistance - taxis[i].getDistance() && taxis[i].isTaxiAvailable() == true) {
				minimumDistance = userDistance - taxis[0].getDistance();
				taxiNumber = taxis[i].getTaxiNumber();
			}
		}
		return taxiNumber;
	}

	private static TaxiUser[] addTaxiUser(TaxiUser[] taxiUsers) {
		System.out.println("Enter User Name : ");
		String name = sc.next();
		System.out.println("Enter User Age :");
		int age = intValidate();
		age = ageValidate(age);
		System.out.println("Select Traveler gender :\n\n1.Male\n2.Female\n3.Trans Gender");
		int userGender = intValidate();
		userGender = genderValidate(userGender);
		String gender = getGender(userGender);
		System.out.println("Enter User Mobile Number :");
		String mobileNumber = sc.nextLine();
		mobileNumber = phoneValidate(mobileNumber);
		System.out.println("Enter User Distance :");
		double distance = doubleValidate();
		taxiUsers = addTaxiUsers(name, age, gender, mobileNumber, distance, taxiUsers);
		return taxiUsers;
	}

	private static TaxiUser[] addTaxiUsers(String name, int age, String gender, String mobileNumber, double distance,
			TaxiUser[] taxiUsers) {
		TaxiUser res[] = new TaxiUser[taxiUsers.length + 1];
		for (int i = 0; i < taxiUsers.length; i++) {
			res[i] = taxiUsers[i];
		}
		res[taxiUsers.length] = new TaxiUser(name, age, gender, mobileNumber, distance);
		return res;
	}

	private static TaxiDriver addTaxiDetails(TaxiDriver taxiDriver) {
		System.out.println("Enter the Taxi driver Name : ");
		String driverName = sc.next();
		taxiDriver.setDriverName(driverName);
		System.out.println("Enter the Taxi driver ID : ");
		int driverId = intValidate();
		taxiDriver.setDriverId(driverId);
		System.out.println("Enter the Taxi Number : ");
		String taxiNumber = sc.next();
		taxiDriver.setTaxiNumber(taxiNumber);
		System.out.println("Enter the Taxi distance : ");
		double distance = doubleValidate();
		taxiDriver.setDistance(distance);
		taxiDriver.setTaxiAvailable(true);
		return taxiDriver;
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

	private static String getGender(int gender) {
		String travelerGender = "";
		if (gender == 1) {
			travelerGender = "Male";
		}
		if (gender == 2) {
			travelerGender = "Female";
		}
		if (gender == 3) {
			travelerGender = "Trans";
		}
		return travelerGender;
	}

	private static int ageValidate(int age) {
		while (age < 1 || age > 100) {
			System.out.println("Enter the valid age : ");
			age = intValidate();
		}
		return age;
	}

	private static int genderValidate(int gender) {
		while (!(gender > 0 && gender < 4)) {
			System.out.println("Please select a valid gender : ");
			System.out.println("Select Traveler gender :\n\n1.Male\n2.Female\n3.Trans Gender");
			gender = intValidate();

		}
		return gender;
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
