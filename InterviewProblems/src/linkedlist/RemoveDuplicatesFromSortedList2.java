package linkedlist;

public class RemoveDuplicatesFromSortedList2 {
    /**
     * Remove Duplicates from Sorted List II
     * 
     * Given a sorted linked list, delete all nodes that have duplicate numbers,
     * leaving only distinct numbers from the original list.
     * 
     * For example,
     * 
     * Given 1->2->3->3->4->4->5, return 1->2->5.
     * 
     * Given 1->1->1->2->3, return 2->3.
     */

    /*
     * When deal with Linked list problems, be aware of the returned node.
     * Sometimes the original head will be deleted (to be set to null) and we
     * cannot just return it
     */

    public static ListNode deleteDuplicates2(ListNode head) {
	if (head == null || head.next == null) {
	    return head;
	}

	ListNode scanNode = head.next;
	ListNode preScanNode = head;
	ListNode updateNode = head;
	ListNode preUpdateNode = new ListNode(0);
	preUpdateNode.next = head;

	/*
	 * !! biggest corner case:
	 * 
	 * cannot just return head, since there is possibility that all elements
	 * has duplicate and we shall return null.
	 * 
	 * this case cannot be properly handled by modifying original
	 * linkedlist, since the head cannot be set to null
	 */
	boolean shallReturnNull = true;

	while (scanNode != null) {
	    int counter = 1;
	    while (scanNode != null && scanNode.val == preScanNode.val) {
		preScanNode = scanNode;
		scanNode = scanNode.next;
		counter++;
	    }
	    if (counter == 1) {
		shallReturnNull = false;
		updateNode.val = preScanNode.val;
		preUpdateNode = updateNode;
		updateNode = updateNode.next;
	    }
	    counter = 1;

	    // corner case
	    if (scanNode == null)
		break;
	    else if (scanNode.next == null) {
		shallReturnNull = false;
		updateNode.val = scanNode.val;
		preUpdateNode = updateNode;
		updateNode = updateNode.next;
	    }

	    preScanNode = scanNode;
	    scanNode = scanNode.next;

	}
	/*
	 * cannot just set a Node to null? or just the "head" cannot be
	 * changed???
	 * 
	 * can only set aNode.next to null
	 */

	preUpdateNode.next = null;

	if (shallReturnNull)
	    head = null;

	return head;
    }
}
