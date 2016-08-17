package binaryTree.rebuildBSTByPos;

import commonDataStructure.doubleNode.Node;

public class RebuildBSTByPos {
	
	public boolean isPosArray(int[] arr) {
		if (arr == null || arr.length == 0)
			return false;
		return isPos(arr, 0, arr.length - 1);
	}

	private boolean isPos(int[] arr, int start, int end) {
		if (arr == null || arr.length == 0)
			return false;
		int less = -1;
		int more = end;
		for (int i = start; i < end; i++) {
			if (arr[end] > arr[i])
				less = i;// 找到最后一个比头节点小的
			else {
				if (more == end)
					more = i;// 找到第一个比头节点大的
			}
		}
		if (less == -1 || more == end)
			return isPos(arr, start, end - 1);// less = -1,没有左子树//more = end,没有右子树
		if (less != more - 1)// 不是搜索二叉树
			return false;
		return isPos(arr, start, less) && isPos(arr, more, end - 1);// 递归左右子树
	}
	
	public Node posArrayToBST(int[] arr) {
		if (arr == null || arr.length == 0)
			return null;
		return posToBST(arr, 0, arr.length - 1);
	}

	private Node posToBST(int[] arr, int start, int end) {
		if (arr == null || arr.length == 0)
			return null;
		Node head = new Node(arr[end]);
		int less = -1;
		int more = end;
		for (int i = start; i < end; i++) {
			if (arr[end] > arr[i])
				less = i;
			else {
				if (more == end)
					more = i;
			}
		}
		head.left = posToBST(arr, start, less);
		head.right = posToBST(arr, more, end - 1);
		return head;
	}

}
