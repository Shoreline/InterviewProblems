package tree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * http://n00tc0d3r.blogspot.com/2013/08/implement-iterator-for-binarytree-i-in.
 * html
 *
 */
public class BinaryTreeInOrderIterator implements Iterator<TreeNode> {
    Stack<TreeNode> stack = new Stack<TreeNode>();

    private void pushLeftChildren(TreeNode cur) {
	while (cur != null) {
	    stack.push(cur);
	    cur = cur.left;
	}
    }

    public BinaryTreeInOrderIterator(TreeNode root) {
	pushLeftChildren(root);
    }

    @Override
    public boolean hasNext() {
	return !stack.isEmpty();
    }

    @Override
    public TreeNode next() {
	if (!hasNext()) {
	    throw new NoSuchElementException("no new node");
	}

	TreeNode res = stack.pop();
	pushLeftChildren(res.right);

	return res;
    }

}
