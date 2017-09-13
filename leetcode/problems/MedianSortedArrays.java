package leetcode.problems;

public class MedianSortedArrays {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int length1 = nums1.length;
		int length2 = nums2.length;

		if (length1 % 2 != 0 && length2 % 2 == 0) {
			return nums1[length1 - 1];
		} else if (length1 % 2 == 0 && length2 % 2 != 0) {
			return nums2[0];
		} else {
			if(length1 == 0 && length2 == 0) {
				return 0.0;
			}else if(length1 == 0 && length2 != 0) {
				return nums2[length2/2 - 1] + nums2[length2/2];
			}else {
				return nums1[length1/2 - 1] + nums1[length1/2];
			}
		}
	}

	public static void main(String[] args) {
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

}
