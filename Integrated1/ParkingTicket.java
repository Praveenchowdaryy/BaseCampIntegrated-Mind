package com.mind.Integrated1;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ParkingTicket {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Parking[] parkingDetails = new Parking[100];
		String vehicalNumber = "";
		String entryTime = "";
		boolean isParkingAvailable[] = new boolean[100];
		for (int i = 0; i < isParkingAvailable.length; i++) {
			parkingDetails[i] = new Parking();
			parkingDetails[i].setParkingAvailable(true);
			parkingDetails[i].setEntryTime("null");
			parkingDetails[i].setExitTime("null");
			parkingDetails[i].setVehicalNumber("null");
		}
		int choice;
		do {

			System.out.println(
					"\nenter your choice \n 1. Check for the available parking \n 2.  Enter the vehicle number coming in for parking \n 3.  Enter the entry time of a vehicle \n 4.  allocate the empty slot for parking \n 5.  Exit calculate the parking fee \n 6. exit ");

			choice = intValidate();
			if (choice > 2 && choice < 5) {
				System.out.println("We need Raw Details to take you to the advanced steps :\n");
				choice = 2;
			}
			switch (choice) {
			case 1: {
				System.out.println("Parking is available at locations are :");
				for (int i = 0; i < isParkingAvailable.length; i++) {
					if (parkingDetails[i].isParkingAvailable() == true) {
						System.out.print(i + ", ");
					}
				}
			}
				break;
			case 2: {
				if (parkingDetails[parkingDetails.length - 1].isParkingAvailable() == false) {
					System.out.println("No Parking Space Available !");
				} else {
					System.out.println("Enter the vehical number :");
					vehicalNumber = sc.next();
					boolean isPresent = findVehical(vehicalNumber, parkingDetails);
					while (isPresent) {
						System.out.println("Enter the valid vehical number :");
						vehicalNumber = sc.next();
						isPresent = findVehical(vehicalNumber, parkingDetails);
					}
				}
			}

			case 3: {
				if (parkingDetails[parkingDetails.length - 1].isParkingAvailable() == false) {
					System.out.println("No Parking Space Available !");
				} else {
					if (vehicalNumber.length() == 0) {
						System.out.println("Please enter the vehical number first :");
						vehicalNumber = sc.next();
					} else {
						System.out.println("Please enter the vehical Entry time in 24 Hours Formate(HH:MM) :");
						entryTime = sc.next();
						entryTime = timeLengthValidate(entryTime);
						String entryHour = "";
						entryHour += entryTime.charAt(0);
						entryHour += entryTime.charAt(1);
						String entryMinute = "";
						entryMinute += entryTime.charAt(3);
						entryMinute += entryTime.charAt(4);
						int entryHours = ConvertToInteger(entryHour);
						int entryMinutes = ConvertToInteger(entryMinute);
						boolean isValidTime = timeValidate(entryHours, entryMinutes);
						if (isValidTime) {
							continue;
						}

					}
				}

			}

			case 4: {
				parkingDetails = allocateSlot(vehicalNumber, entryTime, parkingDetails);
				int slotId=getSlotId(vehicalNumber,parkingDetails);
				System.out.println("your Parking Slot is been allocated Successfully \n\nSlot ID : "+slotId);
			}
				break;
			case 5: {
				System.out.println("Enter the vehical number :");
				String tempVehicalNum = sc.next();
				boolean isVehicalFound = findVehical(tempVehicalNum, parkingDetails);
				if (isVehicalFound) {
					double bill = calculateBill(tempVehicalNum, parkingDetails);
					System.out.println("your bill for parking is rupees : " + bill);
				} else {
					System.out.println("Vehical not Found !");
				}

			}
				break;
			case 6: {
				System.out.println("Thank you !");
			}
				break;
			default: {
				System.out.println("Invalid Input : ");
			}
			}
		} while (choice != 6);

	}

	private static int getSlotId(String vehicalNumber, Parking[] parkingDetails) {
		int slotId=0;
		for (int i = 0; i < parkingDetails.length; i++) {
			if (vehicalNumber.compareTo(parkingDetails[i].getVehicalNumber()) == 0) {
				slotId=i;
			}
		}
		return slotId;
	}

	private static boolean timeValidate(int Hours, int Minutes) {
		boolean isTimeValid = false;
		while ((Hours > 24 && Minutes > 60) && (Hours <= 0 && Minutes <= 0)) {
			System.out.println("Enter a Valid Time");
			String entryTime = sc.next();
			entryTime = timeLengthValidate(entryTime);
			String entryHour = "";
			entryHour += entryTime.charAt(0);
			entryHour += entryTime.charAt(1);
			String entryMinute = "";
			entryMinute += entryTime.charAt(3);
			entryMinute += entryTime.charAt(4);
			Hours = ConvertToInteger(entryHour);
			Minutes = ConvertToInteger(entryMinute);
			isTimeValid = true;
		}
		return isTimeValid;
	}

	private static double calculateBill(String tempVehicalNum, Parking[] parkingDetails) {
		double totalBill = 0;
		for (int i = 0; i < parkingDetails.length; i++) {
			if (parkingDetails[i].getVehicalNumber().compareTo(tempVehicalNum) == 0) {
				String entryTime = parkingDetails[i].getEntryTime();
				String entryHour = getTimeHour(entryTime);
				String entryMinute = getTimeMinute(entryTime);
				int entryHours = ConvertToInteger(entryHour);
				int entryMinutes = ConvertToInteger(entryMinute);
				if (entryMinutes == 60) {
					entryMinutes = 0;
					entryHours += 1;
				}
				LocalDateTime date = LocalDateTime.now();
				int exitHours = date.getHour();
				int totalHour = exitHours - entryHours;

				if (totalHour < 2) {
					totalBill = 50;
				} else {
					totalBill = 50 + (30 * (totalHour - 2));
				}
				parkingDetails[i].setParkingAvailable(true);
			}
		}
		return totalBill;
	}

	private static String getTimeMinute(String entryTime) {
		String minute = "";
		minute += entryTime.charAt(3);
		minute += entryTime.charAt(4);
		return minute;
	}

	private static String getTimeHour(String entryTime) {
		String hour = "";
		hour += entryTime.charAt(0);
		hour += entryTime.charAt(1);
		return hour;
	}

	private static boolean findVehical(String tempVehicalNum, Parking[] parkingDetails) {
		boolean found = false;
		for (int i = 0; i < parkingDetails.length; i++) {
			if (tempVehicalNum.compareTo(parkingDetails[i].getVehicalNumber()) == 0) {
				found = true;
			}
		}

		return found;
	}

	private static Parking[] allocateSlot(String vehicalNumber, String entryTime, Parking[] parkingDetails) {
		for (int i = 0; i < parkingDetails.length; i++) {
			if (parkingDetails[i].isParkingAvailable() == true) {
				parkingDetails[i].setVehicalNumber(vehicalNumber);
				parkingDetails[i].setEntryTime(entryTime);
				parkingDetails[i].setParkingAvailable(false);
				break;
			}
		}
		return parkingDetails;
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

	private static int ConvertToInteger(String string) {
		int num = 0;
		for (int i = 0; i < string.length(); i++) {
			num = num * 10 + ((int) string.charAt(i) - 48);
		}
		return num;
	}

	private static String timeLengthValidate(String time) {
		while ((time.length() != 5)) {
			System.out.println("Enter the valid time (HH:MM) :");
			time = sc.next();
		}
		while(time.charAt(2) != ':')
		{
			System.out.println("Enter the valid time (HH:MM) :");
			time = sc.next();
		}
		return time;
	}

}

