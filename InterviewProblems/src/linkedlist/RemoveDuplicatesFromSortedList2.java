package linkedlist;

public class RemoveDuplicatesFromSortedList2 {
    /**
     * Remove Duplicates from Sorted List II
     * 
     * Given a sorted linked list, delete all nodes that have duplicate numbers,
     * leaving only distinct numbers from the original list.
     * 
     * For example,
     * 
     * Given 1->2->3->3->4->4->5, return 1->2->5.
     * 
     * Given 1->1->1->2->3, return 2->3.
     */

    /*
     * I do not like using node.next.next. Below solution is more straightforward
     * 
     * Use cur instead of head as pointer variable to scan the list; 'head' will
     * be the true head of new list. It will point to the first non-duplicated
     * node -> this is for easy understanding.
     * 
     * Dummy node tail is used to create a new list for return. 
     */
    public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
	    ListNode tail = new ListNode(-1);
	    tail.next = head;
	    ListNode cur = head;
	    head = null;

	    while (cur != null) {

		boolean isDuplicated = false;
		while (cur.next != null && cur.val == cur.next.val) {
		    isDuplicated = true;
		    cur = cur.next;
		}

		if (!isDuplicated) {
		    /*
		     * Only add non-duplicated node to new list
		     * head will be assigned to the first non-duplicated node
		     */
		    head = (head == null ? cur : head);

		    tail.next = cur;
		    cur = cur.next;
		    tail = tail.next;

		    /*
		     * need to clear tail.next. Otherwise if the rest of list
		     * are all duplicated nodes then tail will still be connected
		     * with them
		     */
		    tail.next = null;
		} else {
		    /*
		     * Skip all duplicated nodes
		     */
		    cur = cur.next;
		}
	    }

	    return head;
	}
    }

    /*
     * When deal with Linked list problems, be aware of the returned node.
     * Sometimes the original head will be deleted (to be set to null) and we
     * cannot just return it
     */
    class Solution_old {
	public ListNode deleteDuplicates2(ListNode head) {
	    if (head == null || head.next == null) {
		return head;
	    }

	    ListNode scanNode = head.next;
	    ListNode preScanNode = head;
	    ListNode updateNode = head;
	    ListNode preUpdateNode = new ListNode(0);
	    preUpdateNode.next = head;

	    /*
	     * !! biggest corner case:
	     * 
	     * cannot just return head, since there is possibility that all
	     * elements has duplicate and we shall return null.
	     * 
	     * this case cannot be properly handled by modifying original
	     * linkedlist, since the head cannot be set to null
	     */
	    boolean shallReturnNull = true;

	    while (scanNode != null) {
		int counter = 1;
		while (scanNode != null && scanNode.val == preScanNode.val) {
		    preScanNode = scanNode;
		    scanNode = scanNode.next;
		    counter++;
		}
		if (counter == 1) {
		    shallReturnNull = false;
		    updateNode.val = preScanNode.val;
		    preUpdateNode = updateNode;
		    updateNode = updateNode.next;
		}
		counter = 1;

		// corner case
		if (scanNode == null)
		    break;
		else if (scanNode.next == null) {
		    shallReturnNull = false;
		    updateNode.val = scanNode.val;
		    preUpdateNode = updateNode;
		    updateNode = updateNode.next;
		}

		preScanNode = scanNode;
		scanNode = scanNode.next;

	    }
	    /*
	     * cannot just set a Node to null? or just the "head" cannot be
	     * changed???
	     * 
	     * can only set aNode.next to null
	     */

	    preUpdateNode.next = null;

	    if (shallReturnNull)
		head = null;

	    return head;
	}
    }
}
