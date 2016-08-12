package one.reverse;

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

class Node {
	
	public int value;
	public Node next;
	
	public Node(int data) {
		this.value = data;
	}
}

class DoubleNode {
	
	public int value;
	public DoubleNode pre;
	public DoubleNode next;
	
	public DoubleNode(int data) {
		this.value = data;
	}
}
