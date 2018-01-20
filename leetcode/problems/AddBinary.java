package leetcode.problems;

/*
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * 
 */
public class AddBinary {

    public static String addBinary(String a, String b) {
    	StringBuilder sb = new StringBuilder();
    	int i = a.length() - 1;
    	int j = b.length() - 1;
    	int sum = 0, carry = 0;
    	while( i >= 0 || j >= 0) {
    		sum = carry;
    		if (i >= 0)
    			sum += a.charAt(i--) - '0';
    		if (j >= 0)
    			sum += b.charAt(j--) - '0';
    		carry = sum / 2;
    		sb.append(sum % 2);
    	}
    	if (carry == 1) sb.append(carry);
    	return sb.reverse().toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("11", "11"));
	}

}
