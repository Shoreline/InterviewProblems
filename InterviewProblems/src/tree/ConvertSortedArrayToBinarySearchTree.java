package tree;

public class ConvertSortedArrayToBinarySearchTree {
    /**
     * Convert Sorted Array to Binary Search Tree
     * 
     * Given an array where elements are sorted in ascending order, convert it
     * to a height balanced BST.
     */

    public static TreeNode sortedArrayToBST(int[] num) {
	if (num == null || num.length == 0)
	    return null;

	TreeNode root = sortedArrayToBST(num, 0, num.length - 1);

	return root;
    }

    private static TreeNode sortedArrayToBST(int[] num, int start, int end) {

	if (start > end)
	    return null;

	int mid = (start + end) / 2;
	TreeNode root = new TreeNode(num[mid]);

	root.left = sortedArrayToBST(num, start, mid - 1);
	root.right = sortedArrayToBST(num, mid + 1, end);

	return root;
    }
}
