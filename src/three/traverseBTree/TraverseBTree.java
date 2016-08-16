package three.traverseBTree;

import java.util.Stack;

import commonDataStructure.doubleNode.Node;

public class TraverseBTree {
	
	public void preOrder1(Node head) {
		if (head == null)
			return;
		System.out.print(head.value + "	");
		preOrder1(head.left);
		preOrder1(head.right);
	}
	
	public void inOrder1(Node head) {
		if (head == null)
			return;
		inOrder1(head.left);
		System.out.print(head.value + "	");
		inOrder1(head.right);
	}
	
	public void posOrder1(Node head) {
		if (head == null)
			return;
		posOrder1(head.left);
		posOrder1(head.right);
		System.out.print(head.value + "	");
	}
	
	public void preOrder2(Node head) {
		if (head != null) {
			Stack<Node> s = new Stack<Node>();
			s.push(head);// 头节点压入栈
			while (!s.isEmpty()) {// 直到栈为空为止
				head = s.pop(); // 弹出栈顶节点
				System.out.print(head.value + "	");// 并打印
				if (head.right != null)// 压入右孩子
					s.push(head.right);
				if (head.left != null)// 压入左孩子
					s.push(head.left);
			}
		}
	}
	
	public void inOrder2(Node head) {
		if (head != null) {
			Stack<Node> s = new Stack<Node>();
			while (!s.isEmpty() || head != null) {
				if (head != null) {
					head = head.left;// 不停的令head = head.left
					s.push(head);// 压入left
				} else {// 没有左孩子了
					head = s.pop();// 弹出栈顶
					System.out.print(head.value + "	");
					head = head.right;
				}
			}
		}
	}
	
	public void posOrder2(Node head) {
		if (head != null) {
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			s1.push(head);
			while (!s1.isEmpty()) {
				head = s1.pop();// 弹出栈顶
				s2.push(head);// 压入s2
				// 压入栈顶节点的左孩子和右孩子
				if (head.left != null)
					s1.push(head.left);
				if (head.right != null)
					s1.push(head.right);
			}
			while (!s2.isEmpty())
				System.out.print(s2.pop().value + "	");
		}
	}
}
