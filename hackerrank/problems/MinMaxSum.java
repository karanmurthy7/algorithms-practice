package hackerrank.problems;

import java.util.Scanner;

/*
 * HackerRank problem: Mini-Max Sum
 * Given five positive integers, find the minimum and maximum values
 * that can be calculated by summing exactly four of the five integers.
 * Then print the respective minimum and maximum values as a single line 
 * of two space-separated long integers.
 * 
 * Sample Input: 1 2 3 4 5
 * Sample Output: 10 14
 */
public class MinMaxSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long numbers[] = new long[5];
        for(int i = 0; i < 5; i++){
        	numbers[i] = in.nextLong();
        }
        in.close();
        calculateMinMaxSum(numbers);
    }

	private static void calculateMinMaxSum(long[] numbers) {
		// TODO Auto-generated method stub
		long minValue = numbers[0], maxValue = numbers[0];
		long sum = 0;
		for(int i = 1; i < numbers.length; i++){
			if(numbers[i] > maxValue)
				maxValue = numbers[i];
			if(numbers[i] < minValue)
				minValue = numbers[i];	
		}
		
		for(int i = 0; i < numbers.length; i++){
				sum += numbers[i];
		}
		  
		System.out.println((sum - maxValue) + " " + (sum - minValue));
	}


}
