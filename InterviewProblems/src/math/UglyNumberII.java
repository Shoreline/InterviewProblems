package math;

/**
 * Ugly Number II
 * 
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10
 * ugly numbers.
 * 
 * Note that 1 is typically treated as an ugly number.
 * 
 * Hint:
 * 
 * The naive approach is to call isUgly for every number until you reach the nth
 * one. Most numbers are not ugly. Try to focus your effort on generating only
 * the ugly ones.
 * 
 * An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly
 * number.
 * 
 * The key is how to maintain the order of the ugly numbers. Try a similar
 * approach of merging from three sorted lists: L1, L2, and L3.
 * 
 * Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 *
 * 3, L3 * 5).
 *
 */
public class UglyNumberII {
    class Solution {
	/*
	 * Here is a time efficient solution with O(n) extra space. The
	 * ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … because
	 * every number can only be divided by 2, 3, 5, one way to look at the
	 * sequence is to split the sequence to three groups as below: (1) 1×2,
	 * 2×2, 3×2, 4×2, 5×2, … (2) 1×3, 2×3, 3×3, 4×3, 5×3, … (3) 1×5, 2×5,
	 * 3×5, 4×5, 5×5, …
	 * 
	 * We can find that every subsequence is the ugly-sequence itself (1, 2,
	 * 3, 4, 5, …) multiply 2, 3, 5. Then we use similar merge method as
	 * merge sort, to get every ugly number from the three subsequence.
	 * Every step we choose the smallest one, and move one step after.
	 */
	public int nthUglyNumber(int n) {
	    int[] ugly = new int[n];
	    ugly[0] = 1;
	    int i2 = 0;
	    int i3 = 0;
	    int i5 = 0; // index of the number that can generate next smallest 5-group ugly number 
	    int i = 1;
	    while (i < n) {
		int next = Math.min(ugly[i2] * 2, Math.min(ugly[i3] * 3, ugly[i5] * 5));
		if (next == ugly[i2] * 2) {
		    i2++;
		}
		if (next == ugly[i3] * 3) {
		    i3++;
		}
		if (next == ugly[i5] * 5) {
		    i5++;
		}
		ugly[i++] = next;
	    }

	    return ugly[n - 1];
	}
    }
}
