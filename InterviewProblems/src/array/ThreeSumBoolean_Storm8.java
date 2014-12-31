package array;

import java.util.Arrays;

public class ThreeSumBoolean_Storm8 {
    /**
     * Stom8 Interview Question Sample
     * 
     * Given an unsorted array of integers and a single integer, write code that
     * returns true if there exists a combination of three values in the array
     * whose sum is equal to the integer, and false if no combination exists.
     */
    /*
     * Not sure if the solution is bug free
     */
    public boolean hasCombination(int[] input, int target) {
	if (input == null || input.length < 3)
	    return false;

	Arrays.sort(input);

	for (int i = 0; i < input.length - 2; i++) {
	    int j = i + 1;
	    int k = input.length - 1;
	    while (j < k) {
		int sum = input[i] + input[j] + input[k];
		if (sum == target) {
		    return true;
		} else if (sum < target) {
		    i++;
		} else {
		    j--;
		}
	    }
	}

	return false;
    }

}
