package binaryTree.rebuildBTree;

import java.util.HashMap;

import commonDataStructure.doubleNode.Node;

public class RebuildBTree {
	
	public Node preInToTree(int[] pre, int[] in) {
		if (pre == null || in == null)
			return null;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < in.length; i++)
			map.put(in[i], i);
		return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
	}

	private Node preIn(int[] pre, int pi, int pj, int[] in, int ini, int inj, HashMap<Integer, Integer> map) {
		if (pre == null || in == null)
			return null;
		Node head = new Node(pre[pi]);
		int index = map.get(pre[pi]);
		head.left = preIn(pre, pi + 1, pi + index - ini, in, ini, index - 1, map);
		head.right = preIn(pre, pi + index - ini + 1, pj, in, index + 1, inj, map);
		return head;
	}
}
