package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import tree.AddAndSearchWord.WordDictionary;
import linkedlist.ListNode;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
	TreeNode root = new TreeNode(0);
	root.left = new TreeNode(1);
	root.right = new TreeNode(1);
	new PathSumII().new Solution().pathSum(root, 1);
    }

 
}
