package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum III - Data structure design (Easy)
 * 
 * Design and implement a TwoSum class. It should support the following
 * operations: add and find.
 * 
 * add - Add the number to an internal data structure. find - Find if there
 * exists any pair of numbers which sum is equal to the value.
 * 
 * For example, add(1); add(3); add(5);
 * 
 * find(4) -> true
 * 
 * find(7) -> false
 *
 */

/*
 * Use a map to store existing number-count info
 */
public class TwoSumIII_DataStructureDesign {
    public class TwoSum {
	// number count map
	Map<Integer, Integer> map = new HashMap<>();

	public void add(int number) {
	    if (map.containsKey(number)) {
		map.put(number, map.get(number) + 1);
	    } else {
		map.put(number, 1);
	    }
	}

	public boolean find(int value) {
	    for (int num : map.keySet()) {
		if (map.containsKey(value - num) && num * 2 != value) {
		    return true;
		} else if (num * 2 == value && map.get(num) > 1) {
		    return true;
		}
	    }
	    return false;
	}
    }
}
