package ctci.problems;

/*
 * This algorithm will test if two strings are
 * permutations of each other. The comparison is
 * case sensitive. The running time of the algorithm
 * is O(n)
 */
public class StringPermutation {

	private static boolean checkPermutation(String s, String t) {
		if(s == null || t == null) {
			return false;
		}
		if (s.length() != t.length()) {
			return false;
		}
		// Assuming ASCII character set
		int[] letters = new int[128];
		for(int i = 0; i < s.length(); i++) {
			letters[s.charAt(i)]++;
		}
		for(int i = 0; i < t.length(); i++) {
			letters[t.charAt(i)]--;
			if(letters[t.charAt(i)] < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(checkPermutation("computer", "terupcom"));
	}

}
