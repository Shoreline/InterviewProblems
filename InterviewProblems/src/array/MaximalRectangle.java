package array;

public class MaximalRectangle {
    /**
     * Maximal Rectangle
     * 
     * Given a 2D binary matrix filled with 0's and 1's, find the largest
     * rectangle containing all ones and return its area.
     */

    /*
     * rectangle! not square
     * 
     * 1) DP。用f[i][j]来记录i行以j列为结尾，往前连续的1的个数。然后再一个O(n^3)的循环来找以(i,
     * j)为右下角的矩形最大的1的面积。
     * 
     * 2)
     * O(n^2)的算法，可以把问题看成求多个直方图的最大矩形面积，这样就可以从上往下来做例如第i层就是0~i的直方图，第i+1就是0~i+1的直方图，
     * 这样求直方图的复杂度O(n)，于是就有O(n^2)
     */

    /*
     * The following method does not work!
     * 
     * Since it cannot deal with cases like below:
     * 
     * 1 1
     * 
     * 1 0
     * 
     * It will return 2, which is wrong.
     */
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}

		int[][] dp = new int[matrix.length][matrix[0].length];
		int[][] dp2 = new int[matrix.length][matrix[0].length];

		int max = 0;

		// initial condition set up
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][matrix[0].length - 1] == '1') {
				dp[i][matrix[0].length - 1] = 1;
				max = 1;
			} else {
				dp[i][matrix[0].length - 1] = 0;
			}
		}

		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[matrix.length - 1][i] == '1') {
				dp2[matrix.length - 1][i] = 1;
				max = 1;
			} else {
				dp2[matrix.length - 1][i] = 0;
			}
		}

		// start filling dp matrix
		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[0].length - 2; j >= 0; j--) {
				if (matrix[i][j] == '0') {
					dp[i][j] = 0;
				} else {
					dp[i][j] = 1 + dp[i][j + 1];
				}
			}
		}

		for (int i = matrix.length - 2; i >= 0; i--) {
			for (int j = matrix[0].length - 1; j >= 0; j--) {
				if (matrix[i][j] == '0') {
					dp2[i][j] = 0;
				} else {
					dp2[i][j] = 1 + dp2[i + 1][j];
				}
			}
		}

		// compute maximum rectangle area
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				max = Math.max(max, dp[i][j] * dp2[i][j]);
			}
		}

		return max;
	}
}
