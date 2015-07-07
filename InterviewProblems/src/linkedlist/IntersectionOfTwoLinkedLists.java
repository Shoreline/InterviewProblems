package linkedlist;

/**
 * Intersection of Two Linked Lists
 * 
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * If the two linked lists have no intersection at all, return null.
 *
 * The linked lists must retain their original structure after the function
 * returns.
 * 
 * You may assume there are no cycles anywhere in the entire linked structure.
 * 
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */

/*
 * Get the lengths of two lists. Then first/late movers, the first moves
 * len1-len2 steps. The first node that first==late is the joint node
 */
public class IntersectionOfTwoLinkedLists {
    public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    if (headA == null || headB == null) {
		return null;
	    }

	    int lenA = getLen(headA);
	    int lenB = getLen(headB);

	    ListNode firstMover = lenA > lenB ? headA : headB;
	    ListNode lateMover = lenA <= lenB ? headA : headB;

	    for (int i = 0; i < Math.abs(lenA - lenB); i++) {
		firstMover = firstMover.next;
	    }
	    
	    while (firstMover != null && lateMover != null) {
		if (firstMover == lateMover) {
		    return firstMover;
		}
		firstMover = firstMover.next;
		lateMover = lateMover.next;
	    }
	    return null;
	}

	private int getLen(ListNode head) {
	    int n = 0;
	    while (head != null) {
		n++;
		head = head.next;
	    }
	    return n;
	}
    }
}
