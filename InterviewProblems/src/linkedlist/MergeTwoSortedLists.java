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

    public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	    if (l1 == null) {
		return l2;
	    } else if (l2 == null) {
		return l1;
	    }

	    ListNode head = (l1.val < l2.val ? l1 : l2);
	    ListNode end = new ListNode(-1);

	    while (l1 != null && l2 != null) {
		ListNode min = null;
		if (l1.val < l2.val) {
		    min = l1;
		    l1 = l1.next;
		} else {
		    min = l2;
		    l2 = l2.next;
		}

		// add a node to the end
		end.next = min;
		end = end.next;
	    }

	    end.next = (l1 == null ? l2 : l1);

	    return head;
	}
    }
}
