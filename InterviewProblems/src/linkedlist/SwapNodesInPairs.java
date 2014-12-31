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
     * Allow odd number nodes
     * 
     * Easy to forget dealing with pre
     * 
     * Similar to other LinkedList node-reversing problems, but much easier
     * since only need to deal with 2 nodes at a time
     */
    public static class ListNode {
	int val;
	ListNode next;

	public ListNode(int x) {
	    val = x;
	    next = null;
	}
    }

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
