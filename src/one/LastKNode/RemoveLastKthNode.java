package one.LastKNode;

public class RemoveLastKthNode {
	
	public Node SingleRemove(Node head, int K) {
		if (head == null || K < 1)
			return head;
		Node cur = head;
		while (cur != null) {
			K--;
			cur = cur.next;
		}
		if (K == 0)
			head = head.next;
		if (K < 0) {
			cur = head;
			while (++K != 0)
				cur = cur.next;
			cur.next = cur.next.next;
		}
		return head;
	}
	
	public DoubleNode DoubleRemove(DoubleNode head, int K) {
		if (head == null || K < 1)
			return head;
		DoubleNode cur = head;
		while (cur != null) {
			K--;
			cur = cur.next;
		}
		if (K == 0) {
			head = head.next;
			head.pre = null;
		}
		if (K < 0) {
			cur = head;
			while (++K != 0)
				cur = cur.next;
			cur.next = cur.next.next;
			if (cur.next.next != null)
				cur.next.next.pre = cur;
		}
		return head;
	}
}

class Node {
	
	public int value;
	public Node next;
	
	public Node(int data) {
		this.value = data;
	}
}

class DoubleNode {
	
	public int value;
	public DoubleNode pre;
	public DoubleNode next;
	
	public DoubleNode(int data) {
		this.value = data;
	}
}
