package leetcode.problems;

/*
 * Given an array nums, write a function to move all 0's to the end of it 
 * while maintaining the relative order of the non-zero elements. 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * 
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 */
public class MoveZeroes {

	private static void swap(int[] nums, int i, int j) {
		nums[i] = nums[j];
		nums[j] = 0;
	}

	public static void moveZeroes(int[] nums) {
		int i = 0, zeroIndex = -1;

		while (i < nums.length) {
			if (nums[i] == 0 && zeroIndex == -1) {
				zeroIndex = i;
			}
			if (nums[i] != 0 && zeroIndex != -1) {
				swap(nums, zeroIndex, i);
				zeroIndex += 1;
			}
			i++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0, 0, 0, 1};
		moveZeroes(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

}
