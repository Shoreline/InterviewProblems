package linkedlist;

/**
 * Reverse Linked List II
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 * 
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition:
 * 
 * 1 �� m �� n �� length of list.
 */

/*
 * total nodes need to be reversed: n-m+1
 * 
 * if stack is allowed, it will be much easier--> two-pass
 * 
 * *important*: reverse a singly linkedlist by one-pass!! (Key: reverse link
 * direction between two adjacent nodes)
 */
public class ReverseLinkedListII {

    /*
     * The reversing part is similar to ReverseLinkedList I; simpler than the
     * 2013 solution
     */
    public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
	    if (head == null || m == n) {
		return head;
	    }

	    ListNode preSubHead = new ListNode(-1);
	    preSubHead.next = head;
	    for (int i = 0; i < m - 1; i++) {	// easy to make mistake
		preSubHead = preSubHead.next;
	    }

	    ListNode pre = preSubHead;
	    ListNode cur = pre.next;
	    for (int i = 0; i <= n - m && cur != null; i++) {
		ListNode tmp = cur.next;
		cur.next = pre;
		pre = cur;
		cur = tmp;
	    }

	    preSubHead.next.next = cur; // if reach here than m<n
	    preSubHead.next = pre;

	    return (m == 1 ? pre : head);
	}
    }

    class Solution_2013 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
	    if (head == null || m == n)
		return head;

	    // rename variables!
	    ListNode preRstart = new ListNode(-1); // safe guard
	    preRstart.next = head;

	    // since preRstart is a node before m-th node, so i <m-1
	    for (int i = 0; i < m - 1; i++) {
		preRstart = preRstart.next;
	    }

	    // Important!! reverse node order between m and n
	    ListNode pre = preRstart;
	    ListNode cur = preRstart.next;
	    ListNode next = cur.next;
	    // be careful when i shall stop
	    for (int i = 0; i < n - m + 1; i++) {

		// at the last iteration, only change the link direction of cur
		if (i == n - m + 1 - 1) {
		    cur.next = pre;
		    break;
		}

		cur.next = pre;
		pre = cur;
		cur = next;
		next = next.next;
	    }

	    preRstart.next.next = next; // !=cur.next
	    preRstart.next = cur;

	    if (m == 1) {
		// m==1 means the original head has been moved
		return cur;
	    } else {
		return head;
	    }

	}
    }
}
