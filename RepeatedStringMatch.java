package leetcode.problems;

/*
 * Given two strings A and B, find the minimum number of times A has to be repeated such 
 * that B is a substring of it. If no such solution, return -1.
 * For example, with A = "abcd" and B = "cdabcdab". 
 * Return 3, because by repeating A three times (“abcdabcdabcd”), 
 * B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 */
public class RepeatedStringMatch {

	public static int repeatedStringMatch(String A, String B) {
	 	StringBuilder sb = new StringBuilder(A);
			int repetitionCount = 1;
			
			while(sb.length() <= B.length() + 2*A.length()) {
				if (sb.indexOf(B) != -1) {
					return repetitionCount;
				}
				sb.append(A);
				repetitionCount++;
			}
			return -1;
	}


	public static void main(String[] args) {
		System.out.println(repeatedStringMatch("a", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));

	}

}
