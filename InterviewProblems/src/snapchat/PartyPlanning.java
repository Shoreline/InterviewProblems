package snapchat;

/*
 * http://massivealgorithms.blogspot.com/2015/08/tyvj-p1052-wikioi-1380-dp-yutians-blog.html
 * 
 * DP
 * 
 * k1, k2,..., kn are children of node i
 * 
 * 1) if i goes to party:
 * dp[i][0]: sum( Math.max(dp[k1][0], dp[k1][1]) + Math.max(dp[k2][0], dp[k2][1]) + ...)
 * 
 * 2) if i does not go to party: 
 * dp[i][1]: happy[i] + sum( dp[k1][0] + dp[k2][0] + ...)
 */
public class PartyPlanning {
    class Method {

    }
}
