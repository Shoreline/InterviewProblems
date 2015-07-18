package linkedin;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

public class BinaryTreeToDoublyList {
    public void tree2DoublyList(TreeNode root) {
	List<TreeNode> list = new ArrayList<TreeNode>();
	traversal(root, list);
	for (int i = 0; i < list.size() - 1; i++)
	    list.get(i).right = list.get(i + 1);
	list.get(list.size() - 1).right = list.get(0);
	for (int i = 1; i < list.size(); i++)
	    list.get(i).left = list.get(i - 1);
	list.get(0).left = list.get(list.size() - 1);
	return;
    }

    private void traversal(TreeNode root, List<TreeNode> list) {
	if (root == null) {
	    return;
	}

	traversal(root.left, list);
	list.add(root);
	traversal(root.right, list);
	return;
    }

    class Solution2 {
	private TreeNode prev;
	private TreeNode head;

	public TreeNode bstToDLL(TreeNode node) {
	    if (node == null)
		return null;
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
