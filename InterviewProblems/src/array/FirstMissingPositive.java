package array;

/**
 * First Missing Positive
 * 
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 */

public class FirstMissingPositive {
    /*
     * The result must be in this interval: [1, A.length].
     * 
     * Use constant space -> use the input memory as cache.
     * 
     * Key: use sign ( + or -) to do flagging
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
    public class Solution {
	public int firstMissingPositive(int[] nums) {
	    if (nums == null || nums.length == 0) {
		return 1;
	    }

	    for (int i = 0; i < nums.length; i++) {
		if (nums[i] < 1 || nums[i] > nums.length) {
		    nums[i] = 0;
		}
	    }

	    for (int i = 0; i < nums.length; i++) {
		if (nums[i] != 0) {
		    int k = Math.abs(nums[i]) - 1;
		    if (nums[k] == 0) {
			nums[k] = -Math.abs(nums[i]);
		    } else {
			nums[k] = -Math.abs(nums[k]);
		    }
		}
	    }

	    for (int i = 0; i < nums.length; i++) {	
		if (nums[i] >= 0) {
		    return i + 1;
		}
	    }

	    return nums.length + 1;
	}
    }

    /*
     * Straightforward but costs additional space. Violates the "constant space"
     * requirement? time: O(2N); space: O(2N)
     */
    public class Solution_easy {
	public int firstMissingPositive(int[] A) {
	    if (A == null) {
		return 1;
	    }

	    int res = A.length + 1;
	    boolean[] existingNums = new boolean[A.length];

	    for (int i = 0; i < A.length; i++) {
		if (A[i] > 0 && A[i] <= A.length) {
		    existingNums[A[i] - 1] = true;
		}
	    }

	    for (int i = 0; i < existingNums.length; i++) {
		if (existingNums[i] == false) {
		    res = i + 1;
		    break;
		}
	    }

	    return res;
	}
    }
}
