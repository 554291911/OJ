package one.palindromeList;

import java.util.Stack;

import commonDataStructure.Node;

public class PalindromeList {
	
	public boolean palindrome1(Node head) {
		if (head == null || head.next == null)
			return true;
		Stack<Node> stack = new Stack<Node>();
		Node cur = head;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while (head != null && !stack.isEmpty()) {
			if (head.value != stack.pop().value)
				return false;
			head = head.next;
		}
		return true;
	}
	
	public boolean palindrome2(Node head) {
		if (head == null || head.next == null)
			return true;
		Stack<Node> stack = new Stack<Node>();
		Node left = head;
		Node right = head.next;
		while (left.next != null && left.next.next != null) {
			stack.push(right);
			right = right.next;
		}
		while (!stack.isEmpty()) {
			if (head.value != stack.pop().value)
				return false;
			head = head.next;
		}
		return true;
	}

}

