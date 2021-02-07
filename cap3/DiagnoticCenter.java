package com.mind.cap3;

import java.util.Scanner;

public class DiagnoticCenter {

	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		Patient patients[]= {};
		DiagnoticTest tests[]= {};
		boolean temp=true;
		do {
			int choice=getChoice();
			switch(choice) {
			case 1:boolean checkPatient=addPatient(patients);
			       if(checkPatient) {
			    	   System.out.println("Added successfully");
			       }
			       break;
			case 2:boolean checkTest=addTest(tests);
				   if(checkTest) {
					   System.out.println("Added successfully");
				   }
			       break;
			case 3:boolean checkSort=getSort(patients);
			       if(checkSort) {
			    	   System.out.println("sorted successfully");
			       }
			       break;
			case 4:boolean checkSearch=getPatient(patients);
			       if(checkSearch) {
			    	   System.out.println("searched successfully");
			       }
				   break;
			case 5:boolean checkBill=getBill(tests);
			       if(checkBill) {
			    	   System.out.println("Generated successfully");
			       }
			       break;
			case 6:System.out.println("Thank you");
			       temp=false;
			       break;
			       
			}
			
		}while(temp);

	}

	private static boolean addTest(DiagnoticTest[] tests) {
		System.out.println("Enter patient id :");
		int testPatientId = scanner.nextInt();
		System.out.println("Enter test id :");
		int testId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter test name :");
		String testName = scanner.nextLine();
		tests = addTestDetails(testPatientId, testId, testName, tests);
		return true;
	}

	private static boolean addPatient(Patient[] patients) {
		System.out.println("Enter patient id :");
		int patientId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter patient name :");
		String patientName = scanner.nextLine();
		System.out.println("Enter patient address");
		String patientAddress = scanner.nextLine();
		System.out.println("Enter patient ph no :");
		String patientPhno = scanner.nextLine();
		patients = addDetails(patientId, patientName, patientAddress, patientPhno, patients);
		return true;
	}

	private static boolean getBill(DiagnoticTest[] tests) {
		System.out.println("Enter your test id :");
		int billTestId = scanner.nextInt();
		int billIndex = getBillIndex(tests, billTestId);
		System.out.println("Bill details");
		System.out.println("============");
		System.out.println("Patient id :" + tests[billIndex].getTestPatientId());
		System.out.println("Test id :" + tests[billIndex].getTestId());
		System.out.println("Test Name :" + tests[billIndex].getTestName());
		System.out.println("Bill amount :" + tests[billIndex].getBill());
		return true;
	}

	private static boolean getPatient(Patient[] patients) {
		System.out.println("Enter patient name :");
		scanner.nextLine();
		String searchName = scanner.nextLine();
		Patient sortedPatients[] = getSortedPatients(patients);
		int patientIndex = getSearchPatient(sortedPatients, searchName);
		System.out.println("Patient id :" + sortedPatients[patientIndex].getPatientId());
		System.out.println("Patient name:" + sortedPatients[patientIndex].getPatientName());
		System.out.println("Patient address :" + sortedPatients[patientIndex].getPatientAddress());
		System.out.println("Patient Phno :" + sortedPatients[patientIndex].getPatientPhno());
		return true;
	}

	private static boolean getSort(Patient[] patients) {
		System.out.println("Sorting.....");
		Patient sortPatints[] = getSortedPatients(patients);
		for (int i = 0; i < sortPatints.length; i++) {
			System.out.println("Patient id :" + sortPatints[i].getPatientId());
			System.out.println("Patient name:" + sortPatints[i].getPatientName());
			System.out.println("Patient address :" + sortPatints[i].getPatientAddress());
			System.out.println("Patient Phno :" + sortPatints[i].getPatientPhno());
		}
		return true;
	}
	private static int getChoice() {
		System.out.println("Choose option :");
		System.out.println("=============");
		System.out.println("1.Add Patient details");
		System.out.println("2.Add diagnotic test");
		System.out.println("3.sort based on patient id ");
		System.out.println("4.search patient");
		System.out.println("5.Generate test details");
		System.out.println("6.Exit");
		int temp=scanner.nextInt();
		return temp;
	}
	private static int getBillIndex(DiagnoticTest[] tests, int billTestId) {
		for (int i = 0; i < tests.length; i++) {
			if(tests[i].getTestId()==billTestId) {
				return i;
			}
		}
		return 0;
	}
	private static int getSearchPatient(Patient[] patients, String searchName) {
		
		int start=0;
		int last=patients.length;
		int mid=(start+last)/2;
		while(start<=last) {
			if(patients[mid].getPatientName().compareTo(searchName)<0) {
				start=mid+1;
			}else if(patients[mid].getPatientName().compareTo(searchName)>0) {
				return mid;
			}else {
				last=mid-1;
			}
			if(start>last) {
				return 0;
			}
		}
		return 0;
	}
	private static Patient[] getSortedPatients(Patient[] patients) {
		
		for (int i = 0; i < patients.length; i++) {
			Patient temp=patients[i];
			int j=i-1;
			while((j>-1)&& (patients[j].getPatientId()<temp.getPatientId())) {
				patients[j+1]=patients[j];
				j--;
			}
			patients[j+1]=temp;
		}
		return patients;
	}
	private static DiagnoticTest[] addTestDetails(int testPatientId, int testId, String testName,
			DiagnoticTest[] tests) {
		DiagnoticTest res[]=new DiagnoticTest[tests.length+1];
		for (int i = 0; i < tests.length; i++) {
			res[i]=tests[i];
		}
		res[tests.length]=new DiagnoticTest(testPatientId,testId,testName);
		return res;
	}
	private static Patient[] addDetails(int patientId, String patientName, String patientAddress, String patientPhno,
			Patient[] patients) {
		Patient res[]=new Patient[patients.length+1];
		for (int i = 0; i < patients.length; i++) {
			res[i]=patients[i];
		}
		res[patients.length]=new Patient(patientId,patientName,patientAddress,patientPhno);
		return res;
	}

}
