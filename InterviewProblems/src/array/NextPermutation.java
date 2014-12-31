package array;

public class NextPermutation {
    /**
     * Next Permutation
     * 
     * Implement next permutation, which rearranges numbers into the
     * lexicographically next greater permutation of numbers.
     * 
     * If such arrangement is not possible, it must rearrange it as the lowest
     * possible order (ie, sorted in ascending order).
     * 
     * The replacement must be in-place, do not allocate extra memory.
     * 
     * Here are some examples. Inputs are in the left-hand column and its
     * corresponding outputs are in the right-hand column.
     * 
     * 1,2,3 ¡ú 1,3,2
     * 
     * 3,2,1 ¡ú 1,2,3
     * 
     * 1,1,5 ¡ú 1,5,1
     */
    /*
     * hard
     * 
     * in-place swap a whole array is tricky
     * 
     * Another solution (I think)
     * 
     * 1. find out current case is the n-th permutation
     * 
     * 2. get the (n+1)th permutation
     */

    /*
     * Solution: Need to know math
     * 
     * 1. From right to left, find the first digit (PartitionNumber) which
     * violate the increase trend;
     * 
     * 2. From right to left, find the first digit larger than the
     * PartitionNumber, call it changeNumber;
     * 
     * 3. Swap the PartitionNumber and the changeNumber;
     * 
     * 4. Reverse all digits on the right of the original index of the
     * PartitionNumber (current index of the changeNumber)
     */
    public static void nextPermutation(int[] num) {
	if (num == null || num.length < 2)
	    return;

	for (int i = num.length - 2; i >= 0; i--) {
	    if (num[i] < num[i + 1]) {
		for (int j = num.length - 1; j >= 0; j--) {
		    if (num[j] > num[i]) {
			// swap num[i] and num[j]
			swap(num, i, j);

			/*
			 * reverse all digits on the right of i
			 * 
			 * be careful of the range of k
			 */
			for (int k = 1; k <= (num.length - 1 - i) / 2; k++) {
			    swap(num, i + k, num.length - k);
			}

			// next permutation has been generated, return
			return;
		    }
		}
	    }
	}

	/*
	 * if reach here, means num[] is like 3,2,1. We need to reverse the
	 * whole array
	 */
	for (int k = 0; k < num.length / 2; k++) {
	    swap(num, k, num.length - 1 - k);
	}

    }

    private static void swap(int[] num, int i, int j) {
	int temp = num[i];
	num[i] = num[j];
	num[j] = temp;
    }

}
