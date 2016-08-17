package linkedList.mergeList;

import commonDataStructure.Node;

public class MergeList {

	public Node merge(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			if (head1 != null)
				return head1;
			else
				return head2;
		}
		Node head = null;
		Node cur1, cur2;
		if (head1.value < head2.value) {
			head = head1;
			head1 = head1.next;
		} else {
			head = head2;
			head2 = head2.next;
		}
		Node cur = head;
		while (head1 != null && head2 != null) {
			if (head1.value < head2.value) {
				cur.next = head1;
				head1 = head1.next;
			} else {
				cur.next = head2;
				head2 = head2.next;
			}
			cur = cur.next;
		}
		if (head1 == null) {
			cur.next = head2;
		} else
			cur.next = head1;
		return head;
	}
}
