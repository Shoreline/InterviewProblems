package bit;

/**
 * Number of 1 Bits
 * 
 * Return the number of "1"s in the binary version for a given Integer
 */

/*
 * Important:
 * 
 * 1. n & (n-1) will result in setting the rightmost '1' to '0'
 * 
 * 2. n & 1 will return the last bit of n (so, (n >> i) & 1 will return the i-th
 * bit of n )
 */
public class NumberOfOneBits {
    /*
     * Similar method as one of the solutions used in solving reverse bits.
     */
    public class Solution {
	public int hammingWeight(int n) {
	    int res = 0;
	    for (int i = 0; i < 32; i++) {
		res += (n >> i) & 1;
	    }
	    return res;
	}
    }

    // A faster way. only count n times (n is the number of 1)
    public class Solution2 {
	public int hammingWeight(int n) {
	    int count = 0;
	    while (n != 0) { // it is wrong to use (n>0) as condition
		count++;
		n = n & (n - 1);
	    }

	    return count;
	}
    }

    // time limit exceeded for 10000000000000000000000000000000.
    public class Method_Shift {
	public int countOne1(int a) {
	    int counter = 0;

	    while (a != 0) {
		if ((a & 1) == 1)
		    counter++;
		a = a >> 1;
	    }

	    return counter;
	}
    }
}
