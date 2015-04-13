package linkedlist;

/**
 * Partition List
 * 
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example,
 * 
 * Given 1->4->3->2->5->2 and x = 3,
 * 
 * return 1->2->2->4->3->5.
 */

/*
 * create two new lists based on the original one, then link them together
 * 
 * Or to use double pointers: http://blog.csdn.net/linhuanmars/article/details/24446871
 */
public class PartitionList {

    public class Solution {
	public ListNode partition(ListNode head, int x) {
	    if (head == null) {
		return null;
	    }

	    ListNode preHead1 = new ListNode(-1);
	    ListNode tail1 = preHead1;
	    ListNode preHead2 = new ListNode(-1);
	    ListNode tail2 = preHead2;
	    ListNode cur = head;

	    while (cur != null) {
		if (cur.val < x) {
		    tail1.next = cur;
		    tail1 = tail1.next;
		    cur = cur.next;
		    tail1.next = null; // set next to null to prevent loop!
		} else {
		    tail2.next = cur;
		    tail2 = tail2.next;
		    cur = cur.next;
		    tail2.next = null;
		}
	    }

	    tail1.next = preHead2.next;

	    return preHead1.next;
	}
    }

    class Solution_2013 {
	public ListNode partition(ListNode head, int x) {
	    if (head == null)
		return null;

	    ListNode h1 = null;
	    ListNode pre1 = new ListNode(-1);
	    ListNode h2 = null;
	    ListNode pre2 = new ListNode(-1);

	    ListNode cur = head;

	    while (cur != null) {
		if (cur.val < x) {
		    if (h1 == null) {
			h1 = cur;
		    }
		    pre1.next = cur;
		    pre1 = pre1.next;
		} else {
		    if (h2 == null)
			h2 = cur;
		    pre2.next = cur;
		    pre2 = pre2.next;
		}
		cur = cur.next;
	    }

	    // !! make sure the second list ends with null
	    pre2.next = null;

	    if (h1 != null) {
		pre1.next = h2;
		return h1;
	    } else {
		return h2;
	    }
	}
    }
}
