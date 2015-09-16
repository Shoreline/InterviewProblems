package math;

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
	    if (numerator == 0) {
		return "0";
	    }

	    StringBuilder res = new StringBuilder();
	    boolean isNeg = (numerator > 0) ^ (denominator > 0);
	    if (isNeg) {
		res.append('-');
	    }
	    // use long to avoid Integer overflow
	    long nu = Math.abs((long) numerator);
	    long de = Math.abs((long) denominator);

	    res.append(String.valueOf(nu / de));

	    if (nu % de == 0) {
		return res.toString();
	    }

	    res.append('.');
	    // <某余数, 其在res字符串首次出现位置》
	    Map<Long, Integer> seen = new HashMap<>();
	    nu %= de;
	    while (nu != 0 && !seen.containsKey(nu)) {
		res.append(String.valueOf(nu * 10 / de));
		seen.put(nu, res.length() - 1);
		nu = (nu * 10) % de;
	    }

	    if (nu == 0) {
		return res.toString();
	    }

	    res.insert(seen.get(nu), "(");
	    res.append(')');
	    return res.toString();
	}
    }

}
