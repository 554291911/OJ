package linkedList.copyRandomList;


/**
 * 	复制含有随机指针节点的链表 一种特殊的链表节点类描述如下：
 * 		public class Node {
 *	
 *			public int value;
 *			public Node next;
 *			public Node rand;
 *
 *			public Node(int data) {
 *				this.value = data;
 *			}
 *		}
 *	Node类中的value是节点值，next指针和正常单链表中next指针的意义一样，都指向下一个节点，rand指针是Node类中新增的指针，
 *	这个指针可能指向链表中的任意一个节点，也可能指向null。
 *	给定一个由Node节点类型组成的无环单链表的头节点head,请实现一个函数完成这个链表中所有结构的复制，并返回复制的新链表的头节点。
 *	例如：链表： 1 -> 2 -> 3 -> null,假设1的rand指针指向3,2的rand指针指向null,3的rand指针指向1.复制后的链表应该也是这种结构，
 *	比如， 1' -> 2' -> 3' -> null,1'的rand指针指向3'，2'的rand指针指向null,3'的rand指针指向1'，最后返回1'。
 *	进阶：
 *	不使用额外的数据结构，只用有限几个变量，且在时间复杂度为O(N)内完成原问题要实现的函数
 *			
 */

