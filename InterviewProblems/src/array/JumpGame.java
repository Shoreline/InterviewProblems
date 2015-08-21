package array;

/**
 * Jump Game
 * 
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example: A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 */

public class JumpGame {
    /*
     * My thought (Greedy Solution):
     * 
     * if you can reach A[i], then you can reach all A[0] ~ A[i-1]
     * 
     * keep updating the farthest index you can go. If can reach the last
     * element (nums[nums.length-1]) then return true;
     */
    public class Solution {
	public boolean canJump(int[] nums) {
	    if (nums == null || nums.length == 0) {
		return false;
	    }

	    int max = nums[0]; // 0-based index
	    int ptr = 0;
	    while (ptr <= max && ptr < nums.length) {
		if (max >= nums.length - 1) {
		    return true;
		}

		max = Math.max(max, nums[ptr] + ptr);
		ptr++;
	    }

	    return false;
	}
    }

    public class Solution_Greedy2 {
	public boolean canJump(int[] A) {
	    if (A == null || A.length < 1) {
		return false;
	    }

	    int farthest = A[0];

	    int i = 0;
	    while (i <= farthest && i < A.length) {
		if (farthest >= A.length - 1) {
		    return true;
		} else {
		    farthest = Math.max(farthest, i + A[i]);
		}

		i++;
	    }

	    return false;
	}
    }

    /*
     * Time limit exceeded for some corner cases
     */
    public class Method_DP {
	public boolean canJump(int[] A) {
	    if (A == null || A.length < 1) {
		return false;
	    }

	    boolean[] can = new boolean[A.length];
	    can[0] = true;

	    for (int i = 1; i < A.length; i++) {
		// if from any previous reachable element can jump to i then
		// can[i]=true
		for (int j = 0; j < i; j++) {
		    if (can[j] && (j + A[j] >= i)) {
			can[i] = true;
			if (i + A[i] >= A.length - 1) {
			    return true;
			}
			break;
		    }
		}

	    }

	    return can[A.length - 1];
	}
    }
}
