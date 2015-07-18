package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains Duplicate II
 * 
 * Given an array of integers and an integer k, find out whether there there are
 * two distinct indices i and j in the array such that nums[i] = nums[j] and the
 * difference between i and j is at most k.
 *
 */
public class ContainsDuplicateII {
    public class Solution {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
	    if (nums == null) {
		return false;
	    }
	    Map<Integer, Integer> locMap = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
		Integer lastSeen = locMap.get(nums[i]);
		if (lastSeen != null && i - lastSeen <= k) {
		    return true;
		}
		locMap.put(nums[i], i);
	    }

	    return false;
	}
    }
}
