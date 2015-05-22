package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * 
 * For example, words: ["This", "is", "an", "example", "of", "text",
 * "justification."] L: 16.
 * 
 * Return the formatted lines as:
 * 
 * "This    is    an",
 * 
 * "example  of text",
 * 
 * "justification.  "
 * 
 * Note: Each word is guaranteed not to exceed L in length.
 * 
 * Corner Cases: A line other than the last line might contain only one word.
 * What should you do in this case? In this case, that line should be
 * left-justified.
 */

public class TextJustification {

    public class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {
	    List<String> res = new ArrayList<String>();
	    int i = 0;
	    while (i < words.length) {
		int start = i;
		int segLen = 0;
		while (i < words.length
			&& segLen + words[i].length() <= maxWidth) {
		    segLen += words[i].length() + 1;
		    i++;
		}

		int end = i - 1;
		int gapCount = end - start; // end - start + 1 words

		int avgSpace = 0;
		int leftSpace = 0;

		// if more than one word
		if (gapCount > 0) {
		    int spaces = maxWidth - segLen + end - start + 1;
		    avgSpace = spaces / gapCount;
		    leftSpace = spaces % gapCount;
		}

		StringBuilder sb = new StringBuilder();

		// j<end as stop condition: to deal with the last word later
		for (int j = start; j < end; j++) {
		    sb.append(words[j]);
		    if (i == words.length) {
			// no need to insert additional space for the last line
			sb.append(' ');
		    } else {
			for (int k = 0; k < avgSpace; k++) {
			    sb.append(' ');
			}
			if (leftSpace > 0) {
			    sb.append(' ');
			    leftSpace--;
			}
		    }
		}
		sb.append(words[end]);

		for (int k = sb.length(); k < maxWidth; k++) {
		    sb.append(' ');
		}

		res.add(sb.toString());
	    }
	    return res;
	}
    }
}
