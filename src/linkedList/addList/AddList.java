package linkedList.addList;

import java.util.Stack;

import commonDataStructure.Node;

public class AddList {
	
	public Node addList1(Node head1, Node head2) {
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		while (head1 != null) {
			s1.push(head1.value);
			head1 = head1.next;
		}
		while (head2 != null) {
			s2.push(head2.value);
			head2 = head2.next;
		}
		int num1 = 0, num2 = 0, carry = 0, n = 0;
		Node node = null, pre = null;
		while (!s1.isEmpty() || s2.isEmpty()) {
			if (s1.isEmpty())
				num1 = 0;
			else
				num1 = s1.pop();
			if (s2.isEmpty())
				num2 = 0;
			else
				num2 = s2.pop();
			n = num1 + num2 + carry;
			pre = node;
			node = new Node(n % 10);
			node.next = pre;
			carry = n / 10;
		}
		if (carry == 1) {
			pre = node;
			node = new Node(1);
			node.next = pre;
		}
		return node;
	}
	
	public Node addList2(Node head1, Node head2) {
		head1 = reverseList(head1);
		head2 = reverseList(head2);
		int num1 = 0, num2 = 0, carry = 0, n = 0;
		Node node = null, pre = null;
		while (head1 != null || head2 != null) {
			if (head1 != null)
				num1 = head1.value;
			else
				num2 = 0;
			if (head2 != null)
				num2 = head2.value;
			else
				num2 = 0;
			n = num1 + num2 + carry;
			carry = n / 10;
			pre = node;
			node = new Node(n % 10);
			node.next = pre;
			if(head1.next == null)
				head1 = null;
			else
				head1 = head1.next;
			if(head2.next == null)
				head2 = null;
			else
				head2 = head2.next;
		}
		if (carry == 1) {
			pre = node;
			node = new Node(1);
			node.next = pre;
		}
		return node;
	}
	
	private Node reverseList(Node head) {
		Node pre = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return head;
	}
}
