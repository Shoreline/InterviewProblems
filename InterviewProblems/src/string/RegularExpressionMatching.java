package string;

public class RegularExpressionMatching {
    /**
     * Implement regular expression matching with support for '.' and '*'.
     * 
     * '.' Matches any single character.
     * 
     * '*' Matches zero or more of the preceding element.
     * 
     * The matching should cover the entire input string (not partial).
     * 
     * The function prototype should be: bool isMatch(const char *s, const char
     * *p)
     * 
     * Some examples: isMatch("aa","a") 鈫�false 
     * isMatch("aa","aa") 鈫�true
     * isMatch("aaa","aa") 鈫�false 
     * isMatch("aa", "a*") 鈫�true 
     * isMatch("aa", ".*") 鈫�true 
     * isMatch("ab", ".*") 鈫�true 
     * isMatch("aab", "c*a*b") 鈫�true
     */

    /*
     * DP: http://blog.csdn.net/linhuanmars/article/details/21145563 
     * 
     */
    
    
    /*
     * Understand the problem correctly. '*' means the number of the character
     * ahead of it, can be 0 to N
     * 
     * '\0' (char c = 0) is a special control char, use it for null
     * 
     * corner case: s = "", p = "a*b*c*"; they still match
     */
    class solution2 {
	public boolean isMatch(String s, String p) {
	    if ((s == null && p == null) || s.length() == 0 && p.length() == 0) {
		return true;
	    }

	    if (p.length() == 0 && s.length() > 0) {
		return false;
	    }

	    char s0 = (s.length() > 0 ? s.charAt(0) : 0);
	    char p0 = p.charAt(0);
	    char p1 = (p.length() > 1 ? p.charAt(1) : 0);

	    if (p1 == '*') {
		if (isMatch(s, p.substring(2))) {
		    return true;
		}

		int i = 0;
		while (i < s.length() && (p0 == '.' || p0 == s.charAt(i))) {
		    if (isMatch(s.substring(i + 1), p.substring(2))) {
			return true;
		    }
		    i++;
		}

		return false;
	    } else if (s.length() != 0 && (p0 == '.' || p0 == s0)) {
		return isMatch(s.substring(1), p.substring(1));
	    } else {
		return false;
	    }
	}
    }

}
