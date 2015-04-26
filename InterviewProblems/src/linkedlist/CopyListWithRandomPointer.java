package linkedlist;

/**
 * Copy List with Random Pointer A linked list is given such that each node
 * contains an additional random pointer which could point to any node in the
 * list or null.
 * 
 * Return a deep copy of the list.
 *
 */
class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
	this.label = x;
    }
};

/*
 * Method 1: use similar way of graph copy. Time O(2N), space O(N). Need
 * additional space for a HashMap.
 * 
 * Better method: Time O(3N), space O(1), do not need any additional space. (
 * O(1)? still need O(N) space for creating new nodes)
 * 
 * http://blog.csdn.net/linhuanmars/article/details/22463599
 */
public class CopyListWithRandomPointer {
    public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
	    if (head == null) {
		return null;
	    }

	    RandomListNode cur = head;
	    while (cur != null) {
		RandomListNode next = cur.next;
		RandomListNode newNode = new RandomListNode(cur.label);
		// insert the new node after cur
		cur.next = newNode;
		newNode.next = next;
		cur = next;
	    }

	    cur = head;
	    while (cur != null) {
		RandomListNode next = cur.next.next;
		if (cur.random != null) {
		    cur.next.random = cur.random.next;
		}
		cur = next;
	    }

	    cur = head;
	    RandomListNode newPreHead = new RandomListNode(-1);
	    RandomListNode newCur = newPreHead;
	    while (cur != null) {
		RandomListNode next = cur.next.next;
		newCur.next = cur.next;
		cur.next = next;

		cur = cur.next;
		newCur = newCur.next;
		newCur.next = null;
	    }

	    return newPreHead.next;
	}
    }
}
