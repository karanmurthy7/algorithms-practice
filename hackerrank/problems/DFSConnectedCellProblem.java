package hackerrank.problems;

import java.util.Scanner;

/*
 * Problem - DFS: Connected Cell in a Grid
 * Consider a matrix with  rows and  columns, where each cell contains either a 0 or a 1 
 * and any cell containing a is called a filled cell. Two cells are said to be connected 
 * if they are adjacent to each other horizontally, vertically, or diagonally;
 * If one or more filled cells are also connected, they form a region. 
 * Note that each cell in a region is connected to at least one other cell in the region 
 * but is not necessarily directly connected to all the other cells in the region.
 * 
 * The first line contains an integer, n, denoting the number of rows in the matrix. 
 * The second line contains an integer, m, denoting the number of columns in the matrix. 
 * Each line i of the n subsequent lines contains m space-separated integers describing the 
 * respective values filling each row in the matrix.

 * Sample Input:
 * 4
 * 4
 * 1 1 0 0
 * 0 1 1 0
 * 0 0 1 0
 * 1 0 0 0
 * 
 * Sample Output:
 * 5
 */
public class DFSConnectedCellProblem {

	  public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int m = in.nextInt();
	        int grid[][] = new int[n][m];
	        int connectedComponents = 0;
	        boolean visited[][] = new boolean[n][m];
	        
	        for(int grid_i=0; grid_i < n; grid_i++){
	            for(int grid_j=0; grid_j < m; grid_j++){
	                grid[grid_i][grid_j] = in.nextInt();
	            }
	        }
	        
	        for(int grid_i=0; grid_i < n; grid_i++){
	            for(int grid_j=0; grid_j < m; grid_j++){
	                if(grid[grid_i][grid_j] == 1 && !visited[grid_i][grid_j]){
	                	connectedComponents = Math.max(connectedComponents, countConnectedComponents(grid_i,grid_j, grid, visited));
	                }
	            }
	        }
	        in.close();
	        System.out.println(connectedComponents);
	    }

	private static int countConnectedComponents(int i, int j,
			int[][] grid, boolean[][] visited) {
		int count = 1;
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
			return 0;
		
		if(visited[i][j] || grid[i][j] != 1)
			return 0;
		
		visited[i][j] = true;
		
		count += countConnectedComponents(i, j-1, grid, visited);
		count += countConnectedComponents(i-1, j-1, grid, visited);
		count += countConnectedComponents(i-1, j, grid, visited);
		count += countConnectedComponents(i-1, j+1, grid, visited);
		count += countConnectedComponents(i, j+1, grid, visited);
		count += countConnectedComponents(i+1, j+1, grid, visited);
		count += countConnectedComponents(i+1, j, grid, visited);
		count += countConnectedComponents(i+1, j-1, grid, visited);
		return count;
	}
}
