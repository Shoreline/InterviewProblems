package string;

import java.util.Set;

/**
 * Word Break
 * 
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 *
 */

/*
 * I think the two solutions, DP or not, cost same resource.
 * 
 * The normal solution is more straightforward.
 */
public class WordBreak {
    /*
     * DP. Time O(N^2); space O(N)
     * 
     * dp[i] defines whether there is a perfect word break ends for the first i
     * characters.
     * 
     * So only if any dp[j] == true && dict.contains(s.substring(j,i)) then d[i]
     * is true | 0<=j<i
     * 
     * The DP array size is s.length() + 1 since we need to include the case
     * when zero character of s is included
     */
    public class Solution {
	public boolean wordBreak(String s, Set<String> dict) {
	    if (s == null || s.length() == 0) {
		return true;
	    } else if (dict == null || dict.size() == 0) {
		return false;
	    }

	    boolean[] dp = new boolean[s.length() + 1];
	    dp[0] = true;

	    for (int i = 1; i <= s.length(); i++) {
		for (int j = 0; j < i; j++) {
		    String piece = s.substring(j, i);

		    if (dict.contains(piece) && dp[j]) {
			dp[i] = true;
			break;
		    }
		}
	    }

	    return dp[dp.length - 1];
	}
    }

    /*
     * Also passed LeetCode judge.
     */
    public class Solution_normal {
	public boolean wordBreak(String s, Set<String> wordDict) {
	    if (s == null || s.length() == 0) {
		return true;
	    }

	    boolean[] breakable = new boolean[s.length() + 1];
	    breakable[0] = true;

	    for (int i = 0; i < s.length(); i++) {
		if (!breakable[i]) {
		    continue;
		}

		for (int j = i + 1; j <= s.length(); j++) {
		    String word = s.substring(i, j);
		    if (wordDict.contains(word)) {
			breakable[j] = true;
		    }
		}
	    }

	    return breakable[breakable.length - 1];
	}
    }
}
