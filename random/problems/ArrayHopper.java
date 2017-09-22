package random.problems;

import java.util.Scanner;

/*
 * Given an array of non negative integers where each element represents the max 
 * number of steps that can be made forward from that element. Write a function to 
 * return the minimum number of jumps to reach the end of the array from first element
 */
public class ArrayHopper {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the length of the array : ");
		int length = scanner.nextInt();
		int arr[] = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = scanner.nextInt();
		}
		System.out.println("Minimum number of jumps to reach the end is : " + findMinimumJumps(arr, length));
		scanner.close();
	}

	private static int findMinimumJumps(int[] arr, int length) {
		int[] jumps = new int[length];
		int[] indexes = new int[length];

		indexes[0] = -1;
		for (int i = 1; i < length; i++) {
			jumps[i] = Integer.MAX_VALUE - 1;
		}

		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] >= i - j) {
					if (jumps[j] + 1 < jumps[i]) {
						jumps[i] = jumps[j] + 1;
						indexes[i] = j;
					}
				}
			}
		}
		return jumps[length - 1];
	}

}
