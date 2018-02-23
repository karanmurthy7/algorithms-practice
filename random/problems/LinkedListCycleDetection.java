package random.problems;

/*
 * 
 * Write a function detectAndRemoveLoop() that checks whether 
 * a given Linked List contains loop and if loop is present 
 * then removes the loop and returns true. 
 * And if the list doesn’t contain loop then returns false.
 * 
 * Using Floyd's Cycle Detection algorithm to detect and remove the loop.
 */
public class LinkedListCycleDetection {

	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public boolean detectAndRemoveLoop(Node root) {
		Node fast = head, slow = head;
		boolean isCyclePresent = false;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				isCyclePresent = true;
				break;
			}
		}
		
		if (isCyclePresent) {
			slow = root;
			while(slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
		}
		
		return isCyclePresent;

	}

	// Function to print the linked list
	public void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		LinkedListCycleDetection list = new LinkedListCycleDetection();
		list.head = new Node(50);
		list.head.next = new Node(20);
		list.head.next.next = new Node(15);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(10);

		// Creating a loop for testing
		head.next.next.next.next.next = head.next.next;
		list.detectAndRemoveLoop(head);
		System.out.println("Linked List after removing loop : ");
		list.printList(head);
	}

}
