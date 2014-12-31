package tree;

import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversal {
    /**
     * Binary Tree Level Order Traversal
     * 
     * Given a binary tree, return the level order traversal of its nodes'
     * values. (ie, from left to right, level by level).
     * 
     * For example: Given binary tree {3,9,20,#,#,15,7}, 3 / \ 9 20 / \ 15 7
     * return its level order traversal as: [ [3], [9,20], [15,7] ]
     */

    /*
     * one time pass!
     */

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	if (root == null)
	    return result;

	ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
	nodeList.add(root);

	while (!nodeList.isEmpty()) {
	    ArrayList<Integer> values = new ArrayList<Integer>();
	    ArrayList<TreeNode> nextNodeList = new ArrayList<TreeNode>();
	    for (TreeNode aNode : nodeList) {
		values.add(aNode.val);
		if (aNode.left != null)
		    nextNodeList.add(aNode.left);
		if (aNode.right != null)
		    nextNodeList.add(aNode.right);
	    }
	    result.add(values);
	    nodeList.clear();
	    nodeList.addAll(nextNodeList);
	}

	return result;
    }
}
