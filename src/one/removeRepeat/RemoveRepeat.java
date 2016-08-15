package one.removeRepeat;

import java.util.HashSet;

import commonDataStructure.Node;

public class RemoveRepeat {

	public void removeRepeat1(Node head) {
		if (head == null)
			return;
		HashSet<Integer> set = new HashSet<Integer>();
		Node pre = head;
		Node cur = head.next;
		set.add(head.value);
		while (cur != null) {
			if (set.contains(cur.value))
				pre.next = cur.next;
			else {
				set.add(cur.value);
				pre = cur;
			}
			cur = cur.next;
		}
	}
	
	public void removeRepeat2(Node head) {
		if (head == null)
			return;
		Node pre = null;
		Node cur = head;
		Node next = null;
		while (cur != null) {
			next = cur.next;
			while (next != null) {
				if (cur.value == next.value)
					pre.next = next.next;
				else
					pre = next;
				next = next.next;
			}
			cur = cur.next;
		}
	}
}
