package hackerrank.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UnsortedSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int n = in.nextInt();
		int[] array = new int[n];
		System.out.println("Enter the array");
		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}
		List<Integer> unsortedSubArray = getUnsortedSubArray(array);
		if(unsortedSubArray.size()!=0){
			for(int number: unsortedSubArray){
				System.out.print(number + " ");
			}
		}
	}

	private static List<Integer> getUnsortedSubArray(int[] array) {
		int length = array.length;
		int start = 0, end = length - 1, max, min, i;
		List<Integer> unsortedSubArray = new ArrayList<Integer>();
		for (start = 0; start < length; start++) {
			if (array[start + 1] < array[start]) {
				break;
			}
		}

		for (end = length - 1; end > 0; end--) {
			if (array[end - 1] > array[end]) {
				break;
			}
		}

		max = array[start];
		min = array[start];

		for (i = start; i <= end; i++) {
			if (array[i] > max) {
				max = array[i];
			}
			if (array[i] < min) {
				min = array[i];
			}
		}

		for (i = 0; i <= start; i++) {
			if (array[i] > min) {
				start = i;
			}
		}

		for (i = end; i < length; i++) {
			if (array[i] < max) {
				end = i;
			}
		}

		for (i = start; i <= end; i++) {
			unsortedSubArray.add(array[i]);
		}
		return unsortedSubArray;
	}
}
