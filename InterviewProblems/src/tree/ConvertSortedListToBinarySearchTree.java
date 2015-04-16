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

public class ConvertSortedListToBinarySearchTree {
    /*
     * The in-order traversal for a BST is a sorted sequence
     * 
     * -> similarly, from left to right to traverse a sorted sequence has the
     * same order as in-order BST traversal.
     */
    public class Solution {
	public TreeNode sortedListToBST(ListNode head) {
	    if (head == null) {
		return null;
	    }
	    // always only 1 element
	    List<ListNode> headList = new ArrayList<ListNode>();
	    headList.add(head);

	    int len = 0;
	    ListNode cur = head;
	    while (cur != null) {
		cur = cur.next;
		len++;
	    }

	    return treeBuilder(headList, 0, len - 1);
	}

	private TreeNode treeBuilder(List<ListNode> head, int start, int end) {
	    if (start > end) {
		return null;
	    }

	    // in-order traverse. Go for the left child first.
	    TreeNode left = treeBuilder(head, start, (start + end) / 2 - 1);

	    ListNode headNode = head.get(0);
	    TreeNode root = new TreeNode(headNode.val);
	    root.left = left;
	    // headNode=headNode.next; // this does not work!
	    head.set(0, headNode.next);

	    TreeNode right = treeBuilder(head, (start + end) / 2 + 1, end);
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

    /*
     * 
     * So , have to use an alternative way
     */
    class method_2 {
	public TreeNode sortedListToBST(ListNode head) {
	    if (head == null)
		return null;

	    ListNode curNode = head;
	    int length = 0; // start from 0
	    while (curNode != null) {
		length++;
	    }

	    TreeNode result = sortedListToBST(head, length);

	    return result;
	}

	private TreeNode sortedListToBST(ListNode head, int length) {
	    if (length <= 0)
		return null;

	    int mid = (length - 1) / 2;

	    ListNode midNode = head;
	    int counter = 0;
	    while (counter < mid) {
		midNode = midNode.next;
		counter++;
	    }

	    TreeNode root = new TreeNode(midNode.val);
	    root.left = sortedListToBST(head, counter);
	    root.right = sortedListToBST(midNode.next, length - 1 - counter);

	    return root;
	}
    }
}
