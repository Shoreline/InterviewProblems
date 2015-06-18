package array;

/**
 * Spiral Matrix II
 * 
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n2 in spiral order.
 * 
 * For example, Given n = 3,
 * 
 * You should return the following matrix:
 * 
 * [
 * 
 * [ 1, 2, 3 ],
 * 
 * [ 8, 9, 4 ],
 * 
 * [ 7, 6, 5 ]
 * 
 * ]
 */

/*
 * similar to Spiral Matrix I, the key is how to traverse a 2D array by spiral
 * order
 */
public class SpiralMatrix2 {

    public class Solution {
	public int[][] generateMatrix(int n) {

	    if (n < 0) {
		return null;
	    }

	    int[][] res = new int[n][n];

	    int top = 0;
	    int bottom = n - 1;
	    int left = 0;
	    int right = n - 1;

	    int c = 1;
	    while (top <= bottom && left <= right) {
		for (int i = left; i <= right; i++) {
		    res[top][i] = c++; // concise
		}

		for (int i = top + 1; i <= bottom - 1; i++) {
		    res[i][right] = c++;
		}

		if (left != right) {
		    for (int i = right; i >= left; i--) {
			res[bottom][i] = c++;
		    }
		}

		if (top != bottom) {
		    for (int i = bottom - 1; i >= top + 1; i--) {
			res[i][left] = c++;
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

    class Solution_2 {
	public int[][] generateMatrix(int n) {
	    if (n < 0) {
		return null;
	    }

	    int[][] matrix = new int[n][n];

	    int curValue = 1;

	    // set initial values for boundaries
	    int offset = 0;
	    int p = n; // square matrix

	    while (p - offset > 1) {
		for (int i = offset; i < p - 1; i++) {
		    matrix[offset][i] = curValue;
		    curValue++;
		}

		for (int i = offset; i < p - 1; i++) {
		    matrix[i][p - 1] = curValue;
		    curValue++;
		}

		for (int i = p - 1; i > offset; i--) {
		    matrix[p - 1][i] = curValue;
		    curValue++;
		}

		for (int i = p - 1; i > offset; i--) {
		    matrix[i][offset] = curValue;
		    curValue++;
		}
		offset++;
		p--;
	    }

	    if (p - offset == 1) {
		matrix[offset][offset] = curValue;
	    }

	    return matrix;
	}
    }
}
