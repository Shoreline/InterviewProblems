package string;

/**
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * Update (2015-02-12): For C programmers: Try to solve it in-place in O(1)
 * space.
 * 
 * click to show clarification.
 * 
 * Clarification: What constitutes a word? -A sequence of non-space characters
 * constitutes a word.
 * 
 * Could the input string contain leading or trailing spaces? -Yes. However,
 * your reversed string should not contain leading or trailing spaces.
 * 
 * How about multiple spaces between two words? -Reduce them to a single space
 * in the reversed string.
 *
 */

/*
 * Another way: 1) reverse the whole String: "eulb si yks eht"; 2) reverse each
 * space separated piece: "blue is sky the".
 */
public class ReverseWordsInAString {
    /*
     * "  ".split(" ") is a String array that has two "" Strings.
     */
    public class Solution {
	public String reverseWords(String s) {
	    if (s == null || s.length() == 0) {
		return s;
	    }

	    String[] subStrings = s.split(" ");
	    StringBuilder res = new StringBuilder();
	    for (int i = subStrings.length - 1; i >= 0; i--) {
		if (!subStrings[i].isEmpty()) {
		    res.append(subStrings[i]);
		    res.append(" ");
		}
	    }
	    // res.setLength(res.length()-1); error if res is empty
	    return res.toString().trim();
	}
    }
}
