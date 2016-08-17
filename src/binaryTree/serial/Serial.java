package binaryTree.serial;

import java.util.LinkedList;

import commonDataStructure.doubleNode.Node;

public class Serial {
	
	public String serialByPre(Node head) {
		if (head == null)
			return "#!";
		String res = head.value + "!";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}
	
	public Node reSerialByPre(String preStr) {
		String[] values = preStr.split("!");
		LinkedList<String> queue = new LinkedList<String>();
		for (int i = 0; i < values.length; i++)
			queue.offer(values[i]);
		return recoverPreOrder(queue);
	}
	
	private Node recoverPreOrder(LinkedList<String> queue) {
		String value = queue.poll();
		if (value.equals("#"))
			return null;
		Node head = new Node(Integer.valueOf(value));
		head.left = recoverPreOrder(queue);
		head.right = recoverPreOrder(queue);
		return head;
	}
	
	public String serialByLevel(Node head) {
		if (head == null)
			return "#!";
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.offer(head);
		String res = head.value + "!";
		while (!queue.isEmpty()) {
			head = queue.poll();
			if (head.left != null) {
				res += head.left.value + "!";
				queue.offer(head.left);
			} else
				res += "#!";
			if (head.right == null) {
				res += head.right.value + "!";
				queue.offer(head.right);
			} else
				res += "#!";
		}
		return res;
	}
	
	public Node reSerialByLevel(String levelStr) {
		String[] values = levelStr.split("!");
		Node head = generateNode(values[0]);
		LinkedList<Node> queue = new LinkedList<Node>();
		if (head != null)
			queue.offer(head);
		Node node = null;
		int index = 1;
		while (!queue.isEmpty()) {
			node = queue.poll();
			node.left = generateNode(values[index++]);
			node.right = generateNode(values[index++]);
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}
		return head;
	}
	
	private Node generateNode(String string) {
		if (string.equals("#"))
			return null;
		else
			return new Node(Integer.valueOf(string));
	}
}
