package bit;

import java.util.ArrayList;

public class AddWithoutArithmetic {
    /**
     * Do addition without using +, -, *, /
     * 
     */

    public int bitAdd(int a, int b) {
	if (b == 0)
	    return a;

	int sum = a ^ b;

	/*
	 * the carrier of nth bit shall be added to the (n+1)th bit, so we shall
	 * shift it leftwards by 1
	 */
	int carrier = (a & b) << 1;

	ArrayList<String[]> result = new ArrayList<String[]>();

	return bitAdd(sum, carrier);
    }
}
