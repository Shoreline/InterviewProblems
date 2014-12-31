package array;

public class SpiralMatrix2 {
    /**
     * Given an integer n, generate a square matrix filled with elements from 1
     * to n2 in spiral order.
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

    public static int[][] generateMatrix(int n) {
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
