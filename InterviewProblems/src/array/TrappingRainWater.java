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

    /*
     * Best solution costs only O(N) time
     * http://blog.csdn.net/linhuanmars/article/details/20888505 
     */
    
    
    /*
     * If the highest bar on the left hand side of A[i] is maxLeft, and the
     * highest bar on its right hand side is maxRight, then A[i] can hole at
     * most v = (min(maxLeft, maxRight) - A[i]) units of water. 
     * (of course, if v < 0 then A[i] won't hold any water) 
     * 
     * time: O(3N); space: O(2N)
     * 
     * Note: the 2nd and 3rd scans can be integrated to reduce time complexity
     */
    public class Solution {
	public int trap(int[] A) {
	    if (A == null || A.length < 3) {
		return 0;
	    }

	    int len = A.length;
	    int[] maxLeft = new int[len];
	    int[] maxRight = new int[len];

	    maxLeft[0] = A[0];
	    for (int i = 1; i < len - 1; i++) {
		if (A[i - 1] > maxLeft[i - 1]) {
		    maxLeft[i] = A[i - 1];
		} else {
		    maxLeft[i] = maxLeft[i - 1];
		}
	    }

	    maxRight[len - 1] = A[len - 1];
	    for (int i = len - 2; i > 0; i--) {
		if (A[i + 1] > maxRight[i + 1]) {
		    maxRight[i] = A[i + 1];
		} else {
		    maxRight[i] = maxRight[i + 1];
		}
	    }

	    int sum = 0;
	    for (int i = 1; i < len - 1; i++) {
		int bar = Math.min(maxLeft[i], maxRight[i]) - A[i];
		if (bar > 0) {
		    sum += bar;
		}
	    }

	    return sum;
	}
    }

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
