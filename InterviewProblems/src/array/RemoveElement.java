package array;

public class RemoveElement {
    /**
     * Remove Element
     * 
     * Given an array and a value, remove all instances of that value in place
     * and return the new length.
     * 
     * The order of elements can be changed. It doesn't matter what you leave
     * beyond the new length.
     */

    /*
     * Two pointers starting from the beginning of the array. (One is always the
     * same or slower than the other )
     * 
     * Maintain the beginning part of the array
     */

    public int removeElement(int[] A, int elem) {
	if (A.length == 0) {
	    return 0;
	}

	int idx = 0;

	for (int i = 0; i < A.length; i++) {
	    if (A[i] != elem) {
		A[idx] = A[i];
		idx++;
	    }
	}

	return idx;
    }
}
