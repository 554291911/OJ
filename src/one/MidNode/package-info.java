package one.MidNode;

/**
 *	给定链表的头节点head,实现删除链表中的中间节点的函数
 *	例如：
 *	1 -> 2, 删除节点1;
 *	1 -> 2 -> 3, 删除节点2;
 *	1 -> 2 -> 3 -> 4, 删除节点2;
 *	1 -> 2 -> 3 -> 4 -> 5, 删除节点3;
 *	进阶：
 *	给定链表的头节点head,整数a和b，实现删除位于a/b处节点的函数
 *	例如：
 *	链表1 -> 2 -> 3 -> 4 -> 5, 假设a/b的值为r。
 *	如果r等于0，不删除任何节点
 *	如果r在区间(0, 1/5]上，删除节点1;
 *	如果r在区间(1/5, 2/5]上，删除节点2;
 *	如果r在区间(2/5, 3/5]上，删除节点3;
 *	如果r在区间(3/5, 4/5]上，删除节点4;
 *	如果r在区间(4/5, 1]上，删除节点5;
 *	如果r大于1，不删除任何节点
 *
 */
