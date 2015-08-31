package array;

import java.util.TreeSet;

/**
 * Contains Duplicates III
 * 
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the difference between nums[i] and nums[j] is at
 * most t and the difference between i and j is at most k.
 */

/*
 * A special sliding window implemented by a TreeSet
 * 
 * TreeSet.subSet(i,j): i inclusive and j exclusive.
 * 
 * Must use Long otherwise cannot pass corner case that t= Integer.MAX_VAUE
 */
public class ContainsDuplicatesIII {
    public class Solution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	    if (nums == null || nums.length < 2 || k < 1 || t < 0) {
		return false;
	    }

	    TreeSet<Long> window = new TreeSet<>();
	    for (int i = 0; i < nums.length; i++) {
		if (window.subSet((long) nums[i] - t, (long) nums[i] + t + 1).size() > 0) {
		    return true;
		}
		if (i >= k) {
		    // remove by value, not index
		    window.remove((long) nums[i - k]);
		}
		window.add((long) nums[i]);
	    }

	    return false;
	}
    }

    /*
     * won't work for cases like: window={0, 100}, k = 10; and nums[i]= 50
     */
    public class WrongMethod {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	    if (nums == null || nums.length < 2 || k < 1 || t < 0) {
		return false;
	    }

	    TreeSet<Long> window = new TreeSet<>();
	    for (int i = 0; i < nums.length; i++) {
		if (!window.isEmpty() && nums[i] <= window.last() + t && nums[i] >= window.first() - t) {
		    return true;
		}
		if (i >= k) {
		    window.remove((long) nums[i - k]);
		}
		window.add((long) nums[i]);
	    }
	    return false;
	}
    }

}
