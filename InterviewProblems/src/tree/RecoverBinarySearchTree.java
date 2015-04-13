package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Recover Binary Search Tree
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note: A solution using O(n) space is pretty straight forward. Could you
 * devise a constant space solution?
 */

/*
 * O(N) time and O(logN) space. The space is used by JVM stack to handle
 * recursion? O(1) space may be too difficult
 * 
 * In oreder traversal the BST, we shall have an ascending sequence.
 * 
 * For example: 1,2,3,4,5,6,7
 * 
 * If any two nodes are swapped by mistake, like 1,6,3,4,5,2,7:
 * 
 * Then iterate through this sequence, event "pre.val > cur.val" will happen
 * twice. The first time, the wrong node is pre, the second time, the wrong node
 * is cur (6>3 and 5>2).
 * 
 * So, we need to do in-order traversal and keep comparing pre.val and cur.val
 * 
 * 
 * Corner case: if values of two adjacent nodes are swapped, like 1,3,2,4,5,6,7.
 * Then "pre.val>cur.val" happen only once, and both pre and cur are the wrong
 * nodes
 * 
 * Important: how to keep track of the pre node??
 * 
 * To swap two nodes, we can just swap their value.
 */

public class RecoverBinarySearchTree {
    public class Solution {
	public void recoverTree(TreeNode root) {
	    if (root == null) {
		return;
	    }

	    //maximum size is 1
	    List<TreeNode> preNode = new ArrayList<TreeNode>();
	    
	    // maximum size is 2
	    List<TreeNode> candidates = new ArrayList<TreeNode>();
	    preNode.add(null); // no pre root for 'root'
	    inOrderTraverse(root, preNode, candidates);

	    int tmp = candidates.get(0).val;
	    candidates.get(0).val = candidates.get(1).val;
	    candidates.get(1).val = tmp;
	}

	private void inOrderTraverse(TreeNode root, List<TreeNode> preNodes,
		List<TreeNode> candidates) {
	    if (root == null) {
		return;
	    }

	    inOrderTraverse(root.left, preNodes, candidates);

	    TreeNode preNode = preNodes.get(0);
	    if (preNode != null && preNode.val > root.val) {
		if (candidates.size() == 0) {
		    candidates.add(preNode);
		    candidates.add(root);
		} else {
		    candidates.remove(1);
		    candidates.add(root);
		}
	    }

	    preNodes.clear();
	    preNodes.add(root);
	    inOrderTraverse(root.right, preNodes, candidates);
	}

    }

    // use a static global variable
    class Solution_2013 {
	TreeNode pre = null;

	public void recoverTree(TreeNode root) {
	    if (root == null)
		return;

	    ArrayList<TreeNode> candidates = new ArrayList<TreeNode>();
	    findNodes(root, candidates);

	    if (candidates.size() == 2) {
		int temp = candidates.get(0).val;
		candidates.get(0).val = candidates.get(1).val;
		candidates.get(1).val = temp;
	    } else {
		// error if reach here
	    }

	    // only for leetcode online judge. need to reset the global variable
	    pre = null;
	}

	private void findNodes(TreeNode cur, ArrayList<TreeNode> candidates) {
	    if (cur == null)
		return;
	    findNodes(cur.left, candidates);

	    if (pre != null && pre.val > cur.val) {
		if (candidates.size() == 0) {
		    candidates.add(pre);
		    candidates.add(cur);
		} else {
		    candidates.remove(1);
		    candidates.add(cur);
		}
	    }

	    // reset pre!!
	    pre = cur;

	    findNodes(cur.right, candidates);

	}
    }
}
