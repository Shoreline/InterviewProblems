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
     * �����ռ�Ļ�����һ���Կ����ǲ��ǹ̶������ļ��������ܸ㶨��������Կ����ǲ������Ȿ���Ѿ��ṩ���㹻�Ŀռ䡣
     * ��������ں��ߣ��������þ���ĵ�һ�к͵�һ������Ϊ�����ռ�ʹ�á����ÿ����µĴ洢�ռ䡣�������ǣ� 1.��ȷ����һ�к͵�һ���Ƿ���Ҫ����
     * 2.ɨ��ʣ�µľ���Ԫ�أ����������0���ͽ���Ӧ�ĵ�һ�к͵�һ���ϵ�Ԫ�ظ�ֵΪ0
     * 3.���ݵ�һ�к͵�һ�е���Ϣ���Ѿ����Խ�ʣ�µľ���Ԫ�ظ�ֵΪ��������ֵ�� 4.����1��ȷ����״̬�������һ�к͵�һ�С�
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
