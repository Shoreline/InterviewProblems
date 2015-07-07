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
 * why n-- in each while loop?
 * 
 * Because the smallest digit in this special 26-进制 mechanism is 1 instead of 0.
 */
public class ExcelSheetColumnTitle {
    public class Solution {
	public String convertToTitle(int n) {
	    StringBuilder sb = new StringBuilder();

	    while (n > 0) {
		n--;
		sb.append((char) ('A' + n % 26));
		n /= 26;
	    }

	    return sb.reverse().toString();
	}
    }
}
