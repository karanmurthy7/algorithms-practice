package leetcode.problems;

/*
 * 
 * Given a string s and a list of strings dict, you need to add a closed 
 * pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. 
 * If two such substrings overlap, you need to wrap them together by only 
 * one pair of closed bold tag. Also, if two substrings wrapped by bold tags 
 * are consecutive, you need to combine them.
 * 
 * Input: 
 * s = "aaabbcc" 
 * dict = ["aaa","aab","bc"]
 * 
 * Output:
 * "<b>aaabbc</b>c"
 * 
 */
public class AddBoldTagsSolution {

	public static String addBoldTag(String s, String[] dict) {
		int length = s.length();
		boolean[] bold = new boolean[length];
		for (int i = 0, end = 0; i < length; i++) {
			for (String word: dict) {
				if (s.startsWith(word, i)) {
					end = Math.max(end, i + word.length());
				}
			}
			bold[i] = end > i;
		}
		StringBuilder output = new StringBuilder();
		
		for(int i = 0; i < length; i++) {
			if (!bold[i]) {
				output.append(s.charAt(i));
			}else {
				int j = i;
				while(j < length && bold[j]) j++;
				output.append("<b>").append(s.substring(i, j)).append("</b>");
				i = j - 1;
			}
		}
		return output.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] dict = {"aaa","aab","bc"};
		System.out.println(addBoldTag("aaabbcc", dict));
	}

}
