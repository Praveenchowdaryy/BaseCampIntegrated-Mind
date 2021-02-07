import java.util.Scanner;

public class Demo {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter size :");
		int size=sc.nextInt();
		String strings[][]=new String[size][size];
		strings=getStrings(strings);
		if(checkStrings(strings)) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}

	}
	private static boolean checkStrings(String[][] strings) {
		int k=0;
		int count=0;
		for (int i = 0; i < strings.length; i++) {
			if(checkTemp(strings[k][i],strings)) {
				count++;
			}
		}
		if(count==strings.length) {
			return true;
		}
		return false;
	}
	private static boolean checkTemp(String string, String[][] strings) {
		int count=0;
		int flag=0;
		for (int i = 1; i < strings.length; i++) {
			for (int j = 0; j < strings.length; j++) {
				if(string==strings[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	private static String[][] getStrings(String[][] strings) {
		for (int i = 0; i < strings.length; i++) {
			for (int j = 0; j < strings.length; j++) {
				strings[i][j]=sc.nextLine();
			}
		}
		return strings;
	}

}
