package array;

public class MaximalSumOfSubmatrix {
    /**
     * Maximal sum of submatrix
     * 
     */

    /*
     * If the matrix is m x n, the time complexity if O(m^2(n+n))= O(nmm)
     * 
     * sumHelp is the matrix that help us easily get the 1D summation array
     * between row i and j by using sumHelp[j][]-sumHelp[i][]
     */
    public int maximalSubMatrix(char[][] matrix) {
	if (matrix.length == 0) {
	    return 0;
	}

	/*
	 * let the first row of sumHelp to be all 0
	 */
	int[][] sumHelp = new int[matrix.length + 1][matrix[0].length];
	for (int i = 1; i < matrix.length + 1; i++) {
	    for (int j = 0; j < matrix[0].length; j++) {
		if (i == 0) {
		    sumHelp[i][j] = (matrix[i - 1][j] == '1' ? 1 : 0);
		} else {
		    sumHelp[i][j] = sumHelp[i - 1][j]
			    + (matrix[i - 1][j] == '1' ? 1 : 0);
		}
	    }
	}

	int max = Integer.MIN_VALUE;
	for (int i = 1; i < matrix.length + 1; i++) {
	    for (int j = 0; j < i; j++) {
		int[] temp = new int[matrix[0].length];

		for (int k = 0; k < matrix[0].length; k++) {
		    temp[k] = sumHelp[i][k] - sumHelp[j][k];
		}

		max = Math.max(max, maximalSubArray(temp));
	    }
	}

	return max;
    }

    private static int maximalSubArray(int[] A) {
	if (A == null || A.length == 0) {
	    return 0;
	}

	int max = Integer.MIN_VALUE;
	int maxElement = Integer.MIN_VALUE;
	int curSum = 0;

	for (int i = 0; i < A.length; i++) {
	    if (A[i] >= 0) {
		curSum += A[i];
		max = Math.max(max, curSum);
		maxElement = Math.max(maxElement, A[i]);
	    } else {
		int temp = 0;
		while (i < A.length && A[i] <= 0) {
		    temp += A[i];
		    maxElement = Math.max(maxElement, A[i]);
		    i++;

		}
		i--;
		if (temp + curSum > 0) {
		    curSum += temp;
		} else {
		    curSum = 0;
		}
	    }
	}

	if (maxElement <= 0) {
	    return maxElement;
	}
	return max;
    }
}
