package com.mind.Integrated7;


import java.util.Scanner;

public class NewsPaperAndMagazineApp {
	static Scanner sc = new Scanner(System.in);
	static int subscriberId = 0;
	/*
	 * static NewsPaper[] papers = {}; static Magazine[] magazines = {}; static
	 * Subscribers[] subscribers = {};
	 */

	public static void main(String[] args) {

		NewsPaper[] papers = {};
		Magazine[] magazines = {};
		Subscribers[] subscribers = {};

		int choice;
		do {
			System.out.println("1.Add Papers Details\n" + "2.Add Customer Details\n"
					+ "3.Get the list of subscribers having both newspaper and magazine subscription\n"
					+ "4. Get the maximum subscribed newspaper and magazine\n"
					+ "5. Given a range of age, find out the preference of the subscribers over newspaper andmagazine\n"
					+ "6.Binary search" + "7.Exit");
			choice = intValidate();
			switch (choice) {
			case 1: {
				System.out.println("1.NewsPaper\n2.Magazine\n\n Select an option : ");
				int option = intValidate();
				option = optionCheck(option);
				if (option == 1) {
					papers = addDetails(papers);
				} else {
					magazines = addDetails(magazines);
				}
			}
				break;
			case 2: {
				subscribers = addSubscribers(subscribers, papers, magazines);
			}
				break;
			case 3: {
				displayBothSubscribers(subscribers);
			}
				break;
			case 4: {
				displayMaxSubscribed(papers, magazines);
			}
				break;
			case 5: {
				displayBetweenAgeRange(subscribers);
			}
				break;
			case 6: {
				binarySearch(subscribers);

			}
				break;
			case 7: {
				System.out.println("Thank you!");
			}
				break;
			default: {
				System.out.println("Invalid Input !");
			}
			}

		} while (choice != 6);

	}

	private static void binarySearch(Subscribers[] subscribers) {
		System.out.println("Enter the subscriber id to search the subscriber : ");
		int id = intValidate();
		search(id, subscribers);

	}

	private static void search(int id, Subscribers[] subscribers) {
		int first = 0, last = subscribers.length - 1, mid = (first + last) / 2;
		while (first <= last) {
			if (subscribers[mid].getSubscriberID() == id) {
				display(subscribers[mid]);
				break;
			} else if (subscribers[mid].getSubscriberID() < id) {
				first = mid + 1;
			} else {
				last = mid - 1;
			}
			mid = (first + last) / 2;
			if (first > last) {
				System.out.println("Not found : ");
			}
		}

	}

	private static void display(Subscribers subscribers) {
		System.out.println("ID\t\tName\t\tMobileNumber");
		System.out.println(subscribers.getSubscriberID() + "\t\t" + subscribers.getName() + "\t\t"
				+ subscribers.getMobileNumber());
	}

	private static void displayBetweenAgeRange(Subscribers[] subscribers) {
		System.out.println("Enter the from age : ");
		int fromAge = intValidate();
		fromAge = ageValidate(fromAge);
		System.out.println("Enter the to age : ");
		int toAge = intValidate();
		toAge = ageValidate(toAge);
		boolean ifTrue = ageRangeValidate(fromAge, toAge);
		if (ifTrue) {
			int newsPaperCount = getNewsPaperCount(subscribers);
			int magazineCount = getMagasineCount(subscribers);
			System.out.println("NewsPaper Subscribers count : " + newsPaperCount);
			System.out.println("Magazine Subscribers count : " + magazineCount);
		}

	}

	private static int getMagasineCount(Subscribers[] subscribers) {
		int count = 0;
		for (int i = 0; i < subscribers.length; i++) {
			if (subscribers[i].getMagazineName() != null) {
				count++;
			}
		}
		return count;
	}

	private static int getNewsPaperCount(Subscribers[] subscribers) {
		int count = 0;
		for (int i = 0; i < subscribers.length; i++) {
			if (subscribers[i].getNewsPaperName() != null) {
				count++;
			}
		}
		return count;
	}

	private static void displayMaxSubscribed(NewsPaper[] papers, Magazine[] magazines) {
		String maxSoldPaper = getPaperCount(papers);
		String maxSoldMagazine = getMagazineCount(magazines);
		System.out.println("max sold NewsPaper is " + maxSoldPaper);
		System.out.println("max sold NewsPaper is " + maxSoldMagazine);
	}

	private static String getMagazineCount(Magazine[] magazines) {
		int magazineCount = 0;
		String magazine = "";
		for (int i = 0; i < magazines.length; i++) {
			if (magazines[i].getSubscriberCount() > magazineCount) {
				magazineCount = magazines[i].getSubscriberCount();
				magazine = magazines[i].getName();
			}
		}
		return magazine;
	}

	private static String getPaperCount(NewsPaper[] papers) {
		int paperCount = 0;
		String paper = "";
		for (int i = 0; i < papers.length; i++) {
			if (papers[i].getSubscriberCount() > paperCount) {
				paperCount = papers[i].getSubscriberCount();
				paper = papers[i].getName();
			}
		}
		return paper;
	}

	private static void displayBothSubscribers(Subscribers[] subscribers) {
		System.out.println("Name\tMobileNumber");
		for (int i = 0; i < subscribers.length; i++) {
			if (subscribers[i].isTypeBoth() == true) {
				System.out.println(subscribers[i].getName() + "\t" + subscribers[i].getMobileNumber());
			}
		}
	}

	private static Subscribers[] addSubscribers(Subscribers[] subscribers, NewsPaper[] papers, Magazine[] magazines) {
		System.out.println("Enter Subscriber Name :");
		String name = sc.next();
		System.out.println("Enter Subscriber Age :");
		int age = intValidate();
		age = ageValidate(age);
		System.out.println("Enter Subscriber Mobile Number :");
		String mobileNumber = sc.next();
		mobileNumber = phoneValidate(mobileNumber);
		System.out.println("Enter Subscriber Address : ");
		String address = sc.next();
		subscribers = addSubscribers(name, age, mobileNumber, address, subscribers, papers, magazines);
		return subscribers;
	}

	private static Subscribers[] addSubscribers(String name, int age, String mobileNumber, String address,
			Subscribers[] subscribers, NewsPaper[] papers, Magazine[] magazines) {
		System.out.println("1.NewsPaper\n2.Magazine\n3.Both\n Select an option : ");
		int option = intValidate();
		option = optionCheck1(option);
		if (option == 1) {
			String newsPaper = getNewsPaperName(papers);
			String magazine = null;
			boolean both = false;
			subscriberId += 1;
			if (newsPaper != null) {
				subscribers = addNewsPaperSupscribers(name, age, mobileNumber, address, newsPaper, magazine, both,
						subscribers, subscriberId);
			} else {
				System.out.println("NewsPaper not Found!");
			}
		}
		if (option == 2) {
			String magazine = getMagazineName(magazines);
			String newsPaper = null;
			boolean both = false;
			subscriberId += 1;
			if (magazine != null) {
				subscribers = addNewsPaperSupscribers(name, age, mobileNumber, address, newsPaper, magazine, both,
						subscribers, subscriberId);
			} else {
				System.out.println("Magazine not Found!");
			}
		}
		if (option == 3) {
			String newsPaper = getNewsPaperName(papers);
			String magazine = getMagazineName(magazines);
			boolean both = true;
			subscriberId += 1;
			if (newsPaper != null && magazine != null) {
				subscribers = addNewsPaperSupscribers(name, age, mobileNumber, address, newsPaper, magazine, both,
						subscribers, subscriberId);
			} else {
				System.out.println("Input not Found!");
			}
		}
		return subscribers;
	}

	private static int optionCheck1(int option) {
		while (!(option > 0 && option < 4)) {
			System.out.println("1.NewsPaper\n2.Magazine\n3.both\n Select an option : ");
			option = intValidate();
		}
		return option;
	}

	private static String getMagazineName(Magazine[] magazines) {
		String magazine = null;
		System.out.println("Magazine\t\tLanguage");
		for (int i = 0; i < magazines.length; i++) {
			System.out.println(magazines[i].getName() + "\t\t\t" + magazines[i].getLanguage());
		}
		System.out.println("Enter Magazine name to subscribe : ");
		String name = sc.next();
		if (magazineFound(name, magazines)) {
			magazine = name;
			System.out.println("Subscribed !");
		}
		return magazine;
	}

	private static boolean magazineFound(String name, Magazine[] magazines) {
		for (int i = 0; i < magazines.length; i++) {
			if (magazines[i].getName().compareToIgnoreCase(name) == 0) {
				magazines[i].setSubscriberCount(magazines[i].getSubscriberCount() + 1);
				return true;
			}
		}
		return false;

	}

	private static Subscribers[] addNewsPaperSupscribers(String name, int age, String mobileNumber, String address,
			String newsPaper, String magazine, boolean both, Subscribers[] subscribers, int subscriberId) {
		Subscribers res[] = new Subscribers[subscribers.length + 1];
		for (int i = 0; i < subscribers.length; i++) {
			res[i] = subscribers[i];
		}
		res[subscribers.length] = new Subscribers(name, age, mobileNumber, address, newsPaper, magazine, both,
				subscriberId);
		return res;
	}

	private static String getNewsPaperName(NewsPaper[] papers) {
		String newsPaper = null;
		System.out.println("NewsPaper\t\tLanguage");
		for (int i = 0; i < papers.length; i++) {
			System.out.println(papers[i].getName() + "\t\t\t" + papers[i].getLanguage());
		}
		System.out.println("Enter newsPaper name to subscribe : ");
		String name = sc.next();
		if (paperFound(name, papers)) {
			newsPaper = name;
			System.out.println("Subscribed !");
		}
		return newsPaper;
	}

	private static boolean paperFound(String name, NewsPaper[] papers) {
		for (int i = 0; i < papers.length; i++) {
			if (papers[i].getName().compareToIgnoreCase(name) == 0) {
				papers[i].setSubscriberCount(papers[i].getSubscriberCount() + 1);
				return true;
			}
		}
		return false;
	}

	private static Magazine[] addDetails(Magazine[] magazines) {
		System.out.println("Enter the name of magazine : ");
		String name = sc.next();
		System.out.println("Enter the magazine language : ");
		String language = sc.next();
		magazines = addmagazine(name, language, magazines);
		return magazines;
	}

	private static Magazine[] addmagazine(String name, String language, Magazine[] magazines) {
		Magazine res[] = new Magazine[magazines.length + 1];
		for (int i = 0; i < magazines.length; i++) {
			res[i] = magazines[i];
		}
		res[magazines.length] = new Magazine(name, language);
		return res;
	}

	private static NewsPaper[] addDetails(NewsPaper[] papers) {
		System.out.println("Enter the name of news Paper : ");
		String name = sc.next();
		System.out.println("Enter the news Paper language : ");
		String language = sc.next();
		papers = addNewsPaper(name, language, papers);
		return papers;
	}

	private static NewsPaper[] addNewsPaper(String name, String language, NewsPaper[] papers) {
		NewsPaper res[] = new NewsPaper[papers.length + 1];
		for (int i = 0; i < papers.length; i++) {
			res[i] = papers[i];
		}
		res[papers.length] = new NewsPaper(name, language);
		return res;
	}

	private static int optionCheck(int option) {
		while (!(option > 0 && option < 3)) {
			System.out.println("1.NewsPaper\n2.Magazine\n\n Select an option : ");
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

	private static int ageValidate(int age) {
		while (age < 1 || age > 100) {
			System.out.println("Enter the valid age : ");
			age = intValidate();
		}
		return age;
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

	private static boolean ageRangeValidate(int fromAge, int toAge) {
		while (fromAge >= toAge) {
			System.out.println("Enter the valid age range :");
			System.out.println("Enter the from age : ");
			fromAge = intValidate();
			fromAge = ageValidate(fromAge);
			System.out.println("Enter the to age : ");
			toAge = intValidate();
			toAge = ageValidate(toAge);
		}
		return true;
	}
}

