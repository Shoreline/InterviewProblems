package array;

/**
 * Maximum Subarray
 * 
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6.
 * 
 * More practice: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {
    /*
     * 1D DP (reduced to just one variable to save space)
     * 
     * local/global dp variables
     * 
     * The maximum-subarray must ends with some A[i] So, let localMax[i] is the
     * sub-maximum value of any sub array ends with A[i].
     * 
     * Then for localMax[i+1], its corresponding sub array has only two
     * possibilities: 1) it contains A[i]: localMax[i+1] = localMax[i] + A[i] 2)
     * it does not contain A[i]: localMax[i+1] = A[i]
     */
    public class Solution_DP {
	public int maxSubArray(int[] A) {
	    if (A == null) {
		return Integer.MIN_VALUE;
	    }
	    int max = A[0];
	    int localMax = A[0];

	    for (int i = 1; i < A.length; i++) {
		localMax = Math.max(A[i], A[i] + localMax);
		max = Math.max(localMax, max);
	    }

	    return max;
	}
    }

    /*
     * Time: O(nlogn)
     * 
     * 但是题目中要求，不要用这个O(n)解法，而是采用Divide & Conquer。这就暗示了，解法必然是二分。分析如下：
     * 
     * 假设数组A[left, right]存在最大值区间[i, j](i>=left & j<=right)，以mid = (left +
     * right)/2 分界，无非以下三种情况：
     * 
     * subarray A[i,..j] is
     * 
     * (1) Entirely in A[low,mid-1]
     * 
     * (2) Entirely in A[mid+1,high]
     * 
     * (3) Across mid
     * 
     * 对于(1) and (2)，直接递归求解即可，对于(3)，则需要以min为中心，向左及向右扫描求最大值，意味着在A[left,
     * Mid]区间中找出A[i..mid], 而在A[mid+1, right]中找出A[mid+1..j]，两者加和即为(3)的解。
     */
    public class Solution_divide_and_conquer {

	public int maxSubArray(int[] nums) {
	    return divide(nums, 0, nums.length - 1);
	}

	public int divide(int nums[], int low, int high) {
	    if (low == high)
		return nums[low];
	    if (low == high - 1)
		return Math.max(nums[low] + nums[high], Math.max(nums[low], nums[high]));

	    int mid = (low + high) / 2;
	    int lmax = divide(nums, low, mid - 1);
	    int rmax = divide(nums, mid + 1, high);

	    int mmax = nums[mid];
	    int tmp = mmax;
	    for (int i = mid - 1; i >= low; i--) {
		tmp += nums[i];
		mmax = Math.max(tmp, mmax);
	    }
	    tmp = mmax;
	    for (int i = mid + 1; i <= high; i++) {
		tmp += nums[i];
		mmax = Math.max(tmp, mmax);
	    }
	    return Math.max(mmax, Math.max(lmax, rmax));
	}

    }

    /*
     * be careful, do not forget the lines marked as "*notice!"
     */
    public class Solution_Lame {
	public int maxSubArray(int[] A) {

	    if (A.length < 1) {
		return Integer.MIN_VALUE;
	    }

	    int max = Integer.MIN_VALUE;
	    int curSum = 0;

	    // In case all elements are negative
	    int maxElement = Integer.MIN_VALUE;

	    for (int i = 0; i < A.length; i++) {
		maxElement = Math.max(maxElement, A[i]);

		if (A[i] >= 0) {
		    curSum += A[i];
		    max = Math.max(max, curSum);
		} else {
		    int temp = 0;

		    while (i < A.length && A[i] <= 0) {
			maxElement = Math.max(maxElement, A[i]); // *notice!
			temp += A[i];
			i++;
		    }
		    i--; // *notice!

		    if (curSum + temp > 0) {
			curSum = curSum + temp;
		    } else {
			curSum = 0;
		    }
		}

	    }

	    if (maxElement <= 0) {
		return maxElement;
	    } else {
		return max;
	    }
	}
    }
}
