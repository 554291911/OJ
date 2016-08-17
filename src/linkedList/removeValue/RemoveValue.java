package linkedList.removeValue;

import java.util.Stack;

import commonDataStructure.Node;

public class RemoveValue {

	public Node removeValue1(Node head, int num) {
		Stack<Node> stack = new Stack<Node>();
		while (head != null) {
			if (head.value != num)
				stack.push(head);
			head = head.next;
		}
		Node node = null;
		while (!stack.isEmpty()) {
			node = head;
			head = stack.pop();
			head.next = node;
		}
		return head;
	}
	
	public Node removeValue2(Node head, int num) {
		while (head != null) {
			if (head.value != num)
				break;
			head = head.next;
		}
		Node pre = head;
		Node cur = head;
		while (cur != null) {
			if (cur.value == num)
				pre.next = cur.next;
			cur = cur.next;
		}
		return head;
	}
}
