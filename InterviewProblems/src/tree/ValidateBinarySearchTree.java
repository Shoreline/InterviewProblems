package tree;

/**
 * Validate Binary Search Tree
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key.
 * 
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * 
 * Both the left and right subtrees must also be binary search trees.
 */

/*
 * Two solutions:
 * 
 * 1) By BST definition: value of a node must be within a range.
 * 
 * 2) Do in-order traversal, nodes' value must be in ascending order
 * 
 * Both solutions must consider boundary cases. Use null for initial value
 * boundary instead of Integer.MAX_VALUE and/or Integer.MIN_VALUE. So the first
 * seen Integer.MAX_VALUE/Integer.MIN_VALUE is allowed
 */
public class ValidateBinarySearchTree {
    public class Solution_Inorder {
	Integer val = null; // used a global variable

	public boolean isValidBST(TreeNode root) {
	    if (root == null) {
		return true;
	    }

	    if (!isValidBST(root.left)) {
		return false;
	    }

	    if (val != null && root.val <= val) {
		return false;
	    }

	    val = root.val;

	    return isValidBST(root.right);
	}

    }

    /*
     * only need to recursively check the value of root, see if it satisfy the
     * (min,max) allowed
     * 
     * However, too may corner cases! {2147483647} or {-2147483648,
     * -2147483648}...
     */
    public class Solution_ByDef {
	public boolean isValidBST(TreeNode root) {
	    return valid(root, null, null);
	}

	private boolean valid(TreeNode root, Integer min, Integer max) {
	    if (root == null)
		return true;

	    if (min != null && root.val <= min)
		return false;
	    if (max != null && root.val >= max)
		return false;

	    return valid(root.left, min, root.val)
		    && valid(root.right, root.val, max);

	}
    }

    /*
     * Cannot pass the corner case
     */
    class Method_byDef {
	public boolean isValidBST(TreeNode root) {
	    return isValidBSThelp(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

	}

	private boolean isValidBSThelp(TreeNode root, int min, int max) {

	    if (root == null)
		return true;

	    if (root.val >= max || root.val <= min)
		return false;

	    return (isValidBSThelp(root.left, min, root.val) && isValidBSThelp(
		    root.right, root.val, max));
	}
    }
}
