package linkedList.splitAndSortList;

import commonDataStructure.Node;

public class SplitAndSortList {
	
	public Node splitAndSortList(Node head, int pivot) {
		Node smallHead = null;// 小部分的头
		Node smallLast = null;// 小部分的尾
		Node equalHead = null;// 相等部分的头
		Node equalLast = null;// 相等部分的尾
		Node bigHead = null;// 大部分的头
		Node bigLast = null;// 大部分的尾
		Node next = null;// 下一个节点
		while (head != null) {
			next = head.next;
			head.next = null;
			if (head.value < pivot) {
				if (smallHead == null) {
					smallHead = head;
					smallLast = head;
				} else {
					smallLast.next = head;
					smallLast = head;
				}
			} else
				if (head.value == pivot) {
					if (equalHead == null) {
						equalHead = head;
						equalLast = head;
					} else {
						equalLast.next = head;
						equalLast = head;
					}
				} else {
					if (bigHead == null) {
						bigHead = head;
						bigLast = head;
					} else {
						bigLast.next = head;
						bigLast = head;
					}
				}
			head = next;
		}
		if (smallLast != null) {
			smallLast.next = equalHead;
			if (equalLast == null)
				equalLast = smallLast;
		}
		if (equalLast != null) {
			equalLast.next = bigHead;
		}
		if (smallHead != null)
			return smallHead;
		else
			if (equalHead != null)
				return equalHead;
			else
				return bigHead;
	}
}
