package com.mind.Integrated5;

import java.util.Scanner;

public class TravelAgentApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		TravelerAgent travelers[] = {};
		int choice;
		do {
			System.out.println(
					"1.add Travelers\n2. book one-way or return journey\n3.find the most prefered Destination by traveler\n4.Exit\n\n Enter your choice : ");
			choice = intValidate();
			switch (choice) {
			case 1: {
				travelers=addTravelerDetails(travelers);
			}
				break;
			case 2: {
				bookTicket(travelers);
			}
				break;
			case 3: {
				findPreferedDestination(travelers);
			}
				break;
			case 4: {
				System.out.println("Thank you!");
			}
				break;
			default: {
				System.out.println("Invalid input!");
			}
			}
		} while (choice != 4);
	}

	private static void findPreferedDestination(TravelerAgent[] travelers) {
		System.out.println("Enter the Customer Id :");
		int customerId = intValidate();
		boolean isCustomerIdPresent = findCustomer(customerId, travelers);
		if (isCustomerIdPresent) {
			String preferedDestination = getPreferedDestination(customerId, travelers);
			System.out.println("The prefered destination of customer ID " + customerId + " is " + preferedDestination);
		} else {
			System.out.println("Customer not found !");
		}
	}

	private static String getPreferedDestination(int customerId, TravelerAgent[] travelers) {
		int max = 0;
		String PreferedLocation = "";
		for (int i = 0; i < travelers.length; i++) {
			if (travelers[i].getTravelerId() == customerId) {
				if (travelers[i].getPreferedDestination() > max) {
					max = travelers[i].getPreferedDestination();
					PreferedLocation = travelers[i].getTravelerDestination();
				}
			}
		}
		return PreferedLocation;
	}

	private static void bookTicket(TravelerAgent[] travelers) {
		System.out.println("Enter Customer id : ");
		int customerId = intValidate();
		boolean isCustomerIdPresent = findCustomer(customerId, travelers);
		if (isCustomerIdPresent==true) {
			System.out.println("Select an option \n1.one way\n2.return journey");
			int travelType = intValidate();
			travelType = travelTypeValidate(travelType);
			addBookingDetails(customerId, travelType, travelers);
		} else {
			System.out.println("Customer not Present please add the customer first !");
		}

	}

	private static boolean findCustomer(int customerId, TravelerAgent[] travelers) {
		boolean isCustomerFound = false;
		for (int i = 0; i < travelers.length; i++) {
			if (travelers[i].getTravelerId()==customerId) {
				isCustomerFound = true;
				break;
			}
		}
		return isCustomerFound;
	}

	private static void addBookingDetails(int customerId, int travelType, TravelerAgent[] travelers) {
		if (travelType == 1) {
			addOneWayBookingDetails(customerId, travelers);
		} else {
			addTwoWayBookingDetails(customerId, travelers);
		}

	}

	private static void addTwoWayBookingDetails(int customerId, TravelerAgent[] travelers) {
		System.out.println("Enter the Airlines : ");
		String airLines = sc.next();
		System.out.println("Enter the source : ");
		String source = sc.next();
		System.out.println("Enter the Destination : ");
		String destination = sc.next();
		System.out.println("Enter the depature date : ");
		String date = sc.next();
		date = dateValidate(date);
		System.out.println("Enter the depature time :");
		String time = sc.next();
		boolean twoWayBooking = true;
		setTwoWayBooking(customerId, airLines, source, destination, date, time, twoWayBooking, travelers);
		setDestinationPreferance(customerId, destination, travelers);
	}

	private static void setDestinationPreferance(int customerId, String destination, TravelerAgent[] travelers) {
		for (int i = 0; i < travelers.length; i++) {
			if (travelers[i].getTravelerId() == customerId) {
				if (travelers[i].getTravelerDestination().compareToIgnoreCase(destination) == 0) {
					travelers[i].setPreferedDestination(travelers[i].getPreferedDestination() + 1);
				}
			}
		}

	}

	private static void setTwoWayBooking(int customerId, String airLines, String source, String destination,
			String date, String time, boolean twoWayBooking, TravelerAgent[] travelers) {
		for (int i = 0; i < travelers.length; i++) {
			if (customerId == travelers[i].getTravelerId()) {
				travelers[i].setAirlines(airLines);
				travelers[i].setTravelerSource(source);
				travelers[i].setTravelerDestination(destination);
				travelers[i].setDepatureDate(date);
				travelers[i].setDepatureTime(time);
				travelers[i].setIstwoWayBooking(twoWayBooking);
			}
		}

	}

	private static void addOneWayBookingDetails(int customerId, TravelerAgent[] travelers) {
		System.out.println("Enter the Airlines : ");
		String airLines = sc.next();
		System.out.println("Enter the source : ");
		String source = sc.next();
		System.out.println("Enter the Destination : ");
		String destination = sc.next();
		System.out.println("Enter the depature date : ");
		String date = sc.next();
		date = dateValidate(date);
		System.out.println("Enter the depature time :");
		String time = sc.next();
		boolean twoWayBooking = false;
		setOneWayBooking(customerId, airLines, source, destination, date, time, twoWayBooking, travelers);
		setDestinationPreferance(customerId, destination, travelers);
	}

	private static void setOneWayBooking(int customerId, String airLines, String source, String destination,
			String date, String time, boolean twoWayBooking, TravelerAgent[] travelers) {
		for (int i = 0; i < travelers.length; i++) {
			if (customerId == travelers[i].getTravelerId()) {
				travelers[i].setAirlines(airLines);
				travelers[i].setTravelerSource(source);
				travelers[i].setTravelerDestination(destination);
				travelers[i].setDepatureDate(date);
				travelers[i].setDepatureTime(time);
				travelers[i].setIstwoWayBooking(twoWayBooking);
			}
		}

	}

	private static String dateValidate(String data) {

		while (!data.matches("((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")) {
			System.out.println("Please retype the Date of Birth");
			data = sc.next();
		}
		return data;
	}

	private static int travelTypeValidate(int travelType) {
		while (!(travelType > 0 && travelType < 3)) {
			System.out.println("Please select a valid travelType : ");
			System.out.println("Select an option \n1.one way\n2.return journey");
			travelType = intValidate();
		}
		return travelType;
	}

	private static TravelerAgent[] addTravelerDetails(TravelerAgent[] travelers) {
		System.out.println("Enter Traveler id :");
		int travelerId = intValidate();
		System.out.println("Enter Traveler name :");
		String travelerName = sc.next();
		System.out.println("Select Traveler gender :\n\n1.Male\n2.Female\n3.Trans Gender");
		int gender = intValidate();
		gender = genderValidate(gender);
		String travelerGender = getTravelerGender(gender);
		System.out.println("Enter Traveler age :");
		int age = intValidate();
		age = ageValidate(age);
		return travelers = addDetails(travelerId, travelerName, travelerGender, age, travelers);

	}

	private static String getTravelerGender(int gender) {
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

	private static TravelerAgent[] addDetails(int travelerId, String travelerName, String gender, int age,
			TravelerAgent[] travelers) {
		TravelerAgent res[] = new TravelerAgent[travelers.length + 1];
		for (int i = 0; i < travelers.length; i++) {
			res[i] = travelers[i];
		}
		res[travelers.length] = new TravelerAgent(travelerId, travelerName, gender, age);
		return res;

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

