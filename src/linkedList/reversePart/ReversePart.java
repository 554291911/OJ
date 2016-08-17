package linkedList.reversePart;

import commonDataStructure.Node;

public class ReversePart {
	
	public Node reversePart(Node head, int from, int to) {
		int len = 0;
		Node node1 = head, fPre = null, tPos = null;
		while (node1 != null) {
			len++;
			if (len == from - 1)// 找到要逆转的链表的头节点的前一个节点
				fPre = node1;
			if (len == to + 1)// 找到要逆转的链表的尾节点的后一个节点
				tPos = node1;
			node1 = node1.next;
		}
		if (from > to || from < 1 || to > len)
			return head;
		if (fPre == null)// 要逆转的链表包含头节点
			node1 = head;
		else
			node1 = fPre.next;
		Node node2 = node1.next;
		node1.next = tPos;// 逆序链表的头连上尾
		Node next = null;
		while (node2 != tPos) {
			next = node2.next;
			node2.next = node1;
			node1 = node2;
			node2 = next;
		}
		if (fPre != null) {
			fPre.next = node1;
			return head;
		}
		return node1;
	}
}
