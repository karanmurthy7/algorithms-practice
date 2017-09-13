package hackerrank.problems;

import java.util.Arrays;
import java.util.Scanner;

/*
 * This algorithm counts the occurrences of an element in an array using
 * Iterative Binary Search.
 */
public class CountOccurrences {

	public static void main(String[] args) {
		System.out.println("Enter the size of the array : ");
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int arr[] = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = scanner.nextInt();
		}

		System.out.println("Enter the element you want to find: ");
		int element = scanner.nextInt();
		Arrays.sort(arr);
		int firstOccurrence = binarySearch(arr, size, element, true);
		if (firstOccurrence == -1) {
			System.out.println("Element " + element + " not found !");
		} else {
			int lastOccurrence = binarySearch(arr, size, element, false);
			System.out.println("Element " + element + " found and occurs "
					+ (lastOccurrence - firstOccurrence + 1) + " times");
		}
		scanner.close();
	}

	private static int binarySearch(int[] arr, int size, int element,
			boolean searchFirst) {
		int low = 0;
		int high = size - 1;
		int mid, result = -1;

		while (low <= high) {
			mid = (low + high) / 2;
			if (element > arr[mid])
				low = mid + 1;
			else if (element < arr[mid])
				high = mid - 1;
			else {
				result = mid;
				if (searchFirst)
					high = mid - 1;
				else
					low = mid + 1;
			}
		}
		return result;

	}

}
