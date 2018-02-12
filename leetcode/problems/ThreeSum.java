package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array S of n integers, are there elements a, b, c in S 
 * such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * 	[-1, 0, 1],
 * 	[-1, -1, 2]
 * ]
 * 
 */
public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int sum, low, high;
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				sum = 0 - nums[i];
				low = i + 1;
				high = nums.length - 1;
				while (low < high) {
					if (nums[low] + nums[high] == sum) {
						List<Integer> threeSumList = new ArrayList<Integer>();
						threeSumList.add(nums[i]);
						threeSumList.add(nums[low]);
						threeSumList.add(nums[high]);
						while (low < high && nums[low] == nums[low+1]) low++;
						while (low < high && nums[high] == nums[high-1]) high--;
						high--;
						low++;
						output.add(threeSumList);
					} else if (nums[low] + nums[high] < sum) {
						low++;
					} else {
						high--;
					}
				}
			}
		}
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -1, 0, 1, 2, -1, -4};
		List<List<Integer>> output = threeSum(nums);
		for (List<Integer> numList : output) {
			for (Integer number: numList) {
				System.out.print(number + ", ");
			}
			System.out.println();
		}
	}

}
