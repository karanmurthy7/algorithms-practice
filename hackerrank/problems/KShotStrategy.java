package hackerrank.problems;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Java class that contains the algorithm to compute 
 * k-shot strategy to buy and sell a sequence of shares.
 * Name: Karan Murthy
 * 
 */
public class KShotStrategy {

	/*
	 * Computes the k-shot strategy for n days. The time complexity 
	 * of the algorithm is O(k*n)
	 */
	private static void findBestKShotStrategy(int n, int k, int[] p) {
		int OPT[][] = new int[k+1][n];
		int maxDifference;
		for(int i = 1; i <= k; i++){
			maxDifference = Integer.MIN_VALUE;
			for(int j = 1; j < n; j++){
/*				max =p[j] - p[0] + OPT[i-1][0];
				for(int m = 1; m < j; m++){
					if((p[j] - p[m] + OPT[i-1][m]) > max){
						max = p[j] - p[m] + OPT[i-1][m];
					}
				}*/
				if(OPT[i-1][j-1] - p[j-1] > maxDifference){
					maxDifference = OPT[i-1][j-1] - p[j-1];
				}
				if(OPT[i][j-1] > p[j] + maxDifference){
					OPT[i][j] = OPT[i][j-1];
				}else{
					OPT[i][j] = p[j] + maxDifference;
				}
/*				if(OPT[i][j-1] > max)
					max = OPT[i][j-1];
				
				OPT[i][j] = max;*/
			}
		}
		
		// Backtracking to find the shares bought/sold.
		int totalReturn = OPT[k][n-1];
		if(totalReturn == 0){
			// This is the case when the best strategy is to not buy any share.
			System.out.println("The best strategy is to not buy any share");
		}else{
			int i = k, j = n-1, m = 0;
			while(OPT[i][j] != 0){
				if(OPT[i][j] == OPT[i][j-1]){
					// This is the case when number of shares bought is 
					// less than k.
					j--;
				}else{
					// Here j and some share before j was bought.
					int index = j-1;
					int difference = OPT[i][j] - p[j];
					while(index >= 0){
						if(OPT[i-1][index] - p[index] == difference){
							// Adding 1 to j while printing since j runs from 0 to n-1
							System.out.println("Share bought: " + (index+1) + " , Share sold: " + (j+1));
							m++;
							j = index;
							break;
						}
						index--;
					}
					i--;
				}
			}
			
			System.out.println("A total of " + m + " shares were bought for a total return of $" + totalReturn);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("E:\\Karan\\GMAT\\UWash\\Course Details\\CSE 417\\Week 7\\input1.txt");
		Scanner scanner = new Scanner(file);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int p[] = new int[n];
		
		for(int i = 0; i < n; i++){
			p[i] = scanner.nextInt();
		}
		findBestKShotStrategy(n, k, p);
		scanner.close();
	}


}
