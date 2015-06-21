package array;

/**
 * Search a 2D Matrix
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * 
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row. For example,
 * 
 * Consider the following matrix:
 * 
 * [
 * 
 * [1, 3, 5, 7],
 * 
 * [10, 11, 16, 20],
 * 
 * [23, 30, 34, 50]
 * 
 * ]
 */

/*
 * The matrix in this question is different from Yang's matrix
 * 
 * Two solutions: 1. treat matrix as a 1D array and use classical BS; 2. Two
 * rounds of BS
 * 
 * related: search insert position?
 */

public class SearchA2DMatrix {
    public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
	    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
		return false;
	    }
	    int low = 0;
	    int high = matrix.length * matrix[0].length - 1;
	    while (low <= high) {
		int mid = (low + high) / 2;
		int i = mid / matrix[0].length;
		int j = mid % matrix[0].length;
		if (matrix[i][j] == target) {
		    return true;
		} else if (matrix[i][j] < target) {
		    low = mid + 1;
		} else {
		    high = mid - 1;
		}
	    }

	    return false;
	}
    }

    /*
     * Two rounds of binary search. The way of handling (matrix[mid][0] <
     * target) makes that if the target is not found in the first loop, it may
     * be in row mid or row mid-1
     * 
     * While looking for the targetRow, if target> matrix[mid][0], then target
     * may be in row mid.
     * 
     * However we still let low = mid +1, which will just miss the actual target
     * row in future search range. It is OK since after this round, low will
     * never be increased, and eventually the while loop exits when high=low-1,
     * in which case high becomes the target row.
     */
    public class Solution_2searches {
	public boolean searchMatrix(int[][] matrix, int target) {
	    if (matrix == null || matrix.length == 0 || matrix[0].length == 0
		    || target < matrix[0][0]) {
		return false;
	    }

	    int low = 0;
	    int high = matrix.length - 1;

	    while (low <= high) {
		int mid = (low + high) / 2;
		if (matrix[mid][0] == target) {
		    return true;
		} else if (target < matrix[mid][0]) {
		    high = mid - 1;
		} else {
		    low = mid + 1;
		}
	    }
	    int targetRow = high; // important!

	    low = 0;
	    high = matrix[0].length - 1;
	    while (low <= high) {
		int mid = (low + high) / 2;
		if (matrix[targetRow][mid] == target) {
		    return true;
		} else if (target < matrix[targetRow][mid]) {
		    high = mid - 1;
		} else {
		    low = mid + 1;
		}
	    }

	    return false;
	}
    }

    class Solution_2013 {
	public boolean searchMatrix(int[][] matrix, int target) {
	    if (matrix == null || matrix.length == 0)
		return false;

	    int m = matrix.length;
	    int n = matrix[0].length;

	    int i = 0;
	    int j = m - 1;
	    int mid = 0;

	    // the exit condition is i<=j, not i<j !!!
	    while (i <= j) {
		// remember how to get mid!!!!
		mid = i + (j - i) / 2;

		if (matrix[mid][0] == target) {
		    return true;
		} else if (matrix[mid][0] < target) {
		    /*
		     * even if (matrix[mid][0] < target), the target may still
		     * in row mid
		     * 
		     * be careful of which pointer shall be moved
		     */
		    i = mid + 1;
		} else {
		    j = mid - 1;
		}
	    }

	    /*
	     * Important: determine where the target locates
	     * 
	     * it could be between (A[mid], A[mid+1]), or (A[mid-1], A[mid]) ->
	     * target maybe in row mid or row mid-1, or nowhere. See how we move
	     * i when (matrix[mid][0] < target) in the fist while loop
	     */
	    int row = mid;
	    if (matrix[mid][0] > target && row > 0
		    && matrix[row - 1][0] < target)
		row--;

	    i = 0;
	    j = n - 1;
	    int mid2 = 0;
	    while (i <= j) {
		mid2 = i + (j - i) / 2;
		if (matrix[row][mid2] == target) {
		    return true;
		} else if (matrix[row][mid2] < target) {
		    i = mid2 + 1;
		} else {
		    j = mid2 - 1;
		}
	    }

	    return false;
	}
    }
}
