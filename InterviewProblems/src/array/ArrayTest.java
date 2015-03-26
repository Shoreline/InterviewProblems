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
	new ArrayTest().new Solution().jump(new int[] { 1, 2, 3 });
    }

    public class Solution {
	public int jump(int[] A) {
	    if (A == null || A.length < 1) {
		return -1;
	    } else if (A.length == 1) {
		return 0; // corner case
	    } else if (A[0] >= A.length - 1) {
		return 1;
	    }

	    int jumps = 1; // at least one jump
	    int curRange = 0;
	    int nextRange = 0;

	    for (int i = 0; i < A.length && i <= curRange; i++) {

		for (int j = i; j <= curRange; j++) {
		    nextRange = Math.max(j + A[j], nextRange);
		    if (nextRange >= A.length - 1) {
			return jumps + 1;
		    }
		}

		if (nextRange <= curRange) {
		    return -1;
		}

		i = curRange;
		curRange = nextRange;
		jumps++;
	    }

	    return -1;
	}
    }
}
