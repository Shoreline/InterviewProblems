package array;

import java.util.Arrays;
import java.util.Stack;

/**
 * Maximal Rectangle
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing all ones and return its area.
 */

public class MaximalRectangle {
    /*
     * Space: O(N); time: O(M*N)
     */
    public class Solution {
	public int maximalRectangle(char[][] matrix) {
	    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
		return 0;
	    }

	    int max = 0;
	    int[] height = new int[matrix[0].length];
	    for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[0].length; j++) {
		    if (matrix[i][j] == '1') {
			height[j]++;
		    } else {
			height[j] = 0;
		    }
		}

		max = Math.max(max, getLargestRectangleInHistogram(height));
	    }

	    return max;
	}

	private int getLargestRectangleInHistogram(int[] height) {
	    Stack<Integer> stack = new Stack<Integer>();
	    int max = 0;

	    int[] heightExt = new int[height.length + 1];
	    heightExt = Arrays.copyOf(height, height.length + 1);
	    for (int i = 0; i < heightExt.length; i++) {
		if (stack.isEmpty() || heightExt[stack.peek()] <= heightExt[i]) {
		    stack.push(i);
		} else {
		    int index = stack.pop(); // previous element, also = i-1
		    int h = heightExt[index];
		    // int l = index -(stack.isEmpty()?-1:stack.peek());
		    int l = (stack.isEmpty() ? i : i - stack.peek() - 1);
		    max = Math.max(max, h * l);

		    i--; // great thought, avoid adding additional loop
		}

	    }

	    return max;
	}
    }
}
