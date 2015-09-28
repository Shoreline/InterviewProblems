package array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Sliding Window Maximum
 * 
 * Given an array nums, there is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers
 * in the window. Each time the sliding window moves right by one position.
 * 
 * For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * 
 * Window position Max
 * 
 * --------------- -----
 * 
 * [1 3 -1] -3 5 3 6 7 3
 * 
 * 1 [3 -1 -3] 5 3 6 7 3
 * 
 * 1 3 [-1 -3 5] 3 6 7 5
 * 
 * 1 3 -1 [-3 5 3] 6 7 5
 * 
 * 1 3 -1 -3 [5 3 6] 7 6
 * 
 * 1 3 -1 -3 5 [3 6 7] 7
 * 
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * 
 * Note: You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for
 * non-empty array.
 *
 */
/*
 * http://wiki.jikexueyuan.com/project/for-offer/question-sixty-five.html
 * 
 * The idea is to use a deque to save the possible maximal element index for the
 * incoming sliding window
 * 
 * Each element in nums can only be enqueue and dequeue for at most once each,
 * so the amortized time complexity is still O(N)
 * 
 * deque saves indices. The elements of these indices are in descending order
 */
public class SlidingWindowMaximum {
    public class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
	    if (nums.length == 0) {
		return new int[0];
	    }

	    int[] res = new int[nums.length - k + 1];
	    Deque<Integer> deque = new LinkedList<>();

	    for (int i = 0; i < nums.length; i++) {
		if (deque.isEmpty() || nums[deque.peekLast()] >= nums[i]) {
		    deque.addLast(i);
		} else {
		    while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
			deque.removeLast();
		    }
		    deque.addLast(i);
		}

		if (i >= k - 1) {
		    res[i - k + 1] = nums[deque.peekFirst()];
		}

		if (i - deque.peekFirst() == k - 1) {
		    deque.pollFirst();
		}
	    }

	    return res;
	}
    }
}
