package bit;

/**
 * Single Number III
 * 
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 * 
 * For example:
 * 
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * Note: The order of the result is not important. So in the above example, [5,
 * 3] is also correct. Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant space complexity?
 *
 */
/*
 * 如果对所有元素进行异或操作，最后剩余的结果是出现次数为1次的两个数的异或结果，此时无法直接得到这两个数具体的值。但是，因为这两个数一定是不同的，
 * 所以最终异或的值至少有一个位为1。我们可以找出异或结果中第一个值为1的位，然后根据该位的值是否为1，将数组中的数，分成两组。这样每组就可以采用Single
 * number I中的方法得到只出现一次的数
 */
public class SingleNumberIII {
    public class Solution {
	public int[] singleNumber(int[] nums) {
	    if (nums.length == 2) {
		return nums;
	    }

	    int val = 0;
	    for (int num : nums) {
		val ^= num;
	    }

	    int bit = 0;
	    while (bit < 32) {
		if (((val >> bit) & 1) == 1) { // find the first '1' from left
		    break;
		}
		bit++;
	    }

	    int[] res = new int[2];
	    for (int num : nums) {
		if (((num >> bit) & 1) == 1) {
		    res[0] ^= num;
		} else {
		    res[1] ^= num;
		}
	    }
	    return res;
	}
    }
}
