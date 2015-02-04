package array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 */
public class ThreeSumClosest {

    /*
     * Skip the repeated elements
     */
    public class Solution1 {
	public int threeSumClosest(int[] num, int target) {
	    if (num == null || num.length < 3) {
		return target;
	    }

	    int cloestSum = num[0] + num[1] + num[2];
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
		    if (Math.abs(target - sum) < Math.abs(target - cloestSum)) {
			cloestSum = sum;
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

	    return cloestSum;
	}
    }

    /*
     * returns a list of triplets. Repeated elements not skipped.
     */
    public static class Solution0 {
	public static ArrayList<Integer> getThreeSumCloest(Integer[] input,
		int target) {
	    if (input.length < 3) {
		return null;
	    }

	    ArrayList<Integer> result = new ArrayList<Integer>();
	    int curMin = Integer.MAX_VALUE;

	    Arrays.sort(input);

	    for (int i = 0; i < input.length - 2; i++) {
		int j = i + 1;
		int k = input.length - 1;

		while (j < k) {

		    int sum = input[i] + input[j] + input[k];
		    if (sum == target) {
			result.clear();
			result.add(input[i]);
			result.add(input[j]);
			result.add(input[k]);
			return result;
		    } else if (sum > target) {
			if (sum - target < curMin) {
			    curMin = sum - target;
			    result.clear();
			    result.add(input[i]);
			    result.add(input[j]);
			    result.add(input[k]);
			}
			k--;
		    } else {
			if (target - sum < curMin) {
			    curMin = target - sum;
			    result.clear();
			    result.add(input[i]);
			    result.add(input[j]);
			    result.add(input[k]);
			}
			j++;
		    }

		}

	    }

	    return result;
	}
    }
}
