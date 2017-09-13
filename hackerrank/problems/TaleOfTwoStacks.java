package hackerrank.problems;

import java.util.Scanner;
import java.util.Stack;

/*
 * Problem - HackerRank (Queues: A Tale of Two Stacks)
 * In this challenge, you must first implement a queue using two stacks. 
 * Then process  queries, where each query is one of the following  types:
 * 1 x: Enqueue element  into the end of the queue.
 * 2: Dequeue the element at the front of the queue.
 * 3: Print the element at the front of the queue.
 * 
 * Sample Input:
 * 10
 * 1 42
 * 2
 * 1 14
 * 3
 * 1 28
 * 3
 * 1 60
 * 1 78
 * 2
 * 2
 * 
 * Sample Output:
 * 14
 * 14
 */

public class TaleOfTwoStacks {
	
	static class MyQueue<Integer>{
		
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();

		public void enqueue(Integer nextInt) {
			stack1.push(nextInt);
		}

		public void dequeue() {
			if(stack2.isEmpty()){
				while(!stack1.isEmpty()){
					stack2.push(stack1.pop());
				}
			}
			stack2.pop();
		}

		public Integer peek() {
			Integer head;
			if(stack2.isEmpty()){
				while(!stack1.isEmpty()){
					stack2.push(stack1.pop());
				}
			}
			head = stack2.peek();
			return head;
		}
		
	}

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
