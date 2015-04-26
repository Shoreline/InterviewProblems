package linkedlist;

/**
 * Sort List
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 */
/*
 * Merge Sort -> Recursively find the middle node and merge lists
 */
public class SortList {
    /*
     * for a list of even amount node, divide evenly;
     * 
     * for a list of odd amount node, the middle node goes with the first half
     */
    public class Solution {
	public ListNode sortList(ListNode head) {
	    return mergeSort(head);
	}

	private ListNode mergeSort(ListNode head) {
	    if (head == null || head.next == null) {
		return head;
	    }
	    // wrong!
	    // if(head==null){
	    // return null;
	    // }

	    ListNode walker = head;
	    ListNode runner = head;
	    // runner is not required to reach the end of list
	    while (runner.next != null && runner.next.next != null) {
		walker = walker.next;
		runner = runner.next.next;
	    }

	    ListNode h1 = head;
	    ListNode h2 = walker.next;
	    walker.next = null;

	    h1 = mergeSort(h1);
	    h2 = mergeSort(h2);
	    // Wrong!
	    // mergeSort(h1);
	    // mergeSort(h2);

	    return mergeLists(h1, h2);
	}

	private ListNode mergeLists(ListNode h1, ListNode h2) {
	    if (h1 == null || h2 == null) {
		return h1 == null ? h2 : h1;
	    }
	    ListNode preHead = new ListNode(-1);
	    ListNode pre = preHead;
	    while (h1 != null && h2 != null) {
		if (h1.val <= h2.val) {
		    pre.next = h1;
		    h1 = h1.next;
		} else {
		    pre.next = h2;
		    h2 = h2.next;
		}
		pre = pre.next;
		pre.next = null;
	    }

	    if (h1 == null) {
		pre.next = h2;
	    } else {
		pre.next = h1;
	    }

	    return preHead.next;
	}
    }
}
