package array;

public class MaximumSubarray {
    /**
     * Maximum Subarray
     * 
     * Find the contiguous subarray within an array (containing at least one
     * number) which has the largest sum.
     * 
     * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous
     * subarray [4,−1,2,1] has the largest sum = 6.
     * 
     * More practice: If you have figured out the O(n) solution, try coding
     * another solution using the divide and conquer approach, which is more
     * subtle.
     */

    /*
     * 1D DP (reduced to just one variable to save space)
     * 
     * The maximum-subarray must ends with some A[i]
     * So, let localMax[i] is the sub-maximum value of any sub array ends with A[i].
     * 
     * 
     * Then for localMax[i+1], its corresponding sub array has only two possibilities:
     * 1) it contains A[i]: localMax[i+1] = localMax[i] + A[i]
     * 2) it does not contain A[i]: localMax[i+1] = A[i]
     */
    public class Solution_DP {
	public int maxSubArray(int[] A) {
	    if (A == null) {
		return Integer.MIN_VALUE;
	    }
	    int max = A[0];
	    int localMax = A[0];

	    for (int i = 1; i < A.length; i++) {
		localMax = Math.max(A[i], A[i] + localMax);
		max = Math.max(localMax, max);
	    }

	    return max;
	}
    }

    /*
     * be careful, do not forget the lines marked as "*notice!"
     */
    public class Solution_Lame {
	public int maxSubArray(int[] A) {

	    if (A.length < 1) {
		return Integer.MIN_VALUE;
	    }

	    int max = Integer.MIN_VALUE;
	    int curSum = 0;

	    // In case all elements are negative
	    int maxElement = Integer.MIN_VALUE;

	    for (int i = 0; i < A.length; i++) {
		maxElement = Math.max(maxElement, A[i]);

		if (A[i] >= 0) {
		    curSum += A[i];
		    max = Math.max(max, curSum);
		} else {
		    int temp = 0;

		    while (i < A.length && A[i] <= 0) {
			maxElement = Math.max(maxElement, A[i]); // *notice!
			temp += A[i];
			i++;
		    }
		    i--; // *notice!

		    if (curSum + temp > 0) {
			curSum = curSum + temp;
		    } else {
			curSum = 0;
		    }
		}

	    }

	    if (maxElement <= 0) {
		return maxElement;
	    } else {
		return max;
	    }
	}
    }
}
