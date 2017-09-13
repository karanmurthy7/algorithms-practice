package leetcode.problems;

/*
 * Write a function that takes a string as input and returns the string reversed.
 */
public class StringReverse {

	public static String reverseString(String s) {
		if (s == null) {
			return s;
		}
		int length = s.length();
		StringBuffer output = new StringBuffer(length);

		for (int i = length - 1; i >= 0; i--) {
			output.append(s.charAt(i));
		}
		return output.toString();
	}

	public static void main(String[] args) {
		System.out.println(reverseString("karan"));
	}

}
