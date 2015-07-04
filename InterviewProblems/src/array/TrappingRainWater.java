package array;

/**
 * Trapping Rain Water
 * 
 * Given n non -negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

public class TrappingRainWater {
    /*
     * Two pointers solution, O(N) time.
     * 
     * the inner while loop condition must be height[left/right] < curMin! If
     * using <= there will be error
     */
    public class Solution {
	public int trap(int[] height) {
	    if (height == null) {
		return 0;
	    }

	    int left = 0;
	    int right = height.length - 1;
	    int res = 0;
	    while (left < right) {

		int curMin = Math.min(height[left], height[right]);
		if (height[left] == curMin) {
		    left++;
		    while (left < height.length && height[left] < curMin) {
			res += curMin - height[left];
			left++;
		    }
		} else {
		    right--;
		    while (right >= 0 && height[right] < curMin) {
			res += curMin - height[right];
			right--;
		    }
		}
	    }

	    return res;
	}
    }

    /*
     * If the highest bar on the left hand side of A[i] is maxLeft, and the
     * highest bar on its right hand side is maxRight, then A[i] can hole at
     * most v = (min(maxLeft, maxRight) - A[i]) units of water. (of course, if v
     * < 0 then A[i] won't hold any water)
     * 
     * time: O(3N); space: O(2N)
     * 
     * Note: the 2nd and 3rd scans can be integrated to reduce time complexity
     * 
     * similar to: Candy
     */
    public class Solution2 {
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
