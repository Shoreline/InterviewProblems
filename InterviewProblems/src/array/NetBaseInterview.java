package array;

public class NetBaseInterview {
    /************************************************************************************************
     * Given an array a[n] containing n numbers and a number t called answer
     * a[k] and a[k+1] can use the following operators: +, -, *, / to create
     * a1[k], 0 <= k <= n-2 a1[k] will contain n-1 numbers iterate it... the
     * array will contain only one element Is t the possible number? Please
     * finish the following function
     ************************************************************************************************/

    // 我给的解法

    public boolean isPossible(int[] a, int t) {
	if (a == null || a.length == 0)
	    return false;

	if (a.length == 1 && a[0] == t)
	    return true;

	int i = 0;

	while (i + 1 < a.length) {
	    int[][] newArrays = new int[4][a.length - 1];
	    int[] temp = new int[] { a[i] + a[i + 1], a[i] - a[i + 1],
		    a[i] * a[i + 1], a[i] / a[i + 1] };

	    for (int j = 0; j < temp.length; j++) {
		if (temp[j] == t)
		    return true;

		for (int m = 0; m < a.length; m++) {
		    if (m == i) {
			newArrays[j][m] = temp[j];
			m++;
			continue;
		    }
		    newArrays[j][m] = a[m];
		}
	    }
	    return isPossible(newArrays[0], t) || isPossible(newArrays[1], t)
		    || isPossible(newArrays[2], t)
		    || isPossible(newArrays[3], t);
	}
	return false;
    }

    public boolean isPossible2(int[] a, int t) {
	if (a == null || a.length == 0)
	    return false;

	if (a.length == 1 && a[0] == t)
	    return true;

	return false;
    }

}
