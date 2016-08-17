package binaryTree.printByLevel;

import java.util.LinkedList;

import commonDataStructure.doubleNode.Node;

public class PrintByLevel {
	
	public void printByLevel(Node head) {
		if (head == null)
			return;
		Node last = head;
		Node nextLast = null;
		int level = 1;
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.offer(head);
		System.out.print("Level " + level + " : ");
		while (!queue.isEmpty()) {
			head = queue.pop();
			if (head.left != null) {
				queue.offer(head.left);
				nextLast = head.left;
			}
			if (head.right != null) {
				queue.offer(head.right);
				nextLast = head.right;
			}
			if (head == last && !queue.isEmpty()) {
				System.out.print("\nLevel " + (level++) + " : ");
				last = nextLast;
			}
		}
	}
}
