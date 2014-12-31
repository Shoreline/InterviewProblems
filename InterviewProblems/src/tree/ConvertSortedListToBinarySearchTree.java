package tree;

import java.util.ArrayList;

import linkedlist.ListNode;

public class ConvertSortedListToBinarySearchTree {
    /**
     * Convert Sorted List to Binary Search Tree
     * 
     * Given a singly linked list where elements are sorted in ascending order,
     * convert it to a height balanced BST.
     */

    /*
     * Just convert the list to be an array or ArrayList -> memory limit
     * exceeded
     */

    public static TreeNode sortedListToBSTB(ListNode head) {
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

    private static TreeNode sortedListToBSTB(ArrayList<Integer> list,
	    int start, int end) {
	if (start > end)
	    return null;

	int mid = (start + end) / 2;
	TreeNode root = new TreeNode(list.get(mid));
	root.left = sortedListToBSTB(list, start, mid - 1);
	root.right = sortedListToBSTB(list, mid + 1, end);

	return root;
    }

    /*
     * 
     * So , have to use an alternative way
     */

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
