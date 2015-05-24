package string;

/**
 * Reverse Words In a String II
 * 
 * Given an input string, reverse the string word by word. A word is defined as
 * a sequence of non-space characters.
 * 
 * The input string does not contain leading or trailing spaces and the words
 * are always separated by a single space.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 *
 */
/*
 * 1) reverse the whole String: "eulb si yks eht"; 2) reverse each space
 * separated piece: "blue is sky the".
 */
public class ReverseWordsInAStringII {
    public class Solution {
	public void reverseWords(char[] s) {
	    if (s == null || s.length == 0) {
		return;
	    }

	    swap(s, 0, s.length - 1);

	    int start = 0;
	    int end = 0;
	    while (end < s.length) {
		if ((end < s.length - 1 && s[end + 1] == ' ')
			|| end == s.length - 1) {
		    swap(s, start, end);
		    start = end + 2;
		}
		end++;
	    }
	}

	private void swap(char[] s, int start, int end) {
	    for (int i = 0; start + i < end - i; i++) {
		char tmp = s[start + i];
		s[start + i] = s[end - i];
		s[end - i] = tmp;
	    }
	}
    }
}
