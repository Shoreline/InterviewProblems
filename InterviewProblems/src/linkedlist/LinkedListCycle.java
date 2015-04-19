package linkedlist;

/**
 * Linked List Cycle
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: Can you solve it without using extra space?
 *
 */
public class LinkedListCycle {
    /*
     * A more concise version
     */
    public class Solution_concise {
	public boolean hasCycle(ListNode head) {
	    if (head == null) {
		return false;
	    }

	    ListNode walker = head;
	    ListNode runner = head;

	    while (runner != null && runner.next != null) {
		walker = walker.next;
		runner = runner.next.next;

		if (walker == runner) {
		    return true;
		}
	    }

	    return false;
	}
    }

    public class Solution {
	public boolean hasCycle(ListNode head) {
	    if (head == null) {
		return false;
	    }

	    ListNode walker = head;
	    ListNode runner = head;

	    while (walker != null && runner != null) {
		walker = walker.next;
		runner = runner.next;
		if (runner == null) {
		    return false;
		}
		runner = runner.next;

		if (walker == runner) {
		    return true;
		}
	    }

	    return false;
	}
    }
}
