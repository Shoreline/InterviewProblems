package linkedin;

import java.util.List;

/*
 * Unconfirmed solution
 */
public class NestedIntegerReversedSum {
    class Solution {
	int calWeightedSum(NestedInteger ni) {
	    if (ni == null) {
		return 0;
	    } else {
		if (ni.isInteger()) {
		    return ni.getInteger();
		} else {
		    int depth = getDepth(ni.getList());
		    return getListSum(ni.getList(), depth);
		}
	    }
	}

	int getListSum(List<NestedInteger> li, int depth) {
	    int res = 0;
	    for (NestedInteger ni : li) {
		if (ni.isInteger()) {
		    res += ni.getInteger() * depth;
		} else {
		    res += getListSum(ni.getList(), depth - 1);
		}
	    }
	    return res;
	}

	int getDepth(List<NestedInteger> niList) {
	    int res = 1;
	    for (NestedInteger ni : niList) {
		if (!ni.isInteger()) {
		    res = Math.max(res, 1 + getDepth(ni.getList()));
		}
	    }
	    return res;
	}
    }
}
