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
 * 
 * return -(s1 + s2).compareTo(s2 + s1);
 */
public class LargestNumber {
    public class Solution {
	public String largestNumber(int[] nums) {
	    if (nums == null || nums.length == 0) {
		return "";
	    }

	    Integer[] nums2 = new Integer[nums.length];
	    for (int i = 0; i < nums.length; i++) {
		nums2[i] = nums[i];
	    }

	    Arrays.sort(nums2, new Comparator<Integer>() {
		@Override
		public int compare(Integer i1, Integer i2) {
		    String s1 = String.valueOf(i1);
		    String s2 = String.valueOf(i2);
		    return -(s1 + s2).compareTo(s2 + s1);
		}
	    });

	    StringBuilder res = new StringBuilder();
	    for (int i = 0; i < nums2.length; i++) {
		// avoid cases like "00".
		if (res.length() == 0 && nums2[i] == 0 && i < nums2.length - 1 && nums2[i] == nums2[i + 1]) {
		    continue;
		}
		res.append(String.valueOf(nums2[i]));
	    }

	    return res.toString();
	}
    }

}
