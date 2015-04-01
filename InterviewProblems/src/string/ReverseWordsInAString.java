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
 * Clarification: 
 * What constitutes a word? 
 * -A sequence of non-space characters constitutes a word. 
 * 
 * Could the input string contain leading or trailing spaces?  
 * -Yes. However, your reversed string should not contain leading or trailing spaces. 
 * 
 * How about multiple spaces between two words? 
 * -Reduce them to a single space in the reversed string.
 *
 */

/*
 * Another way:
 * 1) reverse the whole String: "eulb si yks eht";
 * 2) reverse each space separated piece: "blue is sky the".
 */
public class ReverseWordsInAString {
    /*
     * "  ".split(" ") is a String array that has two "" Strings.
     */
    public class Solution {
	public String reverseWords(String s) {
	    if (s == null) {
		return s;
	    }

	    String[] strArray = s.split(" ");
	    StringBuilder sb = new StringBuilder();
	    for (int i = strArray.length - 1; i >= 0; i--) {
		if (strArray[i].length() == 0) {
		    continue;
		}
		sb.append(strArray[i].trim());
		sb.append(' ');
	    }

	    return sb.toString().trim();
	}
    }
}
