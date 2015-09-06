package linkedlist;

/**
 * Palindrome Linked List
 * 
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 *
 */
public class PalindromeLinkedList {
    /*
     * Time:O(N); Space: O(1).
     * 
     * Thought: find middle node, cut the list into two half, reverse one of
     * them, then compare values
     * 
     * one time AC!
     */
    public class Solution {
	public boolean isPalindrome(ListNode head) {
	    if (head == null || head.next == null) {
		return true;
	    }

	    ListNode preMiddle = findPreMiddle(head);
	    ListNode head2 = preMiddle.next;
	    preMiddle.next = null;

	    head2 = reverseList(head2);

	    while (head != null && head2 != null) {
		if (head.val != head2.val) {
		    return false;
		}
		head = head.next;
		head2 = head2.next;
	    }

	    return true;
	}

	private ListNode findPreMiddle(ListNode head) {
	    ListNode preHead = new ListNode(-1);
	    preHead.next = head;
	    ListNode fast = preHead;
	    ListNode slow = preHead;

	    while (fast.next != null && fast.next.next != null) {
		fast = fast.next.next;
		slow = slow.next;
	    }

	    return slow;
	}

	private ListNode reverseList(ListNode head) {
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
