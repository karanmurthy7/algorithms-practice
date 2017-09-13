package hackerrank.problems;

import java.util.Scanner;

/*
 * GeeksforGeeks : Longest Increasing Subsequence (Dynamic Programming).
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the 
 * longest subsequence of a given sequence such that all elements of the subsequence 
 * are sorted in increasing order. For example, the length of LIS for 
 * {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int input[] = new int[n];
		for(int i = 0; i < n; i++){
			input[i] = scanner.nextInt();
		}
		scanner.close();
		computeLongestIncreasingSubsequence(input);

	}

	private static void computeLongestIncreasingSubsequence(int[] input) {
		// TODO Auto-generated method stub

		int i,j;
		int OPT[] = new int[input.length];
		
		/*
		 * Initializing the OPT array with 1 for all index positions.
		 * This means that for each individual element in the array,
		 * there is at least 1 longest increasing subsequence.
		 */
		for(i = 0; i < OPT.length; i++){
			OPT[i] = 1;
		}
		
		i = 1;
		while(i < input.length){
			j = 0;
			while(j <= i){
				if(input[j] < input[i]){
					OPT[i] = Math.max(OPT[i], OPT[j]+1);
				}
				j++;
			}
			i++;
		}
		
		// Finding the index position of the biggest element of 
		// the OPT array.
		
		int maxLength = OPT[0];
		int maxIndex = 0;
		for (i = 0; i < OPT.length-1; i++){
			if(OPT[i] < OPT[i+1]){
				maxLength = OPT[i+1];
				maxIndex = i+1;
			}
		}
		
		/*
		 * Backtracking to compute the optimal solution.
		 */
		int output[] = new int[maxLength];
		output[maxLength-1] = input[maxIndex];
		for(i = maxIndex-1; i >= 0 ; i--){
			if(OPT[i] == maxLength-1){
				maxLength--;
				output[maxLength-1] = input[i];
			}
		}

		// Printing the final solution
		System.out.print("The longest increasing subsequence is : ");
		for(i = 0; i < output.length; i++){
				System.out.print(output[i] + " ");
		}
		System.out.println();
		System.out.println("The length of the subsequence is : " + output.length);
	}

}
