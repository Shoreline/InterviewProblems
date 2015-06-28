package linkedlist;

/**
 * Sort List
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 */
/*
 * Merge Sort -> Recursively find the middle node and merge lists
 * 
 * 3 methods:
 * 
 * 1) sortList itself
 * 
 * 2) Merge (sort and merge two sorted lists)
 * 
 * 3) findMiddle
 */
public class SortList {
    public class Solution {
	public ListNode sortList(ListNode head) {
	    if (head == null) {
		return null;
	    } else if (head.next == null) {
		return head;
	    }

	    ListNode mid = findMiddle(head);
	    ListNode head2 = mid.next;
	    mid.next = null;

	    ListNode h1 = sortList(head);
	    ListNode h2 = sortList(head2);

	    return merge(h1, h2);
	}

	private ListNode merge(ListNode h1, ListNode h2) {
	    ListNode preHead = new ListNode(-1);
	    ListNode tail = preHead;
	    while (h1 != null && h2 != null) {
		if (h1.val < h2.val) {
		    tail.next = h1;
		    h1 = h1.next;
		} else {
		    tail.next = h2;
		    h2 = h2.next;
		}
		tail = tail.next;
	    }

	    tail.next = h1 == null ? h2 : h1;

	    return preHead.next;
	}

	private ListNode findMiddle(ListNode head) {
	    if (head == null) {
		return null;
	    }

	    ListNode walker = head;
	    ListNode runner = head;

	    while (runner.next != null && runner.next.next != null) {
		walker = walker.next;
		runner = runner.next.next;
	    }

	    return walker;
	}
    }
}
