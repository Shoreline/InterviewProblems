package tree;

/**
 * Verify Preorder Sequence in Binary Search Tree
 * 
 * Given an array of numbers, verify whether it is the correct preorder
 * traversal sequence of a binary search tree.
 * 
 * You may assume each number in the sequence is unique.
 * 
 * Follow up: Could you do it using only constant space complexity?
 *
 */
public class VerifyPreorderSequenceInBinarySearchTree {
    /*
     * My original thought.
     * 
     * Sometimes AC (1856ms), but sometimes TLE
     * 
     * The drawback is that in this way you have to go to the leaf level to find
     * out if a leaf node has illegal value
     */
    public class Solution {
	public boolean verifyPreorder(int[] preorder) {
	    return checkRange(preorder, 0, preorder.length - 1, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	private boolean checkRange(int[] preorder, int start, int end, int max, int min) {
	    if (start > end) {
		return true;
	    }

	    int rootVal = preorder[start];

	    if (rootVal > max || rootVal < min) {
		return false;
	    }
	    if (start == end) {
		return true;
	    }

	    int low = start + 1;
	    int high = end;
	    while (low < high) {
		int mid = low + (high - low) / 2;
		if (preorder[mid] <= rootVal) {
		    low = low + 1;
		} else {
		    high = high - 1;
		}
	    }

	    // split is the starting index of right sub tree.
	    int split = preorder[low] > rootVal ? low : low + 1;

	    return checkRange(preorder, start + 1, split - 1, rootVal - 1, min)
		    && checkRange(preorder, split, end, max, rootVal + 1);

	}
    }

    /*
     * faster
     */
    public class Solution2 {
	public boolean verifyPreorder(int[] preorder) {
	    return verifyPreorder(preorder, 0, preorder.length);
	}

	public boolean verifyPreorder(int[] seq, int start, int end) {
	    if (start + 1 >= end) {
		return true;
	    }

	    int root = seq[start];

	    int i = start + 1;
	    while (i < end && seq[i] < root) {
		i++;
	    }

	    if (i < end) {
		int j = i;
		while (j < end && seq[j] > root) {
		    j++;
		}
		if (j < end) {
		    return false;
		}

		return verifyPreorder(seq, start + 1, i) && verifyPreorder(seq, i, end);
	    } else {
		return verifyPreorder(seq, start + 1, end);
	    }
	}

    }
}
