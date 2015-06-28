package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Sum Root to Leaf Numbers
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 * 1 / \ 2 3
 * 
 * The root-to-leaf path 1->2 represents the number 12. The root-to-leaf path
 * 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 *
 */

/*
 * Corner case: root.val == 0. Ex: root to leaf is 01234, then result is 1234.
 * 
 * To handle it, adding digits in List<Intger> num from back
 */
public class SumRootToLeafNumbers {
    /*
     * DFS
     */
    public class Solution {
	int res = 0;

	public int sumNumbers(TreeNode root) {
	    if (root == null) {
		return 0;
	    }

	    dfs(root, new ArrayList<Integer>());

	    return res;
	}

	private void dfs(TreeNode root, List<Integer> num) {
	    num.add(root.val);

	    if (root.left == null && root.right == null) {
		for (int i = num.size() - 1; i >= 0; i--) {
		    res += num.get(i) * Math.pow(10, (num.size() - i - 1));
		}
		return;
	    }

	    if (root.left != null) {
		dfs(root.left, num);
		num.remove(num.size() - 1);
	    }
	    if (root.right != null) {
		dfs(root.right, num);
		num.remove(num.size() - 1);
	    }
	}
    }
}
