package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle II
 * 
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 */

public class PascalsTriangleII {

    /*
     * Keep appending elements to an arraylist
     */
    public class Solution {
	public List<Integer> getRow(int rowIndex) {
	    List<Integer> res = new ArrayList<Integer>();
	    if (rowIndex < 0) {
		return res;
	    }

	    res.add(1);
	    for (int i = 1; i <= rowIndex; i++) {

		int preValue = 1;
		for (int j = 1; j < res.size(); j++) {
		    int tmp = res.get(j);
		    res.set(j, preValue + res.get(j));
		    preValue = tmp;
		}
		res.add(1);
	    }

	    return res;
	}
    }

    /*
     * It is worth noticed that the result list has k+1 numbers for a given k
     * Used similar way to Triangle to save space
     */
    public class Solution_array {
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
}
