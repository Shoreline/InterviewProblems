package string;

/**
 * Given a Roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 */

/*
 * Similar to integer to roman
 */
public class RomanToInteger {
    public class Solution {
	public int romanToInt(String s) {
	    int integers[] = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	    String romans[] = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	    int i = 0;
	    int pos = 0;
	    int res = 0;
	    while (pos < s.length()) {
		if (s.startsWith(romans[i], pos)) {
		    res += integers[i];
		    pos += romans[i].length();
		} else {
		    i++;
		}
	    }
	    return res;
	}
    }
}
