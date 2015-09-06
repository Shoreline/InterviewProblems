package array;

import java.util.*;

/**
 * 
 * Summary Ranges
 * 
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 * 
 */
public class SummaryRanges {
    public class Solution {
	public List<String> summaryRanges(int[] nums) {
	    List<String> res = new ArrayList<>();
	    if (nums == null || nums.length == 0) {
		return res;
	    }
	    int start = nums[0];
	    for (int i = 1; i <= nums.length; i++) {
		if (i == nums.length || nums[i] != nums[i - 1] + 1) {
		    StringBuilder range = new StringBuilder();
		    range.append(start);
		    if (start < nums[i - 1]) {
			range.append("->" + nums[i - 1]);
		    }
		    res.add(range.toString());

		    if (i < nums.length)
			start = nums[i];
		}
	    }

	    return res;
	}
    }
}
