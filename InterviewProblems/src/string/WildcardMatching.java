package string;

public class WildcardMatching {
    /**
     * Wildcard Matching
     * 
     * Implement wildcard pattern matching with support for '?' and '*'.
     * 
     * '?' Matches any single character.
     * 
     * '*' Matches any sequence of characters (including the empty sequence).
     * 
     * The matching should cover the entire input string (not partial).
     * 
     * The function prototype should be:
     * 
     * bool isMatch(const char *s, const char *p)
     * 
     * Some examples:
     * 
     * isMatch("aa","a") ¡ú false
     * 
     * isMatch("aa","aa") ¡ú true
     * 
     * isMatch("aaa","aa") ¡ú false
     * 
     * isMatch("aa", "*") ¡ú true
     * 
     * isMatch("aa", "a*") ¡ú true
     * 
     * isMatch("ab", "?*") ¡ú true
     * 
     * isMatch("aab", "c*a*b") ¡ú false
     */
    /*
     * Both s and p can contain '*' and/or '?'
     * 
     * DP: http://blog.csdn.net/linhuanmars/article/details/21198049
     * http://m4tiku.duapp.com/report?pid=123
     */
    
    /*
     * very tricky
     * 
     * shall use a dp[lenS+1][lenS+1] 2d array.
     * 
     * if only use 
     */
    public class Solution {
	public boolean isMatch(String s, String p) {
	    boolean[] preFlag = new boolean[s.length() + 1];
	    boolean[] curFlag = new boolean[s.length() + 1];
	    int minCount = 0;
	    for (int i = 0; i < p.length(); i++) {
		if (p.charAt(i) != '*') {
		    minCount++;
		}
	    }
	    if (minCount > s.length()) {
		return false;
	    }
	    /*
	     * since use rolling array to reduce space cost -> cannot initialize
	     * boundary conditions of a 2D dp array have to deal with boundary
	     * conditions with if
	     */

	    // important: the fist 0 char of s matches the first 0 char of p: ""
	    // matches ""
	    preFlag[0] = true;
	    
	    /* first loop only scan lenP times, not lenP+1 times,
	     * because preFlag[] is equivalent to doing one scan
	     * */
	    
	    for (int i = 0; i < p.length(); i++) {
		for (int j = 0; j < s.length() + 1; j++) {
		    if (p.charAt(i) == '?') {
			curFlag[j] = j == 0 ? false : preFlag[j - 1];
		    } else if (p.charAt(i) == '*') {
			curFlag[j] = j == 0 ? preFlag[j]
				: (preFlag[j] || curFlag[j - 1]); // check j-1 not j!
		    } else {
			curFlag[j] = (j == 0 || p.charAt(i) != s.charAt(j - 1)) ? false
				: preFlag[j - 1];
		    }
		}
		boolean[] temp = preFlag;
		preFlag = curFlag;
		curFlag = temp;
	    }
	    return preFlag[s.length()];
	}
    }

}
