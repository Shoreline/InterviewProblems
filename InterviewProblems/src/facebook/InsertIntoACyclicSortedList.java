package facebook;

import linkedlist.ListNode;

/**
 * http://articles.leetcode.com/2011/08/insert-into-a-cyclic-sorted-list.html
 * 
 * http://www.geeksforgeeks.org/sorted-insert-for-circular-linked-list/
 *
 */
/*
 * 1. prev→val ≤ x ≤ current→val: Insert between prev and current.
 * 
 * 2. x is the maximum or minimum value in the list: Insert before the head.
 * (ie, the head has the smallest value and its prev→val > head→val.
 * 
 * 3. Traverses back to the starting point: Insert before the starting point.
 */
public class InsertIntoACyclicSortedList {
    public ListNode insertCyclicList(ListNode head, int data) {
	ListNode node = new ListNode(data);
	if (head == null) {
	    return node;
	}
	ListNode cur = head;
	ListNode prev = null;

	do {
	    prev = cur;
	    cur = cur.next;
	    if (data <= cur.val && data >= prev.val)
		break;
	    if (prev.val > cur.val && (prev.val < data || cur.val > data))
		break;
	} while (head != cur);

	prev.next = node;
	node.next = cur;

	return head;
    }
}
/*
void insert(Node *& aNode, int x) {
    if (!aNode) {
      aNode = new Node(x);
      aNode->next = aNode;
      return;
    }
   
    Node *p = aNode;
    Node *prev = NULL;
    do {
      prev = p;
      p = p->next;
      if (x <= p->data && x >= prev->data) break;   // For case 1)
      if ((prev->data > p->data) && (x < p->data || x > prev->data)) break; // For case 2)
    } while (p != aNode);   // when back to starting point, then stop. For case 3)
   
    Node *newNode = new Node(x);
    newNode->next = p;
    prev->next = newNode;
  }
*/