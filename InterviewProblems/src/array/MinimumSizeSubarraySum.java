package array;

/**
 * Minimum Size Subarray Sum
 * 
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a subarray of which the sum ≥ s. If there isn't one, return
 * 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has
 * the minimal length under the problem constraint.
 * 
 * click to show more practice.
 * 
 * More practice: If you have figured out the O(n) solution, try coding another
 * solution of which the time complexity is O(n log n).
 *
 */
public class MinimumSizeSubarraySum {
    /*
     * Typical sliding window for an array with all non-negative numbers
     * 
     * O(N) time; O(1) space
     */
    public class Solution {
	public int minSubArrayLen(int s, int[] nums) {
	    if (nums == null || nums.length == 0) {
		return 0;
	    }

	    int min = nums.length + 1;

	    int i = 0;
	    int j = 0;
	    int sum = nums[0];
	    while (j < nums.length) {
		if (sum >= s) {
		    min = Math.min(min, j - i + 1);
		}

		if (sum >= s && i < j) {
		    sum -= nums[i];
		    i++;
		} else {
		    j++;
		    if (j < nums.length) {
			sum += nums[j];
		    }
		}
	    }

	    return min <= nums.length ? min : 0;
	}
    }

    public class Solution2 {
	public int minSubArrayLen(int s, int[] nums) {
	    if (nums == null || nums.length == 0) {
		return 0;
	    }

	    int min = nums.length + 1;

	    int i = 0;
	    int j = 0;
	    int sum = nums[0];
	    while (j < nums.length) {
		if (sum >= s) {
		    min = Math.min(min, j - i + 1);
		    if (j > i) {
			sum -= nums[i];
			i++;
		    } else {
			j++;
			if (j < nums.length) {
			    sum += nums[j];
			}
		    }
		} else {
		    j++;
		    if (j < nums.length) {
			sum += nums[j];
		    }
		}
	    }

	    return min <= nums.length ? min : 0;
	}
    }
}
