package math;

/**
 * Paint Fence
 * 
 * There is a fence with n posts, each post can be painted with one of the k
 * colors.
 * 
 * You have to paint all the posts such that no more than two adjacent fence
 * posts have the same color.
 * 
 * Return the total number of ways you can paint the fence.
 * 
 * Note: n and k are non-negative integers.
 *
 */
/*
 * DP
 * 
 * dp[i] = (k-1) * (dp[i-1] + dp[i-2]) // same color as previous post; or different color as previous post
 */
public class PaintFence {
    public class Solution {
	public int numWays(int n, int k) {
	    if (n == 0 || k == 0) {
		return 0;
	    } else if (n == 1) {
		return k;
	    }

	    int m1 = k; // if there is 1 post, k possible ways
	    int m2 = (k - 1) * k + k; // 2 posts: 1) different colors: k*(k-1); 2) same color: k
	    for (int i = 2; i < n; i++) {
		int next = (k - 1) * (m1 + m2);
		m1 = m2;
		m2 = next;
	    }

	    return m2;
	}
    }
}
