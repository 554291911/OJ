package one.MidNode;

public class RemoveMidNode {
	
	public Node removeMidNode(Node head) {
		if (head == null || head.next == null)
			return head;
		if (head.next.next == null)
			return head.next;
		Node pre = head;
		Node cur = head.next.next;
		while (cur.next.next != null) {
			cur = cur.next.next;
			pre = pre.next;
		}
		pre.next = pre.next.next;
		return head;
	}
	
	public Node removeABNode(Node head, int a, int b) {
		if (a < 1 || a > b)
			return head;
		int n = 0;
		Node cur = head;
		while (cur != null) {
			cur = cur.next;
			n++;
		}
		n = (int)Math.ceil((double)(a * n) / (double)b);
		if (n == 1)
			head = head.next;
		if (n > 1) {
			cur = head;
			while (--n != 1)
				cur = cur.next;
			cur.next = cur.next.next;
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
