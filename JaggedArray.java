import java.util.Scanner;

public class JaggedArray {

	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		int[][] twoDimenArray = new int[2][];
		twoDimenArray[0] = new int[3];
		twoDimenArray[1] = new int[4];

		int counter = 0;
		for (int row = 0; row < twoDimenArray.length; row++) {

			for (int col = 0; col < twoDimenArray[row].length; col++) {
				twoDimenArray[row][col] = counter++;
			}
		}
		for (int row = 0; row < twoDimenArray.length; row++) {
			System.out.println();
			for (int col = 0; col < twoDimenArray[row].length; col++) {
				System.out.print(twoDimenArray[row][col] + " ");
			}
		}

	}
	

}
