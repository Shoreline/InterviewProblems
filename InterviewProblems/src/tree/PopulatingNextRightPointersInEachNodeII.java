package tree;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution
 * still work?
 * 
 * Note:
 * 
 * You may only use constant extra space.
 * 
 * For example, Given the following binary tree,
 * 
 * 1 / \ 2 3 / \ \ 4 5 7
 * 
 * After calling your function, the tree should look like:
 * 
 * 1 -> NULL / \ 2 -> 3 -> NULL / \ \ 4-> 5 -> 7 -> NULL
 */

/*
 * Use level order traversal.
 * 
 * But do not need additional lists to cache current level nodes and next level
 * nodes.
 * 
 * Horizontally, nodes in each level form a linked list.
 */
public class PopulatingNextRightPointersInEachNodeII {
    public class Solution {
	public void connect(TreeLinkNode root) {
	    if (root == null) {
		return;
	    }

	    TreeLinkNode curLvlHead = root;
	    TreeLinkNode cur = root;

	    while (curLvlHead != null) {
		TreeLinkNode pre = null;
		TreeLinkNode nextLvlHead = null;
		cur = curLvlHead;

		while (cur != null) {
		    if (cur.left != null) {
			if (pre == null) {
			    // the first node will be head
			    pre = cur.left;
			    nextLvlHead = cur.left;
			} else {
			    pre.next = cur.left;
			    pre = cur.left;
			}
		    }

		    if (cur.right != null) {
			if (pre == null) {
			    pre = cur.right;
			    nextLvlHead = cur.right;
			} else {
			    pre.next = cur.right;
			    pre = cur.right;
			}
		    }

		    cur = cur.next;
		}
		curLvlHead = nextLvlHead;
	    }

	    return;
	}
    }

}
