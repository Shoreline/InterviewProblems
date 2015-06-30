package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Consecutive Sequence
 * 
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {
    /*
     * To get O(N) time complexity, have to trade with space
     * 
     * The idea is to save every numbers in a Set and then for each number in
     * array see how many consecutive numbers in the Set
     * 
     * *Need to remove checked elements in Set, otherwise O(N^2)
     */
    public class Solution {
	public int longestConsecutive(int[] nums) {
	    if (nums == null) {
		return 0;
	    }

	    Set<Integer> set = new HashSet<>();
	    for (int n : nums) {
		set.add(n);
	    }

	    int maxLen = 0;

	    for (int i = 0; i < nums.length; i++) {
		if (set.contains(nums[i])) {
		    int len = 1;
		    int k = nums[i] - 1;
		    while (set.contains(k)) {
			len++;
			set.remove(k);
			k--;
		    }
		    k = nums[i] + 1;
		    while (set.contains(k)) {
			len++;
			set.remove(k);
			k++;
		    }
		    maxLen = Math.max(maxLen, len);
		}
	    }

	    return maxLen;
	}
    }
}
