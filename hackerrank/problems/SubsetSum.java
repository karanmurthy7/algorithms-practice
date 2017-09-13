package hackerrank.problems;

import java.util.Scanner;

/*
 * GeeksForGeeks : Subset Sum Problem
 * Given a set of non-negative integers, and a value sum, 
 * determine if there is a subset of the given set with sum equal to given sum.
 * 
 * Sample Input:
 * 6 // Size of the array followed by the elements of the array.
 * 3
 * 34
 * 4
 * 12
 * 5
 * 2
 * 9 // The required sum
 * 
 * Sample Output:
 * Whether subset sum exists or not. If it exists, then print the elements in the subset.
 */
public class SubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int array[] = new int[size];

		for (int i = 0; i < size; i++) {
			array[i] = scanner.nextInt();
		}
		int sum = scanner.nextInt();
		verifySubsetSum(array, sum);
		scanner.close();
	}

	private static void verifySubsetSum(int[] array, int sum) {
		boolean OPT[][] = new boolean[array.length + 1][sum + 1];
		for(int i = 0 ; i <= array.length; i++){
			for(int j = 0; j <= sum; j++){
				OPT[i][0] = true;
			}
		}
		
		for(int i = 1 ; i <= array.length; i++){
			for(int j = 1; j <= sum; j++){
				if(array[i-1] > j){
					OPT[i][j] = OPT[i-1][j];
				}else{
					OPT[i][j] = OPT[i-1][j] || OPT[i-1][j-array[i-1]];
				}
			}
		}
		int i = array.length;
		int j = sum;
		
		if(OPT[i][j]){
			System.out.println("Subset Exists");
			while(j != 0){
				if(!OPT[i][j]){
					i = i - 1;
					continue;
				}
				if(OPT[i][j] && OPT[i][j] != OPT[i-1][j]){
					System.out.println(array[i-1]);
					j = j - array[i-1];
				}
				i = i - 1;
			}
		}else{
			System.out.println("There is no subset within the given set that adds to " + sum);
		}
	}
}
