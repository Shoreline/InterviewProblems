package linkedlist;

/**
 * Insertion Sort List
 * 
 * Sort a linked list using insertion sort.
 *
 */

/*
 * Time O(N^2); Space O(1)
 */
public class InsersionSortList {
    public class Solution {
	public ListNode insertionSortList(ListNode head) {
	    if (head == null) {
		return null;
	    }

	    ListNode dummy = new ListNode(-1);
	    dummy.next = head;

	    ListNode pre = dummy;
	    ListNode cur = head;
	    
	    while (cur.next != null) {
		ListNode next = cur.next;
		if (next.val >= cur.val) {
		    // next node > cur node is expected
		    pre = cur;
		    cur = cur.next;
		} else {
		    cur.next = next.next;// take next out

		    // start from beginning to find the insertion place for next
		    pre = dummy;
		    cur = dummy.next;
		    while (cur != null && cur.val < next.val) {
			pre = cur;
			cur = cur.next;
		    }

		    // insert next between pre and cur
		    pre.next = next;
		    next.next = cur;
		    pre = next;
		}
	    }

	    return dummy.next;
	}
    }
}
