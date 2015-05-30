package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Three Sum
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a<=
 * b <= c) The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 */

/*
 * To get unique items, without using Set
 * 
 * Iterate by "the lowest index", e1
 * 
 * Need to skip repeated values for all e1, e2 and e3
 */
public class ThreeSum {
    public class Solution {
	public List<List<Integer>> threeSum(int[] num) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (num == null || num.length < 3) {
		return res;
	    }

	    Arrays.sort(num);
	    for (int e1 = 0; e1 < num.length - 2; e1++) {
		if (e1 > 0 && num[e1] == num[e1 - 1]) {
		    continue;
		}

		int e2 = e1 + 1;
		int e3 = num.length - 1;
		while (e2 < e3) {
		    if (e2 > e1 + 1 && num[e2] == num[e2 - 1]) {
			e2++;
			continue;
		    } else if (e3 < num.length - 1 && num[e3] == num[e3 + 1]) {
			e3--;
			continue;
		    }

		    int sum = num[e1] + num[e2] + num[e3];
		    if (sum == 0) {
			ArrayList<Integer> ans = new ArrayList<Integer>();
			ans.add(num[e1]);
			ans.add(num[e2]);
			ans.add(num[e3]);

			res.add(ans);

			e2++;
			e3--;
		    } else if (sum < 0) {
			e2++;
		    } else {
			e3--;
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
