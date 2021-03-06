package array;

/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 */

/*
 * Only compare nums[mid] with nums[high]: 3 cases: >, <, or ==
 *
 * if use the same way as dealing with array with unique elements, we can not
 * guarantee that if A[I]<=A[m] than I~m is a ascending sub-array (ex: 1,1,3,1)
 * 
 * there will be error:
 * 
 * for example:A=[1,3,1,1,1], target=3
 * 
 * cannot implement binary search and just use linearly scan the whole array A
 * (cost O(N))? -> wrong. The worst case time is O(N), but still we can apply
 * binary search. Just need to handle the cases A[mid]==A[low] (or
 * A[mid]==A[high], equivalent)
 */
public class SearchInRotatedSortedArrayII {
    public class Solution {
	public boolean search(int[] nums, int target) {
	    if (nums == null || nums.length == 0) {
		return false;
	    }

	    int low = 0;
	    int high = nums.length - 1;
	    while (low <= high) {
		int mid = (low + high) / 2;
		if (nums[mid] == target) {
		    return true;
		}

		if (nums[mid] < nums[high]) {
		    if (target > nums[mid] && target <= nums[high]) {
			low = mid + 1;
		    } else {
			high = mid - 1;
		    }
		} else if (nums[mid] > nums[high]) {
		    if (target >= nums[low] && target < nums[mid]) {
			high = mid - 1;
		    } else {
			low = mid + 1;
		    }
		} else {
		    high--; // important
		}
	    }

	    return false;
	}
    }
}
