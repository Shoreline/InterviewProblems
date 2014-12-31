package array;

public class RiverCrossing {

    /**
     * River Crossing
     * 
     * X~~~~~~~~~~~~~~~~~~~~~~~~~~~__($)
     * 
     * * ** * * * * *
     * 
     * 011 2 3 3 2 3 4 5 6
     * 
     * 011 2 3 3 2 3 2 2 3X
     * 
     * 
     * loc = 0, speed = 0 each step: choose new speed from {speed, speed - 1,
     * speed + 1} (no negative numbers) loc += speed if water, fail if past end
     * of river, succeed
     * 
     * river = "*****  * ** *  * * *    *   "
     * 
     * 
     */

    /*
     * DP. O(n^2)
     */
    public boolean canCrossRiver(char[] river) {
	/*
	 * dp[i][j] means whether we can jump from river[i] to river[j]
	 * directly. if dp[i][j] is true, then at river[i] we must have speed of
	 * either j-i-1 or j-i or j-i+1. It is equivalent to say that at least
	 * one of the following cases must be true:
	 * 
	 * 1.we can jump from river[i - (j-i)]to river[i] 2.we can jump from
	 * river[i - (j-i-1)]to river[i] 3.we can jump from river[i - (j-i+1)]to
	 * river[i]
	 * 
	 * The speed variable is converted to position in river[].
	 * 
	 * Plus, if the remaining part of the river (river.length - i) is
	 * smaller than the maximum possible next speed (i-j+1), then we can
	 * return a true
	 */
	boolean[][] dp = new boolean[river.length][river.length];

	/*
	 * Initialize dp array (default value of boolean array element is false)
	 */
	dp[1][0] = true;

	for (int i = 0; i < river.length; i++) {
	    for (int j = i; j < river.length; j++) {
		int gap = j - i;

		if (river.length - i < gap + 1) {
		    return true; // found a successful case
		}

		if (river[i] != '*') {
		    dp[i][j] = false;
		} else {
		    /*
		     * need to add some boundary check.
		     * 
		     * unfinished
		     */
		    boolean c1 = dp[i - gap][i];
		    boolean c2 = dp[i - gap - 1][i];
		    boolean c3 = dp[i - gap + 1][i];

		    dp[i][j] = dp[i - gap][i] || dp[i - gap - 1][i]
			    || dp[i - gap + 1][i];
		}
	    }
	}

	return false; // if reach here then no successful case
    }

    /*
     * Recursion approach. O(3^n)
     */
    public boolean canCrossRiver(char[] river, int speed, int startIndex) {

	if (startIndex > river.length - 1) {
	    return true;
	}

	if (river[startIndex] != '*') {
	    return false;
	}
	if (startIndex != 0 && speed < 1) {
	    return false;
	}

	return (canCrossRiver(river, speed - 1, startIndex + speed)
		|| canCrossRiver(river, speed, startIndex + speed) || canCrossRiver(
		    river, speed + 1, startIndex + speed));

    }

}
