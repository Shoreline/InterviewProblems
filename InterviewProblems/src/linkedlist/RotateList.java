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
     * Note: k may larger than the length of this list. In this case let k = k %
     * len
     */

    /*
     * Since the new head is certain, so did not use dummy node.
     * 
     * Fast-slow (early-late) two pointers. Once fast reaches the end:
     * 1) new head is slow.next; new end is slow;
     * 2) fast.next needs to connect to slow
     */
    public class Solution_2 {
	public ListNode rotateRight(ListNode head, int k) {
	    if (head == null || k == 0) {
		return head;
	    }

	    ListNode tmp = head;
	    int len = 0;
	    while (tmp != null) {
		tmp = tmp.next;
		len++;
	    }

	    k = k % len;

	    ListNode fast = head;
	    ListNode slow = head;

	    for (int i = 0; i < k; i++) {
		fast = fast.next;
	    }

	    while (fast.next != null) {
		fast = fast.next;
		slow = slow.next;
	    }

	    fast.next = head;
	    head = slow.next;
	    slow.next = null;

	    return head;
	}
    }

    
    class Solution_1 {
	public ListNode rotateRight(ListNode head, int n) {
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
}
