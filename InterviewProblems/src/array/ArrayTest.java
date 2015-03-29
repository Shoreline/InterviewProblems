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
	new ArrayTest().new Solution().spiralOrder(new int[][] { { 6, 9, 7 } });
    }

    public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
	    List<Integer> res = new ArrayList<Integer>();
	    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
		return res;
	    }

	    int top = 0;
	    int bottom = matrix.length - 1;
	    int left = 0;
	    int right = matrix[0].length - 1;

	    /*
	     * Unlike rotate image problem, here must take care the cases of
	     * top==bottom or left==right
	     * 
	     * For rotating image, top and bottom will never be equal, same for
	     * left and right
	     */
	    while (top <= bottom && left <= right) {
		for (int i = left; i <= right; i++) {
		    res.add(matrix[top][i]);
		}

		for (int i = top + 1; i < bottom; i++) {
		    res.add(matrix[i][right]);
		}

		if (top != bottom) {
		    for (int i = right; i > left; i--) {
			res.add(matrix[bottom][i]);
		    }
		}

		if (left != right) {
		    for (int i = bottom; i > top; i--) {
			res.add(matrix[i][left]);
		    }
		}
		top++;
		bottom--;
		left++;
		right--;
	    }

	    // if(top == bottom && left == right){
	    // res.add(matrix[top][left]);
	    // }

	    return res;
	}
    }
}
