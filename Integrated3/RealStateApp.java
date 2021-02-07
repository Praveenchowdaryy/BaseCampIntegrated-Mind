package com.mind.Integrated3;

import java.util.Scanner;

public class RealStateApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		RealState houses[] = {};
		int choice;
		do {
			System.out.println(
					"1.Add House\n2. Categorize the listing based on To Let (Rent) and For Sale (Sale)\n3.Categorize the listing based on 1BHK, 2BHK and 3BHK\n4.Categorize the listing based on Apartment Flat and Individual house\n5.More filters\n6.Exit");
			System.out.println("Enter your choice :");
			choice = intValidate();
			switch (choice) {
			case 1: {
				System.out.println("Enter the sale type of the house(tolet/sale) : ");
				String saleType = sc.next();
				System.out.println("Enter the house Size(1BHK,2BHK,3BHK");
				String houseSize = sc.next();
				System.out.println("Enter the house Type(Apartment/individual house) : ");
				String houseType = sc.next();
				houses = addDetails(saleType, houseSize, houseType, houses);
			}
				break;
			case 2: {
				System.out.println("Enter the sale type to find the houses(Tolet/sale) :");
				String saleType = sc.next();
				displayHousesBasedOnSaleType(saleType, houses);

			}
				break;
			case 3: {
				System.out.println("Enter the House Size(1BHK,2BHK,3BHK) to find the houses :");
				String houseSize = sc.next();
				displayHousesBasedOnHouseSize(houseSize, houses);
			}
				break;
			case 4: {
				System.out.println("Enter the house Type (Apartment/Individual House) :");
				String houseType = sc.next();
				displayHousesBasedOnhouseType(houseType, houses);
			}
				break;
			case 5: {
				int innerChoice;
				do {
					System.out.println(
							"1.Based on Type ( 1BHK, 2BHK, 3BHK )\n2.Based on Rent or Sale\n3.Based on First based on Type and then based on Rent or Sale\n4.exit");
					System.out.println("Enter your choice : ");
					innerChoice = intValidate();
					switch (innerChoice) {
					case 1: {
						System.out.println("Enter the House Size(1BHK,2BHK,3BHK) to find the houses :");
						String houseSize = sc.next();
						displayHousesBasedOnHouseSize(houseSize, houses);
					}
						break;
					case 2: {
						System.out.println("Enter the sale type to find the houses(Tolet/sale) :");
						String saleType = sc.next();
						displayHousesBasedOnSaleType(saleType, houses);
					}
						break;
					case 3: {
						System.out.println("Enter the House Size(1BHK,2BHK,3BHK) to find the houses :");
						String houseSize = sc.next();
						System.out.println("Enter the sale type to find the houses(Tolet/sale) :");
						String saleType = sc.next();
						displayHousesBasedOnHouseSizeAndSaleType(houseSize, saleType, houses);
					}
						break;
					case 4: {
						System.out.println("Thank you!");
					}
						break;
					default: {
						System.out.println("Invalid Input");
					}
					}
				} while (innerChoice != 4);

			}
				break;
			case 6: {
				System.out.println("Thank you :");
			}
				break;
			default: {
				System.out.println("Invalid Input :");
			}
			}
		} while (choice != 6);

	}

	private static void displayHousesBasedOnHouseSizeAndSaleType(String houseSize, String saleType,
			RealState[] houses) {
		int ApartmentCount = 0;
		int individualHouseCount = 0;
		for (int i = 0; i < houses.length; i++) {
			if (houses[i].getHouseSize().compareToIgnoreCase(houseSize) == 0
					&& houses[i].getSaleType().compareToIgnoreCase(saleType) == 0) {
				if (houses[i].getHouseType().compareToIgnoreCase("Apartment") == 0) {
					ApartmentCount++;
				}
				if (houses[i].getHouseType().compareToIgnoreCase("Individual House") == 0) {
					individualHouseCount++;
				}
			}
		}
		System.out.println("Apartment\tIndividual House");
		System.out.println(ApartmentCount + "\t\t" + individualHouseCount);
	}

	private static void displayHousesBasedOnhouseType(String houseType, RealState[] houses) {
		int count1Bhk = 0;
		int count2Bhk = 0;
		int count3Bhk = 0;
		for (int i = 0; i < houses.length; i++) {
			if (houseType.compareToIgnoreCase(houses[i].getHouseType()) == 0) {
				if (houses[i].getHouseSize().compareToIgnoreCase("1bhk") == 0) {
					count1Bhk++;
				}
				if (houses[i].getHouseSize().compareToIgnoreCase("2bhk") == 0) {
					count2Bhk++;
				}
				if (houses[i].getHouseSize().compareToIgnoreCase("3bhk") == 0) {
					count3Bhk++;
				}
			}
		}
		System.out.println("House Size\tTotal Houses");
		System.out.println("1BHK\t\t" + count1Bhk);
		System.out.println("2BHK\t\t" + count2Bhk);
		System.out.println("3BHK\t\t" + count3Bhk);

	}

	private static void displayHousesBasedOnHouseSize(String houseSize, RealState[] houses) {
		int rentCount = 0;
		int saleCount = 0;
		for (int i = 0; i < houses.length; i++) {
			if (houseSize.compareToIgnoreCase(houses[i].getHouseSize()) == 0) {
				if (houses[i].getSaleType().compareToIgnoreCase("ToLet") == 0)
					;
				{
					rentCount++;
				}
				if (houses[i].getSaleType().compareToIgnoreCase("Sale") == 0)
					;
				{
					saleCount++;
				}
			}
		}
		System.out.println("Tolet\tSale");
		System.out.println(rentCount + "\t\t" + saleCount);

	}

	private static void displayHousesBasedOnSaleType(String saleType, RealState[] houses) {
		int count1Bhk = 0;
		int count2Bhk = 0;
		int count3Bhk = 0;
		for (int i = 0; i < houses.length; i++) {
			if (saleType.compareToIgnoreCase(houses[i].getSaleType()) == 0) {
				if (houses[i].getHouseSize().compareToIgnoreCase("1bhk") == 0) {
					count1Bhk++;
				}
				if (houses[i].getHouseSize().compareToIgnoreCase("2bhk") == 0) {
					count2Bhk++;
				}
				if (houses[i].getHouseSize().compareToIgnoreCase("3bhk") == 0) {
					count3Bhk++;
				}
			}
		}
		System.out.println("House Size\tTotal Houses");
		System.out.println("1BHK\t\t" + count1Bhk);
		System.out.println("2BHK\t\t" + count2Bhk);
		System.out.println("3BHK\t\t" + count3Bhk);

	}

	private static RealState[] addDetails(String saleType, String houseSize, String houseType, RealState[] houses) {
		RealState res[] = new RealState[houses.length + 1];
		for (int i = 0; i < houses.length; i++) {
			res[i] = houses[i];
		}
		res[houses.length] = new RealState(saleType, houseSize, houseType);
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

}

