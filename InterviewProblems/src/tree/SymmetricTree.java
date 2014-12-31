package tree;

import java.util.ArrayList;

public class SymmetricTree {
    /**
     * Symmetric Tree
     * 
     * Given a binary tree, check whether it is a mirror of itself (ie,
     * symmetric around its center).
     * 
     * For example, this binary tree is symmetric:
     * 
     * 1 / \ 2 2 / \ / \ 3 4 4 3
     * 
     * But the following is not:
     * 
     * 1 / \ 2 2 \ \ 3 3
     * 
     * Note: Bonus points if you could solve it both recursively and
     * iteratively.
     * 
     */

    /*
     * *Important* ArrayList accept null as an element
     * 
     * Solution: Similar to Same Tree
     * 
     * Solution(?) 2: do in-order and in-order2 traversal for two sub-trees. (is
     * this real correct?)
     * 
     * Another solution: Iteratively output the two sub-trees in level order and
     * compare them
     */

    // one time pass
    public static class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    public static boolean isSymmetric(TreeNode root) {
	if (root == null)
	    return true;

	return isSymmetricHelp(root.left, root.right);
    }

    public static boolean isSymmetricHelp(TreeNode leftRoot, TreeNode rightRoot) {
	if (leftRoot == null && rightRoot == null)
	    return true;
	if (leftRoot == null || rightRoot == null)
	    return false;

	if (leftRoot.val == rightRoot.val) {
	    return (isSymmetricHelp(leftRoot.right, rightRoot.left))
		    && isSymmetricHelp(leftRoot.left, rightRoot.right);
	}

	return false;
    }

    // Another way (may be wrong)Check in-order and in-order2 traversal for two
    // sub-trees
    public static boolean isSymmetricB(TreeNode root) {
	if (root == null)
	    return true;

	ArrayList<Integer> left = new ArrayList<Integer>();
	ArrayList<Integer> right = new ArrayList<Integer>();

	inOrderTraversal(root.left, left);
	inOrderTraversal2(root.right, right);

	if (left.equals(right))
	    return true;
	else
	    return false;

    }

    // Sequence: left, root, right
    private static void inOrderTraversal(TreeNode root,
	    ArrayList<Integer> values) {
	if (root == null) {
	    values.add(null);
	    return;
	}

	inOrderTraversal(root.left, values);
	values.add(root.val);
	inOrderTraversal(root.right, values);

    }

    // Sequence: right, root, left
    private static void inOrderTraversal2(TreeNode root,
	    ArrayList<Integer> values) {
	if (root == null) {
	    values.add(null);
	    return;
	}

	inOrderTraversal2(root.right, values);
	values.add(root.val);
	inOrderTraversal2(root.left, values);

    }
}
