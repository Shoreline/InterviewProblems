package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

	    dfs(root, sum, new ArrayList<Integer>(), res);

	    return res;
	}

	private void dfs(TreeNode root, int sum, List<Integer> tmp, List<List<Integer>> res) {
	    if (root == null) {
		return;
	    }

	    tmp.add(root.val);
	    if (root.left == null && root.right == null && root.val == sum) {
		res.add(new ArrayList<Integer>(tmp));
	    } else {
		dfs(root.left, sum - root.val, tmp, res);
		dfs(root.right, sum - root.val, tmp, res);
	    }
	    tmp.remove(tmp.size() - 1);
	}
    }

    public class Solution2 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (root == null) {
		return res;
	    }
	    dfs(root, sum, new ArrayList<Integer>(), res);
	    return res;
	}

	private void dfs(TreeNode root, int sum, List<Integer> tmp, List<List<Integer>> res) {

	    tmp.add(root.val);
	    if (root.left == null && root.right == null && root.val == sum) {
		res.add(new ArrayList<Integer>(tmp));
		return;
	    }

	    if (root.left != null) {
		dfs(root.left, sum - root.val, tmp, res);
		tmp.remove(tmp.size() - 1);
	    }

	    if (root.right != null) {
		dfs(root.right, sum - root.val, tmp, res);
		tmp.remove(tmp.size() - 1);
	    }
	}
    }

    public class Solution_Iteration {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (root == null)
		return res;

	    Queue<TreeNode> nodes = new LinkedList<>();
	    Queue<Integer> subSums = new LinkedList<>();
	    Queue<List<Integer>> paths = new LinkedList<>();

	    nodes.add(root);
	    subSums.add(root.val);
	    List<Integer> initialList = new ArrayList<>();
	    initialList.add(root.val);
	    paths.add(initialList);

	    while (!nodes.isEmpty()) {
		TreeNode cur = nodes.poll();
		int sumVal = subSums.poll();
		List<Integer> path = paths.poll();

		if (cur.left == null && cur.right == null && sumVal == sum) {
		    res.add(path);
		}

		if (cur.left != null) {
		    nodes.add(cur.left);
		    subSums.add(sumVal + cur.left.val);

		    List<Integer> tmp = new ArrayList<>(path);
		    tmp.add(cur.left.val);
		    paths.add(tmp);
		}

		if (cur.right != null) {
		    nodes.add(cur.right);
		    subSums.add(sumVal + cur.right.val);

		    List<Integer> tmp = new ArrayList<>(path);
		    tmp.add(cur.right.val);
		    paths.add(tmp);
		}
	    }

	    return res;
	}
    }

}
