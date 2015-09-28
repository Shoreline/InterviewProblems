package string;

/**
 * Shortest Palindrome
 * 
 * Total Accepted: 9657 Total Submissions: 57199 Difficulty: Hard
 * 
 * Given a string S, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 * 
 * For example:
 * 
 * Given "aacecaaa", return "aaacecaaa".
 * 
 * Given "abcd", return "dcbabcd".
 *
 */
public class ShortestPalindrome {
    /*
     * A solution similar to KMP
     */
    public class Solution {
	public String shortestPalindrome(String s) {
	    if (s.length() <= 1)
		return s;
	    String new_s = s + "#" + new StringBuilder(s).reverse().toString();
	    int[] position = new int[new_s.length()];

	    for (int i = 1; i < position.length; i++) {
		int pre_pos = position[i - 1];
		while (pre_pos > 0 && new_s.charAt(pre_pos) != new_s.charAt(i))
		    pre_pos = position[pre_pos - 1];
		position[i] = pre_pos + ((new_s.charAt(pre_pos) == new_s.charAt(i)) ? 1 : 0);
	    }

	    return new StringBuilder(s.substring(position[position.length - 1])).reverse().toString() + s;
	}
    }

    /*
     * TLE for s = "aaaa....aaa' (very long)
     */
    public class Solution_TLE {
	public String shortestPalindrome(String s) {
	    if (s == null) {
		return null;
	    } else if (s.isEmpty()) {
		return "";
	    }

	    String reverse = new StringBuilder(s).reverse().toString();

	    for (int offset = 0; offset < reverse.length(); offset++) {
		int i = 0;
		while (i + offset < reverse.length()) {
		    if (s.charAt(i) != reverse.charAt(i + offset)) {
			break;
		    }
		    i++;
		}

		if (i + offset == reverse.length()) {
		    return reverse.substring(offset, reverse.length() - 1) + s;
		}
	    }

	    return "";
	}
    }
}
