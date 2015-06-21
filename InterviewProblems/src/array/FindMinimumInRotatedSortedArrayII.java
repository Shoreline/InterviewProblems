package array;

/**
 * Find Minimum in Rotated Sorted Array II
 * 
 * Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why? Suppose a sorted
 * array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 *
 */
public class FindMinimumInRotatedSortedArrayII {
    public class Solution {
	public int findMin(int[] nums) {
	    int low = 0;
	    int high = nums.length - 1;
	    int res = Integer.MAX_VALUE;
	    while (low <= high) {
		int mid = (low + high) / 2;
		res = Math.min(res, nums[mid]);
		if (nums[mid] == nums[high]) {
		    high--;
		} else if (nums[mid] < nums[high]) {
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
		} else if (num[mid] > num[high]) {
		    low = mid + 1;
		} else {
		    high--;
		}
	    }

	    return num[mid];
	}
    }
}
