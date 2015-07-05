package array;

import java.util.Arrays;
import java.util.Stack;

/**
 * Maximal Rectangle
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing all ones and return its area.
 */

/*
 * Take advantage of getLargestRectangleInHistogram().
 */
public class MaximalRectangle {
    /*
     * Space: O(N); time: O(M*N)
     */
    public class Solution {
	public int maximalRectangle(char[][] matrix) {
	    if (matrix == null | matrix.length == 0 || matrix[0].length == 0) {
		return 0;
	    }

	    int max = 0;
	    int[] histogram = new int[matrix[0].length];
	    for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[0].length; j++) {
		    histogram[j] = matrix[i][j] == '0' ? 0 : 1 + histogram[j];
		}
		max = Math.max(max, getLargestRectangleInHistogram(histogram));
	    }

	    return max;
	}

	private int getLargestRectangleInHistogram(int[] height) {
	    int[] tmp = new int[height.length + 1];
	    tmp = Arrays.copyOf(height, height.length + 1);
	    height = tmp;

	    int max = 0;
	    Stack<Integer> stack = new Stack<>();
	    for (int i = 0; i < height.length; i++) {
		if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
		    stack.push(i);
		} else {
		    while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
			int h = height[stack.pop()];
			int l = stack.isEmpty() ? 0 : stack.peek() + 1;
			max = Math.max(max, h * (i - l));
		    }
		    stack.push(i);
		}
	    }

	    return max;
	}
    }
}
