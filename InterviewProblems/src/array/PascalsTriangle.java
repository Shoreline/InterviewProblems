package array;

import java.util.ArrayList;

public class PascalsTriangle {
    /**
     * Pascal's Triangle
     * 
     * Given numRows, generate the first numRows of Pascal's triangle.
     * 
     * For example, given numRows = 5, Return
     * 
     * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
     */

    /*
     * second time pass
     */
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	if (numRows <= 0)
	    return result;

	ArrayList<Integer> firstRow = new ArrayList<Integer>();
	firstRow.add(1);
	result.add(firstRow);

	for (int i = 2; i <= numRows; i++) {
	    ArrayList<Integer> aRow = new ArrayList<Integer>();
	    aRow.add(1);
	    int pre = 1;

	    // be aware! j starts from the second element, ends with the last
	    // element (including the last element)
	    for (int j = 1; j < result.get(result.size() - 1).size(); j++) {
		int cur = result.get(result.size() - 1).get(j);
		aRow.add(pre + cur);
		pre = cur;
	    }
	    aRow.add(1);
	    result.add(aRow);
	}

	return result;
    }
}
