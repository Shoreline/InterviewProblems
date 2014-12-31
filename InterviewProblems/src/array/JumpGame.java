package array;

public class JumpGame {
    /**
     * Jump Game
     * 
     * Given an array of non-negative integers, you are initially positioned at
     * the first index of the array.
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

    /*
     * My thought:
     * 
     * if you can reach A[i], then you can reach all A[0] ~ A[i-1]
     * 
     * keep updating the farthest index you can go
     */

    /*
     * second round. one time pass
     * 
     * Use only 1 while loop with a changing condition. But for Jump Game II
     * (want to know the minimum jumping number), two nested loops must be used.
     */
    public boolean canJump(int[] A) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (A == null || A.length < 1)
	    return false;

	int max = A[0];
	int i = 0;

	while (i <= max && i < A.length) {
	    if (A[i] >= A.length - 1 - i)
		return true;

	    max = Math.max(max, i + A[i]);
	    i++;
	}

	return false;
    }

    /*
     * first round. one time pass!
     * 
     * nested loop: while + for
     */
    public boolean canJump1(int[] A) {
	// Start typing your Java solution below
	// DO NOT write main() function

	if (A.length == 0)
	    return false;

	int i = 0;
	int curFarthest = 0;

	while (curFarthest < A.length - 1) {
	    int newFarthest = curFarthest;

	    for (int j = i; j <= curFarthest; j++) {
		newFarthest = Math.max(newFarthest, A[j] + j);
	    }

	    if (newFarthest == curFarthest) {
		return false;
	    }
	    i = curFarthest + 1;
	    curFarthest = newFarthest;
	}

	return true;
    }
}
