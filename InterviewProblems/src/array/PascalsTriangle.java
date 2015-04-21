package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 */

public class PascalsTriangle {

    public class Solution {
	public List<List<Integer>> generate(int numRows) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (numRows < 1) {
		return res;
	    }

	    List<Integer> row1 = new ArrayList<Integer>();
	    row1.add(1);
	    res.add(row1);

	    for (int i = 1; i < numRows; i++) {
		List<Integer> preRow = res.get(res.size() - 1);
		List<Integer> curRow = new ArrayList<Integer>();
		curRow.add(1);
		for (int j = 0; j < preRow.size() - 1; j++) {
		    curRow.add(preRow.get(j) + preRow.get(j + 1));
		}
		curRow.add(1);
		res.add(curRow);
	    }

	    return res;
	}
    }
}
