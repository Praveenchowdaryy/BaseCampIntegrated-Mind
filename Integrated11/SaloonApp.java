package com.mind.Integrated11;


import java.util.Scanner;

public class SaloonApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Customer[] customers = {};
		SaloonService service = new SaloonService();
		int choice;
		do {
			System.out.println(
					"1.Add service details offered to the customer\n2. Display report\n3.Exit\nEnter your choice : ");
			choice = intValidate();
			switch (choice) {
			case 1: {
				customers = addCustomers(customers, service);
			}
				break;
			case 2: {
				int innerChoice;
				do {
					System.out.println(
							"1.Display Service Details which took less Time\n2.Display the service details sorted by customer Id\n3.Display all the service details with service cost more than 50 rupees\n4.Exit\n\nEnter your Choice : ");
					innerChoice = intValidate();
					switch (innerChoice) {
					case 1: {
						displayServiceDetailsWithMinimumTime(customers);
					}
						break;
					case 2: {
						displayServiceDetailsSortedById(customers);
					}
						break;
					case 3: {
						displayDetailsWithCost(customers);
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
				} while (innerChoice != 4);
			}
				break;
			case 3: {
				System.out.println("Thank you!");
			}
				break;
			default: {
				System.out.println("Invalid option!");
			}
			}
		} while (choice != 3);
	}

	private static void displayDetailsWithCost(Customer[] customers) {
		System.out.println("CustomerId\t\tCustomerName\t\tServiceType\t\tCost");
		for (int i = 0; i < customers.length; i++) {
			if (customers[i].getPrice() >= 50) {
				System.out.println(customers[i].getCustomerId() + "\t\t" + customers[i].getName() + "\t\t"
						+ customers[i].getServiceType() + "\t\t" + customers[i].getPrice());
			}
		}
	}

	private static void displayServiceDetailsSortedById(Customer[] customers) {
		Customer[] sorted = insertionSort(customers);
		System.out.println("CustomerId\t\tCustomerName\t\tServiceType\t\tCost");
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].getCustomerId() + "\t\t" + sorted[i].getName() + "\t\t"
					+ sorted[i].getServiceType() + "\t\t" + sorted[i].getPrice());
		}

	}

	private static Customer[] insertionSort(Customer[] customers) {
		for (int i = 1; i < customers.length; i++) {
			Customer key = customers[i];
			int j = i - 1;
			while (j >= 0 && customers[j].getCustomerId() > key.getCustomerId()) {
				customers[j + 1] = customers[j];
				j = j - 1;
			}
			customers[j + 1] = key;
		}
		return customers;
	}

	private static void displayServiceDetailsWithMinimumTime(Customer[] customers) {
		Customer customer = getCustomerWithMinimumTime(customers);
		System.out.println("CustomerId : " + customer.getCustomerId());
		System.out.println("ServiceType : " + customer.getServiceType());
		System.out.println("Price : " + customer.getPrice());
	}

	private static Customer getCustomerWithMinimumTime(Customer[] customers) {
		Customer customer = customers[0];
		int minimumTime = customers[0].getMinutes();
		for (int i = 0; i < customers.length; i++) {
			if (customers[i].getMinutes() < minimumTime) {
				minimumTime = customers[i].getMinutes();
				customer = customers[i];
			}
		}
		return customer;
	}

	private static Customer[] addCustomers(Customer[] customers, SaloonService service) {
		System.out.println("Enter Customer Id : ");
		int customerId = intValidate();
		System.out.println("Enter Name : ");
		String name = sc.next();
		String gender = getGender();
		display(service);
		String serviceOpted = getService(service);
		System.out.println("Enter The time took to the Service in minutes : ");
		int minutes = intValidate();
		System.out.println("Enter the cost to the service : ");
		double price = getPrice(minutes);
		customers = addCustomer(customerId, name, gender, serviceOpted, minutes, price, customers);
		return customers;
	}

	private static Customer[] addCustomer(int customerId, String name, String gender, String serviceOpted, int minutes,
			double price, Customer[] customers) {
		Customer res[] = new Customer[customers.length + 1];
		for (int i = 0; i < customers.length; i++) {
			res[i] = customers[i];
		}
		res[customers.length] = new Customer(customerId, name, gender, serviceOpted, minutes, price);
		return res;
	}

	private static double getPrice(int minutes) {
		double price = 0;
		if (minutes <= 30) {
			price = 40;
		} else {
			price = 80;
		}
		return price;
	}

	private static String getService(SaloonService service) {
		int option = intValidate();
		option = optionCheck1(option, service);
		String serviceType = service.getServiceTypes()[option - 1];
		return serviceType;
	}

	private static int optionCheck1(int option, SaloonService service) {
		while (!(option > 0 && option < service.getServiceTypes().length + 1)) {
			display(service);
			option = intValidate();
		}
		return option;
	}

	private static void display(SaloonService service) {
		System.out.println("Services offered are : ");
		for (int i = 0; i < service.getServiceTypes().length; i++) {
			System.out.println((i + 1) + ". " + service.getServiceTypes()[i]);
		}

	}

	private static String getGender() {
		System.out.println("1.Male\n2.Female\n3.TransGender\n\nSelect gender:");
		int option = intValidate();
		option = optionCheck(option);
		String gender = "";
		if (option == 1) {
			gender = "Male";
		}
		if (option == 2) {
			gender = "Female";
		}
		if (option == 3) {
			gender = "Trans Gender";
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

	private static int optionCheck(int option) {
		while (!(option > 0 && option < 4)) {
			System.out.println("1.Male\n2.Female\n3.TransGender\n\nSelect gender:");
			option = intValidate();
		}
		return option;
	}
}

