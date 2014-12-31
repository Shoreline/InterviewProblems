package array;

public class SearchInRotatedSortedArray2 {
    /**
     * Follow up for "Search in Rotated Sorted Array": What if duplicates are
     * allowed?
     * 
     * Would this affect the run-time complexity? How and why?
     * 
     * Write a function to determine if a given target is in the array.
     */

    /*
     * if use the same way as dealing with array with unique elements, in some
     * corner cases there will be error:
     * 
     * for example:A=[1,3,1,1,1], target=3
     * 
     * cannot implement binary search. so, just use linearly scan the whole
     * array A. Time complexity O(n)
     */

    public boolean search(int[] A, int target) {

	if (A == null) {
	    return false;
	}

	int lowEnd = 0;
	int highEnd = A.length - 1;

	while (lowEnd <= highEnd) {
	    int mid = lowEnd + (highEnd - lowEnd) / 2;

	    if (A[mid] == target)
		return true;

	    if (A[mid] >= A[lowEnd]) {
		// lowEnd ~ mid is the sorted half

		// see if target is in this half
		if (A[lowEnd] <= target && target < A[mid]) {
		    // target is in this half
		    highEnd = mid - 1;
		} else {
		    lowEnd = mid + 1;
		}
	    } else {
		// mid ~ highEnd is the sorted half

		if (A[mid] < target && target <= A[highEnd]) {
		    lowEnd = mid + 1;
		} else {
		    highEnd = mid - 1;
		}
	    }
	}

	return false;
    }
}
