package linkedlist;

public class ReverseLinkedList {
    /**
     * One pass reverse all nodes in a linked list
     */

    /*
     * Just need one more additional pointer. (not a dummy node?)
     * 
     *                       pre      head	
     * null <-- node_1 <-- node_2    node_3 --> node_4...
     * 
     */
    public class Solution {
	public ListNode reverse(ListNode head) {
	    ListNode pre = null;
	    while (head != null) {
		ListNode tmp = head.next;
		head.next = pre;
		pre = head;
		head = tmp;
	    }

	    return pre;
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
