package string;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 */

/*
 * Similar to climbing stairs
 * 
 * Be careful the conditions of legal code, for single digit and double digits.
 * 
 * Easy to forget deal with '0's
 */
public class DecodeWays {

    /*
     * Be careful about how to handle initial status: set them both to 1!
     * 
     * The two if blocks are parallel, not nested.
     */
    public class Solution {
	public int numDecodings(String s) {
	    if (s == null || s.length() == 0 || s.charAt(0) == '0') {
		return 0;
	    }

	    // dp[i]: how many decode ways for i characters.
	    int dp1 = 1; // 0 character
	    int dp2 = 1; // 1 character

	    // dp[i]= dp[i-1] + dp[i-2];
	    for (int i = 1; i < s.length(); i++) {
		int next = 0;
		if (s.charAt(i) != '0') {
		    next = dp1;
		}
		if (s.charAt(i - 1) != '0' && Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
		    next += dp2;
		}
		dp2 = dp1;
		dp1 = next;
	    }

	    return dp1;
	}
    }

    /*
     * High hand's solution.
     * 
     * Scan from the end of String. Only used one 1D array for DP (may reduced
     * to several variables)
     */
    class Solution_highHand {
	public int numDecodings(String s) {
	    if (s == null || s.length() == 0)
		return 0;

	    int len = s.length();
	    int[] dp = new int[len + 1];

	    dp[len] = 1;

	    for (int i = len - 1; i >= 0; i--) {
		if (s.charAt(i) != '0') {
		    dp[i] = dp[i + 1];
		    if (i < len - 1 && Integer.parseInt(s.substring(i, i + 2)) <= 26)
			dp[i] += dp[i + 2];
		}
	    }

	    return dp[0];
	}
    }

    /*
     * TLE for long s
     */
    public class Method_Recursion {
	public int numDecodings(String s) {
	    return dfs(s, 0);
	}

	private int dfs(String s, int pos) {
	    if (s == null || pos == s.length()) {
		return 1;
	    }

	    int res = 0;
	    if (s.charAt(pos) != '0') {
		res += dfs(s, pos + 1);
		if (pos < s.length() - 1 && s.charAt(pos + 1) - '0' <= 6) {
		    res += dfs(s, pos + 2);
		}
	    }
	    return res;
	}
    }

    /*
     * My own dp solution
     * 
     * dp1[i] Decode ways if using the i-th digit as a letter. (the i-th digit
     * is s.charAt(i-1))
     * 
     * dp2[i] Decode ways if using the i-1 and i-th digits as a letter
     * 
     * So the actual returned value is dp1 + dp2
     */
    public class Solution_DP_old {
	public int numDecodings(String s) {
	    if (s == null || s.length() == 0) {
		return 0;
	    }

	    int[] dp1 = new int[s.length() + 1];
	    int[] dp2 = new int[s.length() + 1];
	    dp1[0] = 1;
	    dp2[0] = 0;
	    dp2[1] = 0;

	    for (int i = 1; i <= s.length(); i++) {
		if (s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '9') {
		    dp1[i] = dp1[i - 1] + dp2[i - 1];
		} else {
		    dp1[i] = 0;
		}

		if (i >= 2 && s.charAt(i - 2) != '0' && Integer.valueOf(s.substring(i - 2, i)) <= 26
			&& Integer.valueOf(s.substring(i - 2, i)) >= 1) {
		    dp2[i] = dp1[i - 2] + dp2[i - 2];
		} else {
		    dp2[i] = 0;
		}
	    }

	    return dp1[s.length()] + dp2[s.length()];
	}
    }

    /*
     * the tricky part is 1) how to deal with "10" and "20" 2) get rid of "0"s
     * in the beginning
     */
    class Solution_2013 {
	public int numDecodings(String s) {
	    int result = 0;

	    int i = 0;
	    while (i < s.length() && s.charAt(i) == '0') {
		i++;
	    }
	    s = s.substring(i);

	    if (s.length() == 0) {
		return 0;
	    } else if (s.length() < 2) {
		return 1;
	    }

	    if (s.length() > 1 && Integer.valueOf(s.substring(0, 2)) <= 26) {
		if (s.charAt(1) == '0') {
		    result = numDecodings(s.substring(2));
		}

		result = (1 + numDecodings(s.substring(2))) + numDecodings(s.substring(1));
	    } else {
		result = numDecodings(s.substring(1));
	    }
	    return result;
	}
    }
}
