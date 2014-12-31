package bit;

public class ReverseIntegerByBit {
    /**
     * Reverse bits of an unsigned integer
     */
    /*
     * 0 ^ 1 = 1; 1 ^ 1 = 0
     * 
     * --> a bit ^ 1 = NOT this bit
     */
    public static int reverseIntegerByBit(int n) {

	for (int i = 0; i < Integer.SIZE / 2; i++) {
	    int j = Integer.SIZE - 1 - i;
	    swapBits(n, i, j);
	}

	return n;
    }

    private static int swapBits(int n, int i, int j) {

	int ithBit = (n >> i) & 1;
	int jthBit = (n >> j) & 1;

	if ((ithBit ^ jthBit) == 1) {
	    /*
	     * build a mask: 0...1...1...0 (Only the ith and jth bits are 1)
	     */
	    int mask1 = 1 << i;
	    int mask2 = 1 << j;
	    int mask = mask1 | mask2;

	    // switch the ith and jth bit
	    n = n ^ mask;
	}

	return n;
    }
}
