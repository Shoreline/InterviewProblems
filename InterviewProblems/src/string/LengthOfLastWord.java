package string;

public class LengthOfLastWord {
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

    // second round
    public int lengthOfLastWord(String s) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (s == null)
	    return 0;

	s = s.trim();

	if (s.length() == 0)
	    return 0;

	String[] haha = s.split(" ");
	return (haha[haha.length - 1].length());
    }

    // first round
    public int lengthOfLastWord1(String s) {
	if (s == null || s.length() == 0) {
	    return 0;
	}

	String[] words = s.split(" ");

	// corner case
	if (words.length < 1) {
	    return 0;
	}

	return words[words.length - 1].length();
    }
}
