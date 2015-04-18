package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Binary Tree Level Order Traversal II
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7}, 3 / \ 9 20 / \ 15 7
 * 
 * return its bottom-up level order traversal as: [ [15,7] [9,20], [3], ]
 */

/*
 * Just return the top-down level order traversal, as previous problem. Then
 * reverse the order of the returned ArrayList.
 * 
 * Note: use Collections.reverse(anArrayList) to do reversing
 */

public class BinaryTreeLevelOrderTraversalII {

    public class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (root == null) {
		return res;
	    }

	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.push(root);

	    while (!queue.isEmpty()) {
		LinkedList<TreeNode> nextLvl = new LinkedList<TreeNode>();
		List<Integer> values = new ArrayList<Integer>();

		while (!queue.isEmpty()) {
		    TreeNode node = queue.poll();
		    values.add(node.val);

		    if (node.left != null) {
			nextLvl.add(node.left);
		    }
		    if (node.right != null) {
			nextLvl.add(node.right);
		    }
		}
		queue = nextLvl;
		res.add(values);
	    }

	    Collections.reverse(res);
	    return res;
	}
    }

}
