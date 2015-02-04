package linkedlist;

public class SwapNodesInPairs {
    /**
     * Swap Nodes in Pairs
     * 
     * Given a linked list, swap every two adjacent nodes and return its head.
     * 
     * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
     * 
     * Your algorithm should use only constant space. You may not modify the
     * values in the list, only nodes itself can be changed.
     */

    /*
     *  recursion solution, simple, but not does not qualify problem restriction.
     *  It takes O(n) space to store node addresses
     */
    public class Solution3 {

	public ListNode swapPairs(ListNode head) {
	    if (head == null || head.next == null) {
		return head;
	    }

	    ListNode newHead = head.next;
	    head.next = swapPairs(head.next.next);
	    newHead.next = head;

	    return newHead;
	}
    }

    /*
     * A more intuitive solution
     * 
     * Swap node i and i+1 (i = 0, 2, 4,...)
     */
    public class Solution2 {
	public ListNode swapPairs(ListNode head) {
	    if (head == null || head.next == null) {
		return head;
	    }

	    ListNode pre = new ListNode(-1);
	    ListNode cur = head;
	    ListNode next = head.next;
	    pre.next = cur;
	    ListNode newHead = next;

	    int count = 0;
	    while (next != null) {
		if (count % 2 == 0) {
		    pre.next = next;
		    cur.next = next.next;
		    next.next = cur;

		    cur = pre.next;	// keep pre-cur-next consistent
		    next = cur.next;
		}

		pre = pre.next;
		cur = cur.next;
		next = next.next;

		count++;
	    }

	    return newHead;
	}
    }

    /*
     * Allow odd number nodes
     * 
     * Easy to forget dealing with pre
     * 
     * Similar to other LinkedList node-reversing problems, but much easier
     * since only need to deal with 2 nodes at a time
     */
    public static class Solution1 {
	public static ListNode swapPairs(ListNode head) {
	    if (head == null)
		return null;

	    // since later we will use pre.next, so pre cannot be initialized to
	    // null
	    ListNode pre = new ListNode(-1);
	    ListNode cur = head;
	    ListNode next = head.next;
	    if (next == null) {
		return head;
	    }
	    ListNode newHead = next;

	    while (cur != null && next != null) {
		cur.next = next.next;
		next.next = cur;
		pre.next = next;
		pre = cur;

		cur = cur.next;
		if (cur == null)
		    break;
		next = cur.next;
	    }

	    // detail! The new head
	    return newHead;
	}
    }
}
