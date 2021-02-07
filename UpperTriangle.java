import java.util.Scanner;

public class UpperTriangle {

	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter size of matrix :");
		int size=scanner.nextInt();
		int array[][]=new int[size][size];
        array=getArrayElements(array);
        System.out.println("Upper triangle :");
        for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if(i>j) {
					array[i][j]=0;
					System.out.print(array[i][j]+" ");
				}else {
					System.out.print(array[i][j]+" ");
				}
				
			}
			System.out.println();
		}
	}
	private static int[][] getArrayElements(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
			    array[i][j]=scanner.nextInt();
			}
		}
		return array;
	}

}
