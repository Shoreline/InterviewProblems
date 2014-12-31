package array;

public class SearchA2DMatrix {
    /**
     * Search a 2D Matrix
     * 
     * Write an efficient algorithm that searches for a value in an m x n
     * matrix.
     * 
     * This matrix has the following properties:
     * 
     * Integers in each row are sorted from left to right. The first integer of
     * each row is greater than the last integer of the previous row. For
     * example,
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
     * My thought: two steps of binary search. The way of handling
     * (matrix[mid][0] < target) makes that if the target is not found in the
     * first loop, it may be in row mid or row mid-1
     * 
     * There is a smarter way: treat the whole matrix as a 1D array:
     * mid=(start+end)/2, midX=mid/matrix[0].length, midY=mid%matrix[0].length;
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
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
		 * even if (matrix[mid][0] < target), the target may still in
		 * row mid
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
	 * target maybe in row mid or row mid-1, or nowhere. See how we move i
	 * when (matrix[mid][0] < target) in the fist while loop
	 */
	int row = mid;
	if (matrix[mid][0] > target && row > 0 && matrix[row - 1][0] < target)
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
