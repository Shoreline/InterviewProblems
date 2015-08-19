package tree;

import java.util.*;

/**
 * Symmetric Tree
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * For example, this binary tree is symmetric:
 * 
 * 1 / \ 2 2 / \ / \ 3 4 4 3
 * 
 * But the following is not:
 * 
 * 1 / \ 2 2 \ \ 3 3
 * 
 * Note: Bonus points if you could solve it both recursively and iteratively.
 * 
 */

/*
 * *Important* ArrayList accept null as an element
 * 
 * Solution: Similar to Same Tree. A recursion taking two TreeNode instances as
 * arguments
 * 
 * Solution(?) 2: do in-order and in-order2 traversal for two sub-trees. (is
 * this real correct?)
 * 
 * Solution 3: Iteratively output the two sub-trees in level order and compare
 * them
 */
public class SymmetricTree {
    public class Solution {
	public boolean isSymmetric(TreeNode root) {
	    if (root == null) {
		return true;
	    }

	    return isSymmetric(root.left, root.right);

	}

	private boolean isSymmetric(TreeNode r1, TreeNode r2) {
	    if (r1 == null && r2 == null) {
		return true;
	    }
	    if (r1 == null || r2 == null || r1.val != r2.val) {
		return false;
	    }

	    return isSymmetric(r1.left, r2.right) && isSymmetric(r1.right, r2.left);
	}
    }

    /*
     * BFS
     */
    public class Solution_Iteration {
	public boolean isSymmetric(TreeNode root) {
	    if (root == null)
		return true;
	    Queue<TreeNode> l = new LinkedList<TreeNode>(), r = new LinkedList<TreeNode>();
	    l.add(root.left);
	    r.add(root.right);
	    while (!l.isEmpty() && !r.isEmpty()) {
		TreeNode temp1 = l.poll(), temp2 = r.poll();
		if (temp1 == null && temp2 != null || temp1 != null && temp2 == null)
		    return false;
		if (temp1 != null) {
		    if (temp1.val != temp2.val)
			return false;
		    l.add(temp1.left);
		    l.add(temp1.right);
		    r.add(temp2.right);
		    r.add(temp2.left);
		}
	    }
	    return true;
	}
    }

    // Another way (may be wrong)Check in-order and in-order2 traversal for two
    // sub-trees
    class attempt {
	public boolean isSymmetricB(TreeNode root) {
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
	private void inOrderTraversal(TreeNode root, ArrayList<Integer> values) {
	    if (root == null) {
		values.add(null);
		return;
	    }

	    inOrderTraversal(root.left, values);
	    values.add(root.val);
	    inOrderTraversal(root.right, values);

	}

	// Sequence: right, root, left
	private void inOrderTraversal2(TreeNode root, ArrayList<Integer> values) {
	    if (root == null) {
		values.add(null);
		return;
	    }

	    inOrderTraversal2(root.right, values);
	    values.add(root.val);
	    inOrderTraversal2(root.left, values);

	}
    }
}
