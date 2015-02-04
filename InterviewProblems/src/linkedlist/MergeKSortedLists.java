package linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    /**
     * Merge k Sorted Lists
     * 
     * Merge k sorted linked lists and return it as one sorted list. Analyze and
     * describe its complexity.
     */

    /*
     * Maintain a heap whose size is no bigger than the number of lists. 
     * (only save the head nodes of each list)
     * 
     * Since all elements in each lists are already sorted, not need to add all
     * elements to the heap at a time -> use much less memory
     */
    public static ListNode mergeKLists3(ArrayList<ListNode> lists) {
	if (lists == null || lists.isEmpty())
	    return null;

	PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(),
		new Comparator<ListNode>() {
		    @Override
		    public int compare(ListNode l1, ListNode l2) {
			return l1.val - l2.val;
		    }
		});

	/*
	 * do not have to add all elements to the priority queue
	 */
	for (ListNode cur : lists) {
	    // *Notice* Be careful of empty list!
	    if (cur != null)
		pq.add(cur);
	}

	ListNode preHead = new ListNode(-1);
	ListNode cur = preHead;

	/*
	 * once element is popped out, add its next node (if there is one) to
	 * the queue
	 */
	while (!pq.isEmpty()) {
	    ListNode temp = pq.poll();
	    
	    if (temp.next != null) {
		pq.add(temp.next);
	    }
	    
	    cur.next = temp;
	    cur = cur.next;

	}

	return preHead.next;
    }

    /*
     * use heap (PriorityQueue)
     * 
     * cannot pass the large test: memory limit exceeded
     */
    public static ListNode mergeKLists2(ArrayList<ListNode> lists) {
	if (lists == null || lists.isEmpty())
	    return null;

	PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(),
		new Comparator<ListNode>() {
		    @Override
		    public int compare(ListNode l1, ListNode l2) {
			return l1.val - l2.val;
		    }
		});

	for (ListNode cur : lists) {
	    while (cur != null) {
		pq.add(cur);
		cur = cur.next;
	    }
	}

	ListNode head = pq.poll();
	ListNode cur = head;
	while (!pq.isEmpty()) {
	    cur.next = pq.poll();
	    cur = cur.next;
	}

	return head;
    }

    /*
     * This solution is not the best.
     */
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
	if (lists == null || lists.isEmpty())
	    return null;

	ListNode head = null;
	ListNode pre = new ListNode(-1);
	ListNode cur = null;

	do {
	    // *Important* do not directly modify ArrayList lists -> sync issue?
	    ArrayList<ListNode> newLists = new ArrayList<ListNode>(lists);
	    for (ListNode aNode : newLists) {
		if (aNode == null) {
		    lists.remove(aNode);
		} else if (cur == null) {
		    cur = aNode;
		} else if (aNode.val <= cur.val) {
		    cur = aNode;
		}
	    }
	    if (head == null) {
		head = cur;
	    }
	    pre.next = cur;
	    if (cur == null) {
		break;
	    }
	    lists.remove(cur);
	    lists.add(cur.next);
	    pre = cur;
	    cur = null;
	} while (!lists.isEmpty());

	return head;
    }
}
