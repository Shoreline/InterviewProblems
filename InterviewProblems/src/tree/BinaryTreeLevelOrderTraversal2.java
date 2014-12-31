package tree;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryTreeLevelOrderTraversal2 {
    /**
     * Binary Tree Level Order Traversal II
     * 
     * Given a binary tree, return the bottom-up level order traversal of its
     * nodes' values. (ie, from left to right, level by level from leaf to
     * root).
     * 
     * For example: Given binary tree {3,9,20,#,#,15,7}, 3 / \ 9 20 / \ 15 7
     * 
     * return its bottom-up level order traversal as: [ [15,7] [9,20], [3], ]
     */

    /*
     * one time pass!
     * 
     * Just return the top-down level order traversal, as previous problem. Then
     * reverse the order of the returned ArrayList.
     * 
     * Note: use Collections.reverse(anArrayList) to do reversing
     */

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	if (root == null)
	    return result;

	ArrayList<TreeNode> curNodeList = new ArrayList<TreeNode>();
	curNodeList.add(root);

	while (!curNodeList.isEmpty()) {
	    ArrayList<Integer> values = new ArrayList<Integer>();
	    ArrayList<TreeNode> nextNodeList = new ArrayList<TreeNode>();

	    for (TreeNode aNode : curNodeList) {
		values.add(aNode.val);
		if (aNode.left != null)
		    nextNodeList.add(aNode.left);
		if (aNode.right != null)
		    nextNodeList.add(aNode.right);
	    }
	    result.add(values);
	    curNodeList = nextNodeList;
	}

	Collections.reverse(result);

	return result;

    }
}
