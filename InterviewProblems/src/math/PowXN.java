package math;

/**
 * Pow(x, n)
 * 
 * Implement pow(x, n).
 */

/*
 * Dichotomy. ([daɪ'kɑtəmi] 二分法) Time: O(logN)
 * 
 * Pow(x, -n) = Pow( 1/x, n)
 */
public class PowXN {
    public class Solution {
	public double myPow(double x, int n) {
	    if (n == 0) {
		return 1.0;
	    }
	    if (n < 0) {
		x = 1 / x;
		n = -n;
	    }

	    double half = myPow(x, n / 2);

	    return n % 2 == 0 ? half * half : half * half * x;
	}
    }
}
