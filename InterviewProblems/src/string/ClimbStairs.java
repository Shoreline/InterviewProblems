package string;

import java.util.HashMap;

public class ClimbStairs {
    /**
     * ClimbStairs
     * 
     * You are climbing a stair case. It takes n steps to reach to the top.
     * 
     * Each time you can either climb 1 or 2 steps. In how many distinct ways
     * can you climb to the top?
     * 
     */

    /*
     * Similar to computing fibnacci sequence.
     * 
     * Recursion + DP
     */
    public static int climbStairs(int n) {

	HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
	record.put(0, 0);
	record.put(1, 1);
	record.put(2, 2);

	int result = climbStairs(n, record);

	return result;
    }

    private static int climbStairs(int n, HashMap<Integer, Integer> record) {
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
