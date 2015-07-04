package string;

/**
 * Length of Last Word
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 */

public class LengthOfLastWord {
    /*
     * Solution without using any build-in String operation methods
     */
    public class Solution {
	public int lengthOfLastWord(String s) {
	    if (s == null) {
		return 0;
	    }

	    for (int i = s.length() - 1; i >= 0; i--) {
		if (s.charAt(i) != ' ') {
		    int j = i - 1;
		    while (j >= 0 && s.charAt(j) != ' ') {
			j--;
		    }
		    return i - j;
		}
	    }

	    return 0;
	}
    }

    public class Solution2 {
	public int lengthOfLastWord(String s) {

	    if (s == null)
		return 0;

	    s = s.trim();

	    // if here s is empty, then s.split(" ") returns a array of size 0
	    if (s.length() == 0)
		return 0;

	    String[] words = s.split(" ");
	    return (words[words.length - 1].length());
	}
    }
}
