package ctci.problems;

import java.util.Scanner;

/*
 * There are 3 types of edits that can be performed on strings:
 * 1. Insert a character
 * 2. Remove a character
 * 3. Replace a character
 * 
 * The given algorithm returns true if the 2 strings are 1 or 0 edits away.
 * for example:
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bae -> false
 */
public class OneEditAway {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter both strings: ");
		String first = scanner.next();
		String second = scanner.next();
		System.out.println(areStringsOneEditAway(first, second));
		scanner.close();

	}

	private static boolean areStringsOneEditAway(String first, String second) {
		if (first.length() == second.length()) {
			return oneEditReplace(first, second);
		} else if (first.length() == second.length() + 1) {
			return oneEditInsert(first, second);
		} else if (second.length() == first.length() + 1) {
			return oneEditInsert(second, first);
		}
		return false;
	}

	private static boolean oneEditInsert(String longString, String shortString) {
		int i = 0, j = 0;
		boolean foundDifference = false;
		while (i < longString.length() && j < shortString.length()) {
			if (longString.charAt(i) != shortString.charAt(j)) {
				if (foundDifference) {
					return false;
				}
				i++;
				foundDifference = true;
			}
			i++;
			j++;
		}
		return true;
	}

	private static boolean oneEditReplace(String first, String second) {
		boolean foundDifference = false;
		for (int i = 0; i < first.length(); i++) {
			if (first.charAt(i) != second.charAt(i)) {
				if (foundDifference) {
					return false;
				}
				foundDifference = true;
			}
		}
		return true;
	}

}
