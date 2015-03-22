package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinanryTreeInorderTraversal {

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
     * Morris Traversal (high hand method) O(N) time (actually is O(2N)); O(1)
     * space http://blog.csdn.net/linhuanmars/article/details/20187257
     */

    /*
     * Iterative method O(N) time, O(logN) space
     * 
     * Besides the Stack, also need to keep track a pointer (root). Each
     * iteration, operates on the pointer node.
     */
    public class Solution2 {
	public List<Integer> inorderTraversal(TreeNode root) {
	    List<Integer> res = new ArrayList<Integer>();
	    if (root == null) {
		return res;
	    }

	    Stack<TreeNode> stack = new Stack<TreeNode>();

	    while (!stack.isEmpty() || root != null) {

		if (root != null) {
		    stack.push(root);
		    root = root.left;
		} else {
		    root = stack.pop();
		    res.add(root.val);
		    root = root.right;
		}
	    }

	    return res;
	}

    }

    /*
     * Recursion solution O(N) time, O(logN) space
     */

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

    public class Solution_Recursion {
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
