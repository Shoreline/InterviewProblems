package bit;

public class NumberOfOne {
    /**
     * Number of One
     * 
     * Return the number of "1"s in the binary version for a given Integer
     */

    /*
     * Important:
     * 
     * 1. n & (n-1) will result in setting the rightmost '1' to '0'
     * 
     * 2. n & 1 will return the last bit of n (so, (n >> i) & 1 will return the
     * i-th bit of n )
     */

    // A faster way. only count n times (n is the number of 1)
    public static int countOne2(int a) {
	int counter = 0;

	while (a != 0) {
	    a = (a & (a - 1));
	    counter++;
	}

	return counter;
    }

    // shift.
    public static int countOne1(int a) {
	int counter = 0;

	while (a != 0) {
	    if ((a & 1) == 1)
		counter++;
	    a = a >> 1;
	}

	return counter;
    }
}
