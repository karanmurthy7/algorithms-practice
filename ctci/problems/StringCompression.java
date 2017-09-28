package ctci.problems;

import java.util.Scanner;

/*
 * This algorithm performs basic string compression using
 * the counts of repeated characters. If the compressed
 * string is not smaller than the original string, then it 
 * returns the original string.
 * 
 * For example,
 * Input: kkkaaarraaaann
 * Output: k3a3r2a4n2
 */
public class StringCompression {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string you want to compress: ");
		String str = scanner.next();
		System.out.println("The compressed string is : " + compressString(str));
		scanner.close();
	}

	private static String compressString(String str) {
		int countConsecutive = 0;
		StringBuilder compressedString = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressedString.append(str.charAt(i));
				compressedString.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressedString.length() < str.length() ? compressedString.toString() : str;
	}

}
