package tree;

public class ValidateBinarySearchTree {
    /**
     * Validate Binary Search Tree
     * 
     * Given a binary tree, determine if it is a valid binary search tree (BST).
     * 
     * Assume a BST is defined as follows:
     * 
     * The left subtree of a node contains only nodes with keys less than the
     * node's key.
     * 
     * The right subtree of a node contains only nodes with keys greater than
     * the node's key.
     * 
     * Both the left and right subtrees must also be binary search trees.
     */

    /*
     * only need to recursively check the value of root, see if it satisfy the
     * (min,max) allowed
     */
    public static boolean isValidBST(TreeNode root) {
	return isValidBSThelp(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    private static boolean isValidBSThelp(TreeNode root, int min, int max) {

	if (root == null)
	    return true;

	if (root.val >= max || root.val <= min)
	    return false;

	return (isValidBSThelp(root.left, min, root.val) && isValidBSThelp(
		root.right, root.val, max));
    }
}
