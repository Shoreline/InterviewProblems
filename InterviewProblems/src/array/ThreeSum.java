package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    /**
     * Three Sum
     * 
     * Given an array S of n integers, are there elements a, b, c in S such that
     * a + b + c = 0? Find all unique triplets in the array which gives the sum
     * of zero.
     * 
     * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie,
     * a �� b �� c) The solution set must not contain duplicate triplets.
     * 
     * For example, given array S = {-1 0 1 2 -1 -4},
     * 
     * A solution set is: (-1, 0, 1) (-1, -1, 2)
     */

    /*
     * To get unique items, not just use Set.
     * 
     * Similar to solution2
     * 
     * Iterate by "the lowest index", k
     * 
     * Need to skip repeated values for all k,i, and j.
     */
    public class Solution4 {
	public List<List<Integer>> threeSum(int[] num) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (num == null || num.length < 3) {
		return res;
	    }

	    Arrays.sort(num);

	    for (int k = 0; k < num.length - 2; k++) {
		if (k > 0 && num[k] == num[k - 1]) {
		    continue;
		}

		int i = k + 1;
		int j = num.length - 1;
		while (i < j) {
		    int sum = num[k] + num[i] + num[j];

		    if (sum == 0) {
			ArrayList<Integer> answer = new ArrayList<Integer>();
			answer.add(num[k]);
			answer.add(num[i]);
			answer.add(num[j]);
			res.add(answer);

			while (i + 1 < j && num[i + 1] == num[i]) {
			    i++;
			}
			while (i < j - 1 && num[j - 1] == num[j]) {
			    j--;
			}

			i++;
			j--;
		    } else if (sum < 0) {
			i++;
		    } else {
			j--;
		    }
		}
	    }

	    return res;
	}
    }

    /*
     * Use a HashSet to avoid duplicate results
     * 
     * -> how to handle duplicated triplets? Don't think this is a correct
     * solution
     */
    class Solution3 {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    HashSet<ArrayList<Integer>> temp = new HashSet<ArrayList<Integer>>();

	    if (num == null || num.length < 3)
		return result;

	    Arrays.sort(num);
	    for (int k = 0; k < num.length - 2; k++) {
		/*
		 * *Important* the initial values of i and j Since i and j are
		 * behind k, so i start from k+1
		 */
		int i = k + 1;
		int j = num.length - 1;
		while (i < j) {
		    int sum = num[k] + num[i] + num[j];
		    if (sum == 0) {
			ArrayList<Integer> aResult = new ArrayList<Integer>();
			aResult.add(num[k]);
			aResult.add(num[i]);
			aResult.add(num[j]);

			temp.add(aResult);
			i++;
			j--;
		    } else if (sum < 0) {
			i++;
		    } else {
			j--;
		    }
		}

	    }
	    result = new ArrayList<ArrayList<Integer>>(temp);

	    return result;

	}
    }

    /*
     * High hand solution. Avoid using HashSet
     */
    class Solution2 {
	public ArrayList<ArrayList<Integer>> threeSumHighHand(int[] num) {
	    Arrays.sort(num);
	    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	    int n = num.length;
	    for (int i = 0; i < n - 2;) {
		int target = -num[i];
		int j = i + 1, k = n - 1;
		while (j < k) {
		    int sum = num[j] + num[k];
		    if (sum < target) {
			j++;
		    } else if (sum > target) {
			k--;
		    } else {
			ArrayList<Integer> triplets = new ArrayList<Integer>();
			triplets.add(new Integer(num[i]));
			triplets.add(new Integer(num[j]));
			triplets.add(new Integer(num[k]));
			ans.add(triplets);
			/*
			 * skip all repeated elements to avoid duplicate results
			 */
			while (j < n && num[j] == triplets.get(1))
			    j++;
			while (k >= 0 && num[k] == triplets.get(2))
			    k--;
		    }
		}
		/*
		 * skip all repeated elements to avoid duplicate results
		 */
		int prev = num[i];
		while (i < n - 2 && num[i] == prev)
		    i++;
	    }
	    return ans;
	}
    }

    class Solution1 {
	// =============== The oldest way
	public HashSet<ArrayList<Integer>> get0SumFrom3_2(int[] input) {
	    HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
	    HashSet<Integer> nums = new HashSet<Integer>();

	    for (int i = 0; i < input.length; i++) {
		for (int j = i + 1; j < input.length; j++) {

		    nums.clear();
		    for (int k = 0; k < input.length; k++) {
			if (k != i && k != j) {
			    nums.add(input[k]);
			}
		    }

		    Integer numWanted = 0 - (input[i] + input[j]);
		    if (nums.contains(numWanted)) {
			ArrayList<Integer> aResult = new ArrayList<Integer>();
			aResult.add(numWanted);
			aResult.add(input[i]);
			aResult.add(input[j]);
			Collections.sort(aResult);

			result.add(aResult);

		    }
		}
	    }

	    for (ArrayList<Integer> aResult : result) {
		System.out.println(aResult);
	    }

	    return result;
	}
    }
}
