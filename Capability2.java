import java.util.Scanner;

public class Capability2 {

	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter size of array :");
		int size=scanner.nextInt();
		scanner.nextLine();
		String stringArray[][]=getStringArray(size);
		stringArray=getStringWithOutVowel(stringArray);
		stringArray=getArrayCapital(stringArray);
		stringArray=getChangeFirst(stringArray);
		String singleArray[]=getSingleArray(stringArray);
        for (int i = 0; i < singleArray.length; i++) {
			System.out.print(singleArray[i]+" ");
			
		}

	}
	private static String[] getSingleArray(String[][] stringArrayFirst) {
		String temp[]=new String[stringArrayFirst.length*stringArrayFirst.length];
		int k=0;
		for (int i = 0; i < stringArrayFirst.length; i++) {
			for (int j = 0; j < stringArrayFirst.length; j++) {
				temp[k]=stringArrayFirst[i][j];
				k++;
			}
		}
		return temp;
	}
	private static String[][] getChangeFirst(String[][] stringArrayCapital) {
		String temp[][]=new String[stringArrayCapital.length][stringArrayCapital.length];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				temp[i][j]=getFirstChange(stringArrayCapital[i][j]);
			}
		}
		return temp;
	}
	private static String getFirstChange(String string) {
		String flag="";
		for (int i = 0; i < string.length(); i++) {
			char ch=string.charAt(i);
			if(i==0) {
				ch=(char)(ch+1);
			}
			flag+=ch;
		}
		return flag;
	}
	private static String[][] getArrayCapital(String[][] stringArrayWithOutVowel) {
		String temp[][]=new String[stringArrayWithOutVowel.length][stringArrayWithOutVowel.length];
		for (int i = 0; i < stringArrayWithOutVowel.length; i++) {
			for (int j = 0; j < stringArrayWithOutVowel.length; j++) {
				temp[i][j]=getCapital(stringArrayWithOutVowel[i][j]);
			}
		}
		return temp;
	}
	private static String getCapital(String string) {
		String flag="";
		for (int i = 0; i < string.length(); i++) {
			char ch=string.charAt(i);
			if(ch>=97 && ch<=122) {
				ch=(char)(ch-32);
				flag+=ch;
			}
		}
		return flag;
	}
	private static String[][] getStringWithOutVowel(String[][] stringArray) {
		String temp[][]=new String[stringArray.length][stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			for (int j = 0; j < stringArray.length; j++) {
				temp[i][j]=getWithOutV(stringArray[i][j]);
			}
		}
		return temp;
	}
	private static String getWithOutV(String sentance) {
		String flag="";
		for (int i = 0; i < sentance.length(); i++) {
			if (sentance.charAt(i) == 'a' || sentance.charAt(i) == 'e' || sentance.charAt(i) == 'i'
					|| sentance.charAt(i) == 'o' || sentance.charAt(i) == 'u' || sentance.charAt(i) == 'A'
					|| sentance.charAt(i) == 'E' || sentance.charAt(i) == 'I' || sentance.charAt(i) == 'O'
					|| sentance.charAt(i) == 'U') {
				
			}else {
				flag=flag+sentance.charAt(i);
			}
		}
		return flag;
	}
	private static String[][] getStringArray(int size) {
		String stringArray[][]=new String[size][size];
		
		for (int i = 0; i < stringArray.length; i++) {
			for (int j = 0; j < stringArray.length; j++) {
				stringArray[i][j]=scanner.nextLine();
			}
		}
		return stringArray;
	}

}
