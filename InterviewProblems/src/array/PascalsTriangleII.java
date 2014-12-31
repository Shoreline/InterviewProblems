package array;

import java.util.ArrayList;

public class PascalsTriangleII {
    /**
     * Pascal's Triangle II
     * 
     * Given an index k, return the kth row of the Pascal's triangle.
     * 
     * For example, given k = 3, Return [1,3,3,1].
     * 
     * Note: Could you optimize your algorithm to use only O(k) extra space?
     */
    /*
     * second time pass
     * 
     * Used similar way to Triangle to save space
     */
    public ArrayList<Integer> getRow(int rowIndex) {
	ArrayList<Integer> result = new ArrayList<Integer>();
	if (rowIndex < 0)
	    return result;

	int[] temp = new int[rowIndex + 1];

	temp[0] = 1;
	for (int i = 1; i < temp.length; i++) {
	    for (int j = i; j >= 0; j--) {
		if (j == i || j == 0) {
		    temp[j] = 1;
		} else {
		    temp[j] = temp[j] + temp[j - 1];
		}
	    }
	}

	for (int i = 0; i < temp.length; i++) {
	    result.add(temp[i]);
	}

	return result;
    }
}
