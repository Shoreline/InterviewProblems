package linkedlist;

/**
 * Linked List Cycle II
 * 
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * Follow up: Can you solve it without using extra space?
 *
 */

/*
 * Let there are a nodes before the cycle; c nodes in the cycle. And while the
 * first meet happens at b nodes into the cycle (clearly b<c)
 * 
 * Important: the first meet is guaranteed to happen before walker finish its
 * first cycle.
 * 
 * So while first meet: 
 * a + b = s 
 * a + k*c + b = 2*s 
 * -> a + b = k*c 
 * -> a = k*c - b
 * 
 * Now move the runner to starting point and reduce speed to also move 1 node a
 * time. Then after a rounds it will reach the fist node of the cycle. During
 * this a rounds, the walker also moved a steps, which is (k*c-b) steps. Since
 * it was at b nodes into the cycle, so walker will also reach the fist node of
 * the cycle.
 * -> The node they meet is the fist node of cycle
 */
public class LinkedListCycleII {
    public class Solution {
	public ListNode detectCycle(ListNode head) {
	    if (head == null) {
		return null;
	    }

	    ListNode walker = head;
	    ListNode runner = head;
	    while (runner != null && runner.next != null) {
		walker = walker.next;
		runner = runner.next.next;

		if (runner == walker) {
		    break;
		}
	    }

	    if (runner == null || runner.next == null) {
		return null;
	    }

	    ListNode walker2 = head;
	    while (walker2 != walker) {
		walker = walker.next;
		walker2 = walker2.next;
	    }

	    return walker;
	}
    }
}
