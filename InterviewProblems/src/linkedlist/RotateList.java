package linkedlist;

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
 * Note: k may larger than the length of this list. In this case let k = k % len
 */
public class RotateList {
    /*
     * Since the new head is certain, so did not use dummy node.
     * 
     * Fast-slow (early-late) two pointers. Once fast reaches the end: 1) new
     * head is slow.next; new end is slow; 2) fast.next needs to connect to slow
     */
    public class Solution {
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

}
