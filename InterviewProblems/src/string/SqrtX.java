package string;

public class SqrtX {
    /**
     * Sqrt(x)
     * 
     * Implement int sqrt(int x).
     * 
     * Compute and return the square root of x.
     */
    /*
     * Newton's method.
     */
    public int sqrt(int x) {
	if (x <= 1)
	    return x;
	// best initial value: 1597463174
	double result = x / 2.0; // initial value
	double epsilon = 0.1; // tolerance
	double temp = 0;

	while (Math.abs(temp - result) > epsilon) {
	    temp = result;
	    result = (result + x / result) / 2;
	}

	return (int) result;
    }

    /*
     * Another slower method: binary search
     * 
     * The problem is that when x is large, x/2*x/2 may exceed the range of
     * Integer
     */
    public int sqrtB(int x) {
	if (x <= 1)
	    return x;

	int i = 1;
	int j = x / 2;

	// ...
	int maxJ = (int) Math.sqrt(Integer.MAX_VALUE);
	if (j > maxJ)
	    j = maxJ;

	while (i <= j) {
	    int mid = (i + j) / 2;
	    int square = mid * mid;
	    if (square == x) {
		return mid;
	    } else if (square < x) {
		i = mid + 1;
	    } else {
		j = mid - 1;
	    }
	}

	// *** do not return mid
	return (i + j) / 2;
    }
}
