package math;

public class PaintFence {
    public class Solution {
	public int numWays(int n, int k) {
	    if (n == 0 || k == 0) {
		return 0;
	    } else if (n == 1) {
		return k;
	    }

	    int m1 = k;
	    int m2 = (k - 1) * k + k;
	    for (int i = 2; i < n; i++) {
		int next = (k - 1) * (m1 + m2);
		m1 = m2;
		m2 = next;
	    }

	    return m2;
	}
    }
}
