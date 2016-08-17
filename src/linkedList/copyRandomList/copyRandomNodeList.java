package linkedList.copyRandomList;

import java.util.HashMap;

import commonDataStructure.randomNode.Node;

public class copyRandomNodeList {

	public Node copyListWithRand1(Node head) {
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		Node cur = head;
		while (cur != null) {
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		cur = head;
		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		}
		return map.get(head);
	}

	public Node copyListWithRand2(Node head) {
		if (head == null)
			return null;
		Node cur = head;
		Node next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = new Node(cur.value);
			cur.next.next = next;
			cur = next;
		}
		cur = head;
		Node copy = null;
		while (cur != null) {
			next = cur.next.next;
			copy = cur.next;
			if (cur.rand != null)
				copy.rand = cur.rand.next;
			else
				copy.rand = null;
			cur = cur.next;
		}
		Node res = head.next;
		cur = head;
		while (cur != null) {
			next = cur.next.next;
			copy = cur.next;
			cur.next = next;
			if (next != null)
				copy.next = next.next;
			else
				copy.next = null;
			cur = next;
		}
		return res;
	}
}
