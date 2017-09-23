package ctci.problems;

import java.util.Scanner;

/*
 * An algorithm to replace all spaces in a string with '%20'.
 * You are given the true length of the string.
 * You may assume that the string has sufficient space in the end to hold additional
 * characters.
 * 
 * For ex.
 * Input: "Mr Karan Murthy    ", 15
 * Output: "Mr%20Karan%20Murthy"
 */
public class URKLify {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string with spaces and its true length.");
		String str = scanner.nextLine();
		int trueLength = scanner.nextInt();
		String output = replaceSpaces(str.toCharArray(), trueLength);
		System.out.println("The string with spaces replaced with %20 is : " + output);
		scanner.close();
	}

	private static String replaceSpaces(char[] charArray, int trueLength) {
		int numOfSpaces = 0;
		for (int i = 0; i < trueLength; i++) {
			if (charArray[i] == ' ') {
				numOfSpaces++;
			}
		}
		int index = trueLength + numOfSpaces * 2;
		for (int i = trueLength - 1; i >= 0; i--) {
			if (charArray[i] == ' ') {
				charArray[index - 1] = '0';
				charArray[index - 2] = '2';
				charArray[index - 3] = '%';
				index -= 3;
			} else {
				charArray[index - 1] = charArray[i];
				index -= 1;
			}
		}	
		return String.valueOf(charArray);
	}

}
