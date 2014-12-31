package bit;

public class FindMissingNumber {
    /**
     * Find Missing Number I
     * 
     * Given an integer array, there is one number occurs only once. All others
     * occur twice. Find this number.
     */

    /*
     * Take advantage of XOR:
     * 
     * 1. n^n=0;
     * 
     * 2. 0^n=n;
     * 
     * 3. XOR obeys commutative law: a^b^c=c^b^a
     * 
     * So, for all elements in this array: do a1^a2^a3...^an-1 = missing number
     */

    public static int getMissingNum(int[] A) {
	if (A == null || A.length == 0)
	    return (Integer) null;

	int res = 0;
	for (int i = 0; i < A.length; i++) {
	    res ^= A[i];
	}
	return res;

    }

    /**
     * A modified version:
     * 
     * Given an array of size n-1, its elements are from 1 to n except one
     * missing number. Find this number
     */

    /*
     * similar algorithm as above.
     * 
     * This time do a1^a2^a3...^an-1 ^ 1^2^3...^n
     */

}
