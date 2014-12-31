package array;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSumClosest {
    public static ArrayList<Integer> getThreeSumCloest(Integer[] input,
	    int target) {
	if (input.length < 3) {
	    return null;
	}

	ArrayList<Integer> result = new ArrayList<Integer>();
	int curMin = Integer.MAX_VALUE;

	Arrays.sort(input);

	for (int i = 0; i < input.length - 2; i++) {
	    int j = i + 1;
	    int k = input.length - 1;

	    while (j < k) {

		int sum = input[i] + input[j] + input[k];
		if (sum == target) {
		    result.clear();
		    result.add(input[i]);
		    result.add(input[j]);
		    result.add(input[k]);
		    return result;
		} else if (sum > target) {
		    if (sum - target < curMin) {
			curMin = sum - target;
			result.clear();
			result.add(input[i]);
			result.add(input[j]);
			result.add(input[k]);
		    }
		    k--;
		} else {
		    if (target - sum < curMin) {
			curMin = target - sum;
			result.clear();
			result.add(input[i]);
			result.add(input[j]);
			result.add(input[k]);
		    }
		    j++;
		}

	    }

	}

	return result;
    }
}
