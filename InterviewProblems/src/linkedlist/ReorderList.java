package linkedlist;

/**
 * Reorder List
 * 
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 */

/*
 * 1) cut given list into 2 lists from the middle 2) reverse the second list 3)
 * merge the two lists.
 */
public class ReorderList {
    public class Solution {
	public void reorderList(ListNode head) {
	    if (head == null) {
		return;
	    }

	    /*
	     * for a list of even amount node, divide evenly;
	     * 
	     * for a list of odd amount node, the middle node go with the first
	     * half
	     */
	    ListNode middle = findMiddleNode(head);
	    ListNode head2 = middle.next;
	    middle.next = null;

	    head2 = reverseList(head2);

	    ListNode cur = head;
	    head = head.next;

	    int count = 0;
	    while (head != null && head2 != null) {
		if (count % 2 == 0) {
		    cur.next = head2;
		    head2 = head2.next;
		} else {
		    cur.next = head;
		    head = head.next;
		}
		cur = cur.next;
		cur.next = null;
		count++;
	    }

	    if (head != null) {
		cur.next = head;
	    } else {
		cur.next = head2;
	    }

	}

	/*
	 * the index of this node, is the same as int mid = (low+high)/2, while
	 * low and high are two ends of an array
	 */
	private ListNode findMiddleNode(ListNode head) {
	    if (head == null || head.next == null) {
		return head;
	    }

	    ListNode walker = head;
	    ListNode runner = head;

	    while (runner.next != null && runner.next.next != null) {
		walker = walker.next;
		runner = runner.next.next;
	    }

	    return walker;
	}

	private ListNode reverseList(ListNode head) {
	    if (head == null || head.next == null) {
		return head;
	    }

	    ListNode pre = null;
	    ListNode cur = head;

	    while (cur != null) {
		ListNode next = cur.next;
		cur.next = pre;
		pre = cur;
		cur = next;
	    }

	    return pre;
	}
    }

    public class Solution2 {
	public void reorderList(ListNode head) {
	    if (head == null || head.next == null) {
		return;
	    }

	    int len = 0;
	    ListNode cur = head;
	    while (cur != null) {
		cur = cur.next;
		len++;
	    }

	    cur = head;
	    for (int i = 0; i < (len - 1) / 2; i++) {
		cur = cur.next;
	    }

	    ListNode head2 = reverse(cur.next);
	    cur.next = null;

	    ListNode preHead = new ListNode(-1);
	    cur = preHead;

	    int i = 0;
	    while (head != null && head2 != null) {
		if (i % 2 == 0) {
		    cur.next = head;
		    head = head.next;
		} else {
		    cur.next = head2;
		    head2 = head2.next;
		}
		cur = cur.next;
		cur.next = null;
		i++;
	    }

	    if (head != null) {
		cur.next = head;
	    }

	}

	private ListNode reverse(ListNode head) {
	    ListNode pre = null;
	    ListNode cur = head;
	    while (cur != null) {
		ListNode next = cur.next;
		cur.next = pre;
		pre = cur;
		cur = next;
	    }
	    return pre;
	}
    }
}
