package ctci.problems;

/*
 * This algorithm will determine whether a string has all unique 
 * characters without using additional data structures.
 */
public class StringUniqueCharacters {

	public static boolean isUniqueChars(String str) {
		if (str == null) {
			return false;
		}
		if (str.length() > 128) {
			return false;
		}
		boolean[] char_set = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			// If this is true, then we must have already
			// found this character.
			if (char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isUniqueChars("Tulip"));

	}

}
