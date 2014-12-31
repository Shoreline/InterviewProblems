package array;

public class JumpGame2 {
    /**
     * Jump Game II
     * 
     * Given an array of non-negative integers, you are initially positioned at
     * the first index of the array.
     * 
     * Each element in the array represents your maximum jump length at that
     * position.
     * 
     * Your goal is to reach the last index in the minimum number of jumps.
     * 
     * For example: Given array A = [2,3,1,1,4]
     * 
     * The minimum number of jumps to reach the last index is 2. (Jump 1 step
     * from index 0 to 1, then 3 steps to the last index.)
     */

    /*
     * second round.
     */
    public int jump(int[] A) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (A == null || A.length < 2)
	    return 0;

	int count = 1;

	int i = 1;
	int max = A[0];

	// corner case!
	if (A[0] >= A.length - 1)
	    return count;

	while (i < A.length) {

	    int newMax = max;

	    while (i <= max) {
		if (A[i] >= A.length - 1 - i)
		    return count + 1;
		newMax = Math.max(i + A[i], newMax);
		i++;
	    }

	    // now need to change i any more. It has been updated in the inner
	    // while loop
	    count++;
	    if (max == newMax)
		return -1;
	    max = newMax;
	}

	return -1;
    }

    /*
     * first round
     * 
     * very very similar to the Jump Game I.
     * 
     * Just need to return the iterations of the while loop
     */
    public int jump1(int[] A) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (A.length == 0)
	    return 0;

	int i = 0;
	int jumpNum = 0;
	int curFarthest = 0;
	int newFarthest = 0;

	while (curFarthest < A.length - 1) {
	    for (int j = i; j <= curFarthest; j++) {
		newFarthest = Math.max(newFarthest, A[j] + j);
	    }
	    if (newFarthest == curFarthest) {
		return -1; // fail to jump over
	    }

	    i = curFarthest + 1;
	    curFarthest = newFarthest;
	    jumpNum++;
	}
	return jumpNum;
    }
}
