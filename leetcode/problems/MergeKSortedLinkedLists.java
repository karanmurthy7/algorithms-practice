package leetcode.problems;

import java.util.Arrays;
import java.util.List;

/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 */

public class MergeKSortedLinkedLists {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		List<ListNode> collection = Arrays.asList(lists);
		return mergeKLists(collection, 0, collection.size() - 1);
	}

	private ListNode mergeKLists(List<ListNode> lists, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			return (merge(mergeKLists(lists, start, mid), mergeKLists(lists, mid + 1, end)));
		}
		return lists.get(start);
	}

	private ListNode merge(ListNode m, ListNode n) {
		ListNode head = new ListNode(0);
		ListNode current = head;

		while (m != null && n != null) {
			if (m.val < n.val) {
				current.next = m;
				m = m.next;
			} else {
				current.next = n;
				n = n.next;
			}
			current = current.next;
		}

		if (m != null)
			current.next = m;

		if (n != null)
			current.next = n;

		return head.next;
	}

}
