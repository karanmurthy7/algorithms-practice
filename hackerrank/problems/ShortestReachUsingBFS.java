package hackerrank.problems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Problem
 * Consider an undirected graph consisting of n nodes where each node is labeled from 1 to n
 * and the edge between any two nodes is always of length 6. 
 * We define node  to be the starting position for a BFS. Given q queries in the form of a graph and 
 * some starting node, s, perform each query by calculating the shortest distance from starting node s 
 * to all the other nodes in the graph. Then print a single line of n-1 space-separated integers 
 * listing node s's shortest distance to each of the n-1 other nodes (ordered sequentially by node number); 
 * if s is disconnected from a node, print -1 as the distance to that node.
 * 
 * Sample Input:
 *      2
	4 2
	1 2
	1 3
	1
	3 1
	2 3
	2
	
	Sample Output:
	6 6 -1
	-1 6
 */
public class ShortestReachUsingBFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int queries = scanner.nextInt();
		int n,m, u, v, startingVertex;
		LinkedList<Integer> adjacencyList[];
		
		for (int i = 0; i < queries; i++) {
			// n is the number of vertices and m is the number of edges.
			n = scanner.nextInt();
			m = scanner.nextInt();
			adjacencyList = new LinkedList[n+1];
			
			// Loop to create linked list for every vertex.
			for(int k = 1; k <= n; k++){
				adjacencyList[k] = new LinkedList<Integer>(); 
			}
			
			// Loop to capture edge details
			for(int j = 0; j < m; j++){
				// Consider u and v as generic vertices and E(u,v) the edge between them.
				// Since the graph is undirected, we have to add 1 edge for (u,v) and
				// one for (v,u)
				u = scanner.nextInt();
				v = scanner.nextInt();
				adjacencyList[u].add(v);
				adjacencyList[v].add(u);
			}
			startingVertex = scanner.nextInt();
			calculateShortestReach(startingVertex, adjacencyList);
		}
		
		scanner.close();
	}

	/*
	 * Helper method to calculate shortest distance of startingVertex
	 * from all other vertices. It uses breadth first search to compute 
	 * shortest distance.
	 */
	private static void calculateShortestReach(int startingVertex,
			LinkedList<Integer>[] adjacencyList) {
		int distances[] = BFS(startingVertex, adjacencyList);
		for(int i = 1; i < distances.length; i++){
			if(distances[i] == 0 && i != startingVertex)
				distances[i] = -1;
		}
		
		for(int i = 1; i < distances.length; i++){
			if(i != startingVertex)
				System.out.print(distances[i] + " ");
		}
		System.out.println();
	}

	/*
	 * BFS to compute distances of each vertex from the starting vertex.
	 */
	private static int[] BFS(int vertex, LinkedList<Integer>[] adjacencyList) {
		int distances[] = new int[adjacencyList.length];
		boolean visited[] = new boolean[adjacencyList.length];
		visited[vertex] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(vertex);
		int edgeLength = 6;
		
		while(!queue.isEmpty()){
			int u = queue.poll();
			Iterator<Integer> iterator = adjacencyList[u].iterator();
			while(iterator.hasNext()){
				int v = iterator.next();
				if(!visited[v]){
					visited[v] = true;
					distances[v] = distances[u] + edgeLength;
					queue.add(v);					
				}
			}
		}
		return distances;
	}
}
