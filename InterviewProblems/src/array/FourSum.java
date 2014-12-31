package array;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
    /**
     * Four Sum
     * 
     * Given an array S of n integers, are there elements a, b, c, and d in S
     * such that a + b + c + d = target? Find all unique quadruplets in the
     * array which gives the sum of target.
     * 
     * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order.
     * (ie, a ¡Ü b ¡Ü c ¡Ü d) The solution set must not contain duplicate
     * quadruplets. For example, given array S = {1 0 -1 0 -2 2}, and target =
     * 0.
     * 
     * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
     **/

    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {

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
