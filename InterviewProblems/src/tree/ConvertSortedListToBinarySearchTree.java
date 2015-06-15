package tree;

import java.util.ArrayList;
import java.util.List;

import linkedlist.ListNode;

/**
 * Convert Sorted List to Binary Search Tree
 * 
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */

/*
 * In-order traversal
 * 
 * The in-order traversal for a BST is a sorted sequence (not true for general
 * binary tree)
 * 
 * -> similarly, from left to right to traverse a sorted sequence has the same
 * order as in-order BST traversal.
 * 
 * Recursion stop condition is totally depends on Integer start and end.
 */
public class ConvertSortedListToBinarySearchTree {

    public class Solution {
	public TreeNode sortedListToBST(ListNode head) {
	    if (head == null) {
		return null;
	    }
	    // curHead always has only 1 element, which is the first node of
	    // unvisited nodes
	    List<ListNode> curHead = new ArrayList<ListNode>();
	    curHead.add(head);

	    int len = 0;
	    ListNode cur = head;
	    while (cur != null) {
		cur = cur.next;
		len++;
	    }

	    return treeBuilder(curHead, 0, len - 1); // len-1, not len!
	}

	private TreeNode treeBuilder(List<ListNode> head, int start, int end) {
	    if (start > end) {
		return null;
	    }

	    // in-order traverse. Go for the left child first.
	    int mid = (start + end) / 2;
	    TreeNode left = treeBuilder(head, start, mid - 1);

	    ListNode headNode = head.get(0);
	    TreeNode root = new TreeNode(headNode.val);

	    // headNode=headNode.next; // this does not work!
	    head.set(0, headNode.next);
	    TreeNode right = treeBuilder(head, mid + 1, end);

	    root.left = left;
	    root.right = right;

	    return root;
	}
    }

    /*
     * Just convert the list to be an array or ArrayList -> memory limit
     * exceeded
     */
    class method {
	public TreeNode sortedListToBSTB(ListNode head) {
	    if (head == null)
		return null;

	    ArrayList<Integer> list = new ArrayList<Integer>();
	    ListNode curNode = head;
	    while (curNode != null) {
		list.add(curNode.val);
		curNode = curNode.next;
	    }

	    TreeNode result = sortedListToBSTB(list, 0, list.size() - 1);

	    return result;
	}

	private TreeNode sortedListToBSTB(ArrayList<Integer> list, int start,
		int end) {
	    if (start > end)
		return null;

	    int mid = (start + end) / 2;
	    TreeNode root = new TreeNode(list.get(mid));
	    root.left = sortedListToBSTB(list, start, mid - 1);
	    root.right = sortedListToBSTB(list, mid + 1, end);

	    return root;
	}
    }
}
