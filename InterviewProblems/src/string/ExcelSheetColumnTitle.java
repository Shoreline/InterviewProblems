package string;

/**
 * Excel Sheet Column Title
 * 
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A
 * 
 * 2 -> B
 * 
 * 3 -> C
 * 
 * ...
 * 
 * 26 -> Z
 * 
 * 27 -> AA
 * 
 * 28 -> AB
 *
 */

/*
 * why use n-1 instead of n?
 */
public class ExcelSheetColumnTitle {
    public class Solution {
	public String convertToTitle(int n) {
	    StringBuilder sb = new StringBuilder();

	    while (n > 0) {
		sb.append((char) ('A' + (n - 1) % 26));
		n = (n - 1) / 26;
	    }

	    return sb.reverse().toString();
	}
    }
}
