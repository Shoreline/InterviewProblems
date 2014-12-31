package linkedlist;

public class RemoveDuplicatesFromSortedList {
    /**
     * Remove Duplicates from Sorted List
     * 
     * Given a sorted linked list, delete all duplicates such that each element
     * appear only once.
     * 
     * For example,
     * 
     * Given 1->1->2, return 1->2.
     * 
     * Given 1->1->2->3->3, return 1->2->3.
     */

    /*
     * Tell the difference between commands below:
     * 
     * 1. preNode.next = xx
     * 
     * 2. preNode == xx
     * 
     * In the first case, preNode's address is not changed! only the link to
     * next node is changed.
     * 
     * In the second case, preNode's address is changed. It is re-assigned to
     * another node.
     */

    public ListNode deleteDuplicates(ListNode head) {
	if (head == null) {
	    return head;
	}

	ListNode curNode = head.next;
	ListNode preNode = head;

	while (curNode != null) {
	    if (curNode.val == preNode.val) {
		preNode.next = curNode.next; // does not change preNode's value
		curNode = curNode.next;
		/*
		 * in this case, both preNode and curNode have already been
		 * updated: preNode stays the same, curNode= curNode.next
		 * 
		 * So continue to next iteration
		 */
		continue;
	    }

	    preNode = curNode;
	    curNode = curNode.next;

	}

	return head;
    }
}
