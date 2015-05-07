package array;

/**
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * You may assume all elements in the array are non-negative integers and fit in
 * the 32-bit signed integer range.
 *
 */

public class MaximumGap {
    /*
     * Bucket sort
     */
    public class Solution {
	class Range {
	    int low;
	    int high;

	    public Range(int _low, int _high) {
		low = _low;
		high = _high;
	    }
	}

	public int maximumGap(int[] nums) {
	    if (nums == null || nums.length < 2) {
		return 0;
	    }

	    int max = nums[0];
	    int min = nums[0];
	    for (int i = 1; i < nums.length; i++) {
		max = nums[i] > max ? nums[i] : max;
		min = nums[i] < min ? nums[i] : min;
	    }

	    int size = (int) Math
		    .ceil((double) (max - min) / (nums.length - 1));
	    Range[] buckets = new Range[(max - min) / size + 1];
	    for (int i = 0; i < nums.length; i++) {
		int k = (nums[i] - min) / size;
		Range r = buckets[k];
		if (r == null) {
		    buckets[k] = new Range(nums[i], nums[i]);
		} else {
		    r.low = nums[i] < r.low ? nums[i] : r.low;
		    r.high = nums[i] > r.high ? nums[i] : r.high;
		}
	    }

	    int maxGap = 0;
	    Range pre = null;
	    for (int i = 0; i < buckets.length; i++) {
		if (buckets[i] == null) {
		    continue;
		} else if (pre == null) {
		    maxGap = buckets[i].high - buckets[i].low;
		    pre = buckets[i];
		} else {
		    int gap = buckets[i].low - pre.high;
		    maxGap = maxGap > gap ? maxGap : gap;
		    pre = buckets[i];
		}
	    }
	    return maxGap;
	}
    }
}
