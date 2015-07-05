package string;

/**
 * Scramble String
 * 
 * Given a string s1, we may represent it as a binary tree by partitioning it to
 * two non-empty substrings recursively.
 * 
 * Below is one possible representation of s1 = "great":
 * 
 * great / \ gr eat / \ / \ g r e at / \ a t To scramble the string, we may
 * choose any non-leaf node and swap its two children.
 * 
 * For example, if we choose the node "gr" and swap its two children, it
 * produces a scrambled string "rgeat".
 * 
 * rgeat / \ rg eat / \ / \ r g e at / \ a t We say that "rgeat" is a scrambled
 * string of "great".
 * 
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it
 * produces a scrambled string "rgtae".
 * 
 * rgtae / \ rg tae / \ / \ r g ta e / \ t a We say that "rgtae" is a scrambled
 * string of "great".
 * 
 * Given two strings s1 and s2 of the same length, determine if s2 is a
 * scrambled string of s1.
 */

/*
 * http://blog.csdn.net/linhuanmars/article/details/24506703
 * 
 * 3D dynamic programming, very hard. Time O(N^4), space O(N^3)
 * 
 * Two scrable Strings must have the same length.
 * 
 * res[i][j][len]表示的是以i和j分别为s1和s2起点的长度为len的字符串是不是互为scramble
 * 
 * If s1 and s2 are scramble, the there must exist k, 1<k<s1.length(), that
 * makes that either 1) s1.substring(0,k) is scrabmle with s2.substring(0,k) AND
 * s1.substring(k,s1.length()) is scramble with s2.substring(k,s2.length()); or
 * 2) Scramble[ s1.substring(0,k), s2,substring(k, s2.length()] AND Scramble[
 * s1.substring(k,s1.length()), s2,substring(0,k) ]
 * 
 * res[i][j][len] |= (res[i][j][k]&&res[i+k][j+k][len-k] ||
 * res[i][j+len-k][k]&&res[i+k][j][len-k]) 对于所有1<=k<len
 */

public class ScrambleString {
    /*
     * start at index i, the substring can have at most s.length() -1 -i +1
     * length. (s.length() - 1 is the index of last character; the substring
     * that [i, s.length()-1] has size of s.length() -1 -i +1). So len<=
     * s1.length() - i
     */
    public class Solution {
	public boolean isScramble(String s1, String s2) {
	    if (s1 == null || s2 == null || s1.length() != s2.length())
		return false;

	    boolean[][][] res = new boolean[s1.length()][s2.length()][s1
		    .length() + 1];
	    for (int i = 0; i < s1.length(); i++) {
		for (int j = 0; j < s2.length(); j++) {
		    res[i][j][1] = s1.charAt(i) == s2.charAt(j);
		}
	    }
	    for (int len = 2; len <= s1.length(); len++) {
		for (int i = 0; i <= s1.length() - len; i++) {
		    for (int j = 0; j <= s2.length() - len; j++) {
			for (int k = 1; k < len; k++) {
			    res[i][j][len] |= (res[i][j][k] && res[i + k][j + k][len
				    - k])
				    || (res[i][j + len - k][k] && res[i + k][j][len
					    - k]);
			}
		    }
		}
	    }
	    return res[0][0][s1.length()];
	}
    }
}
