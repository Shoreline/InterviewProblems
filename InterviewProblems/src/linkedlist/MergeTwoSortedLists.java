package linkedlist;

public class MergeTwoSortedLists {
    /**
     * Merge Two Sorted Lists
     * 
     * Merge two sorted linked lists and return it as a new list. The new list
     * should be made by splicing together the nodes of the first two lists.
     * 
     * ? Solve this problem
     */
    /*
     * one time pass
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	if (l1 == null)
	    return l2;
	if (l2 == null)
	    return l1;

	ListNode pre = new ListNode(-1);
	ListNode head = null;
	while (l1 != null && l2 != null) {
	    ListNode min = null;
	    if (l1.val < l2.val) {
		min = l1;
		l1 = l1.next;
	    } else {
		min = l2;
		l2 = l2.next;
	    }

	    if (head == null) {
		head = min;
	    }
	    pre.next = min;
	    pre = min;
	}

	if (l1 != null) {
	    pre.next = l1;
	} else if (l2 != null) {
	    pre.next = l2;
	}

	return head;
    }
}
