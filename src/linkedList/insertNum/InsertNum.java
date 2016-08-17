package linkedList.insertNum;

import commonDataStructure.Node;

public class InsertNum {

	public Node selectionSort(Node head, int num) {
		Node node = new Node(num);
		if (head == null) {
			node.next = node;
			return node;
		}
		Node pre = head;
		Node cur = head.next;
		while (cur != head) {
			if (pre.value <= num && cur.value >= num)
				break;
			pre = cur;
			cur = cur.next;
		}
		pre.next = node;
		node.next = cur;
		if (head.value >= num)
			return node;
		return head;
	}
}
