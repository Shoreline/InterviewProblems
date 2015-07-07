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
     * 
     * Say there are N numbers within range A to B. The smallest/biggest numbers
     * are of value A and B.If all the rest N-2 numbers distributed evenly then
     * we have the smallest possible maximum gap. These N-2 numbers will form at
     * most N-1 ranges (cut a rope N-2 times you get N-1 pieces)
     * 
     * To evenly cut [A,B] into N-1 buckets, each bucket has size of
     * ceiling[(B-A)/(N-1)].
     */

    public class Solution2 {
	class Bucket {
	    int low;
	    int high;

	    public Bucket(int _low, int _high) {
		this.low = _low;
		this.high = _high;
	    }
	}

	public int maximumGap(int[] nums) {
	    if (nums == null || nums.length < 2) {
		return 0;
	    }

	    int min = Integer.MAX_VALUE;
	    int max = Integer.MIN_VALUE;
	    for (int num : nums) {
		min = Math.min(min, num);
		max = Math.max(max, num);
	    }

	    int size = (int) Math
		    .ceil((double) (max - min) / (nums.length - 1));
	    Bucket[] buckets = new Bucket[nums.length]; // not nums.length-1!
	    // or buckets = new Range[(max - min) / size + 1];

	    for (int num : nums) {
		int k = num / size;
		Bucket bucket = buckets[k];
		if (bucket == null) {
		    bucket = new Bucket(num, num);
		    buckets[k] = bucket;
		} else {
		    bucket.low = Math.min(num, bucket.low);
		    bucket.high = Math.max(num, bucket.high);
		}
	    }

	    // TODO: not sure if preHigh and maxGap have right initial values
	    int preHigh = min;
	    int maxGap = size;
	    for (Bucket bucket : buckets) {
		if (bucket != null) {
		    int gap = bucket.low - preHigh;
		    maxGap = Math.max(gap, maxGap);
		    preHigh = bucket.high;
		}
	    }

	    return maxGap;
	}
    }
}
