package string;

import java.util.ArrayList;

/**
 * ZigZag Conversion
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string text, int nRows);
 * 
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 */

public class ZigZagConversion {
    /*
     * must return s directly if numRows = 1, otherwise step = 0.
     */
    public class Solution {
	public String convert(String s, int numRows) {
	    if (s == null || numRows <= 1) {
		return s;
	    }

	    int step = 2 * numRows - 2;
	    StringBuilder res = new StringBuilder();
	    for (int i = 0; i < numRows; i++) {
		for (int j = i; j < s.length(); j += step) {
		    res.append(s.charAt(j));
		    if (i != 0 && i != numRows - 1 && j + step - 2 * i < s.length()) {
			res.append(s.charAt(j + step - 2 * i));
		    }
		}
	    }

	    return res.toString();
	}
    }

    /*
     * Same idea as solution2. But more concise. The inner for loop can be
     * further simplified, but will reduce readability
     */
    public String convert3(String s, int nRows) {
	if (s == null || s.length() < 2 || nRows == 1) {
	    return s;
	}

	int len = s.length();
	StringBuilder sb = new StringBuilder(len);

	for (int r = 0; r < nRows; r++) {
	    for (int i = r; i < len; i += (2 * nRows - 2)) {
		if (r == 0 || r == nRows - 1) {
		    sb.append(s.charAt(i));
		} else {
		    sb.append(s.charAt(i));
		    int offset = 2 * (nRows - r - 1);
		    if (i + offset < len) {
			sb.append(s.charAt(i + offset));
		    }
		}
	    }
	}

	return sb.toString();
    }

    /*
     * second round. one time pass!
     * 
     * Directly construct the final char array!
     * 
     * time O(n), space O(n)
     */
    public String convert2(String s, int nRows) {

	if (s == null || s.length() < 2 || nRows < 2)
	    return s;

	char[] str = new char[s.length()];

	int i = 0;
	int len = s.length();

	for (int r = 0; r < nRows; r++) {
	    // the first and last row are special, only need to add 1 char/time
	    if (r == 0 || r == nRows - 1) {
		for (int j = r; j < len; j = j + 2 * nRows - 2) {
		    char c = s.charAt(j);
		    str[i] = c;
		    i++;
		}

	    } else {
		// generally, need to add 2 chars/time
		for (int j = r; j < len; j = j + 2 * nRows - 2) {
		    char c = s.charAt(j);
		    str[i] = c;
		    i++;

		    /*
		     * takes nRows-1-r to reach the end, then another nRows-1-r
		     * to go back up
		     */
		    if (j + 2 * (nRows - 1 - r) < len) {
			c = s.charAt(j + 2 * (nRows - 1 - r));
			str[i] = c;
			i++;
		    }
		}

	    }

	}

	return new String(str);
    }

    /*
     * I think the expected String can be constructed directly from s
     */
    public static String convert1(String s, int nRows) {

	if (s == null || s.length() == 0)
	    return "";

	if (nRows == 1)
	    return s;

	// ! step length.
	int stepLength = nRows + nRows - 2;

	StringBuilder result = new StringBuilder();
	for (int k = 0; k < nRows; k++) {
	    for (int i = k; i < s.length();) {
		result.append(s.charAt(i));

		/*
		 * There is no character between each two columns at the first
		 * and last row
		 */
		if (k == 0 || k == nRows - 1) {
		    i = i + stepLength;
		    continue;
		}

		/*
		 * For other rows, the character between two columns needs to be
		 * appended
		 * 
		 * a is the distance from current character to this middle
		 * character
		 */
		int a = nRows - 1 - k + (nRows - 1 - k);
		if (i + a < s.length())
		    result.append(s.charAt(i + a));

		// reach the same row of next column
		i = i + stepLength;

	    }
	}

	return result.toString();
    }

    public String convert0(String s, int nRows) {

	if (s == null || s.length() == 0)
	    return "";

	if (nRows == 1)
	    return s;

	StringBuilder result = new StringBuilder();
	ArrayList<ArrayList<Character>> lists = new ArrayList<ArrayList<Character>>(nRows);

	int i = 0;
	while (i + (nRows) < s.length()) {
	    char c = s.charAt(i);

	    // too complicated. not finished.

	    i++;
	}

	return "";
    }

}
