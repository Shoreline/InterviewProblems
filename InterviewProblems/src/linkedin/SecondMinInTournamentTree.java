package linkedin;

import java.util.*;

import tree.TreeNode;

/**
 * Tournament tree 的定义是parent 是孩子node的最小值， 如下例 return 5
 * 
 * 
               2
              /  \
            2     7
          /  \    | \
        5     2   8  7
 * 
 */
public class SecondMinInTournamentTree {
    class Method {
	public Integer getSecMin(TreeNode root) {
	    if (root == null) {
		return null;
	    } else if (root.left == null || root.right == null) {
		return getSecMin(root.left != null ? root.left : root.right);
	    }

	    List<Integer> min = new ArrayList<Integer>();
	    List<Integer> secMin = new ArrayList<Integer>();

	    min.add(root.val);
	    secMin.add(Math.max(root.left.val, root.right.val));
	    helper(root, secMin, min);
	    return secMin.get(0);
	}

	private void helper(TreeNode root, List<Integer> secMin, List<Integer> min) {
	    if (root == null) {
		return;
	    }

	    if (root.val != min.get(0)) {
		secMin.set(0, Math.min(root.val, secMin.get(0)));
	    }

	    int cur = secMin.get(0);

	    if (root.left != null && root.left.val < cur) {
		helper(root.left, secMin, min);
	    }

	    if (root.right != null && root.right.val < cur) {
		helper(root.right, secMin, min);
	    }
	}
    }

    public static void main(String[] args) {
	TreeNode root = new TreeNode(2);
	root.left = new TreeNode(2);
	root.right = new TreeNode(7);
	root.left.left = new TreeNode(5);
	root.left.right = new TreeNode(2);
	root.right.left = new TreeNode(8);
	root.right.right = new TreeNode(7);
	System.out.println(new SecondMinInTournamentTree().new Method().getSecMin(root));
    }
}
