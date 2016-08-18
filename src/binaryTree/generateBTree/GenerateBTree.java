package binaryTree.generateBTree;

import commonDataStructure.doubleNode.Node;

public class GenerateBTree {
	
	public Node generateBTree(int[] sortArr) {
		if (sortArr == null || sortArr.length == 0)
			return null;
		return generate(sortArr, 0, sortArr.length - 1);
	}
	
	private Node generate(int[] sortArr, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		Node head = new Node(sortArr[mid]);
		head.left = generate(sortArr, start, mid - 1);
		head.right = generate(sortArr, mid + 1, end);
		return head;
	}
}
