package facebook;

import java.util.*;

/**
 * List 是否有连续的sub-list其和为target。
 * 
 * There may be negative numbers in the list.
 *
 */

/*
 * Fast way to get the sub-sum of an array or list: save sum(0~i) and do
 * subtraction
 */
public class ContainsSubsum {
    class Method {
	public boolean containsSum(List<Integer> list, int target) {
	    if (list == null) {
		return false;
	    }

	    HashSet<Integer> set = new HashSet<>();
	    int sum = 0;
	    set.add(0); // easy to forget!
	    
	    for (int num : list) {
		sum = sum + num;
		set.add(sum);
		if (set.contains(sum - target)) {
		    return true;
		}
	    }
	    return false;
	}
    }
}
