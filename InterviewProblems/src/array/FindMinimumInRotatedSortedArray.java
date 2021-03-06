package array;

/**
 * Find Minimum in Rotated Sorted Array
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 *
 */

/*
 * similar to search in rotated sorted array
 */
public class FindMinimumInRotatedSortedArray {
    /*
     * More straightforward. 
     * Compare nums[mid] to res at each round
     */
    public class Solution {
	public int findMin(int[] nums) {
	    int low = 0;
	    int high = nums.length - 1;

	    int res = Integer.MAX_VALUE;
	    while (low <= high) {
		int mid = (low + high) / 2;
		res = Math.min(nums[mid], res);
		if (nums[mid] < nums[high]) {
		    high = mid - 1;
		} else {
		    low = mid + 1;
		}
	    }

	    return res;
	}
    }

    public class Solution_2 {
	public int findMin(int[] num) {
	    if (num == null || num.length == 0) {
		return 0;
	    }

	    int low = 0;
	    int high = num.length - 1;
	    int mid = 0;
	    while (low <= high) {
		mid = (low + high) / 2;
		if (low == high) {
		    return num[mid];
		}

		if (num[mid] < num[high]) {
		    high = mid;
		} else {
		    low = mid + 1;
		}
	    }

	    return num[mid];
	}
    }
}
