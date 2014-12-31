package tree;

import java.util.ArrayList;

public class UniqueBinarySearchTreesII {

    /**
     * Unique Binary Search Trees II
     * 
     * Given n, generate all structurally unique BST's (binary search trees)
     * that store values 1...n.
     */

    /*
     * My thought: use a boolean array to store whether an Integer has been
     * inserted to a BST
     * 
     * But, on further thought:
     * 
     * 1. all Integers in the left sub-tree must smaller than the root; all
     * Integers in the right sub-tree must bigger than the root
     * 
     * 2. Every Integer can be the root, at least one time
     * 
     * -> recursion, and use iteration inside of each recursion
     * 
     * In tree construction, leaf nodes generally are still not the stopping
     * cases. Their null child nodes are.
     * 
     * Solution from Internet:
     */
    public static ArrayList<TreeNode> generateTrees(int n) {
	ArrayList<TreeNode> result = new ArrayList<TreeNode>();
	// corner case
	if (n <= 0) {
	    result.add(null);
	    return result;
	}

	result = generateTrees(1, n);
	return result;
    }

    private static ArrayList<TreeNode> generateTrees(int start, int end) {
	ArrayList<TreeNode> result = new ArrayList<TreeNode>();
	/*
	 * *Important* Stop condition
	 * 
	 * Another stop case is when start = end. It is processed in the for
	 * loop below with other general cases
	 */
	if (start > end) {
	    result.add(null);
	    return result;
	}

	for (int i = start; i <= end; i++) {
	    ArrayList<TreeNode> leftTrees = generateTrees(start, i - 1);
	    ArrayList<TreeNode> rightTrees = generateTrees(i + 1, end);

	    /*
	     * Create new trees:
	     * 
	     * Connect each possible left sub-tree to the root, then to each
	     * possible right sub-tree
	     */
	    for (TreeNode aLeftTree : leftTrees) {
		for (TreeNode aRightTree : rightTrees) {
		    TreeNode root = new TreeNode(i);
		    root.left = aLeftTree;
		    root.right = aRightTree;
		    result.add(root);
		}
	    }

	}

	return result;
    }
}
