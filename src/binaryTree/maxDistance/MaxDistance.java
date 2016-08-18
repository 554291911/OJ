package binaryTree.maxDistance;

import commonDataStructure.doubleNode.Node;

public class MaxDistance {
	
	public int maxDistance(Node head) {
		int record = 0;
		return posOrder(head, record);
	}

	private int posOrder(Node head, int record) {
		if (head == null) {
			record = 0;
			return 0;
		}
		int leftMax = posOrder(head.left, record);
		int maxFromLeft = record;
		int rightMax = posOrder(head.right, record);
		int maxFromRight = record;
		int curNodeMax = maxFromLeft + maxFromRight + 1;
		record = Math.max(maxFromLeft, maxFromRight) + 1;
		return Math.max(Math.max(leftMax, rightMax), curNodeMax);
	}

}
