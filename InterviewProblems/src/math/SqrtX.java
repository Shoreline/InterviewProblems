package math;

/**
 * Sqrt(x)
 * 
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 */

public class SqrtX {

    /*
     * Newton's method, works when x is int
     */
    public class Solution {
	public int mySqrt(int x) {
	    if (x == 0) {
		return x;
	    }

	    double res = x / 2.0;
	    double preRes = 0;

	    while (res != preRes) {
		preRes = res;
		res = (res + x / res) / 2;
	    }

	    return (int) res;
	}
    }

    /*
     * Binary search.
     * 
     * low and high are the inclusive boundaries of the result.
     */
    public class SolutionBinarySearch {
	public int mySqrt(int x) {
	    if (x == 0) {
		return 0;
	    }

	    int low = 1;
	    int high = x / 2 + 1;
	    while (low <= high) {
		int mid = (low + high) / 2;

		// Do not use if(mid*mid==x), may exceed Integer limit
		if (mid == x / mid) {
		    return mid;
		} else if (mid < x / mid) {
		    low = mid + 1;
		} else {
		    high = mid - 1;
		}
	    }

	    return Math.min(low, high); // since sqrt(2)=1.
	}
    }

    /*
     * Newton's method, works even for double x
     */
    class Solution_Newton_General {
	public int sqrt(int x) {
	    if (x == 0) {
		return x;
	    }
	    // best initial value: 1597463174
	    double res = x / 2.0; // initial value
	    double epsilon = 0.1; // tolerance
	    double preRes = 0;

	    while (Math.abs(res - preRes) > epsilon) {
		preRes = res;
		res = (res + x / res) / 2;
	    }

	    return (int) res;
	}
    }

}
