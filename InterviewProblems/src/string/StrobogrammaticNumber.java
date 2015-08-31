package string;

import java.util.*;

/**
 * Strobogrammatic Number
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Write a function to determine if a number is strobogrammatic. The number is
 * represented as a string.
 * 
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 *
 */
public class StrobogrammaticNumber {
    public class Solution {
	public boolean isStrobogrammatic(String num) {
	    if (num == null || num.length() == 0) {
		return false;
	    }
	    Map<Integer, Integer> map = new HashMap<>();
	    map.put(6, 9);
	    map.put(9, 6);
	    map.put(8, 8);
	    map.put(1, 1);
	    map.put(0, 0);

	    for (int i = 0; i < num.length(); i++) {
		int digit = num.charAt(i) - '0';

		Integer stro = map.get(digit);
		if (stro == null) {
		    return false;
		} else if (num.charAt(num.length() - 1 - i) - '0' != stro) {
		    return false;
		}
	    }

	    return true;
	}
    }
}
