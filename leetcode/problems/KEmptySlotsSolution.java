package leetcode.problems;

/*
 * There is a garden with N slots. In each slot, there is a flower. 
 * The N flowers will bloom one by one in N days. In each day, there will 
 * be exactly one flower blooming and it will be in the status of blooming since then.
 * Given an array flowers consists of number from 1 to N. 
 * Each number in the array represents the place where the flower will open in that day.
 * For example, flowers[i] = x means that the unique flower that blooms at day i will be 
 * at position x, where i and x will be in the range from 1 to N. 
 * Also given an integer k, you need to output in which day there exists two flowers in the 
 * status of blooming, and also the number of flowers between them is k and these flowers are not blooming. 
 * If there isn't such day, output -1.
 * 
 */
public class KEmptySlotsSolution {
	
    public static int kEmptySlots(int[] flowers, int k) {
    	int[] days = new int[flowers.length];
    	int left = 0;
    	int right = k + 1;
    	int result = Integer.MAX_VALUE;
    	
    	for (int i = 0; i < flowers.length; i++) {
    		days[flowers[i] - 1] = i + 1;
    	}
    	
    	for (int i = 1; right < flowers.length; i++) {
    		if (days[i] > days[left] && days[i] > days[right])
    			continue;
    		
    		if (i == right)
    			result = Math.min(result, Math.max(days[left], days[right]));
    		
    		left = i;
    		right = i + k + 1;
    	}
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
	public static void main(String[] args) {
		int[] flowers = {1, 3, 2};
		int k = 1;	
		System.out.println(kEmptySlots(flowers, k));

	}

}
