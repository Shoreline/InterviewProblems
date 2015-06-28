package linkedlist;

/**
 * Merge Two Sorted Lists
 * 
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * ? Solve this problem
 */
/*
 * Uncertain head, use dummy node preHead for help
 */
public class MergeTwoSortedLists {
    public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	    if (l1 == null && l2 == null) {
		return null;
	    }

	    ListNode preHead = new ListNode(-1);
	    ListNode tail = preHead;
	    while (l1 != null && l2 != null) {
		if (l1.val < l2.val) {
		    tail.next = l1;
		    l1 = l1.next;
		} else {
		    tail.next = l2;
		    l2 = l2.next;
		}
		tail = tail.next;
	    }

	    tail.next = l1 == null ? l2 : l1;

	    return preHead.next;
	}
    }
}
