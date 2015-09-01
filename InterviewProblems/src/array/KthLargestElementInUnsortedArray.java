package array;

import java.util.PriorityQueue;

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
    class Solution_QuickSelect {
	public int partition(int[] nums, int start, int end, int pivotIndex) {
	    // Move pivot to end
	    int pVal = nums[pivotIndex];
	    swap(nums, end, pivotIndex);

	    int pos = start;
	    for (int i = start; i <= end - 1; i++) {
		if (nums[i] < pVal) {
		    swap(nums, i, pos);
		    pos++;
		}
	    }
	    swap(nums, end, pos); // move pivot value to its final place
	    return pos; // new index of pivot value
	}

	private void swap(int[] nums, int i, int j) {
	    if (i == j) {
		return;
	    }
	    nums[i] = nums[i] + nums[j];
	    nums[j] = nums[i] - nums[j];
	    nums[i] = nums[i] - nums[j];
	}

	public int quickSelect(int[] nums, int k) {
	    int left = 0;
	    int right = nums.length - 1;
	    while (left < right) {
		int pivotIndex = left + (int) Math.floor(Math.random() * (right - left + 1));
		pivotIndex = partition(nums, left, right, pivotIndex);
		if (k == pivotIndex) {
		    return nums[pivotIndex - 1];
		} else if (k < pivotIndex) {
		    right = pivotIndex - 1;
		} else {
		    left = pivotIndex + 1;
		}
	    }
	    return nums[left - 1];
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
