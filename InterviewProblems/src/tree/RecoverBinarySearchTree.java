package tree;

import java.util.ArrayList;

public class RecoverBinarySearchTree {
    /**
     * Recover Binary Search Tree
     * 
     * Two elements of a binary search tree (BST) are swapped by mistake.
     * 
     * Recover the tree without changing its structure.
     * 
     * Note: A solution using O(n) space is pretty straight forward. Could you
     * devise a constant space solution?
     */

    /*
     * O(N) time and O(1) space solution:
     * 
     * In oreder traversal the BST, we shall have an ascending sequence.
     * 
     * For example: 1,2,3,4,5,6,7
     * 
     * If any two nodes are swapped by mistake, like 1,6,3,4,5,2,7:
     * 
     * Then iterate through this sequence, event "pre.val > cur.val" will happen
     * twice. The first time, the wrong node is pre, the second time, the wrong
     * node is cur (6>3 and 5>2).
     * 
     * So, we need to do in-order traversal and keep comparing pre.val and
     * cur.val
     * 
     * 
     * Corner case: if values of two adjacent nodes are swapped, like
     * 1,3,2,4,5,6,7. Then "pre.val>cur.val" happen only once, and both pre and
     * cur are the wrong nodes
     * 
     * Important: how to keep track of the pre node??
     */

    // use a static global variable
    static TreeNode pre = null;

    public static void recoverTree(TreeNode root) {
	if (root == null)
	    return;

	ArrayList<TreeNode> candidates = new ArrayList<TreeNode>();
	findNodes(root, candidates);

	if (candidates.size() == 2) {
	    int temp = candidates.get(0).val;
	    candidates.get(0).val = candidates.get(1).val;
	    candidates.get(1).val = temp;
	} else {
	    // error if reach here
	}

	// only for leetcode online judge. need to reset the global variable
	pre = null;
    }

    private static void findNodes(TreeNode cur, ArrayList<TreeNode> candidates) {
	if (cur == null)
	    return;
	findNodes(cur.left, candidates);

	if (pre != null && pre.val > cur.val) {
	    if (candidates.size() == 0) {
		candidates.add(pre);
		candidates.add(cur);
	    } else {
		candidates.remove(1);
		candidates.add(cur);
	    }
	}

	// reset pre!!
	pre = cur;

	findNodes(cur.right, candidates);

    }
}
