package tree;

import java.util.*;

/**
 * Closest Binary Search Tree Value II
 * 
 * Given a non-empty binary search tree and a target value, find k values in the
 * BST that are closest to the target.
 * 
 * Note: Given target value is a floating point. You may assume k is always
 * valid, that is: k ≤ total nodes. You are guaranteed to have only one unique
 * set of k values in the BST that are closest to the target.
 * 
 * 
 * Follow up: Assume that the BST is balanced, could you solve it in less than
 * O(n) runtime (where n = total nodes)?
 * 
 * Hint:
 * 
 * Consider implement these two helper functions: getPredecessor(N), which
 * returns the next smaller node to N. getSuccessor(N), which returns the next
 * larger node to N. Try to assume that each node has a parent pointer, it makes
 * the problem much easier. Without parent pointer we just need to keep track of
 * the path from the root to the current node using a stack. You would need two
 * stacks to track the path in finding predecessor and successor node
 * separately.
 *
 */
/*
 * For the follow up: for a balanced BST you may only use O(k) time. What is
 * needed is the K values bigger or equal to target, and K values smaller than
 * target. For a balanced BST we can get to know how many
 * predecessors/successors a node has?
 * 
 * 
 */
public class ClosestBinarySearchTreeValueII {
    public class Solution {
	/*
	 * To compare the predecessors and successors of the closest node to the
	 * target, we can use two stacks to track the predecessors and
	 * successors,
	 * 
	 * The pre Stack saves all nodes having val smaller or equal to target;
	 * the suc Stack saves all nodes having val bigger than target
	 */
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
	    List<Integer> res = new ArrayList<>();
	    Stack<Integer> pre = new Stack<>();
	    Stack<Integer> suc = new Stack<>();

	    inorder(root, target, pre);
	    reversedInorder(root, target, suc);

	    while (k-- > 0) {
		if (pre.isEmpty() || suc.isEmpty()) {
		    res.add(pre.isEmpty() ? suc.pop() : pre.pop());
		} else if (Math.abs(target - pre.peek()) < Math.abs(target - suc.peek())) {
		    res.add(pre.pop());
		} else {
		    res.add(suc.pop());
		}
	    }

	    return res;
	}

	private void inorder(TreeNode root, double target, Stack<Integer> stack) {
	    if (root == null) {
		return;
	    }

	    inorder(root.left, target, stack);
	    if (root.val <= target) {
		stack.push(root.val);
	    } else {
		return;
	    }
	    inorder(root.right, target, stack);
	}

	private void reversedInorder(TreeNode root, double target, Stack<Integer> stack) {
	    if (root == null) {
		return;
	    }

	    reversedInorder(root.right, target, stack);
	    if (root.val > target) {
		stack.push(root.val);
	    } else {
		return;
	    }
	    reversedInorder(root.left, target, stack);
	}
    }
}
