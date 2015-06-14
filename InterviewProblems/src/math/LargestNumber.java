package math;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Largest Number
 * 
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of
 * an integer.
 *
 */

/*
 * The idea is to use a custom comparator to sort integers in given array.
 */
public class LargestNumber {
    public class Solution {
	public String largestNumber(int[] nums) {
	    if (nums == null || nums.length == 0) {
		return "";
	    }

	    // not graceful
	    Integer[] tmp = new Integer[nums.length];
	    for (int i = 0; i < nums.length; i++) {
		tmp[i] = nums[i];
	    }

	    Comparator<Integer> comp = new Comparator<Integer>() {
		public int compare(Integer i1, Integer i2) {
		    String s1 = String.valueOf(i1);
		    String s2 = String.valueOf(i2);
		    return -(s1 + s2).compareTo(s2 + s1);
		    
		    // below method works, but not as simple
		    // Long comp = Long.parseLong(s1 + s2)
		    // - Long.parseLong(s2 + s1);
		    // if (comp == 0) {
		    // return 0;
		    // } else {
		    // return comp > 0 ? -1 : 1;
		    // }
		}
	    };

	    Arrays.sort(tmp, comp);
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < tmp.length; i++) {
		sb.append(tmp[i]);
	    }

	    if (sb.charAt(0) == '0') {
		sb.setLength(1);
	    }

	    return sb.toString();
	}

    }
}
