package leetcode.problems;

/*
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * 
 * Example 1:
 * Given s = "hello", return "holle".
 * 
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 */
public class ReverseVowels {

	public static String reverseVowels(String s) {
		if (s == null || s.trim() == "") {
			return s;
		}
		int start = 0, end = s.length() - 1;
		char[] strArray = s.toCharArray();
		String vowels = "aeiouAEIOU";

		while (start < end) {
			while (!vowels.contains(strArray[end] + "") && (start < end)) {
				end--;
			}
			while (!vowels.contains(strArray[start] + "") && (start < end)) {
				start++;
			}

			char temp = strArray[start];
			strArray[start] = strArray[end];
			strArray[end] = temp;
			end--;
			start++;
		}
		return String.valueOf(strArray);
	}

	public static void main(String[] args) {
		System.out.println(reverseVowels("hello"));
	}

}
