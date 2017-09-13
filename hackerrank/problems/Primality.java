package hackerrank.problems;

import java.util.Scanner;

/*
 * Problem - HackerRank (Time Complexity: Primality)
 * The first line contains an integer, p, denoting the number of integers to check for primality. 
 * Each of the p subsequent lines contains an integer, n, you must test for primality.
 * 
 * Sample Input:
 * 3
 * 12
 * 5
 * 7
 * 
 * Sample Output:
 * Not prime
 * Prime
 * Prime
 */
public class Primality {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		for (int a0 = 0; a0 < p; a0++) {
			int n = in.nextInt();
			System.out.println(checkPrimality(n));
		}
		in.close();
	}

	private static String checkPrimality(int n) {
		if (n == 1)
			return "Not prime";
		if(n == 2)
			return "Prime";
		if(n % 2 == 0)
			return "Not prime";

		for (int i = 3; i*i <= n; i=i+2) {
			if (n % i == 0)
				return "Not prime";
		}
		return "Prime";

	}

}
