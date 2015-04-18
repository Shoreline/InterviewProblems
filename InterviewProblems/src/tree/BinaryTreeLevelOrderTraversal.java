package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Level Order Traversal
 * 
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7}, 3 / \ 9 20 / \ 15 7 return
 * its level order traversal as: [ [3], [9,20], [15,7] ]
 */

public class BinaryTreeLevelOrderTraversal {

    public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (root == null) {
		return res;
	    }

	    List<TreeNode> curLvl = new ArrayList<TreeNode>();
	    curLvl.add(root);

	    while (curLvl.size() > 0) {
		List<TreeNode> nextLvl = new ArrayList<TreeNode>();
		List<Integer> curLvlValues = new ArrayList<Integer>();
		for (TreeNode node : curLvl) {
		    curLvlValues.add(node.val);
		    if (node.left != null) {
			nextLvl.add(node.left);
		    }
		    if (node.right != null) {
			nextLvl.add(node.right);
		    }
		}
		res.add(curLvlValues);
		curLvl = nextLvl;
	    }

	    return res;
	}
    }
}
