package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, 
 * and you may not use the same element twice.
 * 
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		int[] output = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (indexMap.containsKey(nums[i])) {
				output[0] = indexMap.get(nums[i]);
				output[1] = i;
				break;
			}
			indexMap.put(target - nums[i], i);
		}
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3, 2, 4};
		int target = 6;
		int[] output = twoSum(nums, target);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}

}
