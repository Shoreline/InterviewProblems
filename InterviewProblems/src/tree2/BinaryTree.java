package tree2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinaryTree<E extends Comparable<E>> {
    private TreeNode<E> root;
    private int size = 0;

    public BinaryTree() {
    }

    public BinaryTree(E[] objects) {
	for (int i = 0; i < objects.length; i++) {
	    insert(objects[i]);
	}
    }

    public boolean search(E e) {
	// TODO Auto-generated method stub
	TreeNode<E> current = root;
	while (current != null) {
	    if (e.compareTo(current.element) < 0) {
		current = current.left;
	    } else if (e.compareTo(current.element) > 0) {
		current = current.right;
	    } else
		return true;
	}
	return false;
    }

    public boolean insert(E e) {
	// TODO Auto-generated method stub
	if (root == null) {
	    root = creatTreeNode(e);
	} else {
	    TreeNode<E> parent = null;
	    TreeNode<E> current = root;
	    while (current != null) {
		if (e.compareTo(current.element) < 0) {
		    parent = current;
		    current = current.left;
		} else if (e.compareTo(current.element) > 0) {
		    parent = current;
		    current = current.right;
		} else
		    return false;
	    }
	    if (e.compareTo(parent.element) < 0) {
		parent.left = creatTreeNode(e);
	    }
	    if (e.compareTo(parent.element) > 0) {
		parent.right = creatTreeNode(e);
	    }
	}
	size++;
	return true;
    }

    public TreeNode<E> creatTreeNode(E e) {
	return new TreeNode<E>(e);
    }

    public void inorder() {
	inorder(root);
    }

    public void inorder(TreeNode<E> root) {
	if (root == null)
	    return;
	inorder(root.left);
	System.out.print(root.element + "  ");
	inorder(root.right);
    }

    public void postorder() {

	postorder(root);

    }

    public void postorder(TreeNode<E> root) {
	if (root == null)
	    return;
	postorder(root.left);
	postorder(root.right);
	System.out.print(root.element + " ");
    }

    public void preorder() {
	preorder(root);
    }

    public void preorder(TreeNode<E> root) {
	if (root == null)
	    return;
	System.out.print(root.element + " ");
	preorder(root.left);
	preorder(root.right);
    }

    public int getSize() {
	return size;
    }

    public TreeNode getRoot() {
	return root;
    }

    public List<TreeNode<E>> path(E e) {
	List<TreeNode<E>> list = new ArrayList<TreeNode<E>>();
	TreeNode<E> current = root;
	while (current != null) {
	    list.add(current);
	    if (e.compareTo(current.element) < 0) {
		current = current.left;
	    } else if (e.compareTo(current.element) > 0) {
		current = current.right;
	    } else
		break;
	}
	return list;
    }

    public boolean delete(E e) {
	// TODO Auto-generated method stub
	TreeNode<E> parent = null;
	TreeNode<E> current = root;
	while (current != null) {
	    if (e.compareTo(current.element) < 0) {
		parent = current;
		current = current.left;
	    } else if (e.compareTo(current.element) > 0) {
		parent = current;
		current = current.right;
	    } else
		break;
	}
	if (current == null) {
	    return false;
	}
	if (current.left == null) {
	    if (parent == null) {
		root = current.right;
	    } else {
		if (e.compareTo(parent.element) < 0) {
		    parent.left = current.right;
		} else
		    parent.right = current.right;

	    }

	}// current node has left child
	else {
	    TreeNode<E> parentOfRightMost = current;
	    TreeNode<E> rightMost = current.left;
	    while (rightMost.right != null) {
		parentOfRightMost = rightMost;
		rightMost = rightMost.right;
	    }
	    current.element = rightMost.element;
	    if (parentOfRightMost.right == rightMost) {
		parentOfRightMost.right = rightMost.left;
	    } else {
		parentOfRightMost.left = rightMost.left;
	    }
	}
	size--;
	return true;
    }

    public Iterator iterator() {
	return inorderIterator();
    }

    private Iterator inorderIterator() {
	// TODO Auto-generated method stub
	return new InorderIterator();
    }

    class InorderIterator implements Iterator {
	private List<E> list = new ArrayList<E>();
	private int current = 0;

	public InorderIterator() {
	    inorder();
	}

	public void inorder() {
	    inorder(root);
	}

	private void inorder(TreeNode<E> root) {
	    // TODO Auto-generated method stub
	    if (root == null) {
		return;
	    }
	    inorder(root.left);
	    list.add(root.element);
	    inorder(root.right);
	}

	public boolean hasNext() {
	    // TODO Auto-generated method stub
	    if (current < list.size()) {
		return true;
	    }
	    return false;
	}

	@Override
	public Object next() {
	    // TODO Auto-generated method stub
	    return list.get(current++);
	}

	@Override
	public void remove() {
	    // TODO Auto-generated method stub
	    delete(list.get(current));
	    list.clear();
	    inorder();
	}

    }

    public void clear() {
	root = null;
	size = 0;
    }
}
