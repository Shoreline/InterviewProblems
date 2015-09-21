package math;

public class GreatestCommonDivisor {
    class Solution {
	public int getGCD(int a, int b) {
	    while (a != 0 && b != 0) // until either one of them is 0
	    {
		int c = b;
		b = a % b;
		a = c;
	    }
	    return a + b; // either one is 0, so return the non-zero value
	}
    }
}
