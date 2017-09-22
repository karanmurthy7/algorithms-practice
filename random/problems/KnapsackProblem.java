package random.problems;

import java.util.Scanner;

/*
 * https://en.wikipedia.org/wiki/Knapsack_problem
 */
public class KnapsackProblem {

	public static void main(String[] args) {
		System.out.println("Enter the weight of the knapsack");
		Scanner scanner = new Scanner(System.in);
		int knapsackWt = scanner.nextInt();
		System.out.println("Enter the number of items:");
		int noOfItems = scanner.nextInt();
		System.out.println("Enter the weight of each item");
		int weights[] = new int[noOfItems];
		int values[] = new int[noOfItems];
		for (int i = 0; i < noOfItems; i++) {
			weights[i] = scanner.nextInt();
		}
		System.out.println("Enter the value of each item");
		for (int i = 0; i < noOfItems; i++) {
			values[i] = scanner.nextInt();
		}

		solveKnapsackProblem(weights, values, noOfItems, knapsackWt);
		scanner.close();
	}

	private static void solveKnapsackProblem(int[] weights, int[] values, int noOfItems, int knapsackWt) {
		int OPT[][] = new int[noOfItems + 1][knapsackWt + 1];

		for (int i = 1; i <= noOfItems; i++) {
			for (int j = 1; j <= knapsackWt; j++) {
				if (weights[i - 1] > j) {
					OPT[i][j] = OPT[i - 1][j];
				} else {
					OPT[i][j] = Math.max(OPT[i - 1][j], values[i - 1] + OPT[i - 1][j - weights[i - 1]]);
				}
			}
		}

		int i = noOfItems, j = knapsackWt;
		while (OPT[i][j] > 0) {
			if (OPT[i][j] != OPT[i - 1][j]) {
				System.out.println("Element with weight " + weights[i - 1] + " and value " + values[i - 1]
						+ " is in the knapsack");
				j = j - weights[i - 1];
			}
			i = i - 1;
		}
	}

}
