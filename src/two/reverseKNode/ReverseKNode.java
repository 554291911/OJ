package two.reverseKNode;

import java.util.Stack;

import commonDataStructure.Node;

public class ReverseKNode {

	public Node reverseKNode1(int K, Node head) {
		if (K < 2)
			return head;
		Node cur = head;
		Node newHead = head;
		Node pre = null, next = null;
		Stack<Node> s = new Stack<Node>();
		while (cur != null) {
			s.push(cur);
			next = cur.next;
			if (s.size() == K) {
				pre = rebuild(s, pre, next);
				if (newHead == head)
					newHead = cur;
			}
			cur = next;
		}
		return newHead;
	}

	private Node rebuild(Stack<Node> s, Node left, Node right) {
		Node cur = s.pop();
		if (left != null)
			left.next = cur;
		Node next = null;
		while (!s.isEmpty()) {
			next = s.pop();
			cur.next = next;
			cur = next;
		}
		cur.next = right;
		return cur;
	}
	
	public Node reverseKNode2(int K, Node head) {
		if (K < 2)
			return head;
		Node cur = head;
		Node start = null;
		Node pre = null, next = null;
		int count = 1;
		while (cur != null) {
			next = cur.next;
			if (count == K) {
				if (pre == null) {
					start = head;
					head = cur;
				} else
					start = pre.next;
				rebuild2(pre, start, cur, next);
				pre = start;
				count = 0;
			}
			count++;
			cur = next;
		}
		return head;
	}
	
	private void rebuild2(Node left, Node start, Node end, Node right) {
		Node pre = start;
		Node cur = start.next;
		Node next = null;
		while (cur != right) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		if (left != null)
			left.next = end;
		start.next = right;
	}
}
