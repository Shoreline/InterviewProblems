package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4 Sum
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order.
 * (ie, a ≤ b ≤ c ≤ d) The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0
 * 
 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
 **/

/*
 * Two algorithms:
 * 
 * 1. Similar to 3 sum, this time needs O(n^3) time
 * 
 * 2. Pair two array elements up and then apply two sum: O(N^2logN) time
 * http://blog.csdn.net/linhuanmars/article/details/24826871
 */
public class FourSum {
    public class Solution {
	public List<List<Integer>> fourSum(int[] num, int target) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (num == null || num.length < 4) {
		return res;
	    }

	    Arrays.sort(num);

	    for (int e1 = 0; e1 < num.length - 3; e1++) {
		if (e1 > 0 && num[e1] == num[e1 - 1]) {
		    continue;
		}

		for (int e2 = e1 + 1; e2 < num.length - 2; e2++) {
		    if (e2 > e1 + 1 && num[e2] == num[e2 - 1]) {
			continue;
		    }

		    int e3 = e2 + 1;
		    int e4 = num.length - 1;
		    while (e3 < e4) {
			if (e3 > e2 + 1 && num[e3] == num[e2 - 1]) {
			    e3++;
			    continue;
			} else if (e4 < num.length - 1
				&& num[e4] == num[e4 + 1]) {
			    e4--;
			    continue;
			}

			int sum = num[e1] + num[e2] + num[e3] + num[e4];
			if (sum == target) {
			    List<Integer> answer = new ArrayList<Integer>();
			    answer.add(num[e1]);
			    answer.add(num[e2]);
			    answer.add(num[e3]);
			    answer.add(num[e4]);
			    res.add(answer);
			    e3++;
			    e4--;
			} else if (sum < target) {
			    e3++;
			} else {
			    e4--;
			}

		    }
		}
	    }
	    return res;
	}
    }
}
