package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    /**
     * Given a matrix of m x n elements (m rows, n columns), return all elements
     * of the matrix in spiral order.
     * 
     * For example, Given the following matrix:
     * 
     * [
     * 
     * [ 1, 2, 3 ],
     * 
     * [ 4, 5, 6 ],
     * 
     * [ 7, 8, 9 ]
     * 
     * ]
     * 
     * You should return [1,2,3,6,9,8,7,4,5].
     */
    /*
     * use top, bottom, left, right to greatly simplify coding complexity
     */
    public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
	    List<Integer> res = new ArrayList<Integer>();
	    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
		return res;
	    }

	    int top = 0;
	    int bottom = matrix.length - 1;
	    int left = 0;
	    int right = matrix[0].length - 1;

	    /*
	     * Unlike rotate image problem, here must take care the cases of
	     * top==bottom or left==right
	     * 
	     * (For rotating image, top and bottom will never be equal, same for
	     * left and right)
	     */
	    while (top <= bottom && left <= right) {
		for (int i = left; i <= right; i++) {
		    res.add(matrix[top][i]);
		}

		for (int i = top + 1; i < bottom; i++) {
		    res.add(matrix[i][right]);
		}

		if (top != bottom) {
		    for (int i = right; i >= left; i--) {
			res.add(matrix[bottom][i]);
		    }
		}

		if (left != right) {
		    for (int i = bottom - 1; i > top; i--) {
			res.add(matrix[i][left]);
		    }
		}
		top++;
		bottom--;
		left++;
		right--;
	    }

	    return res;
	}
    }

    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
	ArrayList<Integer> result = new ArrayList<Integer>();

	/*
	 * Important! compiler difference?
	 * 
	 * without the following cannot be run in leetcode.com
	 * 
	 * with it cannot run in eclipse
	 */
	// if (matrix.length == 0) {
	// return result;
	// }
	// *******************

	result = spiralOrder(matrix, 0);

	return result;
    }

    public static ArrayList<Integer> spiralOrder(int[][] matrix, int offset) {
	ArrayList<Integer> result = new ArrayList<Integer>();

	if (matrix == null) {
	    return result;
	}

	/*
	 * offset,m and offset,n are new boundaries.
	 * 
	 * The key is to treat inner matrix defined by these boundaries as a
	 * regular matrix (0,0,m,n). So we can get rid of the buzz of offset
	 */
	int m = matrix.length - offset;
	int n = matrix[0].length - offset;

	if (m - offset == 0 || n - offset == 0) {
	    return result;
	}

	if (m - offset == 1) {
	    for (int i = offset; i < n; i++) {
		result.add(matrix[offset][i]);
	    }
	    return result;
	}
	if (n - offset == 1) {
	    for (int i = offset; i < m; i++) {
		result.add(matrix[i][offset]);
	    }
	    return result;
	}

	for (int i = offset; i < n - 1; i++) {
	    result.add(matrix[offset][i]);
	}

	for (int i = offset; i < m - 1; i++) {
	    result.add(matrix[i][n - 1]);
	}

	for (int i = n - 1; i > offset; i--) {
	    result.add(matrix[m - 1][i]);
	}

	for (int i = m - 1; i > offset; i--) {
	    result.add(matrix[i][offset]);
	}
	result.addAll(spiralOrder(matrix, offset + 1));

	return result;
    }
}
