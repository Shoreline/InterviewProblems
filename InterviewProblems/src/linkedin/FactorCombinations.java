package linkedin;

import java.util.*;
/**
 * Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.

Write a function that takes an integer n and return all possible combinations of its factors.

Note:

    Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
    You may assume that n is always positive.
    Factors should be greater than 1 and less than n.

Examples:
input: 1
output:

[]

input: 37
output:

[]

input: 12
output:

[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]

input: 32
output:

[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
 *
 */
public class FactorCombinations {
    public class Solution {
	public List<List<Integer>> getFactors(int n) {
	    if (n == 1) {
		return new ArrayList<List<Integer>>();
	    }
	    return dfs(n, n - 1);
	}

	private List<List<Integer>> dfs(int n, int limit) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (n == 1) {
		res.add(new ArrayList<Integer>());
		return res;
	    }

	    for (int i = limit; i >= 2; i--) {
		if (n % i == 0) {
		    List<List<Integer>> rest = dfs(n / i, i);
		    for (List<Integer> ans : rest) {
			ans.add(i);
			res.add(ans);
		    }
		}
	    }

	    return res;
	}
    }

    public class Solution2 {
	public List<List<Integer>> getFactors(int n) {
	    return dfs(n, n - 1);
	}

	private List<List<Integer>> dfs(int n, int limit) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (n == 1 && limit > 0) {
		res.add(new ArrayList<Integer>());
		return res;
	    }

	    for (int i = limit; i >= 2; i--) {
		if (n % i == 0) {
		    List<List<Integer>> rest = dfs(n / i, i);
		    for (List<Integer> ans : rest) {
			ans.add(i);
			res.add(ans);
		    }
		}
	    }

	    return res;
	}
    }
}
