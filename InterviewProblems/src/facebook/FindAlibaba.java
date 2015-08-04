package facebook;

import java.util.Arrays;

/**
 * 找小偷问题，有n个房间，其中一个房间有小偷。早上我们可以打开一个房间的门看小偷在不在里面，晚
 * 上小偷会向左边或者右边的房间走。现在给你一个开门的sequence，你输出这个sequence能不能保证找到小偷。. 1point 3acres 璁哄潧
 * 比如：如果只有三个房间那么如果打开房间的sequence是{1，1}那么一定会找到小偷。因为如果小偷在中间那么第一天就会被找到，
 * 如果小偷在两边那么第二天一定回来到中间也会被找到。房间数为n，sequence长度为k 跟着我开始brute
 * force假设小偷在某个房间然后dfs所有路径，大概是O（n*n^k）。 考官说好，如果考虑cut branch呢？跟着我就说可以
 * 拿一个n*k的matrix跟着根据sequence来cut
 * branch，reduce到O（n*n*k）。他说有没有可能同时从所有房间开始呢？我说可以跟着直接
 * 在那个n*kmatrix上做一个类似dp的东西。跟着reduce 到 O（n*k）。他说有没有可能把space
 * reduce呢？我说可以我只要O（n）的space. 跟着他就让我再写一个叫nextRow的function来实现O（n）space。
 * 我觉得这题我基本是答得非常漂亮的而且思路很清晰，考官也很开心
 *
 */
public class FindAlibaba {
    /*
     * dp[i][j]: 第i天，第j个房间小偷是否可以survive
     * 
     * dp[i][j] = (dp[i-1][j-1] || dp[i-1][j+1]) && strategy[i] != j
     */
    class Method_DP {
	public boolean findAlibaba(int numCaves, int[] strategy) {
	    int k = strategy.length;

	    // At present day, whether the thief can survive in room j (0<=j<k)
	    boolean[] dp = new boolean[k];
	    Arrays.fill(dp, true);
	    dp[strategy[0]] = false;

	    for (int i = 0; i < k; i++) {
		boolean[] next = new boolean[k];
		boolean canSurvive = false;
		for (int j = 0; j < numCaves; i++) {
		    boolean mayFromLeft = false;
		    boolean mayFromRight = false;

		    mayFromLeft = (j == 0 ? false : dp[j - 1]);
		    mayFromRight = (j == numCaves - 1 ? false : dp[j + 1]);

		    next[j] = (mayFromLeft || mayFromRight)
			    && (strategy[i] != j);

		    canSurvive = canSurvive || next[j];
		}

		if (!canSurvive) {
		    return true;
		}
		dp = next;
	    }

	    return false;
	}
    }

    class Method_BruteForce {
	public boolean findAlibaba(int numCaves, int[] strategy) {

	    for (int i = 0; i < numCaves; i++) {
		if (!dfs(numCaves, strategy, i, 0)) {
		    return false;
		}
	    }

	    return true;
	}

	private boolean dfs(int n, int[] strategy, int pos, int day) {
	    if (day == strategy.length) {
		return false;
	    } else if (strategy[day] == pos) {
		return true;
	    }

	    /*
	     * If we cannot catch Ali at day T, then the only case we can catch
	     * it in future is: dfs returns true no matter Ali goes left or
	     * right in the next round
	     */
	    boolean res = true;
	    if (pos > 0) {
		res &= dfs(n, strategy, pos - 1, day + 1);
	    }
	    if (pos < n - 1) {
		res &= dfs(n, strategy, pos + 1, day + 1);
	    }

	    return res;
	}
    }
}
