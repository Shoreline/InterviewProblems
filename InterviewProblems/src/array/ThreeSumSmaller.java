package array;

import java.util.Arrays;

public class ThreeSumSmaller {
    public class Solution {
	public int threeSumSmaller(int[] nums, int target) {
	    if (nums == null || nums.length < 3) {
		return 0;
	    }

	    Arrays.sort(nums);
	    int count = 0;
	    for (int i = 0; i < nums.length - 2; i++) {
		int j = i + 1;
		int k = nums.length - 1;
		while (j < k) {
		    int sum = nums[i] + nums[j] + nums[k];
		    if (sum < target) {
			// all [i,j,k]; [i,j,k-1]; [i,j,k-2],...,[i,j,j+1] are
			// results
			count += (k - j);
			j++;
		    }
		    else{
			k--;
		    }
		}
	    }

	    return count;
	}
    }
}
