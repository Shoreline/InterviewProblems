package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Missing Ranges
 * 
 * Given a sorted integer array where the range of elements are [lower, upper]
 * inclusive, return its missing ranges.
 * 
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2",
 * "4->49", "51->74", "76->99"].
 *
 */
public class MissingRanges {
    /*
     * cannot just do "if(nums.length==0) return res;" at the beginning, that
     * actually means all Integers between lower and upper are missing
     */
    public class Solution {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
	    List<String> res = new ArrayList<String>();

	    int cur = lower;
	    for (int i = 0; i < nums.length; i++) {
		if (cur < nums[i]) {
		    if (cur < nums[i] - 1) {
			// "->" is a String so no need to cast other Integers
			res.add(cur + "->" + (nums[i] - 1));
		    } else {
			res.add(String.valueOf(cur));
		    }
		    cur = nums[i] + 1;
		} else if (cur == nums[i]) {
		    cur++;
		}
	    }

	    if (cur == upper) {
		res.add(String.valueOf(cur));
	    } else if (cur < upper) {
		res.add(cur + "->" + upper);
	    }

	    return res;
	}
    }
}
