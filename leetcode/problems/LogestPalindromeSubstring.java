package leetcode.problems;

/*
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 * 
 * Example:
 * Input: "babad"
 * 
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer.
 */
public class LogestPalindromeSubstring {

	public static String longestPalindrome(String s) {
		int length = s.length();
		int startsAt = 0;
		int maxPalindromeLength = 1;
		boolean palindromeTable[][] = new boolean[length][length];

		// One character palindromes
		for (int i = 0; i < length; i++) {
			palindromeTable[i][i] = true;
		}

		// Two character palindromes
		for (int i = 0; i < length - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				palindromeTable[i][i + 1] = true;
				startsAt = i;
				maxPalindromeLength = 2;
			}
		}

		// Three or more character palindromes
		for (int currLen = 3; currLen <= length; currLen++) {
			for (int i = 0; i < length - currLen + 1; i++) {
				int j = i + currLen - 1;
				if (s.charAt(i) == s.charAt(j) && palindromeTable[i + 1][j - 1]) {
					if (currLen > maxPalindromeLength) {
						maxPalindromeLength = currLen;
						startsAt = i;
					}
					palindromeTable[i][j] = true;
				}
			}
		}

		return s.substring(startsAt, startsAt + maxPalindromeLength);
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("tbccbgffwwff"));
	}

}
