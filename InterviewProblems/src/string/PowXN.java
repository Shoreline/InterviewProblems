package string;

public class PowXN {
    /**
     * Pow(x, n)
     * 
     * Implement pow(x, n).
     */
    /*
     * The problem is that x is a double number
     * 
     * just return Math.pow(x,n) can pass the large set...
     * 
     * Correct solution (O(lgn)): 二分法, be aware of the cases that n<0
     * 
     * Slow solution: keep doing x * x * x ... n times. O(n)
     * 
     * Can it be done in O(1)?
     */
    public double pow(double x, int n) {
	// the most straightforward way...
	// return Math.pow(x, n);

	// 二分法
	if (n == 0)
	    return 1.0;

	if (n == 1)
	    return x;

	if (x == 0.0)
	    return 0.0;

	if (n < 0) {
	    x = 1.0 / x;
	    n = -n;
	}

	double half = pow(x, n / 2);
	double rest = pow(x, n % 2);

	return half * half * rest;
    }
}
