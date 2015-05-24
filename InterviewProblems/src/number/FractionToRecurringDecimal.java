package number;

import java.util.HashMap;
import java.util.Map;

/**
 * Fraction to Recurring Decimal 
 * 
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * For example,
 * 
 * Given numerator = 1, denominator = 2, return "0.5".
 * 
 * Given numerator = 2, denominator = 1, return "2".
 * 
 * Given numerator = 2, denominator = 3, return "0.(6)".
 *
 */

public class FractionToRecurringDecimal {
    /*
     * mimic manually divide.
     */
    public class Solution {
	public String fractionToDecimal(int numerator, int denominator) {
	    // the only case the result can be 0
	    if (numerator == 0) {
		return "0";
	    }

	    // use long to avoid Integer overflow
	    boolean sign = (numerator < 0) ^ (denominator < 0);
	    long num = Math.abs((long) numerator);
	    long denom = Math.abs((long) denominator);

	    StringBuilder sb = new StringBuilder();
	    if (sign) {
		sb.append("-");
	    }

	    sb.append(String.valueOf(num / denom));
	    num %= denom;
	    if (num == 0) {
		return sb.toString();
	    }

	    sb.append('.');
	    // 循环体在字符串首次出现的位置
	    Map<Long, Integer> map = new HashMap<Long, Integer>();

	    int i = sb.length();
	    while (num != 0 && !map.containsKey(num)) {
		map.put(num, i); 
		num *= 10; // important

		sb.append(String.valueOf((num / denom)));

		num %= denom;
		i++;
	    }

	    if (num == 0) {
		return sb.toString();
	    }

	    sb.insert(map.get(num), "(");
	    sb.append(')');
	    return sb.toString();
	}
    }
}
