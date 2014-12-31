package string;

import java.util.ArrayList;
import java.util.BitSet;

public class GrayCode {
    /**
     * 
     * Gray Code
     * 
     * The gray code is a binary numeral system where two successive values
     * differ in only one bit.
     * 
     * Given a non-negative integer n representing the total number of bits in
     * the code, print the sequence of gray code. A gray code sequence must
     * begin with 0.
     * 
     * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
     * 
     * 00 - 0
     * 
     * 01 - 1
     * 
     * 11 - 3
     * 
     * 10 - 2
     * 
     * Note: For a given n, a gray code sequence is not uniquely defined.
     * 
     * For example, [0,2,3,1] is also a valid gray code sequence according to
     * the above definition.
     * 
     * For now, the judge is able to judge based on one instance of gray code
     * sequence. Sorry about that.
     */

    /*
     * The result is a list of Integers that is from 0 to 2^n-1. The order of
     * these Integers is the key
     * 
     * This problem has a mathematic solution. But using this solution will lose
     * the point of coding interview? (n=k时的Gray Code，相当于n=k-1时的Gray Code的逆序 加上
     * 1<<k)
     * 
     * By observing the sequence of examples. We can find the position of bit
     * that is changed is not random.
     * 
     * for n=2, the changing sequence is : 0,1,2,1
     * 
     * for n=3, the changing sequence is : 0,1,2,1,3,1,2,1
     * 
     * for n=4, the changing sequence is : 0,1,2,1,3,1,2,1,4,1,2,1,3,1,2,1,
     * 
     * So, we can follow the pattern and get expected result
     */

    /*
     * Generate the changing list, then perform bit manipulation
     */
    public static ArrayList<Integer> grayCode(int n) {
	ArrayList<Integer> result = new ArrayList<Integer>();
	ArrayList<Integer> pattern = new ArrayList<Integer>();
	ArrayList<Integer> prePattern = new ArrayList<Integer>();

	// corner case: if n==0, do not just return an empty list
	if (n < 0)
	    return result;

	// 0 is a special case. will treat it separately
	for (int i = 1; i <= n; i++) {
	    pattern.add(i);
	    pattern.addAll(prePattern);
	    // prePattern = pattern; Wrong! Shallow copy!
	    prePattern = new ArrayList<Integer>(pattern);
	}

	result.add(0);
	for (Integer pos : pattern) {
	    int input = result.get(result.size() - 1);
	    result.add(changeBit(input, pos));
	}

	return result;
    }

    // *Important* change the k-th bit of an Integer a
    private static int changeBit(int a, int k) {
	/*
	 * n & 1: return 1 if n is odd, otherwise 0
	 * 
	 * So, temp is 1, if the kth bit is 1;
	 */
	int temp = (a >> (k - 1)) & 1;

	if (temp == 1)
	    /*
	     * if the k-th bit is 1, make it 0 and all other bits remain the
	     * same
	     */
	    return a - (1 << (k - 1));
	else
	    /*
	     * if the k-th bit is 0, make it 1 and all other bits remain the
	     * same
	     */
	    return a + (1 << (k - 1));

    }

    // ? useless?
    public BitSet grayCodeBitSet(int n) {
	if (n <= 0) {
	    return null;
	}
	return null;
    }
}
