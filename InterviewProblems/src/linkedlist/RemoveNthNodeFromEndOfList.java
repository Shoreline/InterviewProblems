package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {
    /**
     * Remove Nth Node From End of List
     * 
     * Given a linked list, remove the nth node from the end of list and return
     * its head.
     * 
     * For example,
     * 
     * Given linked list: 1->2->3->4->5, and n = 2.
     * 
     * After removing the second node from the end, the linked list becomes
     * 1->2->3->5.
     * 
     * Note: Given n will always be valid. Try to do this in one pass.
     */

    /*
     * Simultaneously move two pointers of n step apart 
     * 
     * Pointer target is not necessary, just use preTarget.next
     * Handled the corner cases in Solution2 gracefully
     */
    public class Solution3 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
	    ListNode end = head;
	    ListNode preTarget = new ListNode(-1);
	    preTarget.next = head;

	    for (int i = 0; i < n; i++) {
		end = end.next;
	    }

	    while (end != null) {
		end = end.next;
		preTarget = preTarget.next;
	    }

	    if (preTarget.next == head) {
		return head.next;
	    } else {
		preTarget.next = preTarget.next.next;
		return head;
	    }
	}
    }
    
    
    /*
     * Simultaneously move two pointers of n step apart 
     * 
     * corner case 1: list has only one node and need to be removed
     * corner case 2: list length longer than 1, and the first node needs to be
     * removed
     */
    public class Solution2 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
	    if (head == null || (head.next == null && n == 1)) {
		return null;
	    }

	    ListNode end = head;
	    ListNode target = head;
	    ListNode preTarget = new ListNode(-1);
	    preTarget.next = target;

	    for (int i = 0; i < n; i++) {
		end = end.next;
	    }

	    while (end != null) {
		end = end.next;
		target = target.next;
		preTarget = preTarget.next;
	    }

	    if (target == head) {
		return head.next;
	    } else {
		preTarget.next = target.next;
		return head;
	    }
	}
    }

    /*
     * Memory consuming solution: using another List or Map
     */
    public class Solution1 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
	    if (head == null || n < 1) {
		return head;
	    }

	    List<ListNode> list = new ArrayList<ListNode>();
	    ListNode cur = head;

	    while (cur != null) {
		list.add(cur);
		cur = cur.next;
	    }

	    int len = list.size();

	    if (len == n) {
		return head.next;
	    }

	    list.get(len - n - 1).next = list.get(len - n).next;

	    return head;
	}
    }
}
