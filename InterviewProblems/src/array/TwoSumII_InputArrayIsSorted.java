package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSumII_InputArrayIsSorted {
    public class Solution {
	public int[] twoSum(int[] numbers, int target) {
	    int[] res = new int[2];
	    if (numbers == null || numbers.length < 2) {
		return res;
	    }

	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < numbers.length; i++) {
		if (map.containsKey(numbers[i]) && target == numbers[i] * 2) {
		    res[0] = map.get(numbers[i]);
		    res[1] = i + 1;
		    return res;
		}
		map.put(numbers[i], i + 1);
	    }

	    int i = 0;
	    int j = numbers.length - 1;
	    while (i < j) {
		int sum = numbers[i] + numbers[j];
		if (sum == target) {
		    res[0] = Math.min(map.get(numbers[i]), map.get(numbers[j]));
		    res[1] = Math.max(map.get(numbers[i]), map.get(numbers[j]));
		    return res;
		} else if (sum < target) {
		    i++;
		} else {
		    j--;
		}
	    }

	    return res;
	}
    }
}
