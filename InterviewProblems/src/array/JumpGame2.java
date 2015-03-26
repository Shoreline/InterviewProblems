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
     * DP can find minimum needed jumps for every element. Here the greedy
     * method is actually to find "the maximum reachable range after N jumps".
     * Once the maximum reachable range >= A.length-1 then the current jump
     * times will be the result
     */
    public class Solution_Greedy3 {
	public int jump(int[] A) {
	    if (A == null || A.length < 1) {
		return -1;
	    } else if (A.length == 1) {
		return 0; // corner cases
	    } else if (A[0] >= A.length - 1) {
		return 1;
	    }

	    int jumps = 1; // at least one jump
	    int curRange = A[0];
	    int nextRange = 0;

	    // i start from 1. 
	    for (int i = 1; i < A.length; i++) {
		for (int j = i; j <= curRange; j++) {
		    nextRange = Math.max(j + A[j], nextRange);
		    if (nextRange >= A.length - 1) {
			return jumps + 1;
		    }
		}

		if (nextRange <= curRange) {
		    return -1;
		}

		i = curRange; // so next round i = curRange+1
		curRange = nextRange;
		jumps++;
	    }

	    return -1;
	}
    }

    /*
     * Using two while loops
     */
    class Solution_Greedy2 {
	public int jump(int[] A) {
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

		// now need to change i any more. It has been updated in the
		// inner
		// while loop
		count++;
		if (max == newMax)
		    return -1;
		max = newMax;
	    }

	    return -1;
	}
    }

    /*
     * first round
     * 
     * very very similar to the Jump Game I.
     * 
     * Just need to return the iterations of the while loop
     */
    class Solution_Greedy1 {
	public int jump1(int[] A) {
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

    /*
     * Time limit exceeded. Cannot pass corner cases
     */
    public class Method_DP {
	public int jump(int[] A) {
	    if (A == null || A.length < 1) {
		return -1;
	    }

	    int[] minJumps = new int[A.length];

	    for (int i = 0; i < A.length; i++) {
		minJumps[i] = Integer.MAX_VALUE;
	    }

	    minJumps[0] = 0;
	    for (int i = 0; i < A.length; i++) {
		for (int j = i + 1; j < A.length && j <= i + A[i]; j++) {
		    minJumps[j] = Math.min(minJumps[j], minJumps[i] + 1);
		}
	    }

	    return minJumps[A.length - 1];
	}
    }
}
