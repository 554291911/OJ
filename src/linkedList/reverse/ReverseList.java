package linkedList.reverse;

import commonDataStructure.DoubleNode;
import commonDataStructure.Node;

public class ReverseList {
	
	public Node singleReverse(Node head) {
		Node next = null;
		Node pre = null;
		while (head != null) {
			next = head.next;// 移动next
			head.next = pre;// 反转指针
			pre = head;// 移动pre
			head = next;// 移动head
		}
		return pre;
	}
	
	public DoubleNode doubleReverse(DoubleNode head) {
		DoubleNode pre = null;
		DoubleNode next = null;
		while (head != null) {
			next = head.next;// 移动next
			head.next = pre;// 反转指针
			head.pre = next;// 反转指针
			pre = head;// 移动pre
			head = next;// 移动head
		}
		return pre;
	}
}

