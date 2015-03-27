package array;

public class RotateImage {
    /**
     * Rotate Image
     * 
     * You are given an n x n 2D matrix representing an image.
     * 
     * Rotate the image by 90 degrees (clockwise).
     * 
     * Follow up: Could you do this in-place?
     */

    class Solution_inPlace {
	public void rotate(int[][] matrix) {
	    if (matrix == null || matrix[0] == null) {
		return;
	    }

	    int n = matrix.length;
	    int tmp = 0;
	    // if n is odd, no need to care the center block
	    for (int k = 0; k < n / 2; k++) {
		for (int i = k; i < k + n - 1 - 2 * k; i++) {
		    tmp = matrix[k][i];
		    matrix[k][i] = matrix[i][n - 1 - k];
		    matrix[i][n - 1 - k] = tmp;

		    tmp = matrix[k][i];
		    matrix[k][i] = matrix[n - 1 - k][n - 1 - i];
		    matrix[n - 1 - k][n - 1 - i] = tmp;

		    tmp = matrix[k][i];
		    matrix[k][i] = matrix[n - 1 - i][k];
		    matrix[n - 1 - i][k] = tmp;
		}

	    }
	}
    }

    /*
     * finish with minor errors. fixed pretty soon
     * 
     * My thoughts: lots of detail, similar to spiral matrix
     * 
     * need O(N) additional space
     */
    class Solution_1 {
	public void rotate(int[][] matrix) {
	    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
		return;

	    rotateHelp(matrix, 0);

	}

	private void rotateHelp(int[][] matrix, int m) {

	    int length = matrix.length - m * 2;
	    if (length < 2)
		return;

	    int[] temp = new int[length - 1];

	    for (int i = 0; i < length - 1; i++) {
		temp[i] = matrix[m][m + i];
		matrix[m][m + i] = matrix[matrix.length - 1 - m - i][m];
	    }

	    for (int i = 0; i < length - 1; i++) {
		matrix[matrix.length - 1 - m - i][m] = matrix[matrix.length - 1
			- m][matrix.length - 1 - m - i];
	    }

	    for (int i = 0; i < length - 1; i++) {
		matrix[matrix.length - 1 - m][matrix.length - 1 - m - i] = matrix[m
			+ i][matrix.length - 1 - m];
	    }

	    for (int i = 0; i < length - 1; i++) {
		matrix[m + i][matrix.length - 1 - m] = temp[i];
	    }

	    rotateHelp(matrix, m + 1);
	}
    }
}
