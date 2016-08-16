package one.leftRightRebuild;

import commonDataStructure.Node;

public class LeftRightRebuild {
	
	public Node relocate(Node head) {
		if (head == null || head.next == null)
			return head;
		Node mid = head;
		Node right = head.next;
		while (right.next != null && right.next.next != null) {
			mid = mid.next;
			right = right.next.next;
		}
		right = mid.next;
		mid.next = null;
		Node next = null;
		mid = head;
		while (mid.next != null) {
			next = right.next;
			right.next = mid.next;
			mid.next = right;
			right = next;
		}
		mid.next = right;
		return head;
	}
}
