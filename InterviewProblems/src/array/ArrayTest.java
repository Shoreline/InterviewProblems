package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import array.NextPermutation.Solution;

public class ArrayTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
	new ArrayTest().new Solution().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

    public class Solution {
	public void rotate(int[][] matrix) {
	    if (matrix == null || matrix[0] == null) {
		return;
	    }

	    int n = matrix.length;
	    int tmp = 0;
	    // if n is odd, no need to care the center block
	    for (int k = 0; k < n / 2; k++) {
		for (int i = k; i < n - 1 - k * 2; i++) {
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
}
