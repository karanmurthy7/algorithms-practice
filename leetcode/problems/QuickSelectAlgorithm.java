package leetcode.problems;

/*
 * 
 * In computer science, quickselect is a selection algorithm 
 * to find the kth smallest element in an unordered list. 
 * It is related to the quicksort sorting algorithm.
 */
public class QuickSelectAlgorithm {

	private static int quickSelect(int[] arr, int K) {
		// if largest, change K to arr.length + 1 - K;
		return quickSelectHelper(arr, K, 0, arr.length - 1);
	}

	private static int quickSelectHelper(int[] arr, int K, int left, int right) {
		if (left == right)
			return arr[left];
		
		if (K > arr.length)
			return Integer.MIN_VALUE;
		
		int split = partition(arr, left, right);
		int length = split - left + 1;
		if (K < length)
			return quickSelectHelper(arr, K, left, split - 1);
		else if (K > length)
			return quickSelectHelper(arr, K - length, split + 1, right);
		else
			return arr[split];
	}

	private static int partition(int[] arr, int left, int right) {
		int leftMark = left + 1;
		int rightMark = right;
		int pivot = arr[left];
		
		while(true) {
			while(leftMark < right && arr[leftMark] < pivot)
				leftMark++;
			while(rightMark > left && arr[rightMark] > pivot)
				rightMark--;
			
			if (leftMark >= rightMark)
				break;
			else {
				swap(arr, leftMark, rightMark);
			}
		}
		swap(arr, left, rightMark);
		return rightMark;
	}

	private static void swap(int[] arr, int leftMark, int rightMark) {
		int temp = arr[leftMark];
		arr[leftMark] = arr[rightMark];
		arr[rightMark] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 5, 8, 12, 6, 1, 4 };
		int K = 2;
		System.out.println( K + " smalles number is : " + quickSelect(arr, K));
	}

}
