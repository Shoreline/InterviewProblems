package array;

public class FirstMissingPositive {
    /**
     * First Missing Positive
     * 
     * Given an unsorted integer array, find the first missing positive integer.
     * 
     * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
     * 
     * Your algorithm should run in O(n) time and uses constant space.
     */

    /*
     * The result must be in this interval: [1, A.length].
     * 
     * Use constant space -> use the input memory as cache.
     * 
     * Key: Let positive/negative value to indicate boolean true and false
     * 
     * First scan: set all elements whose value is not in the above interval to
     * be 0;
     * 
     * Second scan: if A[i] != 0, flip A[A[i]-1] to be
     * 
     * 1) (if A[A[i]-1]!=0) -abs(A[A[i]-1]); 2) -abs(A[i])
     * 
     * Third scan: for the first element in A[i] that equals to or bigger than
     * 0, return i+1
     * 
     * if all elements in A is bigger than 0, return A.length+1;
     */
    public static int firstMissingPositive(int[] A) {
	// Start typing your Java solution below
	// DO NOT write main() function

	for (int i = 0; i < A.length; i++) {
	    if (A[i] < 1 || A[i] > A.length)
		A[i] = 0;
	}

	for (int i = 0; i < A.length; i++) {
	    if (A[i] != 0) {
		int index = Math.abs(A[i]) - 1;
		if (A[index] != 0) {
		    A[index] = -Math.abs(A[index]);
		} else {
		    A[index] = -Math.abs(A[i]);
		}
	    }
	}

	for (int i = 0; i < A.length; i++) {
	    if (A[i] >= 0) {
		return i + 1;
	    }
	}

	return A.length + 1;
    }
}
