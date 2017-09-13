package hackerrank.problems;

import java.util.Scanner;

/*
 * Code to check whether a string is a palindrome
 * without using additional space.
 */
public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String word = scanner.next();
		boolean isPalindrome = checkPalindrome(word);
		if(isPalindrome){
			System.out.println("Word : " + word + " is a palindrome !");
		}else{
			System.out.println("Word : " + word + " is not a palindrome !");
		}
		scanner.close();
	}

	private static boolean checkPalindrome(String word) {
		int i = 0, j = word.length()-1;
		while(i < j){
			if(word.charAt(i) != word.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

}
