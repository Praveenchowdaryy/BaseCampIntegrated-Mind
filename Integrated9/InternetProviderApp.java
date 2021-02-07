package com.mind.Integrated9;


import java.util.Scanner;

public class InternetProviderApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		InternetProvider[] plans = {};
		InternetUser[] users = {};
		int choice;
		do {
			System.out.println(
					"1. Add a new plan\n2.Add a new user\n3. Display all the users\n4. Display all the plans available\n5. Display the users subscribed to a particular plan\n6.Display the city name in reverse order\n7. Sort the plans in based on ascending order of their price\n8.Exit\n\nEnter your choice : ");
			choice = intValidate();
			switch (choice) {
			case 1: {
				plans = addPlans(plans);
			}
				break;
			case 2: {
				users = addUsers(users, plans);
			}
				break;
			case 3: {
				displayUsers(users);
			}
				break;
			case 4: {
				displayPlans(plans);
			}
				break;
			case 5: {
				displayUserToPlan(users, plans);
			}
				break;
			case 6: {
				displayCityNamesInReverseOrder(users);
			}
				break;
			case 7: {
				sortPlans(plans);
			}
				break;
			case 8: {
				System.out.println("Thank You !");
			}
				break;
			default: {
				System.out.println("Invalid Input : ");
			}
			}
		} while (choice != 8);

	}

	private static void sortPlans(InternetProvider[] plans) {
		InternetProvider[] plansSorted = insertionSort(plans);
		System.out.println("Plan Name\t\tPrice");
		for (int i = 0; i < plansSorted.length; i++) {
			System.out.println(plansSorted[i].getPlanName() + "\t\t" + plansSorted[i].getPrice());
		}

	}

	private static InternetProvider[] insertionSort(InternetProvider[] plans) {
		for (int i = 1; i < plans.length; i++) {
			InternetProvider key = plans[i];
			int j = i - 1;
			while (j >= 0 && plans[j].getPrice() > key.getPrice()) {
				plans[j + 1] = plans[j];
				j = j - 1;
			}
			plans[j + 1] = key;
		}
		return plans;
	}

	private static void displayCityNamesInReverseOrder(InternetUser[] users) {
		String tempCity = "";
		String rev = "";
		System.out.println("City names in Reverse order :");
		for (int i = 0; i < users.length; i++) {
			tempCity = users[i].getAddress();
			for (int j = tempCity.length() - 1; j >= 0; j--) {
				rev += tempCity.charAt(j);
			}
			System.out.println(rev);
			rev = "";
		}

	}

	private static void displayUserToPlan(InternetUser[] users, InternetProvider[] plans) {
		displayPlans(plans);
		System.out.println("Enter the Plan name : ");
		String planName = sc.next();
		if (planFound(planName, plans)) {
			displayUsers(planName, users);
		} else {
			System.out.println("Your request not found : ");
		}
	}

	private static void displayUsers(String planName, InternetUser[] users) {
		System.out.println("UserId\tName");
		for (int i = 0; i < users.length; i++) {
			if (users[i].getPlanName().compareTo(planName) == 0)
				System.out.println(users[i].getUserId() + "\t\t" + users[i].getName());
		}

	}

	/*
	 * private static void displayPlan(int userId, InternetUser[] users) {
	 * System.out.println("UserId\tPlan Name"); for (int i = 0; i < users.length;
	 * i++) { if (users[i].getUserId() == userId) {
	 * System.out.println(users[i].getUserId() + "\t\t" + users[i].getPlanName()); }
	 * }
	 * 
	 * }
	 * 
	 * private static boolean userFound(int userId, InternetUser[] users) { for (int
	 * i = 0; i < users.length; i++) { if (users[i].getUserId() == userId) { return
	 * true; } } return false; }
	 */

	private static void displayUsers(InternetUser[] users) {
		System.out.println("Name\t\tUserId\t\tMobileNumber");
		for (int i = 0; i < users.length; i++) {
			System.out.println(users[i].getName() + "\t\t" + users[i].getUserId() + "\t" + users[i].getMobileNumber());
		}
	}

	private static InternetUser[] addUsers(InternetUser[] users, InternetProvider[] plans) {
		System.out.println("Enter your Name : ");
		String name = sc.next();
		System.out.println("Enter your UserId : ");
		int userId = intValidate();
		System.out.println("Enter your Mobile Number : ");
		String mobileNumber = sc.next();
		System.out.println("Enter your City : ");
		String city = sc.next();
		displayPlans(plans);
		System.out.println("Enter plan Name to select : ");
		String planName = sc.next();
		if (planFound(planName, plans)) {
			users = addUser(name, userId, mobileNumber, city, planName, users);
		} else {
			System.out.println("Your request not found : ");
		}
		return users;
	}

	private static InternetUser[] addUser(String name, int userId, String mobileNumber, String city, String planName,
			InternetUser[] users) {
		InternetUser res[] = new InternetUser[users.length + 1];
		for (int i = 0; i < users.length; i++) {
			res[i] = users[i];
		}
		res[users.length] = new InternetUser(name, userId, mobileNumber, city, planName);
		return res;
	}

	private static boolean planFound(String planName, InternetProvider[] plans) {
		for (int i = 0; i < plans.length; i++) {
			if (plans[i].getPlanName().compareToIgnoreCase(planName) == 0) {
				return true;
			}
		}
		return false;
	}

	private static void displayPlans(InternetProvider[] plans) {
		System.out.println("Plan\t\tSpeed(Mbps)\t\tMonth Limit(GB)\t\tPrice");
		for (int i = 0; i < plans.length; i++) {
			System.out.println(plans[i].getPlanName() + "\t\t" + plans[i].getInternetSpeed() + "\t\t"
					+ plans[i].getMonthlyLimit() + "\t\t" + plans[i].getPrice());
		}

	}

	private static InternetProvider[] addPlans(InternetProvider[] plans) {
		System.out.println("Enter plan name : ");
		String name = sc.next();
		System.out.println("Enter Internet Speed : ");
		double speed = doubleValidate();
		System.out.println("Enter Monthly Download Limit : ");
		double limit = doubleValidate();
		System.out.println("Enter Price Per Month : ");
		double price = doubleValidate();
		plans = addToPlans(name, speed, limit, price, plans);
		return plans;
	}

	private static InternetProvider[] addToPlans(String name, double speed, double limit, double price,
			InternetProvider[] plans) {
		InternetProvider res[] = new InternetProvider[plans.length + 1];
		for (int i = 0; i < plans.length; i++) {
			res[i] = plans[i];
		}
		res[plans.length] = new InternetProvider(name, speed, limit, price);
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

