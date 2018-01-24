package leetcode.problems;

/*
 * Given a non-empty array of integers, return the third maximum number in this array. 
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 * 
 * Input: [3, 2, 1]
 * Output: 1
 * Explanation: The third maximum is 1
 *
 * Input: [2, 2, 3, 1] 
 * Output: 1 
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 * 
 */
public class ThirdMaxNumber {

	public int thirdMax(int[] nums) {
		Integer max1 = null, max2 = null, max3 = null;

		for (Integer number : nums) {
			if (number.equals(max1) || number.equals(max2) || number.equals(max3))
				continue;
			if (max1 == null || number > max1) {
				max3 = max2;
				max2 = max1;
				max1 = number;
			} else if (max2 == null || number > max2) {
				max3 = max2;
				max2 = number;
			} else if (max3 == null || number > max3) {
				max3 = number;
			}
		}

		return max3 == null ? max1 : max3;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThirdMaxNumber obj = new ThirdMaxNumber();
		int[] nums = { 5, 4, 3, 2, 1 };
		System.out.println(obj.thirdMax(nums));
	}

}
