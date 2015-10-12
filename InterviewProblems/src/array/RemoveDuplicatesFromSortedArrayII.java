package array;

/**
 * Remove Duplicates from Sorted Array II
 * 
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 *
 */
public class RemoveDuplicatesFromSortedArrayII {
    /*
     * Just add a counter.
     * 
     * If counter value still qualifies allowed duplicates amount, A[ptr]=A[i].
     * Otherwise only increment i
     * 
     * In the end return ptr instead of ptr+1. Since ptr got ++ in the last
     * iteration of for loop
     */
    public class Solution {
	public int removeDuplicates(int[] nums) {
	    int k = 2;
	    if (nums == null || nums.length == 0) {
		return 0;
	    }

	    int count = 1;
	    int ptr = 1;
	    for (int i = 1; i < nums.length; i++) {
		if (nums[i] != nums[i - 1]) {
		    count = 0;
		}

		if (count < k) {
		    nums[ptr] = nums[i];
		    ptr++;
		}

		count++;
	    }

	    return ptr;
	}
    }

    public class Solution2 {
	public int removeDuplicates(int[] nums) {
	    if (nums == null || nums.length == 0) {
		return 0;
	    }

	    int ptr = 1;
	    int counter = 1;
	    for (int i = 1; i < nums.length; i++) {
		if (nums[i] == nums[i - 1]) {
		    counter++;
		} else {
		    counter = 1;
		}

		if (counter <= 2) {
		    nums[ptr] = nums[i];
		    ptr++;
		}
	    }

	    // do not return ptr+1!
	    return ptr;
	}
    }

    /*
     * Buggy. hard to handle all cases.
     */
    public class Wrong_attempt {
	public int removeDuplicates(int[] nums) {
	    if (nums == null) {
		return 0;
	    } else if (nums.length < 3) {
		return nums.length;
	    }

	    int ptr = 2;
	    for (int i = 2; i < nums.length; i++) {
		if (nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2]) {
		    while (i < nums.length && nums[i] == nums[i - 1]) {
			i++;
		    }
		    if (i == nums.length) {
			return ptr;
		    }
		}
		nums[ptr] = nums[i];
		ptr++;
	    }

	    return ptr == nums.length ? ptr : ptr + 1;
	}
    }
}
