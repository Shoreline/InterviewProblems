package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import linkedlist.ListNode;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
	TreeNode root = new TreeNode(1);
	root.left = new TreeNode(2);
	System.out.println(new VerifyPreorderSequenceInBinarySearchTree().new Solution().verifyPreorder(new int[]{1,2}));
    }

 
}
