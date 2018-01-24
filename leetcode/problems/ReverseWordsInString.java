package leetcode.problems;

/*
 * 
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * 
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * Could you do it in-place without allocating extra space?
 * 
 */
public class ReverseWordsInString {

    public void reverseWords(char[] str) {
        reverse(str, 0, str.length-1);
        
        for (int i = 0, j = 0; i <=  str.length; i++) {
        	if (i == str.length || str[i] == ' ') {
        		reverse(str, j, i - 1);
        		j = i+1;
        	}
        }
    }
    
    public void reverse(char[] str, int start, int end) {
    	char temp;
    	while(start < end) {
    		temp = str[start];
    		str[start++] = str[end];
    		str[end--] = temp;
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsInString obj = new ReverseWordsInString();
		char[] str = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		obj.reverseWords(str);
		for(char s: str) {
			System.out.print(s);
		}
	}

}
