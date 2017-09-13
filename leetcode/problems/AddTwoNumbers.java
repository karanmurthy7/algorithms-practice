package leetcode.problems;

/*
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(-1);
		ListNode curr = dummyHead;
		int carry = 0;

		while (l1 != null || l2 != null) {
			int x = (l1 == null) ? 0 : l1.val;
			int y = (l2 == null) ? 0 : l2.val;
			int sum = x + y + carry;
			carry = sum / 10;
			if (curr.val == -1) {
				curr.val = sum % 10;
			} else {
				curr.next = new ListNode(sum % 10);
				curr = curr.next;
			}
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if(carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(9);
		ListNode l1Head = l1;
		l1.next = new ListNode(9);
		l1 = l1.next;
		l1.next = new ListNode(7);
		l1 = l1.next;
		
		ListNode l2 = new ListNode(1);
		ListNode l2Head = l2;
		
		ListNode dummyHead = addTwoNumbers(l1Head, l2Head);
		while(dummyHead != null) {
			System.out.println(dummyHead.val);
			dummyHead = dummyHead.next;
		}
	}

}
