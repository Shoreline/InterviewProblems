package string;

/**
 * Given a Roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999. 
 *
 */

public class RomanToInteger {
    public class Solution {
	public int romanToInt(String s) {
	    if (s == null || s.length() == 0) {
		return 0;
	    }

	    int res = 0;
	    String[] roman = new String[] { "M", "CM", "D", "CD", "C", "XC",
		    "L", "XL", "X", "IX", "V", "IV", "I" };
	    int[] val = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10,
		    9, 5, 4, 1 };

	    int i = 0;
	    while (s.length() > 0 && i < roman.length) {
		if (s.startsWith(roman[i])) {
		    res += val[i];
		    s = s.substring(roman[i].length());
		    continue;
		}
		i++;
	    }

	    return res;
	}
    }
}
