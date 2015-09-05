package array;

/**
 * H-Index II
 * 
 * Follow up for H-Index: What if the citations array is sorted in ascending
 * order? Could you optimize your algorithm?
 * 
 * Hint:
 * 
 * Expected runtime complexity is in O(log n) and the input is sorted.
 * 
 */
public class H_IndexII {
    public class Solution {
	public int hIndex(int[] citations) {
	    if (citations == null || citations.length == 0) {
		return 0;
	    }

	    int low = 0;
	    int high = citations.length - 1;
	    int last = 0; // cannot be -1

	    while (low <= high) {
		int mid = low + (high - low) / 2;
		if (citations[mid] == citations.length - mid) {
		    return citations.length - mid;
		} else if (citations[mid] > citations.length - mid) {
		    high = mid - 1; 
		    last = citations.length - mid; // may be the answer
		} else {
		    low = mid + 1;
		}
	    }

	    return last;
	}
    }

    public class Solution2 {
	public int hIndex(int[] citations) {
	    if (citations == null || citations.length == 0) {
		return 0;
	    }

	    int low = 0;
	    int high = citations.length - 1;
	    while (low <= high) {
		int mid = low + (high - low) / 2;
		if (citations[mid] == citations.length - mid) {
		    return citations.length - mid;
		} else if (citations[mid] > citations.length - mid) {
		    /*
		     * h-index is bigger than len-mid. So reduce mid for next
		     * round
		     */
		    high = mid - 1;
		} else {
		    /*
		     * It is guaranteed that mid mustn't be the result
		     */
		    low = mid + 1;
		}
	    }

	    return citations.length - low;
	}
    }
}
