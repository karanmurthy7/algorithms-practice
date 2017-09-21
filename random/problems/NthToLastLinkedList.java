package random.problems;

import java.util.Scanner;

/*
 * Given a singly linked list, write a function to 
 * find the nth-to-last element of the list.
 * 
 * For eg. list = 1 -> 2 -> 3 -> 4 -> 5
 * n = 1, output = 4 (one node away from the last node)
 * n = 2, output = 3
 * n = 5, output = Node does not exist
 */
public class NthToLastLinkedList {

	private static class Node{
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static Node getNthToLastNode(Node root, int n) {
		Node current = root, follower = root;
		for(int i = 0; i < n; i++) {
			if(current.next == null) {
				return null;
			}
			current = current.next;
		}
		while(current.next != null) {
			current = current.next;
			follower = follower.next;
		}
		return follower;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the size of the linked list: ");
		int size = in.nextInt();
		Node root = null, curr = null;
		for (int i = 0; i < size; i++) {
			if(root == null) {
				root = new Node(in.nextInt());
				curr = root;
			}else {
				curr.next = new Node(in.nextInt());
				curr = curr.next;
			}
		}
		System.out.println("Enter the value of n: ");
		int n = in.nextInt();
		Node output = getNthToLastNode(root, n);
		if (output != null) {
			System.out.println("Node at a distance of " + n + " from last is " + output.value);
		}else {
			System.out.println("Node at a distance of " + n + " from last does not exist");
		}
	}
}
