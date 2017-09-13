package hackerrank.problems;

import java.util.Scanner;

/*
 * You are given a sequence of distinct n numbers a_1, a_2, ... a_n.
 * We define inversion as i < j and a_i > a_j. For example, if arr = [2, 4, 1] then the number
 * of inversions is 2 - (2,1) and (4,1)
 * The algorithm given below uses merge sort to count the number of inversions between two orderings.
 */

public class CountInversionsUsingMergeSort {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(countInversions(arr));
        }
        in.close();
    }

	private static long countInversions(int[] arr) {
		int[] tempArray = new int[arr.length];
		return mergeSort(arr, 0, arr.length-1, tempArray);
	}

	private static long mergeSort(int[] arr, int left, int right, int[] tempArray) {
		long countLeft = 0, countRight = 0, countMerged = 0;
		if(left >= right)
			return 0;
		
		int mid = (left + right)/2;
		countLeft = mergeSort(arr, left, mid, tempArray);
		countRight = mergeSort(arr, mid+1, right, tempArray);
		countMerged = mergeHalvesAndCountInversions(arr, left, right, tempArray);
		return countLeft + countRight + countMerged;
	}

	private static long mergeHalvesAndCountInversions(int[] arr, int leftStart,
			int rightEnd, int[] tempArray) {
		int left = leftStart;
		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;
		int right = rightStart;
		int index = leftStart;
		long inversions = 0;
		int size = rightEnd - leftStart;
		
		while (left <= leftEnd && right <= rightEnd){
			if(arr[left] <= arr[right]){
				tempArray[index] = arr[left];
				index++;
				left++;
			}else{
				inversions += leftEnd - left + 1;
				tempArray[index] = arr[right];
				index++;
				right++;
			}
		}
		
		while(left <= leftEnd){
			tempArray[index++] = arr[left++];
		}
		
		while(right <= rightEnd){
			tempArray[index++] = arr[right++];
		}

		while(size >= 0){
			arr[leftStart] = tempArray[leftStart++];
			size--;
		}
		return inversions;
	}
}
