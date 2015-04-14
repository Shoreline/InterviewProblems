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
	public int removeDuplicates(int[] A) {
	    if (A == null || A.length == 0) {
		return 0;
	    }

	    int ptr = 1;
	    int counter = 1;
	    for (int i = 1; i < A.length; i++) {
		if (A[i] == A[i - 1]) {
		    counter++;
		} else {
		    counter = 1;
		}

		if (counter <= 2) {
		    A[ptr] = A[i];
		    ptr++;
		}
	    }

	    // do not return ptr+1!
	    return ptr;
	}
    }
}
