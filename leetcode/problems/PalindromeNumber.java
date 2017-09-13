package leetcode.problems;

/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {

	public static boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0)) {
			return false;
		}
		int n = 1;
		while (x / n >= 10) {
			n *= 10;
		}
		while (n > 1) {
			if (x / n != x % 10) {
				return false;
			}
			x = (x % n) / 10;
			n /= 100;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
	}

}
