package linkedlist;

public class RemoveNthNodeFromEndOfList {
    /**
     * Remove Nth Node From End of List
     * 
     * Given a linked list, remove the nth node from the end of list and return
     * its head.
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
     * need to think whether null will be returned
     * 
     * corner case 2: list length longer than 1, and the first node needs to be
     * removed
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
	if (head == null || (head.next == null && n == 1)) {
	    return null;
	}

	ListNode itr1 = head;
	ListNode itr2 = head;
	ListNode preItr1 = new ListNode(0);
	preItr1.next = itr1;

	for (int i = 0; i < n; i++) {
	    itr2 = itr2.next;
	}

	while (itr2 != null) {
	    preItr1 = itr1;
	    itr1 = itr1.next;
	    itr2 = itr2.next;
	}

	if (head != itr1) {
	    preItr1.next = itr1.next; // skip the node that needs to be removed
	    return head;
	} else {
	    return head.next; // skip head, since it shall be removed
	}
    }
}
