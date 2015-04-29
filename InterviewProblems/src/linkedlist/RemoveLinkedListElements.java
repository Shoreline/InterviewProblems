package linkedlist;

/**
 * Remove Linked List Elements
 * 
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example
 * 
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * 
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 *
 */
public class RemoveLinkedListElements {
    /*
     * head is also possible to be removed, so uncertain new head, so use a
     * dummy node.
     */
    public class Solution {
	public ListNode removeElements(ListNode head, int val) {
	    if (head == null) {
		return head;
	    }

	    ListNode preHead = new ListNode(-1);
	    preHead.next = head;
	    ListNode pre = preHead;
	    ListNode cur = head;
	    while (cur != null) {
		if (cur.val == val) {
		    pre.next = cur.next;
		} else {
		    pre = cur;
		}
		cur = cur.next;
	    }

	    return preHead.next;
	}
    }
}
