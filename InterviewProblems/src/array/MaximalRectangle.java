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
     * 1) DP����f[i][j]����¼i����j��Ϊ��β����ǰ�����1�ĸ���Ȼ����һ��O(n^3)��ѭ��������(i,
     * j)Ϊ���½ǵľ�������1�����
     * 
     * 2)
     * O(n^2)���㷨�����԰����⿴������ֱ��ͼ���������������Ϳ��Դ����������������i�����0~i��ֱ��ͼ����i+1����0~i+1��ֱ��ͼ��
     * ������ֱ��ͼ�ĸ��Ӷ�O(n)�����Ǿ���O(n^2)
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
