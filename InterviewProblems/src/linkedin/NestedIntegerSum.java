package linkedin;

import java.util.List;

public class NestedIntegerSum {
    class Solution {
	public int getSum(NestedInteger ni) {
	    if (ni.isInteger())
		return ni.getInteger();
	    else
		return getListSum(ni.getList(), 1);
	}

	private int getListSum(List<NestedInteger> niList, int depth) {
	    int res = 0;
	    // NestedInteger ni = null;
	    for (NestedInteger ni : niList) {
		if (ni.isInteger())
		    res += ni.getInteger() * depth;
		else
		    res += getListSum(ni.getList(), depth + 1);
	    }
	    return res;
	}
    }
}
