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
     * Some examples:
     * 
     * isMatch("aa","a") �� false
     * 
     * isMatch("aa","aa") �� true
     * 
     * isMatch("aaa","aa") �� false
     * 
     * isMatch("aa", "a*") �� true
     * 
     * isMatch("aa", ".*") �� true
     * 
     * isMatch("ab", ".*") �� true
     * 
     * isMatch("aab", "c*a*b") �� true
     */

    /*
     * My thoughts: two pointers, starting form the end of each String
     */

    /*
     * A high hand: http://blog.csdn.net/hopeztm/article/details/7992253
     * 
     * ��ʵ���ĵ�˼·��һ����̬�滮
     * 
     * dp[i][j]��ʾ�ִ� s[i...len(s)], p[j...len(p)] �Ƿ����ƥ�䡣
     * 
     * ��ô״̬ת�Ʒ������£�
     * 
     * dp[i][j] =
     * 
     * c1. p[j+1] != *. if s[i] == p[j] dp[i][j] = dp[i+1][j+1]
     * 
     * else dp[i][j] = false
     * 
     * c2 p[j+1] == '*' (�������£�Ҫ��չ *, dp[i][j] ����չ������£�ѡ��һ������Ľ����
     * 
     * if( s[i] == p[j] || p[j] == '.' && (*s) != 0) ��s[i] �� p[j] һ����ʱ������ aba,
     * a*b���ʱ��i = 0, j = 0, ��Ȼ����ƥ��a a
     * 
     * ���p[j] == . ��Ϊ������ƥ���κ��ַ������Ժ���ȹ�ϵ�л���һ���ķ�ʽ��
     * 
     * ����ÿһ��ƥ�䶼Ҫ���� i ��ֵ������г����ģ��򷵻�true������ƥ�����ˣ�����ͨ���ƥ����ɺ�Ľ����
     */

    /*
     * Recursion shall be enough.
     * 
     * many corner cases.
     * 
     * not finished
     */
    public boolean isMatch(String s, String p) {
	if (s == null || p == null) {
	    return false;
	}
	if (p.length() == 0) {
	    return true;
	}

	return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int m, String p, int n) {

	if (m == s.length() && n == p.length()) {
	    return true;
	}

	if (s.charAt(m) == p.charAt(n) || p.charAt(n) == '.') {
	    return isMatch(s, m + 1, p, n + 1);
	} else {
	    if (p.charAt(n) == '*') {
		if (p.length() == n + 1)
		    return true;

	    }
	}

	return false;
    }
}
