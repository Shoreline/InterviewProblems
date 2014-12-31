package string;

import java.util.ArrayList;

public class TextJustification {
    /**
     * Given an array of words and a length L, format the text such that each
     * line has exactly L characters and is fully (left and right) justified.
     * 
     * You should pack your words in a greedy approach; that is, pack as many
     * words as you can in each line. Pad extra spaces ' ' when necessary so
     * that each line has exactly L characters.
     * 
     * Extra spaces between words should be distributed as evenly as possible.
     * If the number of spaces on a line do not divide evenly between words, the
     * empty slots on the left will be assigned more spaces than the slots on
     * the right.
     * 
     * For the last line of text, it should be left justified and no extra space
     * is inserted between words.
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
     * Corner Cases: A line other than the last line might contain only one
     * word. What should you do in this case? In this case, that line should be
     * left-justified.
     */

    /*
     * Lots of places can easily go wrong
     */
    public static ArrayList<String> fullJustify(String[] words, int L) {
	ArrayList<String> result = new ArrayList<String>();

	for (int i = 0; i < words.length; i++) {
	    StringBuilder aLine = new StringBuilder();
	    int wordsLength = 0;
	    int wordsNum = 0;
	    while (i < words.length && wordsLength + words[i].length() <= L) {

		wordsLength += words[i].length() + 1;
		wordsNum++;
		i++;
	    }
	    i--;

	    int spaceNum = L - (wordsLength - 1);

	    if (i == words.length - 1) {
		for (int j = i - wordsNum + 1; j <= i - 1; j++) {
		    aLine.append(words[j]);
		    aLine.append(' ');
		}
		aLine.append(words[i]);
		for (int j = 0; j < spaceNum; j++) {
		    aLine.append(' ');
		}
		result.add(aLine.toString());
		return result;
	    }

	    if (wordsNum == 1) {
		aLine.append(words[i]);
		for (int j = 0; j < spaceNum; j++) {
		    aLine.append(' ');
		}
		result.add(aLine.toString());
		continue;
	    }

	    int p = spaceNum / (wordsNum - 1);
	    int q = spaceNum % (wordsNum - 1);

	    for (int j = i - wordsNum + 1; j <= i - 1; j++) {
		aLine.append(words[j]);
		aLine.append(' ');
		for (int m = 0; m < p; m++) {
		    aLine.append(' ');
		}
		if (q > 0) {
		    aLine.append(' ');
		    q--;
		}
	    }
	    aLine.append(words[i]);
	    result.add(aLine.toString());

	}

	return result;
    }
}
