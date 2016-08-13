package one.commonLinkedList;

import commonDataStructure.Node;

public class CommonSortedLinkedList {

	public void printCommonList(Node head1, Node head2) {
		while (head1 != null && head2 != null) {
			if (head1.value < head2.value)
				head1 = head1.next;
			else
				if (head1.value > head2.value)
					head2 = head2.next;
				else {
					System.out.print(head1.value + " ");
					head1 = head1.next;
					head2 = head2.next;
				}
		}
	}
}
