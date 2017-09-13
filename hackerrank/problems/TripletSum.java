package hackerrank.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Given an array and a required number, this class will identify
 * whether there is a triplet (sub-array) whose sum is equal to 
 * the given value.
 */
public class TripletSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the required number");
		int requiredNumber = in.nextInt();
		System.out.println("Enter the size of the array");
		int n = in.nextInt();
		int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}

		List<Integer> result = findTriplet(array, requiredNumber);
		if (null != result) {
			System.out.print("The triplet is : ");
			for (int num : result) {
				System.out.print(num + " ");
			}
		} else {
			System.out.println("There is no such triplet !");
		}

	}

	private static List<Integer> findTriplet(int[] array, int requiredNumber) {
		int length = array.length;
		List<Integer> subList = null;
		for (int i = 0; i < length - 2; i++) {
			for (int j = i + 1; j < length - 1; j++) {
				for (int k = j + 1; k < length; k++) {
					if (array[i] + array[j] + array[k] == requiredNumber) {
						subList = new ArrayList<Integer>();
						subList.add(array[i]);
						subList.add(array[j]);
						subList.add(array[k]);
						return subList;
					}
				}
			}
		}
		return subList;
	}
}
