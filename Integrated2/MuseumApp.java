package com.mind.Integrated2;

import java.util.Scanner;

public class MuseumApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Museum visitors[] = {};

		int choice;
		do {
			
			System.out.println(
					"1.Add Visitors\n2.Calculate the entry fee\n3. fetch the number of visitors to the museum per day\n4. fetch the number of visitors of a range of age\n5. fetch the ratio of female vs male visitors\n6.fetch the total earning per day from the museum fee\n7.Exit");
			System.out.println("Enter the Choice :");
			choice = intValidate();

			switch (choice) {
			case 1: {
				System.out.println("Enter the name :");
				String name = sc.next();
				name = stringValidate(name);
				System.out.println("Enter the age:");
				int age = intValidate();
				age = ageValidate(age);
				System.out.println("Enter the gender : ");
				String gender = sc.next();
				gender = genderValidate(gender);
				visitors = addDetails(name, age, gender, visitors);
			}
				break;
			case 2: {
				System.out.println("i) Age < 5 yrs, NIL\n" + "ii) Age 5 - 18 yrs, Rs 10\n"
						+ "iii) Age 18-60 yrs, Rs 20\n" + "iv) Age above 60 yrs, Rs 5\n");
				visitors = calculateEntryFee(visitors);

			}
				break;
			case 3: {
				System.out.println("Number of visitors :" + visitors.length);

			}
				break;
			case 4: {
				System.out.println("Enter the from age : ");
				int fromAge = intValidate();
				fromAge = ageValidate(fromAge);
				System.out.println("Enter the to age : ");
				int toAge = intValidate();
				toAge = ageValidate(toAge);
				boolean ifTrue = ageRangeValidate(fromAge, toAge);
				if (ifTrue) {
					int NumberOfVisitorsBasedOnAge = getNumberOfVisitors(fromAge, toAge, visitors);
					System.out.println("Number of Visitors based on age are : " + NumberOfVisitorsBasedOnAge);
				}
			}
				break;
			case 5: {
				String maleToFemaleRatio = getMaleFemaleRatio(visitors);
				System.out.println("maleToFemaleRatio :" + maleToFemaleRatio);

			}
				break;
			case 6: {
				double totalEarnings = getTotalEarnings(visitors);
				System.out.println("totalEarnings per day : " + totalEarnings);
			}
				break;
			case 7: {
				System.out.println("Thank you!");
			}
				break;
			default: {
				System.out.println("Invalid input !");
			}
			}

		} while (choice != 7);
	}

	private static double getTotalEarnings(Museum[] visitors) {
		double totalEarnings = 0;
		for (int i = 0; i < visitors.length; i++) {
			totalEarnings += visitors[i].getEntryFee();
		}
		return totalEarnings;
	}

	private static String getMaleFemaleRatio(Museum[] visitors) {
		int maleCount = 0;
		int femaleCount = 0;
		for (int i = 0; i < visitors.length; i++) {
			if (visitors[i].getGender().compareToIgnoreCase("male") == 0) {
				maleCount++;
			} else {
				femaleCount++;
			}
		}
		int maleRatio = (int)(maleCount / femaleCount);
		int femaleRatio =(int) (femaleCount / maleCount);
		String maleToFemaleRatio = "";
		maleToFemaleRatio += maleRatio + " : ";
		maleToFemaleRatio += femaleRatio;
		return maleToFemaleRatio;
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

	private static int getNumberOfVisitors(int fromAge, int toAge, Museum[] visitors) {
		int count = 0;
		for (int i = 0; i < visitors.length; i++) {
			if (visitors[i].getAge() >= fromAge && visitors[i].getAge() <= toAge) {
				count++;
			}
		}
		return count;
	}

	private static Museum[] calculateEntryFee(Museum[] visitors) {
		for (int i = 0; i < visitors.length; i++) {
			if (visitors[i].getAge() < 5) {
				visitors[i].setEntryFee(0);
			} else if (visitors[i].getAge() >= 5 && visitors[i].getAge() < 18) {
				visitors[i].setEntryFee(10);
			} else if (visitors[i].getAge() >= 18 && visitors[i].getAge() < 60) {
				visitors[i].setEntryFee(20);
			} else if (visitors[i].getAge() >= 60) {
				visitors[i].setEntryFee(5);
			}
		}
		return visitors;
	}

	private static Museum[] addDetails(String name, int age, String gender, Museum[] visitors) {
		//new Museum();
		Museum res[] = new Museum[visitors.length + 1];
		for (int i = 0; i < visitors.length; i++) {
			res[i] = visitors[i];
		}
		res[visitors.length] = new Museum(name, age, gender);
		return res;
	}

	private static String genderValidate(String gender) {
		while (!(gender.compareToIgnoreCase("male") == 0 || gender.compareToIgnoreCase("female") == 0)) {
			System.out.println("Enter the valid Gender : ");
			gender = sc.next();
			gender = genderValidate(gender);
		}
		return gender;
	}

	private static int ageValidate(int age) {
		while (age < 1 || age > 100) {
			System.out.println("Enter the valid age : ");
			age = intValidate();
		}
		return age;
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

	private static String stringValidate(String data) {
		int i = 0;
		while (i < data.length()) {
			if (!(data.charAt(i) >= 65 && data.charAt(i) <= 122) && !(data.charAt(i) >= 91 && data.charAt(i) <= 96)) {
				if (!data.isEmpty()) {
					System.out.println("Please retype the alphabetical string");
				}
				data = sc.nextLine();
			}
			i++;
		}
		return data;
	}

}

