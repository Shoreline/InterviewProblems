package tree;

import java.util.*;

/**
 * Count Univalue Subtrees
 * 
 * Given a binary tree, count the number of uni-value subtrees.
 * 
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * 
 * For example: Given binary tree,
 * 
              5
             / \
            1   5
           / \   \
          5   5   5
          
 return 4.
 */
public class CountUnivalueSubtrees {
    public class Solution {
	public int countUnivalSubtrees(TreeNode root) {
	    if (root == null) {
		return 0;
	    }
	    int[] counter = new int[1];
	    parentChildSameValue(root, counter, root.val);
	    return counter[0];
	}

	private boolean parentChildSameValue(TreeNode root, int[] counter, int parVal) {
	    if (root == null) {
		return true;
	    }
	    boolean l = parentChildSameValue(root.left, counter, root.val);
	    boolean r = parentChildSameValue(root.right, counter, root.val);

	    if (l && r) {
		counter[0]++;
	    }

	    return l && r && root.val == parVal;
	}

    }

    /*
     * My own solution.
     */
    public class Solution2 {
	public int countUnivalSubtrees(TreeNode root) {
	    List<Integer> count = new ArrayList<>();
	    count.add(0);
	    isUniSubTree(root, count);

	    return count.get(0);
	}

	private boolean isUniSubTree(TreeNode root, List<Integer> count) {
	    if (root == null) {
		return true;
	    }
	    if (root.left == null && root.right == null) {
		count.set(0, count.get(0) + 1);
		return true;
	    }

	    boolean left = isUniSubTree(root.left, count);
	    boolean right = isUniSubTree(root.right, count);

	    if (!(left && right)) {
		return false;
	    }

	    if (root.left != null && root.right != null) {
		if (root.val == root.left.val && root.val == root.right.val) {
		    count.set(0, count.get(0) + 1);
		    return true;
		}
	    }

	    if (root.left == null || root.right == null) {
		if (root.val == (root.left == null ? root.right.val : root.left.val)) {
		    count.set(0, count.get(0) + 1);
		    return true;
		}
	    }

	    return false;
	}
    }
}
