package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
    /**
     * Binary Tree Zigzag Level Order Traversal
     * 
     * Given a binary tree, return the zigzag level order traversal of its
     * nodes' values. (ie, from left to right, then right to left for the next
     * level and alternate between).
     * 
     * For example: Given binary tree {3,9,20,#,#,15,7}, 3 / \ 9 20 / \ 15 7
     * 
     * return its zigzag level order traversal as: [ [3], [20,9], [15,7] ]
     */

    /*
     * Two stack instances
     * Two while loops
     * O(N)/O(N) 
     */
    public class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (root == null) {
		return res;
	    }

	    Stack<TreeNode> curLvl = new Stack<TreeNode>();
	    Stack<TreeNode> nextLvl = new Stack<TreeNode>();
	    curLvl.push(root);

	    boolean leftFirst = true;
	    while (!curLvl.isEmpty()) {
		List<Integer> nums = new ArrayList<Integer>();
		while (!curLvl.isEmpty()) {
		    TreeNode aNode = curLvl.pop();
		    if (aNode == null) {
			continue;
		    }

		    nums.add(aNode.val);

		    if (leftFirst) {
			nextLvl.push(aNode.left);
			nextLvl.push(aNode.right);
		    } else {
			nextLvl.push(aNode.right);
			nextLvl.push(aNode.left);
		    }
		}

		if (nums.size() > 0) {
		    res.add(nums);
		}
		Stack<TreeNode> tmp = curLvl; // need a temp variable to do
					      // switching
		curLvl = nextLvl;
		nextLvl = tmp;
		leftFirst = !leftFirst;
	    }

	    return res;
	}
    }

    /*
     * lazy implementation. works though
     * 
     * Similar to previous level order traversal, just reverse some Lists in the
     * end
     */
    class Method {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
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

	    int i = 0;
	    for (ArrayList<Integer> aList : result) {
		if (i % 2 == 1) {
		    Collections.reverse(aList);
		}
		i++;
	    }

	    return result;

	}
    }
}
