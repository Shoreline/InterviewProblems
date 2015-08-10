package linkedin;

import tree.TreeNode;

/**
 * Inorderly conver BT into a DLL
 * 
 * Given a Binary Tree (Bt), convert it to a Doubly Linked List(DLL). The left
 * and right pointers in nodes are to be used as previous and next pointers
 * respectively in converted DLL. The order of nodes in DLL must be same as
 * Inorder of the given Binary Tree. The first node of Inorder traversal (left
 * most node in BT) must be head node of the DLL.
 *
 */
public class BinaryTreeToDoublyLinkedListInOrder {
    class Solution {
	private TreeNode prev;
	private TreeNode head;

	public TreeNode bstToDLL(TreeNode node) {
	    if (node == null) {
		return null;
	    }

	    bstToDLL(node.left);

	    node.left = prev;
	    if (prev != null) {
		prev.right = node;
	    } else {
		head = node;
	    }

	    prev = node;

	    bstToDLL(node.right);

	    return head;
	}
    }
}
