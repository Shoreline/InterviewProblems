package math;

import java.util.HashSet;
import java.util.Set;

/**
 * Happy Number
 * 
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 
 * 1^2 + 9^2 = 82
 * 
 * 8^2 + 2^2 = 68
 * 
 * 6^2 + 8^2 = 100
 * 
 * 1^2 + 0^2 + 0^2 = 1
 *
 */
public class HappyNumber {
    public class Solution {
	public boolean isHappy(int n) {
	    Set<Integer> seen = new HashSet<>();
	    while (!seen.contains(n)) {
		seen.add(n);
		int next = 0;
		while (n != 0) {
		    next += (n % 10) * (n % 10);
		    n /= 10;
		}
		n = next;
	    }

	    return n == 1;
	}
    }

    public class Solution2 {
	public boolean isHappy(int n) {
	    Set<Integer> seen = new HashSet<Integer>();

	    while (n != 1) {
		if (seen.contains(n)) {
		    return false;
		}

		seen.add(n);
		int sqrtSum = 0;
		while (n > 0) {
		    sqrtSum += Math.pow((n % 10), 2);
		    n /= 10;
		}
		n = sqrtSum;
	    }

	    return true;
	}
    }
}
