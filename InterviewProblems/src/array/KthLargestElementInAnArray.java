package array;

import java.util.PriorityQueue;

/*
 * O(N) solutions:
 * 
 * Min heap or max heap;
 * 
 * Quick select
 * 
 */
public class KthLargestElementInAnArray {
    /*
     * Min Heap. Time: O(NlogK) ?
     */
    public class Solution {
	    public int findKthLargest(int[] nums, int k) {
	        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	        
	        for(int i = 0; i<nums.length; i++){
	            if(i<k){
	                minHeap.add(nums[i]);
	            }
	            else{
	                if(nums[i]>minHeap.peek()){
	                    minHeap.poll();
	                    minHeap.add(nums[i]);
	                }
	            }
	        }
	        
	        return minHeap.peek();
	    }
	}
}
