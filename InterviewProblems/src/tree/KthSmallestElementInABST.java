package tree;

import java.util.*;

/**
 * Kth Smallest Element in a BST
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Follow up: What if the BST is modified (insert/delete operations) often and
 * you need to find the kth smallest frequently? How would you optimize the
 * kthSmallest routine?
 *
 */
/*
 * http://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-
 * statistics-in-bst/
 * 
 * For the follow up: add a field to save the left subtree size in every node.
 * 
 * Assume that the root is having N nodes in its left subtree. If K = N + 1,
 * root is K-th node. If K < N, we will continue our search (recursion) for the
 * Kth smallest element in the left subtree of root. If K > N + 1, we continue
 * our search in the right subtree for the (K – N – 1)-th smallest element
 */
public class KthSmallestElementInABST {
    public class Solution {
	public int kthSmallest(TreeNode root, int k) {
	    Stack<TreeNode> stack = new Stack<>(); // only save non-null node
	    TreeNode next = root; // next node to push, can be null

	    while (next != null || !stack.isEmpty()) {
		if (next != null) {
		    stack.push(next);
		    next = next.left;
		} else {
		    TreeNode node = stack.pop();
		    if (k == 1) {
			return node.val;
		    }
		    k--;

		    next = node.right;
		    // if node.right == null, next remains null
		}
	    }

	    return -1;
	}
    }
}
