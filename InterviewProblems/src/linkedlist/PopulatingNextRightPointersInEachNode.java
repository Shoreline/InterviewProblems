package linkedlist;

import java.util.ArrayList;

public class PopulatingNextRightPointersInEachNode {
    /**
     * Populating Next Right Pointers in Each Node
     * 
     * Given a binary tree
     * 
     * struct TreeLinkNode { TreeLinkNode *left; TreeLinkNode *right;
     * TreeLinkNode *next; }
     * 
     * Populate each next pointer to point to its next right node. If there is
     * no next right node, the next pointer should be set to NULL.
     * 
     * Initially, all next pointers are set to NULL.
     * 
     * Note:
     * 
     * You may only use constant extra space. You may assume that it is a
     * perfect binary tree (ie, all leaves are at the same level, and every
     * parent has two children).
     * 
     * For example, Given the following perfect binary tree,
     * 
     * 1 / \ 2 3 / \ / \ 4 5 6 7
     * 
     * After calling your function, the tree should look like:
     * 
     * 1 -> NULL / \ 2 -> 3 -> NULL / \ / \ 4->5->6->7 -> NULL
     */

    /*
     * Second time pass. Forgot to check if root.left/root.right is null before
     * adding them to nextLevel
     */

    /*
     * The method below also good for Populating Next Right Pointers in Each
     * Node II
     */
    public static void connectB(TreeLinkNode root) {
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

    /*
     * This method only good for this question. It assumes that the binary tree
     * is perfect
     * 
     * one time pass
     */
    public void connect(TreeLinkNode root) {

	if (root == null)
	    return;

	if (root.left != null)
	    root.left.next = root.right;

	/*
	 * Taking advantage of root.next
	 */
	if (root.next != null && root.right != null)
	    root.right.next = root.next.left;

	connect(root.left);
	connect(root.right);

    }

    public static class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	public TreeLinkNode(int x) {
	    val = x;
	}
    }

}
