package string;

import java.util.HashMap;

/**
 * ClimbStairs
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 */

/*
 * Similar to computing fibnacci sequence.
 */
public class ClimbStairs {
    /*
     * DP
     * 
     * Initial status starts from n = 0: res is 1 for n=0 and 1 for n=1
     */
    public class Solution {
	public int climbStairs(int n) {
	    if (n < 0) {
		return 0;
	    }
	    if (n < 2) {
		return n;
	    }

	    // no need to use int[] dp
	    int dp1 = 1; // n =0;
	    int dp2 = 1; // n = 1;
	    int steps = 0;

	    for (int i = 2; i <= n; i++) {
		steps = dp1 + dp2;
		dp1 = dp2;
		dp2 = steps;
	    }
	    return steps;
	}
    }

    /*
     * Recursion + status_store
     */
    class Solution_Recursion {
	public int climbStairs(int n) {

	    HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
	    record.put(0, 0);
	    record.put(1, 1);
	    record.put(2, 2);

	    int result = climbStairs(n, record);

	    return result;
	}

	private int climbStairs(int n, HashMap<Integer, Integer> record) {
	    if (record.containsKey(n)) {
		return record.get(n);
	    }

	    int a = climbStairs(n - 1, record);
	    int b = climbStairs(n - 2, record);
	    record.put(n - 1, a);
	    record.put(n - 2, b);

	    return a + b;

	}
    }
}
