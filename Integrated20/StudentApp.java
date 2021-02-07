package com.mind.Integrated20;

import java.util.Scanner;

public class StudentApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Student[] details = {};
		int choice;
		do {
			System.out.println("1.Add Student\n2.Display options\n3.Exit\nEnter your choice : ");
			choice = intValidate();
			switch (choice) {
			case 1: {
				details=addStudents(details);
			}
				break;
			case 2: {
				display(details);
			}
				break;
			case 3: {
				System.out.println("Thank you !");
			}
				break;
			default: {
				System.out.println("Invalid option !");
			}
			}
		} while (choice != 3);

	}

	private static void display(Student[] details) {
		int choice;
		do {
			System.out.println(
					"1.Display Students grade\n2. Display student details sorted with branch. For same branch, sort in descending\r\n"
							+ "order with Student Id\n3.Exit\nEnter your choice : ");
			choice = intValidate();
			switch (choice) {
			case 1: {
				displayStudentsGrades(details);
			}
				break;
			case 2: {
				sortDetails(details);
			}
				break;
			case 3: {
				System.out.println("Thank you !");
			}
				break;
			default: {
				System.out.println("Invalid option !");
			}
			}
		} while (choice != 3);
	}

	private static void sortDetails(Student[] details) {
		Student sortedByBranch[] = insertionSortByBranch(details);
		Student sortedById[] = insertionSortById(sortedByBranch);
		displayDetails(sortedById);

	}

	private static Student[] insertionSortById(Student[] details) {
		for (int i = 1; i < details.length; i++) {
			Student key = details[i];
			int j = i - 1;
			while (j >= 0 && details[j].getId() < key.getId()) {
				details[j + 1] = details[j];
				j = j - 1;
			}
			details[j + 1] = key;
		}

		return details;
	}

	private static Student[] insertionSortByBranch(Student[] details) {
		for (int i = 1; i < details.length; i++) {
			Student key = details[i];
			int j = i - 1;
			while (j >= 0 && details[j].getBranch().compareToIgnoreCase(key.getBranch()) > 0) {
				details[j + 1] = details[j];
				j = j - 1;
			}
			details[j + 1] = key;
		}

		return details;
	}

	private static void displayDetails(Student[] details) {
		System.out.println("ID\t\tName\t\tBranch\t\tGrade");
		for (int i = 0; i < details.length; i++) {
			System.out.println(details[i].getId() + "\t\t" + details[i].getName() + "\t\t" + details[i].getBranch());
		}

	}

	private static void displayStudentsGrades(Student[] details) {
		System.out.println("ID\t\tName\t\tBranch\t\tGrade");
		for (int i = 0; i < details.length; i++) {
			char grade = getGrade(details[i]);
			System.out.println(details[i].getId() + "\t\t" + details[i].getName() + "\t\t" + details[i].getBranch()
					+ "\t\t" + grade);
		}

	}

	private static char getGrade(Student student) {
		double totalMarks = 0;
		for (int i = 0; i < student.getMarks().length; i++) {
			totalMarks += student.getMarks()[i];
		}
		double avg = totalMarks / student.getMarks().length;
		char grade = calculateGrade(avg);
		return grade;
	}

	private static char calculateGrade(double avg) {
		char grade = 'A';
		if (avg >= 80) {
			grade = 'B';
		} else if (avg >= 60 && avg < 80) {
			grade = 'C';
		} else if (avg >= 40 && avg < 60) {
			grade = 'A';
		} else {
			grade = 'D';
		}
		return grade;
	}

	private static Student[] addStudents(Student[] details) {
		System.out.println("Enter Student Id : ");
		int id = intValidate();
		System.out.println("Enter Student Name : ");
		String name = sc.next();
		System.out.println("Enter Student Branch : ");
		String branch = sc.next();
		int[] marks = getmarks();
		Student studentDetails=new Student(id, name, branch, marks);
		details = addStudent(studentDetails, details);
		return details;
	}

	private static Student[] addStudent(Student studentDetails, Student[] details) {
		Student res[] = new Student[details.length + 1];
		for (int i = 0; i < details.length; i++) {
			res[i] = details[i];
		}
		res[details.length] = studentDetails;
		return res;
	}
	private static int[] getmarks() {
		int[] marks = new int[3];
		System.out.println("Enter Student Marks: ");
		for (int i = 0; i < marks.length; i++) {
			System.out.println("Enter subject " + (i + 1) + " marks : ");
			marks[i] = sc.nextInt();
		}
		return marks;
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

