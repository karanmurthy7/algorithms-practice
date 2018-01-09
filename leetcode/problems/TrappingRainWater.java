package leetcode.problems;

/*
 * Given n non-negative integers representing an elevation map 
 * where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater {

	public static int trap(int[] height) {
		int waterQty = 0;

		if (height == null || height.length == 0)
			return waterQty;

		int n = height.length;
		int left[] = new int[n];
		int right[] = new int[n];
		left[0] = height[0];
		right[n - 1] = height[n - 1];

		for (int i = 1; i < n; i++) {
			left[i] = Math.max(left[i - 1], height[i]);
		}
		for (int i = n - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], height[i]);
		}
		for (int i = 0; i < n; i++) {
			waterQty += Math.min(left[i], right[i]) - height[i];
		}
		return waterQty;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 3, 0, 0, 2, 0, 4 };
		System.out.println(trap(height));
	}

}
