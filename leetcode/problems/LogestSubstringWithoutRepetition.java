package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 * "pwke" is a subsequence and not a substring.
 */
public class LogestSubstringWithoutRepetition {

	public static int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		int n = s.length();
		int i = 0, j = 0;
		Set<Character> charSet = new HashSet<Character>();
		while(i < n && j < n) {
			if(!charSet.contains(s.charAt(j))) {
				charSet.add(s.charAt(j++));
				maxLength = Math.max(maxLength, j-i);
			}else {
				charSet.remove(s.charAt(i++));		
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		String s = "dvdf";
		System.out.println(lengthOfLongestSubstring(s));
	}

}
