package tree;

import java.util.ArrayList;

/**
 * Populating Next Right Pointers in Each Node
 * 
 * Given a binary tree
 * 
 * struct TreeLinkNode { TreeLinkNode *left; TreeLinkNode *right; TreeLinkNode
 * *next; }
 * 
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * You may only use constant extra space. You may assume that it is a perfect
 * binary tree (ie, all leaves are at the same level, and every parent has two
 * children).
 * 
 * For example, Given the following perfect binary tree,
 * 
 * 1 / \ 2 3 / \ / \ 4 5 6 7
 * 
 * After calling your function, the tree should look like:
 * 
 * 1 -> NULL / \ 2 -> 3 -> NULL / \ / \ 4->5->6->7 -> NULL
 */

public class PopulatingNextRightPointersInEachNode {
    /*
     * This method only good for this question. It assumes that the binary tree
     * is perfect
     * 
     * For each node, find its left and right nodes' next nodes
     */
    public class Solution {
	public void connect(TreeLinkNode root) {

	    if (root == null) {
		return;
	    }

	    if (root.left != null) {
		root.left.next = root.right;
	    }

	    /*
	     * Taking advantage of root.next
	     */
	    if (root.next != null && root.right != null)
		root.right.next = root.next.left;

	    connect(root.left);
	    connect(root.right);

	}
    }

    public class Solution_Iteration {
	public void connect(TreeLinkNode root) {

	    TreeLinkNode cur = root;
	    while (cur != null) {
		TreeLinkNode lvlHead = cur;
		while (cur != null) {
		    if (cur.left != null) {
			cur.left.next = cur.right;
		    }
		    if (cur.right != null && cur.next != null) {
			cur.right.next = cur.next.left;
		    }
		    cur = cur.next;
		}
		cur = lvlHead.left;
	    }

	}

    }

    /*
     * For each node, find its next node.
     */
    public class Solution_Iteration2 {
	public void connect(TreeLinkNode root) {
	    if (root == null) {
		return;
	    }

	    TreeLinkNode parent = root;
	    TreeLinkNode cur = root.left;

	    while (cur != null) {
		TreeLinkNode tmp = cur;
		while (cur != null) {
		    if (cur == parent.left) {
			cur.next = parent.right;
		    } else if (cur == parent.right && parent.next != null) {
			cur.next = parent.next.left;
			parent = parent.next;
		    }
		    cur = cur.next;
		}

		parent = tmp;
		cur = tmp.left;
	    }

	}

    }

    /*
     * Wrong attempt.
     * 
     * space cost is not constant
     */
    class Wrong_attempt {
	public void connectB(TreeLinkNode root) {
	    if (root == null)
		return;

	    ArrayList<TreeLinkNode> curLevel = new ArrayList<TreeLinkNode>();
	    curLevel.add(root);

	    while (!curLevel.isEmpty()) {
		ArrayList<TreeLinkNode> nextLevel = new ArrayList<TreeLinkNode>();
		for (int i = 0; i < curLevel.size(); i++) {
		    if (i != curLevel.size() - 1) {
			curLevel.get(i).next = curLevel.get(i + 1);
		    }
		    /*
		     * Important* Since "null" is also an element in Java's
		     * ArrayList, make sure not to add it
		     */
		    if (curLevel.get(i).left != null)
			nextLevel.add(curLevel.get(i).left);
		    if (curLevel.get(i).right != null)
			nextLevel.add(curLevel.get(i).right);
		}
		curLevel = nextLevel;
	    }
	}
    }

}
