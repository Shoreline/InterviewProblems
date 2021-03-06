package linkedlist;

/**
 * Reverse Nodes in k-Group
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end
 * should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example, Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 */

/*
 * my solution is not the most concise but easy to understand
 * 
 * Inclusively reverse [segHead, cur]. Set cur.next = null before reversing.
 */
public class ReverseNodesInKGroup {

    public class Solution_mine {
	public ListNode reverseKGroup(ListNode head, int k) {
	    if (head == null || k <= 1) {
		return head;
	    }

	    ListNode preHead = new ListNode(-1);
	    preHead.next = head;
	    ListNode cur = head;
	    ListNode segPre = preHead;
	    ListNode segHead = head;
	    int c = 1;
	    while (cur != null) {
		ListNode next = cur.next; // cur may change, so save cur.next to
					  // next beforehand
		if (c % k == 1) {
		    segHead = cur;
		} else if (c % k == 0) {
		    cur.next = null;
		    segPre.next = reverse(segHead);
		    segPre = segHead;
		    segPre.next = next;
		}

		cur = next;
		c++;
	    }

	    return preHead.next;
	}

	private ListNode reverse(ListNode head) {
	    ListNode cur = head;
	    ListNode pre = null;

	    while (cur != null) {
		ListNode next = cur.next;
		cur.next = pre;
		pre = cur;
		cur = next;
	    }

	    return pre;
	}
    }

    public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
	    if (head == null) {
		return null;
	    }
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    int count = 0;
	    ListNode pre = dummy;
	    ListNode cur = head;
	    while (cur != null) {
		count++;
		ListNode next = cur.next;
		if (count == k) {
		    pre = reverse(pre, next);
		    count = 0;
		}
		cur = next;
	    }
	    return dummy.next;
	}

	private ListNode reverse(ListNode pre, ListNode end) {
	    if (pre == null || pre.next == null)
		return pre;
	    ListNode head = pre.next;
	    ListNode cur = pre.next.next;
	    while (cur != end) {
		ListNode next = cur.next;
		cur.next = pre.next;
		pre.next = cur;
		cur = next;
	    }
	    head.next = end;
	    return head;
	}
    }

    class solutions_2013 {
	/*
	 * second round
	 * 
	 * Two passes. The first one is to count the LinkedList length
	 */
	public ListNode reverseKGroup2(ListNode head, int k) {
	    if (head == null || k == 1)
		return head;

	    ListNode cur = head;
	    int len = 0;

	    while (cur != null) {
		len++;
		cur = cur.next;
	    }

	    if (len < k)
		return head;

	    cur = head;

	    ListNode newSegTail = cur;
	    ListNode preSegTail = new ListNode(-1);
	    ListNode pre = null;
	    ListNode next = cur.next;

	    int i = 0;
	    while (i + k <= len) {

		for (int j = 0; j < k; j++) {
		    if (cur == null)
			break;

		    cur.next = pre;
		    pre = cur;
		    cur = next;
		    if (next != null)
			next = next.next;

		}

		if (i < k) {
		    head = pre;
		}

		/*
		 * five ListNode variables need to be updated!
		 */
		preSegTail.next = pre;
		newSegTail.next = cur;
		pre = newSegTail;
		preSegTail = newSegTail;
		newSegTail = cur;

		i += k;
	    }

	    return head;
	}

	/*
	 * The problem wants us to reverse the first k nodes in a list, then
	 * next k nodes, then next next k nodes...
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
	    if (head == null || k <= 1)
		return head;

	    ListNode cur = head;
	    int length = 1;
	    while (cur.next != null) {
		length++;
		cur = cur.next;
	    }
	    if (k > length)
		return head;

	    ListNode pre = new ListNode(-1);
	    cur = head;
	    ListNode next = cur.next;
	    pre.next = cur;

	    ListNode preList = pre;

	    for (int i = 0; i < length / k; i++) {
		if (i > 0) {
		    // easy to mak mistake
		    pre = preList;
		    cur = next;
		    next = cur.next;
		}

		for (int j = 0; j < k; j++) {
		    if (j == k - 1) {
			cur.next = pre;
			pre = cur;
			break;
		    }

		    cur.next = pre;
		    pre = cur;
		    cur = next;
		    next = next.next;
		}
		if (i == 0) {
		    head = cur;
		}

		preList.next.next = next;
		ListNode temp = preList.next;
		preList.next = cur;
		preList = temp;

	    }

	    return head;
	}
    }
}
