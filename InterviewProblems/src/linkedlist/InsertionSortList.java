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
public class InsertionSortList {
    public class Solution {
	public ListNode insertionSortList(ListNode head) {
	    if (head == null || head.next == null) {
		return head;
	    }

	    ListNode preHead = new ListNode(-1);
	    preHead.next = head;
	    ListNode pre = head;
	    ListNode cur = head.next;

	    while (cur != null) {
		if (cur.val >= pre.val) {
		    pre = cur;
		    cur = cur.next;
		} else {
		    /*
		     * cut tmp out and insert it back to a proper place
		     */
		    ListNode tmp = cur;
		    pre.next = cur.next; // pre pointer stays there

		    // start from beginning to find the insertion place for tmp.
		    // It will be inserted between cur and cur.next
		    cur = preHead;
		    while (cur.next.val < tmp.val) {
			cur = cur.next;
		    }
		    tmp.next = cur.next;
		    cur.next = tmp;

		    cur = pre.next;
		}
	    }

	    return preHead.next;
	}
    }

}
