package facebook;

import java.util.*;

import linkedlist.ListNode;

/**
 * interleave two linked-list
 * 
 * For example , Given
 * 
 * 1->2->3->4;
 * 
 * 5->6;
 * 
 * return 1->5->2->6->3->4;
 *
 */
public class InterleaveLinkedLists {
    class Method_Iterative {
	public ListNode getInterleavedList(ListNode l1, ListNode l2) {
	    if (l1 == null || l2 == null) {
		return l1 == null ? l2 : l1;
	    }

	    ListNode tail = new ListNode(-1);
	    Queue<ListNode> queue = new LinkedList<>();
	    queue.offer(l1);
	    queue.offer(l2);

	    while (!queue.isEmpty()) {
		ListNode next = queue.poll();
		tail.next = next;
		if (next.next != null) {
		    queue.offer(next.next);
		}
		tail = tail.next;
	    }

	    return l1;
	}
    }

    class Method_Recursive {
	public ListNode getInterleavedList(ListNode l1, ListNode l2) {
	    if (l1 == null || l2 == null) {
		return l1 == null ? l2 : l1;
	    }

	    l2.next = getInterleavedList(l2.next, l1.next);
	    l1.next = l2;

	    return l1;
	}
    }
}
