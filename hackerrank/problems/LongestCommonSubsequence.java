package hackerrank.problems;

import java.util.Scanner;
import java.util.Stack;

/*
 * Problem - The Longest Common Subsequence 
 * A subsequence is a sequence that can be derived from another sequence 
 * by deleting some elements without changing the order of the remaining elements. 
 * Longest common subsequence (LCS) of 2 sequences is a subsequence, 
 * with maximal length, which is common to both the sequences. 

 * Sample Input:
 * 5 6
 * 1 2 3 4 1
 * 3 4 1 2 1 3
 * 
 * Sample Output:
 * 1 2 3
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a[] = new int[n];
        int b[] = new int[m];
        
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();    
        }
        for(int j = 0; j < m; j++){
            b[j] = scanner.nextInt();    
        }
        printLongestCommonSubsequence(a,b);
        scanner.close();
    }
    
    private static void printLongestCommonSubsequence(int[] a, int[] b){
        int OPT[][] = new int[a.length+1][b.length+1];
        for(int i = 1; i <= a.length; i++){
            for(int j = 1; j <= b.length; j++){
                if(a[i-1] != b[j-1]){
                    OPT[i][j] = Math.max(OPT[i-1][j], OPT[i][j-1]);
                }else{
                    OPT[i][j] = OPT[i-1][j-1] + 1;
                }
            }
        }
        
        int i = a.length;
        int j = b.length;
        Stack<Integer> output = new Stack<Integer>();
        while(OPT[i][j] > 0){
            if(OPT[i][j] != OPT[i][j-1] && OPT[i][j] != OPT[i-1][j]){
               if(OPT[i][j] == (OPT[i-1][j-1] + 1)){
            	  output.push(a[i-1]);
            	  i--;
            	  j--;
               }
            }else{
            	if(OPT[i][j] == OPT[i][j-1]){
            		j--;
            	}else{
            		i--;
            	}
            }
           
            
        }
        
        while(!output.isEmpty()){
        	System.out.print(output.pop() + " ");
        }
        
    }
}
