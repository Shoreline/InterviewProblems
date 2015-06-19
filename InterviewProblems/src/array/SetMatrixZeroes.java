package array;

/**
 * Set Matrix Zeroes
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * Follow up: Did you use extra space? A straight forward solution using O(mn)
 * space is probably a bad idea. A simple improvement uses O(m + n) space, but
 * still not the best solution. Could you devise a constant space solution?
 */

public class SetMatrixZeroes {
    /*
     * constant space: 6 scans
     * 
     * use the first row and first column of input matrix as cache to save
     * whether we shall clean a col/row.
     * 
     * Whether to clean the first row/column themselves are saved into two
     * variables.
     */
    public class Solution {
	public void setZeroes(int[][] matrix) {
	    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
		return;
	    }

	    boolean firstRow = false;
	    boolean firstCol = false;

	    for (int i = 0; i < matrix.length; i++) {
		if (matrix[i][0] == 0) {
		    firstCol = true;
		    break;
		}
	    }

	    for (int j = 0; j < matrix[0].length; j++) {
		if (matrix[0][j] == 0) {
		    firstRow = true;
		    break;
		}
	    }

	    for (int i = 1; i < matrix.length; i++) {
		for (int j = 1; j < matrix[0].length; j++) {

		    if (matrix[i][j] == 0) {
			matrix[i][0] = 0;
			matrix[0][j] = 0;
		    }

		}
	    }

	    for (int i = 1; i < matrix.length; i++) {
		for (int j = 1; j < matrix[0].length; j++) {
		    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
			matrix[i][j] = 0;
		    }
		}
	    }

	    if (firstRow) {
		for (int j = 0; j < matrix[0].length; j++) {
		    matrix[0][j] = 0;
		}
	    }
	    if (firstCol) {
		for (int i = 0; i < matrix.length; i++) {
		    matrix[i][0] = 0;
		}
	    }

	}
    }

    /*
     * Uses O(m+n) space
     */
    class Solution_extraSpace {
	public void setZeroes(int[][] matrix) {
	    if (matrix == null || matrix.length == 0) {
		return;
	    }
	    boolean[] row = new boolean[matrix.length];
	    boolean[] column = new boolean[matrix[0].length];

	    for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[0].length; j++) {
		    if (matrix[i][j] == 0) {
			row[i] = true;
			column[j] = true;
		    }
		}
	    }

	    for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[0].length; j++) {
		    if (row[i] || column[j]) {
			matrix[i][j] = 0;
		    }
		}
	    }
	}

    }
}
