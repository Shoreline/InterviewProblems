package tree;

import java.util.ArrayList;

public class SameTree {
    /**
     * Same Tree
     * 
     * Given two binary trees, write a function to check if they are equal or
     * not.
     * 
     * Two binary trees are considered equal if they are structurally identical
     * and the nodes have the same value.
     */

    /*
     * Similar to Symmetric Tree
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
	if (p == null && q == null)
	    return true;
	if (p == null || q == null)
	    return false;

	if (p.val != q.val)
	    return false;

	return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));

    }

    /*
     * just compare inorder or preorder node value list may not be enough
     */
    public boolean isSameTreeB(TreeNode p, TreeNode q) {
	if (p == null && q == null)
	    return true;
	if (p == null || q == null)
	    return false;
	ArrayList<Integer> left = new ArrayList<Integer>();
	isSameTreeInOrder(p, left);

	ArrayList<Integer> right = new ArrayList<Integer>();
	isSameTreeInOrder(q, right);

	if (left.equals(right))
	    return true;

	return false;
    }

    private static void isSameTreeInOrder(TreeNode root, ArrayList<Integer> list) {
	if (root == null) {
	    list.add(null);
	    return;
	}
	isSameTreeInOrder(root.left, list);
	list.add(root.val);
	isSameTreeInOrder(root.right, list);
    }
}
