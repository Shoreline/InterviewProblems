package array;

public class SetMatrixZeroes {
    /**
     * Set Matrix Zeroes
     * 
     * Given a m x n matrix, if an element is 0, set its entire row and column
     * to 0. Do it in place.
     * 
     * Follow up: Did you use extra space? A straight forward solution using
     * O(mn) space is probably a bad idea. A simple improvement uses O(m + n)
     * space, but still not the best solution. Could you devise a constant space
     * solution?
     */
    /*
     * constant space:
     * 
     * use the a row and a column of input matrix to substitute boolean[] row
     * and boolean[] column
     * 
     * 常数空间的话，第一可以考虑是不是固定数量的几个变量能搞定；否则可以考虑是不是问题本身已经提供了足够的空间。
     * 这道题属于后者，就是利用矩阵的第一行和第一列来作为辅助空间使用。不用开辟新的存储空间。方法就是： 1.先确定第一行和第一列是否需要清零
     * 2.扫描剩下的矩阵元素，如果遇到了0，就将对应的第一行和第一列上的元素赋值为0
     * 3.根据第一行和第一列的信息，已经可以讲剩下的矩阵元素赋值为结果所需的值了 4.根据1中确定的状态，处理第一行和第一列。
     */

    public void setZeroes(int[][] matrix) {
	if (matrix == null && matrix.length == 0) {
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
