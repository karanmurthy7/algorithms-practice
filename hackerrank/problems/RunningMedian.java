package hackerrank.problems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * Problem - HackerRank (Heaps: Find the Running Median)
 * Given an input stream of  integers, you must perform the following task for each ith integer:
 * Add the ith integer to a running list of integers. 
 * Find the median of the updated list (i.e., for the first element through the ith element).
 * Print the list's updated median on a new line. The printed value must be a double-precision 
 * number scaled to decimal place (i.e., 12.3 format).
 * 
 * Sample Input:
 * 6
 * 12
 * 4
 * 5
 * 3
 * 8
 * 7
 * 
 * Sample Output:
 * 12.0
 * 8.0
 * 5.0
 * 4.5
 * 5.0
 * 6.0
 */

public class RunningMedian {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        double[] medians = computeMedians(a);
        for(int i = 0; i < medians.length; i++){
        	System.out.println(medians[i]);
        }
        in.close();
    }

	private static double[] computeMedians(int array[]) {
		//MaxHeap
		PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer a, Integer b) {
				// Multiplying by minus -1 as the priorityQueue
				// by default sorts it in ascending order.
				// We need the maximum element from the lowers priorityQueue.
				return -1 * a.compareTo(b);
			}
		});
		
		// MinHeap
		PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
		double[] medians = new double[array.length];
		for(int i = 0; i < array.length; i++){
			addNumber(array[i], lowers, highers);
			rebalanceQueues(lowers, highers);
			medians[i] = getMedian(lowers, highers);
		}
		return medians;
	}
	
	private static void addNumber(int number, PriorityQueue<Integer> lowers,
			PriorityQueue<Integer> highers) {
		if(lowers.isEmpty() || number < lowers.peek()){
			lowers.add(number);
		}else {
			highers.add(number);	
		}
		
	}
	
	private static void rebalanceQueues(PriorityQueue<Integer> lowers,
			PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() < highers.size() ? lowers : highers;		
		
		if(biggerHeap.size() - smallerHeap.size() >= 2){
			smallerHeap.add(biggerHeap.poll());
		}
	}
	
	private static double getMedian(PriorityQueue<Integer> lowers,
			PriorityQueue<Integer> highers) {
		if(lowers.size() > highers.size()){
			return lowers.peek();
		}else if(lowers.size() < highers.size()){
			return highers.peek();
		}
		return (double)(lowers.peek() + highers.peek()) / 2;
	}

}
