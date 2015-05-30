package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
/**
 * Two Sum
 * 
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 */

/*
 * The tricky part is that this problem requires to return the indice, not just
 * the values
 * 
 * Use an additional class to store both the value and index info for the
 * elements in original array
 * 
 * 1. Be careful that the first element of result[] must be smaller than the
 * second one
 * 
 * 2. The output index starts from 1
 * 
 * Two ways: 1) use hashmap. time: O(N), space O(N) 2) sort array first.
 */
public class TwoSum {
    class Solution_map {
        public int[] twoSum(int[] numbers, int target) {
            int[] res = new int[2];
            if (numbers == null || numbers.length < 2) {
        	return res;
            }
    
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
        	if (map.containsKey(target - numbers[i])) {
        	    res[0] = map.get(target - numbers[i]);
        	    res[1] = i + 1; // not zero-based index!
        	    return res;
        	}
    
        	map.put(numbers[i], i + 1); // not zero-based index!
            }
    
            return res;
        }
    }

    /*
     * [2014 Dec] alternative what if the array elements are not distinct? --It
     * says you can assume there is only one solution, so: 1) if the duplicated
     * elements are not part of the answer element -> does not matter; 2) if the
     * duplicated elements are part of the answer -> the target value must equal
     * to 2x this element (and there can only be two duplications)
     * 
     * Time: O(NlogN); space: depends on the sorting algorithm
     */
    public class Solution {
	public int[] twoSum(int[] numbers, int target) {
	    if (numbers == null || numbers.length == 0) {
		return null;
	    }

	    int[] res = new int[2];

	    Map<Integer, Integer> idxValMap = new HashMap<Integer, Integer>();
	    for (int i = 0; i < numbers.length; i++) {
		if (idxValMap.containsKey(numbers[i])
			&& target == (numbers[i] * 2)) {
		    res[0] = 1 + idxValMap.get(numbers[i]);
		    res[1] = 1 + i;
		    return res;
		}

		idxValMap.put(numbers[i], i);
	    }

	    Arrays.sort(numbers);

	    int i = 0;
	    int j = numbers.length - 1;
	    while (i < j) {
		int sum = numbers[i] + numbers[j];
		if (sum == target) {
		    res[0] = 1 + Math.min(idxValMap.get(numbers[i]),
			    idxValMap.get(numbers[j]));
		    res[1] = 1 + Math.max(idxValMap.get(numbers[i]),
			    idxValMap.get(numbers[j]));
		    break;
		} else if (sum < target) {
		    i++;
		} else {
		    j--;
		}
	    }

	    return res;
	}
    }

    class Solution_2013 {
	public int[] twoSum(int[] numbers, int target) {
	    if (numbers == null || numbers.length == 0)
		return null;

	    Element[] elements = new Element[numbers.length];
	    for (int k = 0; k < numbers.length; k++) {
		elements[k] = new Element(numbers[k], k);
	    }
	    Arrays.sort(elements, new Comparator<Element>() {
		@Override
		public int compare(Element e1, Element e2) {
		    return e1.val - e2.val;
		}
	    });

	    int[] result = new int[2];

	    int i = 0;
	    int j = elements.length - 1;

	    while (i < j) {
		int sum = elements[i].val + elements[j].val;

		if (sum == target) {
		    int i1 = elements[i].pos + 1;
		    int i2 = elements[j].pos + 1;
		    result[0] = Math.min(i1, i2);
		    result[1] = Math.max(i1, i2);
		    return result;
		} else if (sum < target) {
		    i++;
		} else {
		    j--;
		}
	    }

	    return null;
	}

	public class Element {
	    int val;
	    int pos;

	    public Element(int v, int p) {
		val = v;
		pos = p;
	    }
	}

	public int[] twoSum1(int[] numbers, int target) {
	    if (numbers.length < 2) {
		return null;
	    }

	    int[] temp = numbers.clone();
	    Arrays.sort(temp);

	    int i = 0;
	    int j = temp.length - 1;
	    while (i < j) {
		int sum = temp[i] + temp[j];
		if (sum == target) {
		    break;
		} else if (sum < target) {
		    i++;
		} else {
		    j--;
		}
	    }

	    if (i > j) {
		return null;
	    }

	    /*
	     * Do not forget that now i, j is the index of sorted array temp.
	     * What we need to output is the indice of the original array
	     */
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    for (int k = 0; k < numbers.length; k++) {
		if (numbers[k] == temp[i] || numbers[k] == temp[j]) {
		    if (result.size() > 0 && result.get(0) == numbers[k]) {
			continue;
		    }
		    result.add(k);
		}
	    }

	    int[] end = new int[2];
	    for (int a : result) {
		end[result.indexOf(a)] = a + 1;
	    }

	    return end;
	}
    }
}
