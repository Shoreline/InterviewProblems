package array;

import java.util.Arrays;

/**
 * 3 Sum Closet
 * 
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 */

/*
 * Very similar to the 3 sum problem.
 */
public class ThreeSumClosest {
    public class Solution {
	public int threeSumClosest(int[] num, int target) {
	    if (num == null || num.length < 3) {
		return target;
	    }

	    int minDiff = num[0] + num[1] + num[2];
	    Arrays.sort(num);
	    for (int k = 0; k < num.length - 2; k++) {
		if (k > 0 && num[k] == num[k - 1]) {
		    continue;
		}

		int i = k + 1;
		int j = num.length - 1;

		while (i < j) {
		    if (i > k + 1 && num[i] == num[i - 1]) {
			i++;
			continue;
		    } else if (j < num.length - 1 && num[j] == num[j + 1]) {
			j--;
			continue;
		    }

		    int sum = num[k] + num[i] + num[j];
		    if (Math.abs(target - sum) < Math.abs(target - minDiff)) {
			minDiff = sum;
		    }

		    if (sum == target) {
			return target;
		    } else if (sum < target) {
			i++;
		    } else {
			j--;
		    }
		}
	    }

	    return minDiff;
	}
    }
}
