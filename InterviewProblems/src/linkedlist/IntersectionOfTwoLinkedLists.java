package linkedlist;

public class IntersectionOfTwoLinkedLists {
    public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    if (headA == null || headB == null) {
		return null;
	    }

	    int lenA = getListLength(headA);
	    int lenB = getListLength(headB);

	    ListNode longHead = (lenA >= lenB ? headA : headB);
	    ListNode shortHead = (lenA < lenB ? headA : headB);

	    int c = 0;
	    while (c < Math.abs(lenA - lenB)) {
		longHead = longHead.next;
		c++;
	    }

	    while (longHead != null && shortHead != null) {
		if (longHead == shortHead) {
		    return longHead;
		}

		longHead = longHead.next;
		shortHead = shortHead.next;
	    }

	    return null;
	}

	private int getListLength(ListNode head) {
	    int c = 0;
	    while (head != null) {
		head = head.next;
		c++;
	    }
	    return c;
	}
    }
}
