package array;

/**
 * Dungeon Game
 * 
 * The demons had captured the princess (P) and imprisoned her in the
 * bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid
 * out in a 2D grid. Our valiant knight (K) was initially positioned in the
 * top-left room and must fight his way through the dungeon to rescue the
 * princess.
 * 
 * The knight has an initial health point represented by a positive integer. If
 * at any point his health point drops to 0 or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons, so the knight loses health (negative
 * integers) upon entering these rooms; other rooms are either empty (0's) or
 * contain magic orbs that increase the knight's health (positive integers).
 * 
 * In order to reach the princess as quickly as possible, the knight decides to
 * move only rightward or downward in each step.
 * 
 * 
 * Write a function to determine the knight's minimum initial health so that he
 * is able to rescue the princess.
 * 
 * For example, given the dungeon below, the initial health of the knight must
 * be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * 
 * 	-2 (K)	-3	3
	-5	-10	1
	10	30	-5 (P)
 * 
 * Notes:
 * 
 * The knight's health has no upper bound. Any room can contain threats or
 * power-ups, even the first room the knight enters and the bottom-right room
 * where the princess is imprisoned.
 *
 */

/*
 * DP from bottom right corner.
 * 
 * dp[i][j]: the lowest HP needed to reach (m-1,n-1) from (i,j).
 * 
 * dp[i][j] = Math.max( Math.min(dp[i+1][j],dp[i][j+1]) - dungeon[i][j], 0 );
 * 
 * For point (i,j), pick the route needs smaller HP from (i+1,j) and (i,j+1). If
 * at point (i,j) there is a orb to heal, the hero needs even less HP (minus
 * positive), other wise needs more (minus negative)
 */
public class DungeonGame {
    public class Solution {
	public int calculateMinimumHP(int[][] dungeon) {
	    if (dungeon == null || dungeon.length == 0
		    || dungeon[0].length == 0) {
		return -1;
	    }

	    int m = dungeon.length;
	    int n = dungeon[0].length;
	    int[][] dp = new int[m][n];

	    dp[m - 1][n - 1] = Math.max(-dungeon[m - 1][n - 1], 0);

	    for (int i = m - 2; i >= 0; i--) {
		dp[i][n - 1] = Math
			.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 0);
	    }
	    for (int j = n - 2; j >= 0; j--) {
		dp[m - 1][j] = Math
			.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 0);
	    }

	    for (int i = m - 2; i >= 0; i--) {
		for (int j = n - 2; j >= 0; j--) {
		    dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1])
			    - dungeon[i][j], 0);
		}
	    }

	    return dp[0][0] + 1;
	}
    }

    /*
     * The DP solution of this problem cannot start from the top left corner
     */
    public class Wrong_Attempt {

	public int calculateMinimumHP(int[][] dungeon) {
	    if (dungeon == null || dungeon.length == 0
		    || dungeon[0].length == 0) {
		return -1;
	    }

	    int[][] dp = new int[dungeon.length][dungeon[0].length];

	    int lowest = Integer.MAX_VALUE;
	    for (int i = 0; i < dungeon.length; i++) {
		for (int j = 0; j < dungeon[0].length; j++) {
		    if (i == 0 && j == 0) {
			dp[i][j] = dungeon[i][j];
		    } else if (i == 0) {
			dp[i][j] = dp[i][j - 1] + dungeon[i][j];
		    } else if (j == 0) {
			dp[i][j] = dp[i - 1][j] + dungeon[i][j];
		    } else {
			dp[i][j] = dungeon[i][j]
				+ Math.max(dp[i - 1][j], dp[i][j - 1]);
		    }

		    lowest = Math.min(lowest, dp[i][j]);
		}
	    }

	    return lowest >= 0 ? 1 : -lowest + 1;
	}
    }

    /*
     * DFS, Time limit exceeded
     */
    public class Method_DFS {
	int bestRoute = Integer.MIN_VALUE;

	public int calculateMinimumHP(int[][] dungeon) {
	    if (dungeon == null || dungeon.length == 0
		    || dungeon[0].length == 0) {
		return -1;
	    }

	    dfs(dungeon, 0, 0, 0, Integer.MAX_VALUE);
	    return bestRoute >= 0 ? 1 : -bestRoute + 1;
	}

	private void dfs(int[][] dungeon, int i, int j, int hp, int lowest) {
	    if (i >= dungeon.length || j >= dungeon[0].length) {
		return;
	    } else if (i == dungeon.length - 1 && j == dungeon[0].length - 1) {
		bestRoute = Math.max(bestRoute, lowest);
		return;
	    }

	    hp += dungeon[i][j];
	    lowest = Math.min(lowest, hp);

	    dfs(dungeon, i + 1, j, hp, lowest);
	    dfs(dungeon, i, j + 1, hp, lowest);
	}
    }
}
