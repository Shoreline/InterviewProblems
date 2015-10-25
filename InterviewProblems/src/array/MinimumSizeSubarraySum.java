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

	    int minSize = nums.length + 1;
	    int sum = 0; // summation range: [left,right]
	    int left = 0;
	    for (int right = 0; right < nums.length; right++) {
		sum += nums[right];
		while (sum >= s) {
		    minSize = Math.min(minSize, right - left + 1);
		    sum -= nums[left];
		    left++;
		}
	    }

	    return minSize == nums.length + 1 ? 0 : minSize;
	}
    }

    /*
     * Time: O(NlogN)
     * 
     * Search for window sizes
     */
    public class Solution_binary_search {
	public int minSubArrayLen(int s, int[] nums) {
	    int i = 1; // start with 1 and nums.length.
	    int j = nums.length;
	    int min = 0;
	    while (i <= j) {
		int mid = i + (j - i) / 2;
		if (windowExist(mid, nums, s)) {
		    j = mid - 1;
		    min = mid; // only update min while there is a smaller
			       // window size
		} else {
		    i = mid + 1;
		}
	    }
	    return min;
	}

	private boolean windowExist(int size, int[] nums, int s) {
	    int sum = 0;
	    for (int i = 0; i < nums.length; i++) {
		if (i >= size) {
		    sum -= nums[i - size];
		}

		sum += nums[i];

		if (sum >= s) {
		    return true;
		}
	    }
	    return false;
	}
    }

    public class Solution3 {
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
