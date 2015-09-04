package math;

import java.util.*;

/**
 * Majority Element II
 * 
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 *
 */

/*
 * Boyer-Moore Majority Vote algorithm
 * 
 * num1 and num2 are not necessarily be the 2 most frequent elements after the
 * 1st round.
 * 
 * Here is why the poster's 2 "majorities" algorithm really works:
 * 
 * consider 3 cases: 1. there are no elements that appears more than n/3 times,
 * then whatever the algorithm got from 1st round wound be rejected in the
 * second round.
 * 
 * 2. there are only one elements that appears more than n/3 times, after 1st
 * round one of the candidates must be that appears more than n/3 times(<2n/3
 * other elements could only pair out for <n/3 times), the other candidates is
 * not necessarily be the second most frequent but it would be rejected in 2nd
 * round.
 * 
 * -> It takes two consecutive distinct elements to reduce num1's count by 1.
 * remember if count2 = 0, then the new number will not cause count1--
 * 
 * 3. there are two elements appears more than n/3 times, candidates would
 * contain both of them. (<n/3 other elements couldn't pair out any of the
 * majorities.)
 */
public class MajorityElementII {
    public class Solution {
	public List<Integer> majorityElement(int[] nums) {
	    Integer num1 = null;
	    Integer num2 = null;
	    int count1 = 0;
	    int count2 = 0;

	    for (int num : nums) {
		if (num1 != null && num == num1) {
		    count1++;
		} else if (num2 != null && num == num2) {
		    count2++;
		} else if (count1 == 0) {
		    num1 = num;
		    count1++;
		} else if (count2 == 0) {
		    num2 = num;
		    count2++;
		} else {
		    count1--;
		    count2--;
		}
	    }

	    count1 = 0;
	    count2 = 0;
	    for (int num : nums) {
		if (num1 != null && num1 == num) {
		    count1++;
		}
		if (num2 != null && num2 == num) {
		    count2++;
		}
	    }

	    List<Integer> res = new ArrayList<>();
	    if (count1 > nums.length / 3) {
		res.add(num1);
	    }
	    if (count2 > nums.length / 3) {
		res.add(num2);
	    }

	    return res;
	}
    }
}
