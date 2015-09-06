package string;

import java.util.*;

/**
 * Strobogrammatic Number III
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Write a function to count the total strobogrammatic numbers that exist in the
 * range of low <= num <= high.
 * 
 * For example, Given low = "50", high = "100", return 3. Because 69, 88, and 96
 * are three strobogrammatic numbers.
 * 
 * Note: Because the range might be a large number, the low and high numbers are
 * represented as string.
 *
 */
public class StrobogrammaticNumberIII {
    public int strobogrammaticInRange(String low, String high) {

	TreeMap<Integer, Integer> map = new TreeMap<>();
	map.put(0, 0);
	map.put(1, 1);
	map.put(6, 9);
	map.put(8, 8);
	map.put(9, 6);

	int sum = 0;
	for (int i = low.length() + 1; i < high.length(); i++) {
	    sum += getStroNumForLength(i);
	}

	return 0;
    }

    // wrong: O cannot be put at the beginning
    private int getStroNumForLength(int i) {
	if (i % 2 == 0) {
	    return (int) Math.pow(5, i % 2);
	} else {
	    // 3: three cases of 0, 1, 8
	    return (int) (3 * Math.pow(5, i % 2));
	}
    }
}
