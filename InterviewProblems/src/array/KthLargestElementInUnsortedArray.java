package array;

import java.util.PriorityQueue;

/**
 * Kth Largest Element in an Array
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * For example, Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * 
 */
/*
 * http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
 * 
 */
public class KthLargestElementInUnsortedArray {
    /*
     * This solution finds the k-th smallest element, not the k-th largest
     * 
     * Time: worst O(N^2), but average O(N)
     */
    public class Solution_QuickSelect {
	public int findKthLargest(int[] nums, int k) {
	    k = nums.length + 1 - k; // k-th largest = (len+1-k)-th smallest
	    int left = 0;
	    int right = nums.length - 1;
	    while (left <= right) {
		int p = partition(nums, left, right);
		if (p == k - 1) { // k-th smallest element is of k-1 index
		    return nums[p];
		} else if (p < k - 1) {
		    left = p + 1;
		} else {
		    right = p - 1;
		}
	    }

	    return nums[right];
	}

	/*
	 * move all elements < pivot_value to the left hand side; all >=
	 * pivot_value to right hand side.
	 * 
	 * Eventually return an index p where nums[p] = pivot_value
	 */
	private int partition(int[] nums, int start, int end) {
	    int p = start + (int) (Math.random() * (end - start + 1));
	    int pVal = nums[p];

	    // Move pivot to end
	    swap(nums, p, end);

	    int ptr = start;
	    for (int i = start; i <= end - 1; i++) {
		if (nums[i] < pVal) {
		    swap(nums, i, ptr);
		    ptr++;
		}
	    }
	    swap(nums, ptr, end); // move pivot value to its final place
	    return ptr; // new index of pivot value
	}

	private void swap(int[] nums, int i, int j) {
	    int tmp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = tmp;
	}
    }

    /*
     * Min Heap. Time: O(NlogK) ?
     */
    public class Solution_MinHeap {
	public int findKthLargest(int[] nums, int k) {
	    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

	    for (int i = 0; i < nums.length; i++) {
		if (i < k) {
		    minHeap.add(nums[i]);
		} else {
		    if (nums[i] > minHeap.peek()) {
			minHeap.poll();
			minHeap.add(nums[i]);
		    }
		}
	    }

	    return minHeap.peek();
	}
    }
}
