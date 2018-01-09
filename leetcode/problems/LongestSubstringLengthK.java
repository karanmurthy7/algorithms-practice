package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * Given a string, find the length of the longest substring T that contains at most k distinct characters. 
 * For example, Given s = “eceba” and k = 2, 
 * T is "ece" which its length is 3.
 * 
 */
public class LongestSubstringLengthK {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int bestLength = 0;
        int left = 0;
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        	while(charMap.size() > k) {
        		c = s.charAt(left);
        		charMap.put(c, charMap.get(c) - 1);
        		if(charMap.get(c) == 0) {
        			charMap.remove(c);
        		}
        		left++;
        	}
        	bestLength = Math.max(bestLength, i - left + 1);
        }
    	return bestLength;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstringKDistinct("abcdaad", 3));
	}

}
