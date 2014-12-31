package linkedlist;

public class ReverseLinkedList {
    /**
     * One pass reverse all nodes in a linked list
     */
    /*
     * Tested in LeetCode OJ
     */
    public static ListNode reverseList(ListNode head) {

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
