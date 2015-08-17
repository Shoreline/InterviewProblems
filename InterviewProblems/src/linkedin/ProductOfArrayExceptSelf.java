package linkedin;

/**
 * Product of Array Except Self
 * 
 * Given an array of n integers where n > 1, nums, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * Follow up: Could you solve it with constant space complexity? (Note: The
 * output array does not count as extra space for the purpose of space
 * complexity analysis.)
 *
 */

/*
 * 由于output[i] = (x0 * x1 * ... * xi-1) * (xi+1 * .... * xn-1)
 * 
 * 因此执行两趟循环：
 * 
 * 第一趟正向遍历数组，计算x0 ~ xi-1的乘积
 * 
 * 第二趟反向遍历数组，计算xi+1 ~ xn-1的乘积
 */
public class ProductOfArrayExceptSelf {
    public class Solution {
	public int[] productExceptSelf(int[] nums) {
	    int[] res = new int[nums.length];
	    int p = 1;
	    for (int i = 0; i < nums.length; i++) {
		res[i] = p;
		p *= nums[i];
	    }

	    p = 1;
	    for (int i = nums.length - 1; i >= 0; i--) {
		res[i] *= p;
		p *= nums[i];
	    }

	    return res;
	}
    }
}
