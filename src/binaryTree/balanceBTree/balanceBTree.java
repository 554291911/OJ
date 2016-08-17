package binaryTree.balanceBTree;

import commonDataStructure.doubleNode.Node;

public class balanceBTree {
	
	public boolean isBalance(Node head) {
		boolean res = true;
		getHeight(head, 1, res);
		return res;
	}
	
	private int getHeight(Node head, int level, boolean res) {
		if (head == null)
			return level;
		int leftH = getHeight(head.left, level + 1, res);// 递归左子树
		if (!res)
			return level;// 发现左子树不是平衡二叉树，返回
		int rightH = getHeight(head.right, level + 1, res);
		if (!res)
			return level;// 发现右子树不是平衡二叉树，返回
		if (Math.abs(leftH - rightH) > 1)// 发现不是平衡二叉树
			res = false;// flag
		return Math.max(leftH, rightH);
	}
}
