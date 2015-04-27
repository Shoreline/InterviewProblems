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
 * [1,3,5,6], 5 �� 2
 * 
 * [1,3,5,6], 2 �� 1
 * 
 * [1,3,5,6], 7 �� 4
 * 
 * [1,3,5,6], 0 �� 0
 */

/*
 * related: search a 2d matrix
 */
public class SearchInsertPosition {

    /*
     * [2015] Simple
     */
    public class Solution {
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

    /*
     * first answer very close to pass
     * 
     * Similar to my solution to search a sorted 2D array
     */

    public int searchInsert(int[] A, int target) {
	if (A == null || A.length == 0) {
	    return 0;
	}

	/*
	 * This part is not necessary!
	 */
	// corner cases: must be "<" and ">", cannot use "<=" and ">="
	// if (target < A[0])
	// return 0;
	// if (target > A[A.length - 1])
	// return A.length;

	int i = 0;
	int j = A.length - 1;
	int mid = 0;

	while (i <= j) {
	    mid = (i + j) / 2;

	    if (A[mid] == target) {
		return mid;
	    } else if (A[mid] < target) {
		i = mid + 1;
	    } else {
		j = mid - 1;
	    }
	}

	/*
	 * The final mid can be at the right/left neighbor of the target
	 */
	if (A[mid] < target) {
	    mid++;
	}

	return mid;
    }
}
