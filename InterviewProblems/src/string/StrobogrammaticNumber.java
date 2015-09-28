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

/*
 * Unlike isPalindrom(), need to check the middle digit if num has odd number of
 * digits
 */
public class StrobogrammaticNumber {
    public class Solution {
	public boolean isStrobogrammatic(String num) {
	    if (num == null || num.isEmpty()) {
		return false;
	    }
	    Map<Integer, Integer> map = new HashMap<>();
	    map.put(0, 0);
	    map.put(1, 1);
	    map.put(6, 9);
	    map.put(8, 8);
	    map.put(9, 6);

	    // i <= len/2. not usually < len/2
	    for (int i = 0; i <= num.length() / 2; i++) {
		int d1 = num.charAt(i) - '0';
		int d2 = num.charAt(num.length() - 1 - i) - '0';
		if (!map.containsKey(d1) || map.get(d1) != d2) {
		    return false;
		}
	    }

	    return true;
	}
    }
}
