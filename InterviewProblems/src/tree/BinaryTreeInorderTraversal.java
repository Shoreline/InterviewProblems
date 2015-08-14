package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree Inorder Traversal
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 */
/*
 * 3 Solutions: Morris; recursion, iteration (use a stack).
 */
public class BinaryTreeInorderTraversal {
    /*
     * Recursion solution O(N) time, O(logN) space
     * 
     * O(N) time: total N nodes, visit each one once.
     * 
     * O(logN) space: tree height is logN, so maximum logN layers of recursion.
     */
    public class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
	    List<Integer> res = new ArrayList<>();
	    dfs(root, res);

	    return res;
	}

	private void dfs(TreeNode root, List<Integer> res) {
	    if (root == null) {
		return;
	    }

	    dfs(root.left, res);
	    res.add(root.val);
	    dfs(root.right, res);
	}
    }

    /*
     * Morris Traversal: O(N) time (actually is O(2N)); O(1) space
     * 
     * http://blog.csdn.net/linhuanmars/article/details/20187257
     * 
     * Only use two additional variables.
     */
    public class Solution_Morris {
	public List<Integer> inorderTraversal(TreeNode root) {
	    List<Integer> res = new ArrayList<>();
	    TreeNode cur = root;
	    TreeNode pre = null;

	    while (cur != null) {
		if (cur.left == null) {
		    res.add(cur.val);
		    cur = cur.right;
		} else {
		    pre = cur.left;
		    while (pre.right != null && pre.right != cur) {
			pre = pre.right;
		    }

		    if (pre.right == null) {
			pre.right = cur;
			cur = cur.left;
		    } else {
			pre.right = null;
			res.add(cur.val);
			cur = cur.right;
		    }
		}

	    }

	    return res;
	}
    }

    /*
     * Iterative method: use a stack.
     * 
     * O(N) time, O(logN) space
     * 
     * Besides the Stack, also need to keep track a pointer (root). Each
     * iteration, operates on the pointer node.
     */
    public class Solution_Iteration {
	public List<Integer> inorderTraversal(TreeNode root) {
	    List<Integer> res = new ArrayList<>();
	    Stack<TreeNode> stack = new Stack<>();

	    while (root != null || !stack.isEmpty()) {
		if (root != null) {
		    stack.push(root);
		    root = root.left;
		} else {
		    TreeNode node = stack.pop();
		    res.add(node.val);
		    root = node.right;
		}
	    }

	    return res;
	}
    }

    public class Solution_recursion4 {
	public List<Integer> inorderTraversal(TreeNode root) {
	    List<Integer> res = new ArrayList<>();
	    if (root == null) {
		return res;
	    }
	    helper(root, res);
	    return res;
	}

	private void helper(TreeNode root, List<Integer> res) {
	    if (root.left != null) {
		helper(root.left, res);
	    }
	    res.add(root.val);
	    if (root.right != null) {
		helper(root.right, res);
	    }
	}
    }

    // this time less new.
    public class Solution_Recursion2 {
	List<Integer> res = new ArrayList<Integer>();

	public List<Integer> inorderTraversal(TreeNode root) {

	    if (root == null) {
		return res;
	    }

	    inorderTraversal(root.left);
	    res.add(root.val);
	    inorderTraversal(root.right);

	    return res;
	}

    }

    public class Solution_Recursion3 {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
	    ArrayList<Integer> result = new ArrayList<Integer>();

	    if (root == null) {
		return result; // NOTE! do not return null!
	    }

	    result.addAll(inorderTraversal(root.left));
	    result.add(root.val);
	    result.addAll(inorderTraversal(root.right));

	    return result;
	}
    }

    /*
     * If only using Stack without pointer node, infinite loop
     */
    public class SolutionWrong {

	public List<Integer> inorderTraversal(TreeNode root) {
	    List<Integer> res = new ArrayList<Integer>();
	    if (root == null) {
		return res;
	    }

	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.push(root);
	    while (!stack.isEmpty()) {
		TreeNode head = stack.peek();
		if (head.left != null) {
		    stack.push(head.left);
		    continue;
		}
		res.add(head.val);
		stack.pop();
		if (head.right != null) {
		    stack.push(head.right);
		}
	    }
	    return res;
	}

    }

}
