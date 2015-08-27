package uber;

import java.util.Arrays;

/**
 * 给予不同面值的硬币若干种种（每种硬币个数无限多），用若干种硬币组合为某种面额的钱，使硬币的的个数最少
 * 
 * note: If 1 is not an available denomination, it is possible that for some
 * amount of money there is no solution
 */
/*
 * DP:
 * 
 * MIN[i] = min{MIN[i-Vj]+1}. 其中i表示要凑i枚硬币，Vj表示第j枚硬币的面值, 且i-Vj必须大于0
 */
public class MinCoins {
    class Method {
	public int getMinCoin(int[] denominations, int money) {
	    int[]dp = new int[money+1];
	    Arrays.fill(dp, -1);
	    dp[0] = 0;
	    
	    for(int i = 1; i<=money; i++){
		for(int d: denominations){
		    if( i >= d && dp[i - d]!=-1){
			int amount = dp[i-d] + 1;
			dp[i]= (dp[i]==-1? amount: Math.min(dp[i],amount));
		    }
		}
	    }
	    
	    return dp[money];
	}
    }
}
