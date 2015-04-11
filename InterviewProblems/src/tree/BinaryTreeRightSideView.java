package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Right Side View
 * 
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * For example: Given the following binary tree,
 * 
 *        1            <---
 	/   \
	2     3         <---
 	 \     \
  	  5     4       <---
 * 
 * You should return [1, 3, 4].
 */

public class BinaryTreeRightSideView {
    /*
     * Basically, it is a binary tree level traversal problem
     */
    public class Solution {
	public List<Integer> rightSideView(TreeNode root) {
	    List<Integer> res = new ArrayList<Integer>();
	    if (root == null) {
		return res;
	    }

	    List<TreeNode> curLevel = new ArrayList<TreeNode>();
	    List<TreeNode> nextLevel = new ArrayList<TreeNode>();
	    curLevel.add(root);

	    while (curLevel.size() > 0) {

		for (int i = 0; i < curLevel.size(); i++) {

		    TreeNode node = curLevel.get(i);
		    if (i == curLevel.size() - 1) {
			res.add(node.val);
		    }

		    if (node.left != null) {
			nextLevel.add(node.left);
		    }
		    if (node.right != null) {
			nextLevel.add(node.right);
		    }
		}
		curLevel.clear();
		List<TreeNode> tmp = curLevel;
		curLevel = nextLevel;
		nextLevel = tmp;
	    }

	    return res;
	}
    }
}
