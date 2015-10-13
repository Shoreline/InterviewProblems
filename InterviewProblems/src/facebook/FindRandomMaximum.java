package facebook;

import java.util.Random;

/**
 * find random maximum。就是一个int array 里面会有一到多个maximum，返回一个随机maximum的index
 *
 */
/*
 * reservoir sampling
 * 
 * replace the sampling item with 1/count chance
 */
public class FindRandomMaximum {
    public int find(int[] nums) {
	Random rand = new Random();
	int res = 0;
	int max = Integer.MIN_VALUE;
	int maxCount = 0;
	for (int i = 0; i < nums.length; i++) {
	    if (nums[i] == max) {
		maxCount++;

		if (rand.nextInt(maxCount) == 0) {
		    res = i;
		}
	    }

	    if (nums[i] > max) {
		max = nums[i];
		maxCount = 1;
		res = i;
	    }
	}
	return res;
    }
}
