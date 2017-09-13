package hackerrank.problems;

import java.util.Scanner;

/*
 * This class computes the total number of ways in which we can compute
 * change for a given value N using M possible denominations.
 */
public class CoinChangeProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		// N : Value for which we need to compute change
		int N = scanner.nextInt();
		// M : Number of coins
		int M = scanner.nextInt();
		int coins[] = new int[M];
		
		for(int i = 0; i < M ; i++){
			coins[i] = scanner.nextInt();
		}
		scanner.close();
		System.out.println(computeChange(N, coins)); 
	}

	private static long computeChange(int N, int[] coins) {
		int numberOfCoins = coins.length;
		long OPT[][] = new long[numberOfCoins+1][N+1];
		
		for(int i = 0; i <= numberOfCoins; i++){
			OPT[i][0] = 1;
		}
		for(int i = 1; i <= numberOfCoins; i++){
			for(int j = 1; j <= N; j++){
				if(coins[i-1] > j){
					OPT[i][j] = OPT[i-1][j];
				}else{
					OPT[i][j] = OPT[i-1][j] + OPT[i][j-coins[i-1]];
				}
			}
		}
		
		return OPT[numberOfCoins][N];
		
	}

}
