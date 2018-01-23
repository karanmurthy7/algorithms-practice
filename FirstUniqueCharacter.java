package leetcode.problems;

/*
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * s = "leetcode"
 * return 0.
 * s = "loveleetcode",
 * return 2.
 * 
 */
public class FirstUniqueCharacter {

    public static int firstUniqChar(String s) {
    	int [] counts = new int[256];
    	for (int i = 0; i < s.length(); i++) {
    		counts[s.charAt(i)]++;
    	}
    	for (int i = 0; i < s.length(); i++) {
    		if(counts[s.charAt(i)] == 1)
    			return i;
    	}
        return -1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstUniqChar("loveleetcode"));
	}

}
