package tree;

import java.util.ArrayList;

public class PathSum2 {

    /**
     * Given a binary tree and a sum, find all root-to-leaf paths where each
     * path's sum equals the given sum.
     * 
     * For example: Given the below binary tree and sum = 22,
     * 
     * 5 / \ 4 8 / / \ 11 13 4 / \ / \ 7 2 5 1
     * 
     * return [ [5,4,11,2], [5,8,4,5] ]
     */

    /*
     * It will be easier if we use a static variable to store and update result.
     */
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> path = new ArrayList<Integer>();

	if (root == null) {
	    return result;
	}

	path.add(root.val);

	result = pathSum(root, sum, path);

	return result;

    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum,
	    ArrayList<Integer> path) {

	if (root == null) {
	    return null;
	}

	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	if (root.left == null && root.right == null) {
	    int curSum = 0;
	    for (Integer anInteger : path) {
		curSum += anInteger;
	    }
	    if (curSum == sum) {
		result.add(path);
	    }
	}

	ArrayList<Integer> listForLeft = new ArrayList<Integer>(path);
	ArrayList<Integer> listForRight = new ArrayList<Integer>(path);

	if (root.left != null) {
	    listForLeft.add(root.left.val);
	    result.addAll(pathSum(root.left, sum, listForLeft));
	}

	if (root.right != null) {
	    listForRight.add(root.right.val);
	    result.addAll(pathSum(root.right, sum, listForRight));
	}

	return result;
    }

}
