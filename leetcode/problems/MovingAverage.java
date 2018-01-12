package leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a stream of integers and a window size, 
 * calculate the moving average of all integers in the sliding window.
 * 
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * 
 */
class MovingAverage {
	
	private double sum = 0;
	private Queue<Integer> queue;
	private int size;
	
	/** Initialize your data structure here. */
	public MovingAverage(int size) {
		this.queue = new LinkedList<Integer>();
		this.size = size;
	}

	public double next(int val) {
		if (this.queue.size() == this.size) {
			this.sum -= queue.poll();
		}
		queue.offer(val);
		sum += val;
		
		if (sum == 0)
			return 0;
		return (sum / queue.size());
	}
}
