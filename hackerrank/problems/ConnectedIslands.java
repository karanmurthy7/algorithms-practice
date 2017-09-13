package hackerrank.problems;

import java.util.Scanner;

/*
 * GeeksforGeeks : Finding the number of islands.
 * Given a boolean 2D matrix, find the number of islands. 
 * A group of connected 1s forms an island. 
 * For example, the below matrix contains 5 islands
 * 1 1 0 0 0
 * 1 1 0 0 1
 * 0 0 0 1 1
 * 0 0 0 0 0
 * 1 0 1 0 1
 * 
 * We can only move in 4 possible directions : Up, down, forward, backward.
 * Diagonal presence of 1's does not classify it as an island.
 */
public class ConnectedIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int rows = scanner.nextInt();
		int columns = scanner.nextInt();
		int[][] islands = new int[rows][columns];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				islands[i][j] = scanner.nextInt();
			}
		}
		
		System.out.println(computeTotalIslands(islands));
		
		scanner.close();
	}

	private static int computeTotalIslands(int[][] islands) {
		boolean[][] visited = new boolean[islands.length][islands[0].length];
		int islandCount = 0;
		for(int i = 0; i < islands.length; i++){
			for(int j = 0; j < islands[0].length; j++){
				if(!visited[i][j] && islands[i][j] != 0){
					findConnectedIslands(i, j, islands, visited);
					islandCount++;
				}
			}
		}
		
		return islandCount;
	}

	private static void findConnectedIslands(int i, int j, int[][] islands,
			boolean[][] visited) {
		// Error handling for i and j values
		if(i < 0 || j < 0)
			return;
		
		// Error handling for i and j values
		if(i >= islands.length || j >= islands[0].length)
			return;
		
		if(islands[i][j] == 0 )
			return;  
		
		// The recursive function should only explore neighbors of 
		// unvisited islands.
		if(visited[i][j])
			return;
					
		visited[i][j] = true;
		
		findConnectedIslands(i, j-1, islands, visited);
		findConnectedIslands(i, j+1, islands, visited);
		findConnectedIslands(i-1, j, islands, visited);
		findConnectedIslands(i+1, j, islands, visited);
		
	}

}
