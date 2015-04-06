package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * For example: Given the below binary tree and sum = 22,
 * 
 * 5 / \ 4 8 / / \ 11 13 4 / \ / \ 7 2 5 1
 * 
 * return [ [5,4,11,2], [5,8,4,5] ]
 */

public class PathSumII {

    /*
     * DFS + backtracking
     */
    public class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (root == null) {
		return res;
	    }

	    List<Integer> tmpPath = new ArrayList<Integer>();
	    tmpPath.add(root.val);
	    dfsHelper(root, sum, root.val, tmpPath, res);

	    return res;
	}

	private void dfsHelper(TreeNode root, int sum, int subSum,
		List<Integer> path, List<List<Integer>> res) {

	    if (subSum == sum && root.left == null && root.right == null) {
		res.add(new ArrayList<Integer>(path));
		return;
	    }

	    if (root.left != null) {
		path.add(root.left.val);
		dfsHelper(root.left, sum, subSum + root.left.val, path, res);
		path.remove(path.size() - 1);
	    }
	    if (root.right != null) {
		path.add(root.right.val);
		dfsHelper(root.right, sum, subSum + root.right.val, path, res);
		path.remove(path.size() - 1);
	    }

	}
    }

    /*
     * 
     * It will be easier if we use a static variable to store and update result.
     */
    class Solution_2013 {
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

}
