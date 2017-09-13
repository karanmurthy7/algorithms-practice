package hackerrank.problems;


import java.util.Scanner;

/*
 * Problem - HackerRank (Ice Cream Parlor)
 * Given the value of m and the cost of each flavor for t trips to the Ice Cream Parlor,
 * help Sunny and Johnny choose two distinct flavors such that they spend their entire
 * pool of money (m) during each visit. For each trip to the parlor, print the ID numbers 
 * for the two types of ice cream that Sunny and Johnny purchase as two space-separated 
 * integers on a new line. You must print the smaller ID first and the larger ID second.
 * 
 * Sample Input:
 * 2
 * 4
 * 5
 * 1 4 5 3 2
 * 4
 * 4
 * 2 2 4 3
 * 
 * Sample Output:
 * 1 4
 * 1 2
 */

public class IceCreamParlor {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            printPurchasedIceCream(a, m); 
        }
        in.close();
    }

	private static void printPurchasedIceCream(int[] costs, int dollars) {
		int  remainingAmount;
		for (int i = 0; i < costs.length - 1; i++) {
			remainingAmount = dollars - costs[i];
			for (int j = i + 1; j < costs.length; j++) {
				if (costs[j] == remainingAmount) {
					System.out.println((i + 1) + " " + (j + 1));
					return;
				}
			}
		}

	}

}
