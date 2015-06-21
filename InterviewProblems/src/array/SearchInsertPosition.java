package array;

/**
 * Search Insert Position
 * 
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * 
 * [1,3,5,6], 5 -> 2
 * 
 * [1,3,5,6], 2 -> 1
 * 
 * [1,3,5,6], 7 -> 4
 * 
 * [1,3,5,6], 0 -> 0
 */

/*
 * related: search a 2d matrix
 */
public class SearchInsertPosition {
    /*
     * If the target is not in nums, just return low (or high+1).
     */
    public class Solution {
	public int searchInsert(int[] nums, int target) {
	    int low = 0;
	    int high = nums.length - 1;

	    while (low <= high) {
		int mid = (low + high) / 2;
		if (nums[mid] == target) {
		    return mid;
		} else if (nums[mid] < target) {
		    low = mid + 1;
		} else {
		    high = mid - 1;
		}
	    }

	    return low; // or return high+1
	}
    }

    public class Solution2 {
	public int searchInsert(int[] A, int target) {
	    if (A == null) {
		return 0;
	    }

	    int low = 0;
	    int high = A.length - 1;
	    int toInsert = 0;

	    while (low <= high) {
		int mid = (low + high) / 2;
		if (A[mid] == target) {
		    return mid;
		} else if (A[mid] < target) {
		    toInsert = mid + 1;
		    low = mid + 1;
		} else {
		    high = mid - 1;
		}
	    }

	    return toInsert;
	}
    }    
}
