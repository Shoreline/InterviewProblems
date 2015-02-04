package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    /**
     * Four Sum
     * 
     * Given an array S of n integers, are there elements a, b, c, and d in S
     * such that a + b + c + d = target? Find all unique quadruplets in the
     * array which gives the sum of target.
     * 
     * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order.
     * (ie, a ≤ b ≤ c ≤ d) The solution set must not contain duplicate
     * quadruplets. 
     * 
     * For example, given array S = {1 0 -1 0 -2 2}, and target = 0
     * 
     * A solution set is: 
     * (-1, 0, 0, 1) 
     * (-2, -1, 1, 2) 
     * (-2, 0, 0, 2)
     **/

    /*
     * O(n^3) time complexity
     * 
     * Avoided duplicated answers.
     */
    public class Solution2 {
	public List<List<Integer>> fourSum(int[] num, int target) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (num == null || num.length < 4) {
		return res;
	    }

	    Arrays.sort(num);

	    for (int m = 0; m < num.length - 3; m++) {
		if (m > 0 && num[m] == num[m - 1]) {
		    continue;
		}

		for (int n = m + 1; n < num.length - 2; n++) {
		    if (n > m + 1 && num[n] == num[n - 1]) {
			continue;
		    }

		    int i = n + 1;
		    int j = num.length - 1;
		    while (i < j) {
			if (i > n + 1 && num[i] == num[n - 1]) {
			    i++;
			    continue;
			} else if (j < num.length - 1 && num[j] == num[j + 1]) {
			    j--;
			    continue;
			}

			int sum = num[m] + num[n] + num[i] + num[j];
			if (sum == target) {
			    List<Integer> answer = new ArrayList<Integer>();
			    answer.add(num[m]);
			    answer.add(num[n]);
			    answer.add(num[i]);
			    answer.add(num[j]);
			    res.add(answer);
			    i++;
			    j--;
			} else if (sum < target) {
			    i++;
			} else {
			    j--;
			}

		    }
		}
	    }
	    return res;
	}
    }

    public static class Solution1 {
	public static ArrayList<ArrayList<Integer>> fourSum(int[] num,
		int target) {

	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	    Arrays.sort(num);

	    for (int i = 0; i < num.length - 3; i++) {
		for (int j = i + 1; j < num.length - 2; j++) {
		    int m = j + 1;
		    int n = num.length - 1;

		    while (m < n) {
			int sum = num[i] + num[j] + num[m] + num[n];
			if (sum == target) {
			    ArrayList<Integer> aResult = new ArrayList<Integer>();
			    aResult.add(num[i]);
			    aResult.add(num[j]);
			    aResult.add(num[m]);
			    aResult.add(num[n]);
			    m++;
			    n--;
			    if (!result.contains(aResult)) {
				result.add(aResult);
			    }
			} else if (sum < target) {
			    m++;
			} else {
			    n--;
			}
		    }
		}
	    }

	    return result;
	}
    }
}
