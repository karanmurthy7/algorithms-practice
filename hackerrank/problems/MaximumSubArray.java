package hackerrank.problems;

import java.util.Scanner;

/*
 * Problem - HackerRank (The Maximum Subarray)
 * Given an array A = {a1, a2,...,an) of n elements, find the maximum possible sum of a
 * 1. Contiguous subarray
 * 2. Non-contiguous (not necessarily contiguous) subarray.
 * Empty subarrays/subsequences should not be considered.
 * 
 * Sample Input:
 * 2 
 * 4 
 * 1 2 3 4
 * 6
 * 2 -1 2 3 4 -5
 * 
 * Sample Output:
 * 10 10
 * 10 11
 */
public class MaximumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		int size, maxContiguous, maxDiscontiguous;
		int[] array;
		for(int i = 0 ; i < t; i++){
			size = scanner.nextInt();
			array = new int[size];
			for(int j = 0; j < size; j++){
				array[j] = scanner.nextInt();
			}
			maxContiguous = calculateMaximumContiguousSubArray(array);
			maxDiscontiguous = calculateMaximumDiscontiguousSubArray(array);
			System.out.println(maxContiguous + " " + maxDiscontiguous);
		}
		scanner.close();
	}

	private static int calculateMaximumDiscontiguousSubArray(int[] array) {
		// TODO Auto-generated method stub
		int sum[] = new int[array.length];
		sum[0] = array[0];
		int max = sum[0];
		for(int i = 1; i < sum.length; i++){
			if(sum[i-1] >= array[i]){
				sum[i] = Math.max(sum[i-1], sum[i-1] + array[i]);
			}else{
				sum[i] = Math.max(array[i], sum[i-1] + array[i]);
			}
			if(sum[i] > max){
				max = sum[i];
			}
		}
		return max;
	}

	private static int calculateMaximumContiguousSubArray(int[] array) {
		// TODO Auto-generated method stub
		int sum[] = new int[array.length];
		sum[0] = array[0];
		int max = sum[0];
		for(int i = 1; i < sum.length; i++){
			sum[i] = Math.max(sum[i-1] + array[i], array[i]);
			if(sum[i] > max){
				max = sum[i];
			}
		}
		
		return max;
	}

}
