package linkedList.convertBTree;

import java.util.LinkedList;

import commonDataStructure.doubleNode.Node;

public class ConvertBTree {

	public Node convert(Node head) {
		LinkedList<Node> list = new LinkedList<Node>();
		inOrderToqueue(head, list);
		head = list.poll();
		Node pre = head;
		pre.left = null;
		Node cur = null;
		while (!list.isEmpty()) {
			cur = list.poll();
			pre.right = cur;
			cur.left = pre;
			pre = cur;
		}
		pre.right = null;
		return head;
	}

	private void inOrderToqueue(Node head, LinkedList<Node> list) {
		if (head == null)
			return;
		inOrderToqueue(head.left, list);
		list.offer(head);
		inOrderToqueue(head.right, list);
	}

}
