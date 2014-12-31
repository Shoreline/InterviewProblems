package array;

public class TrappingRainWater {
    /**
     * Trapping Rain Water
     * 
     * Given n non -negative integers representing an elevation map where the
     * width of each bar is 1, compute how much water it is able to trap after
     * raining.
     * 
     * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
     */
    public static int trap(int[] A) {
	if (A == null || A.length < 3)
	    return 0;

	int sum = 0;

	int i = 0;
	for (; i < A.length && A[i] <= 0; i++)
	    ;

	int j = A.length - 1;
	for (; j >= 0 && A[j] <= 0; j--)
	    ;

	if (i >= j)
	    return 0;

	int curBlocks = 0;
	int k;
	for (k = i + 1; k <= j; k++) {
	    if (A[k] >= A[i]) {
		sum += A[i] * (k - i - 1) - curBlocks;
		i = k;
		curBlocks = 0;
	    } else {
		curBlocks += A[k];
	    }
	}

	/*
	 * *Important* must go back from the end to i to take care of all corner
	 * cases
	 */
	curBlocks = 0;
	for (int m = j - 1; m >= i; m--) {
	    if (A[m] >= A[j]) {
		sum += A[j] * (j - m - 1) - curBlocks;
		curBlocks = 0;
		j = m;
	    } else {
		curBlocks += A[m];
	    }

	}
	return sum;
    }

}
