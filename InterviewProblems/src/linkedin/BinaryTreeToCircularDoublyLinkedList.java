package linkedin;

import tree.TreeNode;

public class BinaryTreeToCircularDoublyLinkedList {
    class Method {
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

	    node.right = head;

	    prev = node;
	    head.left = node;
	    node.right = head;

	    bstToDLL(node.right);

	    return head;
	}
    }
}
