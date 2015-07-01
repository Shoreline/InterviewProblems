package linkedlist;

/**
 * Remove Nth Node From End of List
 * 
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * Note: Given n will always be valid. Try to do this in one pass.
 */

/*
 * The given head may be removed. So add a dummy node preHead and eventually
 * return preHead.next.
 */
public class RemoveNthNodeFromEndOfList {
    public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
	    if (head == null) {
		return null;
	    }
	    ListNode preHead = new ListNode(-1);
	    preHead.next = head;
	    ListNode runner = preHead;
	    ListNode walker = preHead;

	    for (int i = 0; i < n; i++) {
		runner = runner.next;
	    }

	    while (runner.next != null) {
		walker = walker.next;
		runner = runner.next;
	    }

	    walker.next = walker.next.next;

	    return preHead.next;
	}
    }

}
