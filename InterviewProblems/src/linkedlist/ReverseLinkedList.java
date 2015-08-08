package linkedlist;

/**
 * Reverse Linked List
 * 
 * One pass reverse all nodes in a linked list
 */

public class ReverseLinkedList {
    /*
     * Just need one more additional pointer. (not a dummy node?)
     * 
     * pre head null <-- node_1 <-- node_2 node_3 --> node_4...
     * 
     */
    public class Solution {
	public ListNode reverse(ListNode head) {
	    ListNode pre = null;
	    while (head != null) {
		ListNode next = head.next;
		head.next = pre;
		pre = head;
		head = next;
	    }

	    return pre;
	}
    }

    public class Solution_Recursion {
	public ListNode reverseList(ListNode head) {
	    ListNode[] newHead = new ListNode[1];
	    helper(head, newHead);

	    return newHead[0];
	}

	public ListNode helper(ListNode cur, ListNode[] newHead) {
	    if (cur == null || cur.next == null) {
		newHead[0] = cur;
		return cur;
	    }

	    ListNode next = helper(cur.next, newHead);

	    cur.next = null;
	    next.next = cur;

	    return cur;
	}
    }

    public class Solution_Recursion2 {
	ListNode newHead = null;

	public ListNode reverseList(ListNode head) {
	    helper(head);

	    return newHead;
	}

	public ListNode helper(ListNode cur) {
	    if (cur == null || cur.next == null) {
		newHead = cur;
		return cur;
	    }

	    ListNode next = helper(cur.next);

	    cur.next = null;
	    next.next = cur;

	    return cur;
	}
    }

    /*
     * Same thought as Solution but much harder to understand
     * 
     * Tested in LeetCode OJ
     */
    public class Solution_old {
	public ListNode reverseList(ListNode head) {

	    if (head == null)
		return head;

	    // no need to set safe guard node
	    ListNode pre = null;
	    ListNode cur = head;
	    ListNode next = head.next;

	    while (next != null) {
		cur.next = pre;

		pre = cur;
		cur = next;
		next = next.next;
	    }

	    // do not forget this line
	    cur.next = pre;

	    return cur;
	}
    }
}
