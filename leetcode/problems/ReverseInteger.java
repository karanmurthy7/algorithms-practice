package leetcode.problems;

/*
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * The input is assumed to be a 32-bit signed integer.
 * Function should return 0 when the reversed integer overflows.
 */
public class ReverseInteger {

	public static int reverse(int x) {
		long reversedValue = 0;
		int tempNum = x;
		boolean isNegative = false;

		if (tempNum < 0) {
			tempNum *= -1;
			isNegative = true;
		}
		while (tempNum > 0) {
			int modVal = tempNum % 10;
			tempNum = tempNum / 10;
			reversedValue += modVal;
			if (tempNum != 0) {
				reversedValue *= 10;
			}
		}
		// Handling overflow condition here
		reversedValue = reversedValue > Integer.MAX_VALUE ? 0 : reversedValue;

		reversedValue = isNegative ? reversedValue * -1 : reversedValue;
		return (int) reversedValue;
	}

	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
	}

}
