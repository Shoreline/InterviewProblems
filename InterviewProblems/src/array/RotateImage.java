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
    /*
     * finish with minor errors. fixed pretty soon
     * 
     * My thoughts: lots of detail, similar to spiral matrix
     */
    public static void rotate(int[][] matrix) {
	if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
	    return;

	rotateHelp(matrix, 0);

    }

    private static void rotateHelp(int[][] matrix, int m) {

	int length = matrix.length - m * 2;
	if (length < 2)
	    return;

	int[] temp = new int[length - 1];

	for (int i = 0; i < length - 1; i++) {
	    temp[i] = matrix[m][m + i];
	    matrix[m][m + i] = matrix[matrix.length - 1 - m - i][m];
	}

	for (int i = 0; i < length - 1; i++) {
	    matrix[matrix.length - 1 - m - i][m] = matrix[matrix.length - 1 - m][matrix.length
		    - 1 - m - i];
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
