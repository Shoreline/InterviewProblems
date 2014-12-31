package linkedlist;

public class RotateList {
    /**
     * Rotate List
     * 
     * Given a list, rotate the list to the right by k places, where k is
     * non-negative.
     * 
     * For example:
     * 
     * Given 1->2->3->4->5->NULL and k = 2,
     * 
     * return 4->5->1->2->3->NULL.
     */
    /*
     * what if k is larger than the length of this list?
     */
    public static ListNode rotateRight(ListNode head, int n) {
	// corner case! if n==0 or n%length==0
	if (head == null || n == 0)
	    return head;

	ListNode cur = head;
	int length = 1;
	// move cur to be the last node, meanwhile count list length
	while (cur.next != null) {
	    cur = cur.next;
	    length++;
	}
	// in case n is longer then the length of list
	n = n % length;
	if (n == 0)
	    return head;
	// detail! Rotation starts from n from the BACK!
	n = length - n;

	ListNode newhead = head;
	ListNode newend = new ListNode(-1);
	newend.next = newhead;

	for (int i = 0; i < n; i++) {
	    newend = newend.next;
	    newhead = newhead.next;
	}

	// Link original head to be original end's next node
	cur.next = head;
	newend.next = null;

	return newhead;
    }
}
