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
     * be careful, do not forget the lines marked as "*notice!"
     */

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
