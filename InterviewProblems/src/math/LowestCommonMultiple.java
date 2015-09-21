package math;

public class LowestCommonMultiple {
    class Solution {
	public int getLCM(int a, int b) {
	    return a * b / getGCD(a, b);
	}

	private int getGCD(int a, int b) {
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
