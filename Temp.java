import java.util.Scanner;

public class Temp {

	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		int number=scanner.nextInt();
		for (int i = 0; i <=number; i++) {
			System.out.print(i);
			for (int j = 1; j <=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
