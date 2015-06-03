package tree;

/**
 * Convert Sorted Array to Binary Search Tree
 * 
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 */

/*
 * Similar to construct binary tree from xx and xx traversal, but easier. 
 */
public class ConvertSortedArrayToBinarySearchTree {

    public class Solution {
	public TreeNode sortedArrayToBST(int[] num) {
	    if (num == null || num.length == 0) {
		return null;
	    }

	    return treeBuilder(num, 0, num.length - 1);
	}

	private TreeNode treeBuilder(int[] num, int start, int end) {
	    if (start > end) {
		return null;
	    }
	    int mid = (start + end) / 2;
	    TreeNode root = new TreeNode(num[mid]);
	    root.left = treeBuilder(num, start, mid - 1);
	    root.right = treeBuilder(num, mid + 1, end);

	    return root;
	}
    }
}
