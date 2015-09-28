package google;

import java.util.*;

/**
 * 一队人打散后，每个人有一个高度，每个人记得原来前面有几个人比他高，没有重复高度，求复原原始队列
 */

/*
 * time: O(N) (or still O(N^2)?); space: O(N)
 * 
 * vals[i]: how many elements are ahead the i-th largest element in the original
 * array
 * 
 * For example: we have 2,3,5,4,1
 * 
 * -> the given array will be 4,0,0,1,0 ( the amount of ppl higher than a certain person)
 * 
 *  the output is 2,3,5,4,1
 */

public class RestoreArray {
    class Method_wrong {
	public int[] restore(int[] vals) {
	    LinkedList<Integer> list = new LinkedList<>();
	    for (int i = vals.length - 1; i >= 0; i--) {
		list.add(vals[i], i + 1);
	    }

	    int[] original = new int[vals.length];
	    int i = 0;
	    for (Integer num : list) {
		original[i] = num;
		i++;
	    }

	    return original;
	}
    }
}
